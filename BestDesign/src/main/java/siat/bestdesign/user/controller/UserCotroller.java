package siat.bestdesign.user.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		System.out.println("user�뿉�꽌 �옄�떊 諛섑솚�븯�뒗 紐⑤뱺 �룞�옉 : " + step);
		return "user/"+step;
	}
	
	
	@RequestMapping("signup.do")
	public String signUp(UserVO vo) {
		System.out.println("user�뿉�꽌 signup");
		userService.insertUser(vo);
		return "redirect:/main/index.do";
	}
	
	@RequestMapping("login.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("user�뿉�꽌 login");
		UserVO vo2 = userService.selectLogin(vo);
		String msg = "", content = "", href = "";
		
		if(vo2!=null) {
			if(vo2.getUserType()!=vo.getUserType()) {
				msg = "�삤瑜�";
				content = "�븘�씠�뵒媛� 議댁옱�븯吏� �븡�뒿�땲�떎.";
				href = "chat/login.do";
			}else if(vo2.getUserPwd().equals(vo.getUserPwd())) {
				session.setAttribute("userID", vo2.getUserId());
				if(vo2.getUserType()==1) {
					session.setAttribute("type", "怨좉컼");
				}else {					
					session.setAttribute("type", "�뵒�옄�씠�꼫");
				}
				msg = "�꽦怨�";
				content = "濡쒓렇�씤�뿉 �꽦怨듯뻽�뒿�땲�떎.";
				href = "main/index.do";
			}else {
				msg = "�삤瑜�";
				content = "鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�뒿�땲�떎.";
				href = "chat/login.do";
			}
		}else {
			msg = "�삤瑜�";
			content = "�븘�씠�뵒媛� 議댁옱�븯吏� �븡�뒿�땲�떎.";
			href = "chat/login.do";
		}
		session.setAttribute("messageType", msg);
		session.setAttribute("messageContent", content);
		System.out.println("login.do �뿉�꽌 "+session.getAttribute("messageContent"));
		return "redirect:/"+href;
		
	}
	
	
	
	@RequestMapping(value="checkId.do",produces="application/text; charset=utf-8")//�븘�빟�뒪 �씤肄붾뵫
	@ResponseBody	//�븘�빟�뒪 �븘�닔
	public String checkId(String id, HttpSession session) {
		System.out.println("user�뿉�꽌 checkid");
		UserVO vo = new UserVO();
		vo.setUserId(id);
		int result = userService.checkId(vo);
		if(result==1){
			return "#f05454|以묐났�맂 �븘�씠�뵒�엯�땲�떎.|1";
		}else if(result==2){
			return "#206a5d|�븘�씠�뵒瑜� �엯�젰�븯�꽭�슂.|1";
		}else{
			return "#3c415c|�궗�슜 媛��뒫�븳 �븘�씠�뵒�엯�땲�떎.|2";
		}
	}
	
	
	@RequestMapping(value="userFind.do",produces="zapplication/text; charset=utf-8")//�븘�빟�뒪 �씤肄붾뵫
	@ResponseBody	//�븘�빟�뒪 �븘�닔
	public String userFind(String userID, int type, HttpSession session) {
		System.out.println("user�뿉�꽌 userFind");
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
	
	//�깉�눜
	@RequestMapping(value="secession1.do")
	public void remove(UserVO vo){
		System.out.println("�깉�눜 �릺�뿀�뒿�땲�떎.");
		System.out.println(vo.getUserId());
		System.out.println(vo.getUserPwd());
		userService.withdrawal(vo);
	}
	
	//업데이트
	
	@RequestMapping(value="memberupdate.do")
	public String update(UserVO vo,Model mo){
		int result = userService.userUpdate(vo);
		System.out.println(vo.getUserId());
		System.out.println(vo.getUserName());
		System.out.println(vo.getUserEmail());
		System.out.println(vo.getUserBirth());
		return "redirect:membermodification.do?succces="+result;
		
	}
	
	@RequestMapping(value = "membermodification.do")
	public void membermodification(String succces, HttpSession session,Model m){
		UserVO  vo= new UserVO();
		vo.setUserId((String)session.getAttribute("userID"));
		UserVO result =	userService.selectLogin(vo);
		m.addAttribute("user", result);
		m.addAttribute("succces", succces);
		}
	
	
	
	
}
