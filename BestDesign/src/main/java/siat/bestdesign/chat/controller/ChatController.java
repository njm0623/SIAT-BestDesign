package siat.bestdesign.chat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.domain.ChatVO;
import siat.bestdesign.chat.service.ChatService;

@Controller
@RequestMapping("chat")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	//매핑된 링크 호출
	
	@RequestMapping("test.do")
	public void test(Model m) {
		m.addAttribute("list", chatService.getAllChat());
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/index.do";
	}
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("chat에서 자신 반환하는 모든 동작 : " + step);
		return "chat/"+step;
	}
	
	@RequestMapping(value="chatting.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String chatting(String fromID, String toID, String chatContent) {
		System.out.println("chat에서 chatting.do");
		ChatVO vo = new ChatVO();
		vo.setChatFromId(fromID);
		vo.setChatToId(toID);
		vo.setChatContent(chatContent);
		System.out.println(fromID+ " " + toID+ " " + chatContent);
		chatService.insertChat(vo);
		return "1";
	}
	
	
	@RequestMapping(value="chatList.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String chatList(String fromID, String toID, String listType) {
		System.out.println("chat에서 chatList.do");
		ChatVO vo = new ChatVO();
		vo.setChatFromId(fromID);
		vo.setChatToId(toID);
		if(listType.equals("ten")){
			return chatService.getTen(vo);		
		}else{
			int type = Integer.parseInt(listType);
			vo.setChatId(type);
			return chatService.getID(vo);
		}
	}
	@RequestMapping(value="unReadChat.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String unReadChat(String userID) {
		System.out.println("chat에서 unReadChat.do");
		ChatVO vo = new ChatVO();
		vo.setChatToId(userID);
		return chatService.unReadChat(vo);
	}
	@RequestMapping(value="boxList.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String boxList(String userID) {
		System.out.println("chat에서 boxList.do");
		ChatVO vo = new ChatVO();
		vo.setChatToId(userID);
		System.out.println(userID);
		return chatService.getBox(vo);
	}
	

}
