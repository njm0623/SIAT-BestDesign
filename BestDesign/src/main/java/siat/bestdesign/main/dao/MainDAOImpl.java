package siat.bestdesign.main.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.main.domain.MainVO;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

@Repository("mainDAO")
public class MainDAOImpl implements MainDAO{

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<MainVO> getTopDesigner() {
		return mybatis.selectList("main.getTopDesigner");
	}

	public List<MainVO> getHotDrawing() {
		return mybatis.selectList("main.getHotDrawing");
	}
	
}