<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="chat.model.*" %>
<%
	String id = request.getParameter("userID");
	ChatDAO dao = ChatDAO.getInstance();
	String result = dao.getBox(id);
	out.write(result);
%>	