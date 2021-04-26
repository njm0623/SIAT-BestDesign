package siat.bestdesign.user.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("signup.do")
	public String signUp(String userID, String userPassword, String userName, String userPhone, String userEmail, String userBirth, String userType) {
		System.out.println(userID + " : " + userName);
		return null;
	}
}
