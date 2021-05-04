package siat.bestdesign.manager.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.manager.service.ManagerService;

@Controller
@RequestMapping("manager")
public class ManagerCotroller {

	@Autowired
	ManagerService managerService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("manager에서 자신 반환하는 모든 동작 : " + step);
		return "manager/"+step;
	}
	
	@RequestMapping("login.do")
	public String login(ManagerVO vo, HttpSession session) {
		System.out.println("manager에서 login");
		System.out.println(vo.getManagerId() + " : " + vo.getManagerPwd());
		ManagerVO vo2 = managerService.selectLogin(vo);
		String msg = "", content = "", href = "";
		
		if(vo2!=null) {
			if(vo2.getManagerPwd().equals(vo.getManagerPwd())) {
				session.setAttribute("userID", vo2.getManagerId());
				session.setAttribute("type", "관리자");
				msg = "성공";
				content = "로그인에 성공했습니다.";
				href = "main/index.do";
			}else {
				msg = "오류";
				content = "비밀번호가 일치하지 않습니다.";
				href = "main/manager.do";
			}
		}else {
			msg = "오류";
			content = "아이디가 존재하지 않습니다.";
			href = "main/manager.do";
		}
		
		session.setAttribute("messageType", msg);
		session.setAttribute("messageContent", content);
		System.out.println(session.getAttribute("messageContent"));
		return "redirect:/"+href;
		
	}
	
	
	
	
}
