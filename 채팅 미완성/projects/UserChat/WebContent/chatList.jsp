<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="chat.model.*" %>
<%
	String fromID = request.getParameter("fromID");
	String toID = request.getParameter("toID");
	String listType = request.getParameter("listType");
	ChatDAO dao = ChatDAO.getInstance();
	Chat c = new Chat();
	c.setFromID(fromID);
	c.setToID(toID);
	if(listType.equals("ten")){
		out.write(dao.getTen(c));		
	}else{
		out.write(dao.getID(c));
	}
%>	