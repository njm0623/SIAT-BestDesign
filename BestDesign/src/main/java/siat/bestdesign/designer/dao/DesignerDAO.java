package siat.bestdesign.designer.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.designer.domain.DesignerCartVO;
import siat.bestdesign.designer.domain.DesignerListPagingVO;
import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

public interface DesignerDAO {

	void insertDesigner(DesignerVO vo);
	
	DesignerVO selectLogin(DesignerVO vo);
	
	List<DesignerVO> getAllDesigner(DesignerListPagingVO vo);
	
	// int getTotalCount(HashMap param);
	
	int getTotalCount(DesignerListPagingVO vo);
	
	List<SaleBoardVO> designerPerDrawing(DesignerVO vo);
	
	DesignerCartVO checkCart(HashMap map);
	DesignerCartVO checkCartView(HashMap map);
}
