$(function(){
	$("form").validate({// 데이터 유효성 검사 플러그인
        rules:{
        	userID:"required",
            userPassword:{required:true, minlength:4},//최소 4자리 이상으로 써라
            userPasswordconf:{equalTo:("#userPassword")},//password와 같은지 
            userName:"required"//name 속성이 name인 input 태그에 required 검사가 유효한지
        },
       messages:{
        	userID:"아이디를 입력하세요.",
        	userPassword:{required: "비밀번호를 입력하세요.", minlength:  "{0}자리 이상 입력하세요."},
        	userPasswordconf:{required: "비밀번호를 다시 입력하세요.",equalTo: "같은 비밀번호를 입력하세요."},
        	userName: "이름을 입력하세요."
        }
	})
	$("#checkId").click(function(){
		let id = $("input[name='userID']").val();
		$.ajax({
			data:{id:id},
			type:"get",
			dataType:"text",
			url:"CheckId.jsp",
			success:Check,
			error:function(error){
				alert("에러");
				console.log(error);
			}
		})
		function Check(data){
			let dt = data.split("|");
			$("#red").css("color",dt[0].trim());
			$("#red").text(" * "+dt[1]);
			if(dt[2] == 1){
				$("#checkMessage").html("사용 불가");
				$("checkType").attr("class","modal-content panel-warning");
			}else{
				$("#checkMessage").html("사용 가능");
				$("#checkType").attr("class","modal-content panel-success");
			}
			$("#checkModal").modal("show");
			$("#red").css("opacity",0);
			$("#red").animate({
				opacity:1
			})
		};
	})
})