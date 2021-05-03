package siat.bestdesign.requestboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.requestboard.dao.RequestBoardReplyDAOImpl;
import siat.bestdesign.requestboard.domain.RequestBoardDealVO;
import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;

@Service("requestBoardReplyService")
public class RequestBoardReplyServiceImpl implements RequestBoardReplyService {
	@Autowired
	private RequestBoardReplyDAOImpl requestBoardReplyDAO;

	@Override
	public Integer insertReply(RequestBoardReplyVO vo) {
		return requestBoardReplyDAO.insertReply(vo);
	}

	@Override
	public List<RequestBoardReplyVO> selectAllReply(String requestNum) {	
		return requestBoardReplyDAO.selectAllReply(requestNum);
	}

	@Override
	public int deleteReply(String auctionNum) {
		return requestBoardReplyDAO.deleteReply(auctionNum);
	}
	
	@Override
	public int modifyReply(RequestBoardReplyVO vo) {
		return requestBoardReplyDAO.modifyReply(vo);
	}
	
	@Override
	public void insertRequestBoardDeal(RequestBoardDealVO vo) {
		requestBoardReplyDAO.insertRequestBoardDeal(vo);
	}
	
	@Override
	public void updateRequestBoardState(RequestBoardDealVO vo) {
		requestBoardReplyDAO.updateRequestBoardState(vo);
	}
}
