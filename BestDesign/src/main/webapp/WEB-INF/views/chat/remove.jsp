<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
 	var result = '${result}';
 	
 	if(result === "removeFalse") {
 		alert("비밀번호를 다시 입력해주세요.");
 	}
 </script>
</head>
<body>

<form method="post" autocomplete="off">
 	
 	<div>
 		<label for="userId">아이디</label>
 		<input type="text" id="userId" name="userId" value="${user.identification}" readonly/>
 	</div>
 	
 	<div>
 		<label for="password">비밀번호</label>
 		<input type="password" id="password" name="userPwd" />
 	</div>
 	
 	<div>
 		<button type="submit">회원탈퇴</button>
 	</div>
 	
</form>

	<div>
		<button onclick ="location.href='/'">처음</button>
	</div>
</body>
</html>