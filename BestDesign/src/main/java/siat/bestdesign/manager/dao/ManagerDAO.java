package siat.bestdesign.manager.dao;

import java.util.List;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

public interface ManagerDAO {
	List<ChartVO> getChartList();

	public List<UserVO> getBoardList(UserVO vo) ;//고객 목록
	
	public List<UserVO> getWriteList(UserVO vo) ;//고객 목록(게시글 게시판)
	
	public List<UserVO> getDesignList(UserVO vo) ;//디자이너 리스트
	
	public List<SaleBoardVO> getDesignSale(SaleBoardVO vo) ;//디자이너 판매리스트	

	public List<RequestBoardVO> getRegiWrite(RequestBoardVO vo) ;//고객 작성글 리스트

	public List<ReviewVO> getRegiReview(ReviewVO vo) ;//고객 리뷰 리스트
	
	public List<ContactVO> getRegiContact(ContactVO vo) ;//고객 작성글 리스트
	
	public List<RequestBoardVO> getRequestList(RequestBoardVO vo) ;//그려주세요 리스트
	
	public List<SaleBoardVO> getSaleList(SaleBoardVO vo) ;//드로잉샵 리스트

	ManagerVO selectLogin(ManagerVO vo);
}
