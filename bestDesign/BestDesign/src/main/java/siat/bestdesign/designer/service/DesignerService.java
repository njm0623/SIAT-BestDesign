package siat.bestdesign.designer.service;

import java.util.Map;

import siat.bestdesign.designer.domain.DesignerVO;

public interface DesignerService {

	DesignerVO mapToDesigner(Map<String, Object> map);

	void insertDesigner(DesignerVO vo);

	int selectLogin(DesignerVO vo);

}
