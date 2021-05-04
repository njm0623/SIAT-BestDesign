package siat.bestdesign.designer.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.designer.domain.DesignerCartVO;
import siat.bestdesign.designer.domain.DesignerVO;

public interface DesignerDAO {

	void insertDesigner(DesignerVO vo);
	
	DesignerVO selectLogin(DesignerVO vo);
	
	List<DesignerVO> getAllDesigner(HashMap map);
	
	int getTotalCount();
	
	List<SaleBoardVO> designerPerDrawing(DesignerVO vo);
	
	DesignerCartVO checkCart(HashMap map);
	DesignerCartVO checkCartView(HashMap map);
}
