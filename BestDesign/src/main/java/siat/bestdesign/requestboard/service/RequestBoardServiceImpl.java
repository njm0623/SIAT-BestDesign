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
	
	@Override
	public void insertRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.insertRequestBoard(vo);
	}

	@Override
	public void updateRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.updateRequestBoard(vo);
	}

	@Override
	public void deleteRequestBoard(RequestBoardVO vo) {
		requestBoardDAO.deleteRequestBoard(vo);
	}

	@Override
	public RequestBoardVO getRequestBoard(RequestBoardVO vo) {
		return requestBoardDAO.getRequestBoard(vo);
	}

	@Override
	public List<RequestBoardVO> getRequestBoardList(RequestBoardPagingVO vo) {
		return requestBoardDAO.getRequestBoardList(vo);
	}
	
	@Override
	public int countRequestBoardList(HashMap param) {
		return requestBoardDAO.countRequestBoardList(param);
	}

	@Override
	public void updateRequestBoardView(RequestBoardVO vo) {
		requestBoardDAO.updateRequestBoardView(vo);
	}
}
