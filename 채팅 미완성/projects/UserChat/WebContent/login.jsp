<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
    <title>아약스 실시간 회원제 회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/custom.js"></script>
    <style>
    	.container{
			width:500px;
		}
    </style>
</head>
<body>
    <%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        if(userID != null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "현재 로그인이 되어있는 상태입니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
    %>
    <nav class="navbar navbar-default">
    	<div class="navbar-header">
    		<button type="button" class="navbar-toggle collapsed"
    			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    			aria-expanded="false">
    			<span class="icon-bar"></span>
    			<span class="icon-bar"></span>
    			<span class="icon-bar"></span>
    		</button>
    		<a class="navbar-brand" href="index.jsp">실시간 채팅</a>
    	</div>
    	<div class="collpase navbar-collapse" id="bs-example-navbar-collapse-1">
    		<ul class="nav navbar-nav">
    			<li class="active"><a href="index.jsp">메인</a>
    		</ul>
    		<%
    			if(userID == null){
    		%>
    		<ul class="nav navbar-nav navbar-right">
    			<li class="dropdown">
    				<a href="#" class="dropdown-toggle"
    					data-toggle="dropdown" role="button" aria-haspopup="true"
    					aria-expanded="false">접속하기<span class="caret"></span></a>
    				<ul class="dropdown-menu">
    					<li><a href="login.jsp">로그인</a></li>
    					<li><a href="join.jsp">회원가입</a></li>
    				</ul>
    			</li>
    		</ul>
    		<%} %>
    	</div>
    </nav>
    <div class="container">
    	<form method="post" action="userlogin.jsp">
    		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
    			<thead>
    				<tr>
    					<th colspan="2"><h4>로그인 양식</h4></th>
    				</tr>
    			</thead>
    			<tbody>
    				<tr>
    					<td style="width: 110px;"><h5>아이디</h5></td>
    					<td><input type="text" class="form-control" name="userID" id="userID" maxlength="20" placeholder="아이디를 입력하세요."></td>
    				</tr>
    				<tr>
    					<td style="width: 110px;"><h5>비밀번호</h5></td>
    					<td><input type="password" class="form-control" name="userPassword" id="userPassword" maxlength="20" placeholder="아이디를 입력하세요."></td>
    				</tr>
    				<tr>
    					<td style="text-align: left" colspan="2"><input type="submit" class="btn btn-primary pull-right"  value="로그인"></td>
    				</tr>
    			</tbody>
    		</table>
    	</form>
    </div>
    <%
    	String messageContent = null;
    	if(session.getAttribute("messageContent")!=null){
    		messageContent = (String)session.getAttribute("messageContent");
    	}
    	String messageType = null;
    	if(session.getAttribute("messageType")!=null){
    		messageType = (String)session.getAttribute("messageType");
    	}
    	if(messageContent != null){
    %>
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div class="modal-content <%if(messageType.equals("오류")) out.println("panel-warning"); else out.println("panel-success"); %>">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						<%=messageType %>
    					</h4>
    				</div>
    				<div class="modal-body">
    					<%=messageContent %>
    				</div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	$("#messageModal").modal("show");
    </script>
    <%
    	session.removeAttribute("messageContent");
    	session.removeAttribute("messageType");
    }
    %>
    <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div id="checkType" class="modal-content panel-info">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						확인 메시지
    					</h4>
    				</div>
    				<div id="checkMessage" class="modal-body"></div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</body>
</html>