package siat.bestdesign.manager.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.manager.domain.RequestChartVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

@Repository
public class ManagerDAOImpl implements ManagerDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public ManagerVO selectLogin(ManagerVO vo) {
		return mybatis.selectOne("manager.managerLogin",vo);
	}

	@Override
	public List<UserVO> getBoardList(UserVO vo) {
		System.out.println("===> Mybatis getBoardList() 호출");
		return mybatis.selectList("users.userList",vo);
	}
	
	@Override
	public List<UserVO> getDesignList(UserVO vo) {
		System.out.println("===> Mybatis getDesignList() 호출");
		System.out.println(vo.toString()+"디자이너 리스트");
		return mybatis.selectList("users.designerList",vo);
	}
	
	@Override
	public List<SaleBoardVO> getDesignSale(SaleBoardVO vo) {
		System.out.println("===> Mybatis getDesignSale() 호출");
		System.out.println(vo.toString()+"디자이너 판매 리스트");
		return mybatis.selectList("SaleBoardDAO.saleList",vo);
	}
	
	@Override
	public List<UserVO> getWriteList(UserVO vo) {
		System.out.println("===> Mybatis getWriteList() 호출");
		return mybatis.selectList("users.userList",vo);
	}

	@Override
	public List<RequestBoardVO> getRegiWrite(RequestBoardVO vo) {
		System.out.println("===> Mybatis getRegiWrite() 호출");
		System.out.println(vo.toString()+"고객 견적글 리스트");
		return mybatis.selectList("requestadm.writeList",vo);
	}
	
	@Override
	public List<ReviewVO> getRegiReview(ReviewVO vo) {
		System.out.println("===> Mybatis getRegiReview() 호출");
		System.out.println(vo.toString()+"고객 리뷰 리스트");
		return mybatis.selectList("ReviewDAO.reviewList",vo);
	}
	
	@Override
	public List<ContactVO> getRegiContact(ContactVO vo) {
		System.out.println("===> Mybatis getRegiContact() 호출");
		System.out.println(vo.toString()+"고객 문의 리스트");
		return mybatis.selectList("contactBoard.selectIdList",vo);
	}
	
	@Override
	public List<RequestBoardVO> getRequestList(RequestBoardVO vo) {
		System.out.println("===> Mybatis getRequestList() 호출");
		System.out.println(vo.toString()+"그려주세요 리스트");
		return mybatis.selectList("requestadm.allList",vo);
	}
	
	@Override
	public List<SaleBoardVO> getSaleList(SaleBoardVO vo) {
		System.out.println("===> Mybatis getSaleList() 호출");
		System.out.println(vo.toString()+"드로잉샵 리스트");
		return mybatis.selectList("SaleBoardDAO.allList",vo);
	}
	@Override
	public List<RequestChartVO> getChartList(String board, String deal) {
		System.out.println("===> Mybatis getChartList() 호출");
		if(board.equals("requestdeal")){
		    if(deal.equals("month")){
		    	return mybatis.selectList("chart.getRequestMonth");
		    }else{
		    	return mybatis.selectList("chart.getRequestYear");		    	
		    }
		}else if(board.equals("saledeal")){
			if(deal.equals("month")){
		    	return mybatis.selectList("chart.getSaleMonth");
		    }else{
		    	return mybatis.selectList("chart.getSaleYear");		    	
		    }
		}
		return null;
	}
	
	@Override
	public List<ContactVO> getContactList(ContactVO vo) {
		System.out.println("===> Mybatis getContactList() 호출");
		System.out.println(vo.toString()+"전체 문의글 리스트");
		return mybatis.selectList("contactBoard.getContactList",vo);
	}
}