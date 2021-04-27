package siat.bestdesign.designer.dao;

import siat.bestdesign.designer.domain.DesignerVO;

public interface DesignerDAO {

	void insertDesigner(DesignerVO vo);
	
	DesignerVO selectLogin(DesignerVO vo);
	
}
