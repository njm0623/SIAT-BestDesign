package siat.bestdesign.designer.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
//		DesignerVO vo = new DesignerVO((String)map.get("userID"), (String)map.get("userPassword"), (String)map.get("userName"), (String)map.get("userEmail"), (String)map.get("userBirth"), (String)map.get("userPhone"));
		return null;
	}

	@Override
	public void insertDesigner(DesignerVO vo) {
		designerDAO.insertDesigner(vo);
	}

	@Override
	public DesignerVO selectLogin(DesignerVO vo) {
		return designerDAO.selectLogin(vo);
	}
	
	@Override
	public int checkId(DesignerVO vo) {
		DesignerVO result = designerDAO.selectLogin(vo);
		if(result!=null){
			return 1;//존재
		}else{
			if(vo.getDesignerId().length()==0){
				return 2;//아이디 먼저 입력해
			}else{
				return 0;//사용 가능
			}
		}
	}

}
