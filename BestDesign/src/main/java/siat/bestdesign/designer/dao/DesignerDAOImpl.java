package siat.bestdesign.designer.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.designer.domain.DesignerCartVO;
import siat.bestdesign.designer.domain.DesignerListPagingVO;
import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

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

	public List<DesignerVO> getAllDesigner(DesignerListPagingVO vo) {
		return mybatis.selectList("designer.getAllDesigner", vo);
	}
	
	public int getTotalCount(DesignerListPagingVO vo) {
		return mybatis.selectOne("designer.getTotalCount", vo);
	}
	

	public List<SaleBoardVO> designerPerDrawing(DesignerVO vo) {
		return mybatis.selectList("designer.designerPerDrawing",vo);
	}

	public DesignerCartVO checkCart(HashMap map) {
		DesignerCartVO vo = mybatis.selectOne("designer.checkCart",map);
		if(vo!=null) {
			mybatis.delete("designer.deleteCart",vo);
		}else {
			mybatis.insert("designer.insertCart",map);
		}
		return vo;
	}

	public DesignerCartVO checkCartView(HashMap map) {
		return mybatis.selectOne("designer.checkCart",map);
	}

}
