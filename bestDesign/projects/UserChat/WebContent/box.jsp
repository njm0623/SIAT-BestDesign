<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        if(userID == null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "현재 로그인이 되어있지 않습니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
    %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" href="css/style.css">
    <title>아약스 실시간 회원제 채팅</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
	<script>
			function getUnread(){
				$.ajax({
					type:"post",
					url:"unReadChat.jsp",
					data:{userID : '<%=userID%>'},
					success:function(result){
						let data = result.trim();
						if(data>=1){
							showUnread(data);
						}else{					
							showUnread("");
						}
					}
				})
			}
			function getInfiniteUnread(){
				setInterval(function(){
					getUnread();
				}, 4000);
			}
			function showUnread(result){
				$("#unread").html(result);
			}
			function chatBoxFunction(){
				let userID = '<%= userID%>'
				$.ajax({
					type:"post",
					url:"boxAjax.jsp",
					data:{userID : userID},
					success:function(result){
					 	let data = result.trim();
						let dt = data.split("|");
						if(data == ""){
							return
						}
						console.log(data + " " + dt[0]);
						$("#boxTable").html("");
						for(let i in dt){
							console.log(dt[i]);
							addBox(dt[i]);
						}
					}
				})
			}
			
			function addBox(fromID){
				console.log(fromID);
				$("#boxTable").append('<tr onclick="location.href=\'chat.jsp?toID='+fromID+'\'"><td style="width: 150px;"><h5>'+fromID+' 님과 채팅방</h5></td></tr>');
			}
			function getInfiniteBox(){
				setInterval(function(){
					chatBoxFunction();
				}, 3000)
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
    		<a class="navbar-brand" href="index.jsp">실시간 채팅</a>
    	</div>
    	<div class="collpase navbar-collapse" id="bs-example-navbar-collapse-1">
    		<ul class="nav navbar-nav">
    			<li><a href="index.jsp">메인</a>
    			<li><a href="find.jsp">친구 찾기</a></li>
    			<li><a href="box.jsp"  class="active">메시지 함 <span id="unread" class="label label-info"></span></a></li>
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
    		<%
    			}else{
    		%>
    		<ul class="nav navbar-nav navbar-right">
    			<li class="dropdown">
    				<a href="#" class="dropdown-toggle"
    					data-toggle="dropdown" role="button" aria-haspopup="true"
    					aria-expanded="false">회원 관리<span class="caret"></span>
    				</a>
    				<ul class="dropdown-menu">
    					<li><a href="logoutAction.jsp">로그아웃</a></li>
    				</ul>
    			</li>
    		</ul>
    		<%} %>
    	</div>
    </nav>
    <div class="container">
    	<table class="table" style="margin: 0 auto;">
    		<thead>
    			<tr>
    				<th><h4>주고받은 메시지 목록</h4></th>
    			</tr>
    		</thead>
    		<div style="overflow-y: auto; width: 100%; max-length: 450px;">
    			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd; margin: 0 auto;">
    				<tbody id="boxTable">
    					<!-- <tr onclick="location.href='chat.jsp?toID=b'">
    						<td style="width: 150px;"><h5>채팅하자</h5></td>
    					</tr> -->
    				</tbody>
    			</table>
    		</div>
    	</table>
    </div>
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
    <script type="text/javascript" src="./js/chat.js"></script>
    <%
    	if(userID != null){
    %>
     	<script type="text/javascript">
    		$(function(){
    			getUnread();
    			getInfiniteUnread();
    			chatBoxFunction();
    			getInfiniteBox();
    		});
    	</script>
    <%
    	}
    %>
    
</body>
</html>