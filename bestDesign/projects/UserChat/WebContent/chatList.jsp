<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8"); %>
    <%@ page import="chat.model.*" %>
<%
	String fromID = request.getParameter("fromID");
	String toID = request.getParameter("toID");
	String listType = request.getParameter("listType");
	ChatDAO dao = ChatDAO.getInstance();
	if(listType.equals("ten")){
		out.write(dao.getTen(fromID,toID));		
	}else{
		int type = Integer.parseInt(listType);
		out.write(dao.getID(fromID,toID,type));
	}
%>	