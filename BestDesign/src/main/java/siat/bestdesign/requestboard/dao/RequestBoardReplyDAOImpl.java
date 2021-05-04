package siat.bestdesign.requestboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.requestboard.domain.RequestBoardDealVO;
import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;

@Repository("requestBoardReplyDAO")
public class RequestBoardReplyDAOImpl implements RequestBoardReplyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public Integer insertReply(RequestBoardReplyVO vo) {
		System.out.println("===> Mybatis insertReply() 호출");	
		return mybatis.insert("RequestBoardReplyDAO.insertReply", vo);
	}

	@Override
	public List<RequestBoardReplyVO> selectAllReply(String requestNum) {
		System.out.println("===> Mybatis selectAllReply() 호출");	
		return mybatis.selectList("RequestBoardReplyDAO.selectAllReply", requestNum);
	}

	@Override
	public int deleteReply(String auctionNum) {
		System.out.println("===> Mybatis deleteReply() 호출");	
		return mybatis.delete("RequestBoardReplyDAO.deleteReply", auctionNum);
	}
	
	@Override
	public int modifyReply(RequestBoardReplyVO vo) {
		System.out.println("===> Mybatis modifyReply() 호출");	
		return mybatis.update("RequestBoardReplyDAO.modifyReply", vo);
	}
	
	@Override
	public void insertRequestBoardDeal(RequestBoardDealVO vo) {
		System.out.println("===> Mybatis insertRequestBoardDeal() 호출");
		mybatis.insert("RequestBoardReplyDAO.insertRequestBoardDeal", vo);
	}
	
	@Override
	public void updateRequestBoardState(RequestBoardDealVO vo) {
		System.out.println("===> Mybatis updateRequestBoardState() 호출");
		mybatis.update("RequestBoardReplyDAO.updateRequestBoardState", vo);
	}
}
