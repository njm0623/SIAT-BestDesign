package siat.bestdesign.requestboard.dao;

import java.util.List;

import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;

public interface RequestBoardReplyDAO {

	Integer insertReply(RequestBoardReplyVO vo);

	List<RequestBoardReplyVO> selectAllReply(String requestNum);

	int deleteReply(String auctionNum);

	int modifyReply(RequestBoardReplyVO vo);
}