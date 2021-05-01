package siat.bestdesign.requestboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.requestboard.dao.RequestBoardDAOImpl;
import siat.bestdesign.requestboard.domain.RequestBoardPagingVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;

@Service("requestBoardService")
public class RequestBoardServiceImpl implements RequestBoardService {
	@Autowired
	private RequestBoardDAOImpl requestBoardDAO;
	
	public void insertRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.insertRequestBoard(vo);
	}

	public void updateRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.updateRequestBoard(vo);
	}

	public void deleteRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.deleteRequestBoard(vo);
	}

	public RequestBoardVO getRequestBoard(RequestBoardVO vo) {
		return requestBoardDAO.getRequestBoard(vo);
	}

	public List<RequestBoardVO> getRequestBoardList(RequestBoardPagingVO vo) {
		return requestBoardDAO.getRequestBoardList(vo);
	}
	
	public int countRequestBoardList(HashMap<String, Object> param) {
		return requestBoardDAO.countRequestBoardList(param);
	}

	@Override
	public void updateRequestBoardView(RequestBoardVO vo) {
		requestBoardDAO.updateRequestBoardView(vo);
	}
}
