package siat.bestdesign.saleboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;

@Repository("saleBoardReplyDAO")
public class SaleBoardReplyDAOImpl implements SaleBoardReplyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public Integer insertReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis insertReply() 호출");	
		return mybatis.insert("SaleBoardReplyDAO.insertReply", vo);
	}

	@Override
	public List<SaleBoardReplyVO> selectAllReply(String saleNum) {
		System.out.println("===> Mybatis selectAllReply() 호출");	
		return mybatis.selectList("SaleBoardReplyDAO.selectAllReply", saleNum);
	}

	@Override
	public int deleteReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis deleteReply() 호출");	
		return mybatis.delete("SaleBoardReplyDAO.deleteReply", vo);
	}
	
	@Override
	public int modifyReply(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis modifyReply() 호출");	
		return mybatis.update("SaleBoardReplyDAO.modifyReply", vo);
	}
	
	@Override
	public void insertSaleBoardDeal(SaleBoardDealVO vo) {
		System.out.println("===> Mybatis insertSaleBoardDeal() 호출");
		mybatis.insert("SaleBoardReplyDAO.insertSaleBoardDeal", vo);
	}
	
	@Override
	public void updateSaleBoardRate(SaleBoardReplyVO vo) {
		System.out.println("===> Mybatis modifyReply() 호출");	
		mybatis.update("SaleBoardReplyDAO.updateSaleBoardRate", vo);
	}
}