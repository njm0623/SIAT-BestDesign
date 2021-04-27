package siat.bestdesign.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("user에서 자신 반환하는 모든 동작 : " + step);
		return "user/"+step;
	}

	
	@RequestMapping("signup.do")
	public String signUp(Model m, @RequestParam Map<String, Object> map) {
		System.out.println("user에서 signup");
		m.addAllAttributes(map);
		if(map.get("userType").equals("고객"))
			return "redirect:/customer/signup.do";
		return "redirect:/designer/signup.do";
	}
	
	@RequestMapping("login.do")
	public String login(Model m, String userID, String userPassword, String userType) {
		System.out.println("user에서 login");
		if(userType.equals("고객")) {
			m.addAttribute("customerId",userID);
			m.addAttribute("customerPwd",userPassword);
			return "redirect:/customer/login.do";
		}else {
			m.addAttribute("designerId",userID);
			m.addAttribute("designerPwd",userPassword);
			return "redirect:/designer/login.do";
		}
	}
	
	@RequestMapping(value="checkId.do")
	public String checkId(Model m, String id, String type) {
		System.out.println("user에서 checkid");
		if(type.equals("고객")) {
			m.addAttribute("customerId",id);
			return "redirect:/customer/checkId.do";
		}else {
			m.addAttribute("designerId",id);
			return "redirect:/designer/checkId.do";
		}
	}
}
