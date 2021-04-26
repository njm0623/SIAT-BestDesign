<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
   String userID = null;
   if(session.getAttribute("userID") != null){
   	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
   }
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<link rel="stylesheet" href="../resources/css/custom.css">
	<link rel="stylesheet" href="../resources/css/style.css">
    <title>아약스 실시간 회원제 채팅</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
    <script src="../resources/js/bootstrap.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
	<script>
			function getUnread(){//안 읽은 메시지 표시
				$.ajax({
					type:"post",
					url:"unReadChat.jsp",
					data:{userID : '<%=userID%>'},
					success:function(result){
						let data = result.trim();
						console.log(data);
						if(data>=1){
							showUnread(data);
						}else{					
							showUnread("");
						}
					}
				})
			}
			function getInfiniteUnread(){//무한 안읽은 메시지 체크
				setInterval(function(){
					getUnread();
				}, 4000);
			}
			function showUnread(result){//안 읽은 메시지 수 표시
				$("#unread").html(result);
			}
	</script>
</head>
<body>
    <nav class="navbar navbar-default">
    	<div class="navbar-header">
    		<button type="button" class="navbar-toggle collapsed"
    			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
    			aria-expanded="false">
    			<span class="icon-bar"></span>
    			<span class="icon-bar"></span>
    			<span class="icon-bar"></span>
    		</button>
    		<a class="navbar-brand" href="header.do">실시간 채팅</a>
    	</div>
    	<div class="collpase navbar-collapse" id="bs-example-navbar-collapse-1">
    		<ul class="nav navbar-nav">
    			<li class="active"><a href="header.do">메인</a>
    			<li><a href="find.do">친구 찾기</a></li>
    			<li><a href="box.do">메시지 함 <span id="unread" class="label label-info"></span></a></li>
    		</ul>
    		<%
    			if(userID == null){
    		%>
    		<ul class="nav navbar-nav navbar-right">
				<li><a href="login.do">로그인</a></li>
				<li><a href="join.do">회원가입</a></li>
    		</ul>
    		<%
    			}else{
    		%>
    		<ul class="nav navbar-nav navbar-right">
				<li><a href="logout.do">로그아웃</a></li>
    		</ul>
    		<%} %>
    	</div>
    </nav>
    <div class="alert alert-danger" id="dangerMessage" style="display: none;">
    	<strong>이름과 내용 모두 입력해주세요.</strong>
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
    <script type="text/javascript" src="../resources/js/chat.js"></script>
    <%
    	if(userID != null){
    %>
    	<script type="text/javascript">
    		$(function(){
    			getUnread();
    			getInfiniteUnread();
    		});
    	</script>
    <%
    	}
    %>
    
</body>
</html>