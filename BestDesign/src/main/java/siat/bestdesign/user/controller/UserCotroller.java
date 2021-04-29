package siat.bestdesign.user.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.user.domain.UserVO;
import siat.bestdesign.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserCotroller {

	@Autowired
	UserService userService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("user에서 자신 반환하는 모든 동작 : " + step);
		return "user/"+step;
	}
	
	
	@RequestMapping("signup.do")
	public String signUp(UserVO vo) {
		System.out.println("user에서 signup");
		userService.insertUser(vo);
		return "redirect:/main/index.do";
	}
	
	@RequestMapping("login.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("user에서 login");
		UserVO vo2 = userService.selectLogin(vo);
		String msg = "", content = "", href = "";
		
		if(vo2!=null) {
			if(vo2.getUserType()!=vo.getUserType()) {
				msg = "오류";
				content = "아이디가 존재하지 않습니다.";
				href = "chat/login.do";
			}else if(vo2.getUserPwd().equals(vo.getUserPwd())) {
				session.setAttribute("userID", vo2.getUserId());
				if(vo2.getUserType()==1) {
					session.setAttribute("type", "고객");
				}else {					
					session.setAttribute("type", "디자이너");
				}
				msg = "성공";
				content = "로그인에 성공했습니다.";
				href = "main/index.do";
			}else {
				msg = "오류";
				content = "비밀번호가 일치하지 않습니다.";
				href = "chat/login.do";
			}
		}else {
			msg = "오류";
			content = "아이디가 존재하지 않습니다.";
			href = "chat/login.do";
		}
		session.setAttribute("messageType", msg);
		session.setAttribute("messageContent", content);
		System.out.println("login.do 에서 "+session.getAttribute("messageContent"));
		return "redirect:/"+href;
		
	}
	
	
	
	@RequestMapping(value="checkId.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String checkId(String id, HttpSession session) {
		System.out.println("user에서 checkid");
		UserVO vo = new UserVO();
		vo.setUserId(id);
		int result = userService.checkId(vo);
		if(result==1){
			return "#f05454|중복된 아이디입니다.|1";
		}else if(result==2){
			return "#206a5d|아이디를 입력하세요.|1";
		}else{
			return "#3c415c|사용 가능한 아이디입니다.|2";
		}
	}
	
	
	@RequestMapping(value="userFind.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String userFind(String userID, int type, HttpSession session) {
		System.out.println("user에서 userFind");
		UserVO vo = new UserVO();
		vo.setUserId(userID);
		vo.setUserType(type);
		int result = userService.checkType(vo);
		if(result==1){
			return "0";
		}else{
			return "1";
		}
	}
	
	
}
