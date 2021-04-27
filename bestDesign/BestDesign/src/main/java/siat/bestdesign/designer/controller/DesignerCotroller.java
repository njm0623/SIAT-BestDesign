package siat.bestdesign.designer.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.designer.service.DesignerService;

@Controller
@RequestMapping("designer")
public class DesignerCotroller {

	@Autowired
	DesignerService designerService;
	
	@RequestMapping("signup.do")
	public String signup(Model m, @RequestParam Map<String, Object> map) {
		System.out.println("designer에서 signup");
		DesignerVO vo = designerService.mapToDesigner(map);
		designerService.insertDesigner(vo);
		return "index";
	}
	
	@RequestMapping("login.do")
	public String login(String designerId, String designerPwd, HttpSession session) {
		System.out.println("designer에서 login");
		DesignerVO vo = new DesignerVO();
		vo.setDesignerId(designerId);
		vo.setDesignerPwd(designerPwd);
		int result = designerService.selectLogin(vo);
		String msg = "", content = "", href = "";
		if(result == 1){
			session.setAttribute("userID", designerId);
			msg = "성공";
			content = "로그인에 성공했습니다.";
			href = "main/index.do";
		}else if(result == 2){
			msg = "오류";
			content = "비밀번호가 일치하지 않습니다.";
			href = "chat/login.do";
		}else{
			msg = "오류";
			content = "아이디가 존재하지 않습니다.";
			href = "chat/login.do";
		}
		session.setAttribute("messageType", msg);
		session.setAttribute("messageContent", content);
		return "redirect:/"+href;
	}
}
