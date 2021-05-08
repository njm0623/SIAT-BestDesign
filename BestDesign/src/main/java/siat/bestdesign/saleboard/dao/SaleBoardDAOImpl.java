package siat.bestdesign.saleboard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.designer.domain.DesignerCartVO;
import siat.bestdesign.saleboard.domain.SaleBoardCartVO;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

@Repository("saleBoardDAO")
// 드로잉샵 게시글 기능 DAO
public class SaleBoardDAOImpl implements SaleBoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	// 드로잉샵 게시글 등록 DAO
	public void insertSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis insertSaleBoard() 호출");
		mybatis.insert("SaleBoardDAO.insertSaleBoard", vo);
	}
	
	@Override
	// 드로잉샵 게시글 갱신 DAO
	public void updateSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis updateSaleBoard() 호출");
		mybatis.update("SaleBoardDAO.updateSaleBoard", vo);
	}
	
	@Override
	// 드로잉샵 게시글 삭제 DAO
	public void deleteSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis deleteSaleBoard() 호출");
		mybatis.delete("SaleBoardDAO.deleteSaleBoard", vo);
	}
	
	@Override
	// 드로잉샵 게시글 상세 내용 불러오기 DAO
	public SaleBoardVO getSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis getSaleBoard() 호출");
		return (SaleBoardVO) mybatis.selectOne("SaleBoardDAO.getSaleBoard", vo);
	}

	@Override
	// 드로잉샵 게시글 목록 불러오기 DAO
	public List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo) {
		System.out.println("===> Mybatis getSaleBoardList() 호출");
		return mybatis.selectList("SaleBoardDAO.getSaleBoardList", vo);
	}
	
	@Override
	// 드로잉샵 게시글 수 불러오기 DAO
	public int countSaleBoardList(SaleBoardPagingVO vo) {
		System.out.println("===> Mybatis countSaleBoardList() 호출");
		return mybatis.selectOne("SaleBoardDAO.countSaleBoardList", vo);
	}

	@Override
	// 드로잉샵 게시글 조회수 갱신 DAO
	public void updateSaleBoardView(SaleBoardVO vo) {
		System.out.println("===> Mybatis updateSaleBoardView() 호출");
		mybatis.update("SaleBoardDAO.updateSaleBoardView", vo);
	}
	
	@Override
	// 드로잉샵 작품 구매 DAO
	public void saleBoardPurchase(SaleBoardDealVO vo) {
		System.out.println("===> Mybatis saleBoardPurchase() 호출");
		mybatis.insert("SaleBoardDAO.saleBoardPurchase", vo);
	}

	@Override
	// 드로잉샵 게시글 찜 등록, 해제 기능 DAO
	public SaleBoardCartVO checkCart(HashMap map) {
		SaleBoardCartVO vo = mybatis.selectOne("SaleBoardDAO.checkCart", map);
		if(vo!=null) {
			mybatis.delete("SaleBoardDAO.deleteCart",vo);
		}else {
			mybatis.insert("SaleBoardDAO.insertCart",map);
		}
		return vo;
	}

	@Override
	// 드로잉샵 게시글 찜 상태 불러오기 DAO
	public SaleBoardCartVO checkCartView(HashMap map) {
		return mybatis.selectOne("SaleBoardDAO.checkCart",map);
	}
}
