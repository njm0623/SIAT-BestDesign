package siat.bestdesign.customer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.customer.domain.CustomerVO;
import siat.bestdesign.customer.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerCotroller {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("signup.do")
	public String signup(@RequestParam Map<String, Object> map) {
		System.out.println("customer에서 signup");
		CustomerVO vo = customerService.mapToCustomer(map);
		customerService.insertCustomer(vo);
		return "index";
	}
	
	@RequestMapping("login.do")
	public String login(String customerId, String customerPwd, HttpSession session) {
		System.out.println("customer에서 login");
		CustomerVO vo = new CustomerVO();
		System.out.println(customerId + " : " + customerPwd);
		vo.setCustomerId(customerId);
		vo.setCustomerPwd(customerPwd);
		int result = customerService.selectLogin(vo);
		String msg = "", content = "", href = "";
		if(result == 1){
			session.setAttribute("userID", customerId);
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
		System.out.println(session.getAttribute("messageContent"));
		return "redirect:/"+href;
	}
	
	@RequestMapping(value="checkId.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody	//아약스 필수
	public String checkId(String customerId, HttpSession session) {
		System.out.println("customer에서 checkid");
		CustomerVO vo = new CustomerVO();
		vo.setCustomerId(customerId);
		int result = customerService.checkId(vo);
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
	public String userFind(String customerId, HttpSession session) {
		System.out.println("customer에서 userFind");
		CustomerVO vo = new CustomerVO();
		vo.setCustomerId(customerId);
		int result = customerService.checkId(vo);
		if(result==1){
			return "0";
		}else{
			return "1";
		}
	}
}
