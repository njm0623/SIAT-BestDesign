package siat.bestdesign.designer.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.designer.domain.DesignerVO;

@Repository("designerDAO")
public class DesignerDAOImpl implements DesignerDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertDesigner(DesignerVO vo) {
		mybatis.insert("designer.designerInsert", vo);
	}

	@Override
	public DesignerVO selectLogin(DesignerVO vo) {
		return mybatis.selectOne("designer.designerLogin",vo);
	}

	public void updateDesigner(DesignerVO vo) {
		mybatis.update("designer.designerUpdate",vo);
	}

	public List<DesignerVO> getAllDesigner(HashMap map) {
		return mybatis.selectList("designer.getAllDesigner",map);
	}

	public int getTotalCount() {
		return mybatis.selectOne("designer.getTotalCount");
	}

}
