package siat.bestdesign.designer.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

public interface DesignerDAO {

	void insertDesigner(DesignerVO vo);
	
	DesignerVO selectLogin(DesignerVO vo);
	
	List<DesignerVO> getAllDesigner(HashMap map);
	
	int getTotalCount();
	
	List<SaleBoardVO> designerPerDrawing(DesignerVO vo);
}
