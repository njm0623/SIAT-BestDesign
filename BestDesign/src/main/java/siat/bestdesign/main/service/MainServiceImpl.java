package siat.bestdesign.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.main.dao.MainDAOImpl;
import siat.bestdesign.main.domain.MainVO;

@Service("mainService")
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDAOImpl MainDAO;

	@Override
	public List<MainVO> getTopDesigner() {
		return MainDAO.getTopDesigner();
	}

	@Override
	public List<MainVO> getHotDrawing() {
		return MainDAO.getHotDrawing();
	}
	
}
