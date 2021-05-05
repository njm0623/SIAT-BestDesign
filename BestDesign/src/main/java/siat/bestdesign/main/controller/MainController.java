package siat.bestdesign.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import siat.bestdesign.main.service.MainService;

@Controller
@RequestMapping("main")
public class MainController {

	
	private Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		log.info("main에서 viewPage동작");
		System.out.println("main에서 자신 반환하는 모든 동작 : " + step);
		return "main/"+step;
	}
	
	@RequestMapping("index.do")
	public void index(Model m) {
		log.info("main에서 index동작");
		System.out.println("main 에서 index.do");
		m.addAttribute("dList",mainService.getTopDesigner());
		m.addAttribute("sList",mainService.getHotDrawing());
		m.addAttribute("a_List",mainService.getDrawing("portraits"));
		m.addAttribute("b_List",mainService.getDrawing("landscape"));
		m.addAttribute("c_List",mainService.getDrawing("sentence"));
	}
}