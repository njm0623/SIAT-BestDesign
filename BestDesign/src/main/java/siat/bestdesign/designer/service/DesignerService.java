package siat.bestdesign.designer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

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
}
