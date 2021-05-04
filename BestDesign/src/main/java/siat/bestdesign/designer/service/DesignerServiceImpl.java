package siat.bestdesign.designer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.designer.dao.DesignerDAOImpl;
import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

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

	@Override
	public void updateDesigner(DesignerVO vo) {
		designerDAO.updateDesigner(vo);
		
	}

	@Override
	public DesignerVO editDesigner(DesignerVO vo) {
		return designerDAO.selectLogin(vo);
		
	}
	@Override
	public DesignerVO selectDesigner(DesignerVO vo) {
		DesignerVO vo2 = designerDAO.selectLogin(vo);
		if(vo2.getDesignerProfile()!=null){
			vo2.setDesignerProfile(vo2.getDesignerProfile().replace("\r\n","<br>"));
		}
		return vo2;
	}

	@Override
	public List<DesignerVO> getAllDesigner(HashMap map) {
		return designerDAO.getAllDesigner(map);
	}

	@Override
	public int getTotalPage() {
		double t =  Math.ceil(designerDAO.getTotalCount()/9);
		return (int)t;
	}

	@Override
	public List<SaleBoardVO> designerPerDrawing(DesignerVO vo) {
		return designerDAO.designerPerDrawing(vo);
	}

}
