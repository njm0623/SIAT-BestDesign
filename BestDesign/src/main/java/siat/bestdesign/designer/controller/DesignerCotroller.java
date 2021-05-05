package siat.bestdesign.designer.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public void designerList(Model m, String num) {
		System.out.println("designer에서 designerList");
		int first, end;
		if(num==null) {
			first = 1;
			end = 9;
		}else {
			first = 1+Integer.parseInt(num)*9;
			end = 9+Integer.parseInt(num)*9;
		}
		HashMap map = new HashMap();
		map.put("first", first);
		map.put("end", end);
		m.addAttribute("dList", designerService.getAllDesigner(map));
		m.addAttribute("perPage",designerService.getTotalPage());
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
