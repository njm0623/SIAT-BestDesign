package siat.bestdesign.saleboard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

@Repository("saleBoardDAO")
public class SaleBoardDAOImpl implements SaleBoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis insertSaleBoard() 호출");
		mybatis.insert("SaleBoardDAO.insertSaleBoard", vo);
	}
	
	@Override
	public void updateSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis updateSaleBoard() 호출");
		mybatis.update("SaleBoardDAO.updateSaleBoard", vo);
	}
	
	@Override
	public void deleteSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis deleteSaleBoard() 호출");
		mybatis.delete("SaleBoardDAO.deleteSaleBoard", vo);
	}
	
	@Override
	public SaleBoardVO getSaleBoard(SaleBoardVO vo) {
		System.out.println("===> Mybatis getSaleBoard() 호출");
		return (SaleBoardVO) mybatis.selectOne("SaleBoardDAO.getSaleBoard", vo);
	}

	@Override
	public List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo) {
		System.out.println("===> Mybatis getSaleBoardList() 호출");
		return mybatis.selectList("SaleBoardDAO.getSaleBoardList", vo);
	}
	
	@Override
	public int countSaleBoardList(HashMap param) {
		System.out.println("===> Mybatis countSaleBoardList() 호출");
		return mybatis.selectOne("SaleBoardDAO.countSaleBoardList", param);
	}

	@Override
	public void updateSaleBoardView(SaleBoardVO vo) {
		System.out.println("===> Mybatis updateSaleBoardView() 호출");
		mybatis.update("SaleBoardDAO.updateSaleBoardView", vo);
	}
	
	public void saleBoardPurchase(SaleBoardDealVO vo) {
		System.out.println("===> Mybatis saleBoardPurchase() 호출");
		mybatis.insert("SaleBoardDAO.saleBoardPurchase", vo);
	}
}
