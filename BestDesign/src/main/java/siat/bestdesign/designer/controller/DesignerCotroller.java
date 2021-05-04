package siat.bestdesign.designer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String profile(Model m, DesignerVO vo) {
		if(designerService.checkId(vo)!=1) {
			return "redirect:/main/index.do";
		}
		m.addAttribute("Profile", designerService.selectDesigner(vo));
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
	
	
	
}
