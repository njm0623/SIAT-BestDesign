package siat.bestdesign.saleboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;

@Repository("saleBoardReplyDAO")
// 드로잉샵 리뷰, 거래, 평점 
public class SaleBoardReplyDAOImpl implements SaleBoardReplyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	// 드로잉샵 리뷰 등록 DAO
	public Integer insertReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis insertReply() 호출");	
		return mybatis.insert("SaleBoardReplyDAO.insertReply", vo);
	}

	@Override
	// 드로잉샵 리뷰 목록 불러오기 DAO
	public List<SaleBoardReplyVO> selectAllReply(String saleNum) {
		System.out.println("===> Mybatis selectAllReply() 호출");	
		return mybatis.selectList("SaleBoardReplyDAO.selectAllReply", saleNum);
	}

	@Override
	// 드로잉샵 리뷰 삭제 DAO
	public int deleteReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis deleteReply() 호출");	
		return mybatis.delete("SaleBoardReplyDAO.deleteReply", vo);
	}
	
	@Override
	// 드로잉샵 리뷰 수정 DAO
	public int modifyReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis modifyReply() 호출");	
		return mybatis.update("SaleBoardReplyDAO.modifyReply", vo);
	}
	
	@Override
	// 드로잉샵 가격 내역 등록 DAO
	public void insertSaleBoardDeal(SaleBoardDealVO vo) {
		System.out.println("===> Mybatis insertSaleBoardDeal() 호출");
		mybatis.insert("SaleBoardReplyDAO.insertSaleBoardDeal", vo);
	}
	
	@Override
	// 드로잉샵 게시글 평점 갱신 DAO
	public void updateSaleBoardRate(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis modifyReply() 호출");	
		mybatis.update("SaleBoardReplyDAO.updateSaleBoardRate", vo);
	}
}
