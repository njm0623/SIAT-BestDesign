<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</head>
<body>
    <%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
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
    <div class="container bootstrap snippet">
    	<div class="row">
    		<div class="col-xs-12">
    			<div class="portlet portlet-default">
    				<div class="portlet-heading">
    					<div class="portlet-title">
    						<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
    					</div>
    					<div class="clearfix"></div>
    				</div>
    				<div class="chat" class="panel-collapse collapse in">
    					<div id="chatList" class="portlet-body chat-widget" style="overflow-y: auto; height: 600px;">
		    				
		    				<ul class="chatting-list">
		                	
		                		<li class="sent">
		                    		<span class="profile">
		                        		<span class="user">this.name</span>
		                        		<img class="image" src="https://placeimg.com/50/50/any" alt="any"/>
		                    		</span>
		                    		<span class="message">this.msg</span>
		                    		<span class="time">this.time</span>
				                </li>
				                <li class="clear_div"></li>
				                <li class="received">
				                    <span class="profile">
				                        <span class="user">this.name</span>
				                        <img class="image" src="https://placeimg.com/50/50/any" alt="any"/>
				                    </span>
				                    <span class="message">this.msg</span>
				                    <span class="time">this.time</span>
				              
				                </li>
				                <li class="clear_div"></li>
				            </ul>
				            
			            </div>
    				</div>
    				<div class="portlet-footer">
   						<div class="row" style="height: 90px;">
   							<div class="form-group col-xs-10">
    							<textarea style="height: 80px;" id="chatContent" class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
   							</div>
							<div class="form-group col-xs-2">
								<button type="button" class="btn btn-default pull-right" id="sub">전송</button>
								<div class="clearfix"></div>
							</div>
	   					</div>
	   				</div>
    				
    				
					<!-- <div class="wrapper">
					        <div class="user-container">
					            <label for="nickname">대화명</label>
					            <input type="text" id="nickname">
					        </div>
					        <div class="display-container">
					            <ul class="chatting-list">
					            
					            </ul>
					        </div>
					        <div class="input-container">
					            <span>
					                <input type="text" class="chatting-input">
					                <button class="send-button">전송</button>
					            </span>
					        </div>
					    </div> -->
    			</div>
    		</div>
		</div>
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
</body>
</html>