package siat.bestdesign.manager.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.manager.dao.ManagerDAOImpl;
import siat.bestdesign.manager.domain.ManagerVO;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDAOImpl managerDAO;


	@Override
	public ManagerVO selectLogin(ManagerVO vo) {
		return managerDAO.selectLogin(vo);
	}




}
