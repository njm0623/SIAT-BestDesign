<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="users.user.*" %>
<jsp:useBean id="user" class="users.user.UserDTO">
	<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<%
	UserDAO dao = UserDAO.getInstance();
	dao.insert(user);
	request.getSession().setAttribute("userID", user.getUserID());
	request.getSession().setAttribute("messageType", "성공");
	request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다.");
	response.sendRedirect("index.jsp");
%>