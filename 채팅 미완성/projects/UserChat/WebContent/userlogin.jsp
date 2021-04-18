<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="users.user.*" %>
<jsp:useBean id="user" class="users.user.UserDTO">
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<%
	UserDAO dao = UserDAO.getInstance();
	int i = dao.login(user);
	if(i == 1){
		request.getSession().setAttribute("userID", user.getUserID());
		request.getSession().setAttribute("messageType", "성공");
		request.getSession().setAttribute("messageContent", "로그인에 성공했습니다.");
		response.sendRedirect("chat.jsp");
	}else if(i == 2){
		request.getSession().setAttribute("messageType", "오류");
		request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다.");
		response.sendRedirect("login.jsp");
	}else{
		request.getSession().setAttribute("messageType", "오류");
		request.getSession().setAttribute("messageContent", "아이디가 존재하지 않습니다.");
		response.sendRedirect("login.jsp");
	}
%>