package siat.bestdesign.designer.service;

import java.util.Map;

import siat.bestdesign.designer.domain.DesignerCartVO;
import siat.bestdesign.designer.domain.DesignerVO;

public interface DesignerService {

	DesignerVO mapToDesigner(Map<String, Object> map);

	void insertDesigner(DesignerVO vo);

	DesignerVO selectLogin(DesignerVO vo);
	
	int checkId(DesignerVO vo);

	void updateDesigner(DesignerVO vo);

	DesignerVO selectDesigner(DesignerVO vo);

	DesignerVO editDesigner(DesignerVO vo);

	List<DesignerVO> getAllDesigner(HashMap map);

	int getTotalPage();

	List<SaleBoardVO> designerPerDrawing(DesignerVO vo);

	DesignerCartVO checkCart(HashMap map);

	DesignerCartVO checkCartView(HashMap map);
}
