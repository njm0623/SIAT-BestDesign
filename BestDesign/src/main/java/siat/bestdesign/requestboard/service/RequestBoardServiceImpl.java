package siat.bestdesign.requestboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.requestboard.dao.RequestBoardDAOImpl;
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

	public List<RequestBoardVO> getRequestBoardList(RequestBoardVO vo) {
		return requestBoardDAO.getRequestBoardList(vo);
	}
}
