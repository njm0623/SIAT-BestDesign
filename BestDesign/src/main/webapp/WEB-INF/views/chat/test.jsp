<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>채팅 넘버</td>
			<td>보낸 사람</td>
			<td>받는 사람</td>
			<td>채팅 내용</td>
			<td>채팅 시간</td>
			<td>조회 여부</td>
		</tr>
	<c:forEach var="chat" items="${list }">
		<tr>
			<td>${chat.chatId }</td>
			<td>${chat.chatFromId }</td>
			<td>${chat.chatToId }</td>
			<td>${chat.chatContent }</td>
			<td>${chat.chatDate }</td>
			<td>${chat.chatRead }</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>