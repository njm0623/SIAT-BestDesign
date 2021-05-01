package siat.bestdesign.requestboard.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.requestboard.domain.RequestBoardPagingVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;

public interface RequestBoardDAO {

	void insertRequestBoard(RequestBoardVO vo);

	void updateRequestBoard(RequestBoardVO vo);

	void deleteRequestBoard(RequestBoardVO vo);

	RequestBoardVO getRequestBoard(RequestBoardVO vo);

	List<RequestBoardVO> getRequestBoardList(RequestBoardPagingVO vo);

	int countRequestBoardList(HashMap<String, Object> param);
	
	void updateRequestBoardView(RequestBoardVO vo);
}