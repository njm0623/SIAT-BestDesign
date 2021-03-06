package siat.bestdesign.requestboard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.requestboard.domain.RequestBoardPagingVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;

@Repository("requestBoardDAO")
public class RequestBoardDAOImpl implements RequestBoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertRequestBoard(RequestBoardVO vo) {
		System.out.println("===> Mybatis insertRequestBoard() 호출");
		mybatis.insert("RequestBoardDAO.insertRequestBoard", vo);
	}
	
	@Override
	public void updateRequestBoard(RequestBoardVO vo) {
		System.out.println("===> Mybatis updateRequestBoard() 호출");
		mybatis.update("RequestBoardDAO.updateRequestBoard", vo);
	}
	
	@Override
	public void deleteRequestBoard(RequestBoardVO vo) {
		System.out.println("===> Mybatis deleteRequestBoard() 호출");
		mybatis.delete("RequestBoardDAO.deleteRequestBoard", vo);
	}
	
	@Override
	public RequestBoardVO getRequestBoard(RequestBoardVO vo) {
		System.out.println("===> Mybatis getRequestBoard() 호출");
		return (RequestBoardVO) mybatis.selectOne("RequestBoardDAO.getRequestBoard", vo);
	}

	@Override
	public List<RequestBoardVO> getRequestBoardList(RequestBoardPagingVO vo) {
		System.out.println("===> Mybatis getRequestBoardList() 호출");
		return mybatis.selectList("RequestBoardDAO.getRequestBoardList", vo);
	}
	
	@Override
	public int countRequestBoardList(HashMap param) {
		System.out.println("===> Mybatis countRequestBoardList() 호출");
		return mybatis.selectOne("RequestBoardDAO.countRequestBoardList", param);
	}

	@Override
	public void updateRequestBoardView(RequestBoardVO vo) {
		System.out.println("===> Mybatis updateRequestBoardView() 호출");
		mybatis.update("RequestBoardDAO.updateRequestBoardView", vo);
	}
}
