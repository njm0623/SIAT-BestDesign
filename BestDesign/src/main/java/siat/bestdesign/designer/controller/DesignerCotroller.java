package siat.bestdesign.designer.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.designer.domain.DesignerListPagingVO;
import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.designer.service.DesignerService;

@Controller
@RequestMapping("designer")
public class DesignerCotroller {

	@Autowired
	DesignerService designerService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("자신 반환하는 모든 동작 : " + step);
		return "designer/"+step;
	}
	
	@RequestMapping(value= {"profile.do"})
	public String profile(Model m, DesignerVO vo, HttpSession session) {
		if(designerService.checkId(vo)!=1) {
			return "redirect:/main/index.do";
		}
		m.addAttribute("Profile", designerService.selectDesigner(vo));
		m.addAttribute("draw", designerService.designerPerDrawing(vo));
		
		HashMap map = new HashMap();
		String userId = "";
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		map.put("userId", userId);
		map.put("designerId", vo.getDesignerId());
		String star = null;
		if(designerService.checkCartView(map)!=null) {
			star = "★";
		}else {
			star = "☆";
		}
		m.addAttribute("dcart", star);
		return null;
	}
	@RequestMapping(value= {"edit.do"})
	public String edit(Model m, DesignerVO vo) {
		if(designerService.checkId(vo)!=1) {
			return "redirect:/main/index.do";
		}
		m.addAttribute("Profile", designerService.editDesigner(vo));
		return null;
	}
	
	@RequestMapping("updateProfile.do")
	public String updateProfile(DesignerVO vo) {
		System.out.println("designer 에서 updateProfile");
		designerService.updateDesigner(vo);
		return "redirect:/designer/profile.do?designerId="+vo.getDesignerId();
	}
	
	@RequestMapping("designerList.do")
	public void designerList(DesignerListPagingVO vo, Model model, HttpSession session) {
		System.out.println("designer에서 designerList");
		
		if (vo.getOrderby() == null) vo.setOrderby("name");
		if (vo.getCart() == null) vo.setCart("off");
		
		String userId = "";
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		
		vo.setUserId(userId);
		vo.setTotal(designerService.getTotalPage(vo));
		
		if (vo.getNowPage() == 0 && vo.getCntPerPage() == 0) {
			vo.setNowPage(1);
			vo.setCntPerPage(9);
		}
		else if (vo.getNowPage() == 0) {
			vo.setNowPage(1);
		}
		else if (vo.getCntPerPage() == 0) {
			vo.setCntPerPage(3);
		}
		
		vo.setLastPage((int)Math.ceil((double) vo.getTotal() / (double) vo.getCntPerPage()));
		
		vo.setEndPage((int) Math.ceil((double) vo.getNowPage() / (double) vo.getCntPage()) * vo.getCntPage());
		
		if (vo.getLastPage() < vo.getEndPage()) {
			vo.setEndPage(vo.getLastPage());
		}
		
		vo.setStartPage(vo.getEndPage() - vo.getCntPage() + 1);
		if (vo.getStartPage() < 1) {
			vo.setStartPage(1);
		}
		
		vo.setEnd(vo.getNowPage() * vo.getCntPerPage());
		vo.setStart(vo.getEnd() - vo.getCntPerPage() + 1);		
		
		model.addAttribute("designerListPaging", vo);
		model.addAttribute("dList", designerService.getAllDesigner(vo));
	}
	

	@RequestMapping(value="checkCart.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody
	public String checkCart(String userId, String designerId) {
		System.out.println("designer에서 checkCart");
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("designerId", designerId);
		if(designerService.checkCart(map)!=null) {
			return "☆";
		}else {
			return "★";
		}
	}
	
	
}
