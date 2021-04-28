package siat.bestdesign.designer.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.designer.service.DesignerService;

@Controller
@RequestMapping("designer")
public class DesignerCotroller {

	@Autowired
	DesignerService designerService;
	
//	@RequestMapping("/{step}.do")
//	public String viewPage(@PathVariable String step) {
//		System.out.println("자신 반환하는 모든 동작 : " + step);
//		return "designer/"+step;
//	}
//	
//	@RequestMapping("signup.do")
//	public String signup(@RequestParam Map<String, Object> map) {
//		System.out.println("designer에서 signup");
//		DesignerVO vo = designerService.mapToDesigner(map);
//		designerService.insertDesigner(vo);
//		return "redirect:/main/index.do";
//	}
//	
//	@RequestMapping("login.do")
//	public String login(String designerId, String designerPwd, HttpSession session) {
//		System.out.println("designer에서 login");
//		DesignerVO vo = new DesignerVO();
//		vo.setDesignerId(designerId);
//		vo.setDesignerPwd(designerPwd);
//		DesignerVO vo2 = designerService.selectLogin(vo);
//		
//		
//		String msg = "", content = "", href = "";
//		if(vo2!=null) {
//			if(vo2.getDesignerPwd().equals(vo.getDesignerPwd())) {
//				session.setAttribute("userID", designerId);
//				msg = "성공";
//				content = "로그인에 성공했습니다.";
//				href = "main/index.do";
//			}else {
//				msg = "오류";
//				content = "비밀번호가 일치하지 않습니다.";
//				href = "chat/login.do";
//			}
//		}else {
//			msg = "오류";
//			content = "아이디가 존재하지 않습니다.";
//			href = "chat/login.do";
//		}
//		session.setAttribute("messageType", msg);
//		session.setAttribute("messageContent", content);
//		return "redirect:/"+href;
//	}
//	
//	@RequestMapping(value="checkId.do",produces="application/text; charset=utf-8")//아약스 인코딩
//	@ResponseBody	//아약스 필수
//	public String checkId(String designerId, HttpSession session) {
//		System.out.println("designer에서 checkid");
//		DesignerVO vo = new DesignerVO();
//		vo.setDesignerId(designerId);
//		int result = designerService.checkId(vo);
//		System.out.println(result);
//		if(result==1){
//			return "#f05454|중복된 아이디입니다.|1";
//		}else if(result==2){
//			return "#206a5d|아이디를 입력하세요.|1";
//		}else{
//			return "#3c415c|사용 가능한 아이디입니다.|2";
//		}
//	}
//	@RequestMapping(value="userFind.do",produces="application/text; charset=utf-8")//아약스 인코딩
//	@ResponseBody	//아약스 필수
//	public String userFind(String designerId, HttpSession session) {
//		System.out.println("designer에서 userFind");
//		DesignerVO vo = new DesignerVO();
//		vo.setDesignerId(designerId);
//		int result = designerService.checkId(vo);
//		if(result==1){
//			return "0";
//		}else{
//			return "1";
//		}
//	}
	
}
