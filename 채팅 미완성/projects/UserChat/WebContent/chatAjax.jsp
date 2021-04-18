<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@ page import="chat.model.*" %>
<%
	String fromID = request.getParameter("fromID");
	String toID = request.getParameter("toID");
	String chatContent = request.getParameter("chatContent");
	ChatDAO dao = ChatDAO.getInstance();
	Chat c = new Chat();
	c.setFromID(fromID);
	c.setToID(toID);
	c.setChatContent(chatContent);
	int i = dao.submit(c);
	if(i == 1){
		out.write("1");
	}else{
		out.write("0");
	}
%>	