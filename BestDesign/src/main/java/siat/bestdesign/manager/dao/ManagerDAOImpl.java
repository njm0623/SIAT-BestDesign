package siat.bestdesign.manager.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.manager.domain.ManagerVO;

@Repository("managerDAO")
public class ManagerDAOImpl implements ManagerDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;


	@Override
	public ManagerVO selectLogin(ManagerVO vo) {
		return mybatis.selectOne("manager.managerLogin",vo);
	}


}
