package siat.bestdesign.saleboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("saleboard")
public class SaleBoardController {
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("saleboard에서 자신 반환하는 모든 동작 : " + step);
		return "saleboard/"+step;
	}
}