package siat.bestdesign.manager.service;

import java.util.List;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

public interface ManagerService {

List<ChartVO> getChartList();//차트
	
	List<UserVO> getBoardList(UserVO vo);//고객목록게시판
	
	List<UserVO> getDesignList(UserVO vo);//디자이너 목록
	
	List<SaleBoardVO> getDesignSale(SaleBoardVO vo);//디자이너 판매리스트
	
	List<UserVO> getWriteList(UserVO vo);//고객목록 (게시글목록)
		
	List<RequestBoardVO> getRegiWrite(RequestBoardVO vo);//고객이 작성한 글목록

	List<ContactVO> getRegiContact(ContactVO vo);//고객이 작성한 문의목록
	
	List<ReviewVO> getRegiReview(ReviewVO vo);//고객이 작성한 글목록
	
	List<RequestBoardVO> getRequestList(RequestBoardVO vo);//그려주세요 리스트
	
	List<SaleBoardVO> getSaleList(SaleBoardVO vo);//그려주세요 리스트
	
	ManagerVO selectLogin(ManagerVO vo);

}
