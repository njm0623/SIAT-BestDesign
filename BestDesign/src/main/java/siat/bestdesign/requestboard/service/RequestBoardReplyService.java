package siat.bestdesign.requestboard.service;

import java.util.List;

import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;

public interface RequestBoardReplyService {

	Integer insertReply(RequestBoardReplyVO vo);

	List<RequestBoardReplyVO> selectAllReply(String requestNum);

	int deleteReply(String auctionNum);

	int modifyReply(RequestBoardReplyVO vo);
}