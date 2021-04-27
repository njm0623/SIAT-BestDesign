package siat.bestdesign.designer.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.designer.dao.DesignerDAOImpl;

@Service("designerService")
public class DesignerServiceImpl implements DesignerService{
	
	@Autowired
	private DesignerDAOImpl designerDAO;

	@Override
	public DesignerVO mapToDesigner(Map<String, Object> map) {
		DesignerVO vo = new DesignerVO((String)map.get("userID"), (String)map.get("userPassword"), (String)map.get("userName"), (String)map.get("userEmail"), (String)map.get("userBirth"), (String)map.get("userPhone"));
		return vo;
	}

	@Override
	public void insertDesigner(DesignerVO vo) {
		designerDAO.insertDesigner(vo);
	}

	@Override
	public int selectLogin(DesignerVO vo) {
		DesignerVO vo2 = designerDAO.selectLogin(vo);
		if(vo2!=null) {
			if(vo2.getDesignerPwd().equals(vo.getDesignerPwd())) {
				return 1;//성공
			}
			return 2;//비밀번호 틀릭
		}else {
			return 0;//사용자 존재하지 않음
		}
	}

}
