<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="users.user.*" %>
<%
	String id = request.getParameter("userID");
	UserDAO dao = UserDAO.getInstance();
	boolean result = dao.isDuplicatedId(id);
	
	if(result){
		out.write("0");
	}else{
		out.write("1");
	}
	
	%>