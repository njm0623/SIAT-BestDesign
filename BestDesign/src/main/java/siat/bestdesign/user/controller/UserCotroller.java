package siat.bestdesign.user.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.controller.ChatController;
import siat.bestdesign.user.domain.UserVO;
import siat.bestdesign.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserCotroller {
	//컨트롤러이름.class
	//log.info("'컨트롤러 매핑' 이름 에서 '메소드 명' 동작")
	private Logger log = LoggerFactory.getLogger(ChatController.class);
		
	@Autowired
	UserService userService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		log.info("user에서 "+step+"동작");
		System.out.println("user에서 자신 반환하는 모든 동작 : " + step);
		return "user/"+step;
	}
	
	
	@RequestMapping("signup.do")
	public String signUp(UserVO vo, HttpSession session) {
		log.info("signup에서 동작");
		System.out.println("signup");
		userService.insertUser(vo);
		session.setAttribute("messageType", "성공");
		session.setAttribute("messageContent", "회원가입에 성공했습니다.");
		return "redirect:/main/index.do";
	}
	
	@RequestMapping("login.do")
	public String login(UserVO vo, HttpSession session) {
		log.info("login에서 동작");
		System.out.println("user에서 login동작");
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
		log.info("user에서 checkids실행동작");
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
		log.info("user에서 userFind동작");
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
