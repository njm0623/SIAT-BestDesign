package siat.bestdesign.manager.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.manager.dao.ManagerDAOImpl;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDAOImpl managerDAO;


	@Override
	public ManagerVO selectLogin(ManagerVO vo) {
		return managerDAO.selectLogin(vo);
	}
	@Override
	public List<ChartVO> getChartList() { // 차트
		return managerDAO.getChartList();
	}
	
	@Override
	public List<UserVO> getBoardList(UserVO vo) { // 고객목록 게시판
		return managerDAO.getBoardList(vo);
	}
	@Override
	public List<UserVO> getWriteList(UserVO vo) { // 고객 글목록 게시판
		return managerDAO.getWriteList(vo);
	}
	@Override
	public List<UserVO> getDesignList(UserVO vo) { //디자이너 목록 
		return managerDAO.getDesignList(vo);
	}
	@Override
	public List<SaleBoardVO> getDesignSale(SaleBoardVO vo) { //디자이너 판매리스트 
		return managerDAO.getDesignSale(vo);
	}
	@Override
	public List<RequestBoardVO> getRegiWrite(RequestBoardVO vo) { // 고객 글목록 게시판
		return managerDAO.getRegiWrite(vo);
	}
	@Override
	public List<ReviewVO> getRegiReview(ReviewVO vo) { //고객 리뷰 게시판
		return managerDAO.getRegiReview(vo);
	}
	@Override
	public List<ContactVO> getRegiContact(ContactVO vo) { //고객 문의 글 리스트
		return managerDAO.getRegiContact(vo);
	}
	
	@Override
	public List<RequestBoardVO> getRequestList(RequestBoardVO vo) { //그려주세요 리스트
		return managerDAO.getRequestList(vo);
	}
	@Override
	public List<SaleBoardVO> getSaleList(SaleBoardVO vo) { //드로잉샵 리스트
		return managerDAO.getSaleList(vo);
	}



}
