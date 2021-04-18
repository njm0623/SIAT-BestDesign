<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>아약스 실시간 회원제 채팅</title>
</head>
<body>
    <%
        session.invalidate();
	    request.getSession().setAttribute("messageType", "성공");
		request.getSession().setAttribute("messageContent", "로그아웃 하였습니다.");
    %>
    <script type="text/javascript">
    	location.href="index.jsp";
    </script>
</body>
</html>