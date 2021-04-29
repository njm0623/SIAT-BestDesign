package siat.bestdesign.requestboard.service;

import java.util.List;

import siat.bestdesign.requestboard.domain.RequestBoardVO;

public interface RequestBoardService {
	void insertRequestBoard(RequestBoardVO vo);

	void updateRequestBoard(RequestBoardVO vo);

	void deleteRequestBoard(RequestBoardVO vo);

	RequestBoardVO getRequestBoard(RequestBoardVO vo);

	List<RequestBoardVO> getRequestBoardList(RequestBoardVO vo);
}
