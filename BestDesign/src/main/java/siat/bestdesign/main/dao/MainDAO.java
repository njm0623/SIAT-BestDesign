package siat.bestdesign.main.dao;

import java.util.List;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.main.domain.MainVO;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

public interface MainDAO {
	List<MainVO> getTopDesigner();
}
