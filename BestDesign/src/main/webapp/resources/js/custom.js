$(function(){
	let flag = false;
	$("input[name='userId']").keyup(function(){
		flag=false;
	})
	$(".btn-group .btn").click(function(){
		flag=false;
	})
	
	$("form").validate({// 데이터 유효성 검사 플러그인
        rules:{
        	userId:"required",
            userPwd:{required:true, minlength:4},//최소 4자리 이상으로 써라
            userPwdconf:{equalTo:("#userPwd")},//password와 같은지 
            userName:"required",//name 속성이 name인 input 태그에 required 검사가 유효한지
            userPhone:{required:true,minlength:13},
            userEmail:{required:true,email:true},
            userBirth:"required"
        },
       messages:{
        	userId:"아이디를 입력하세요.",
        	userPwd:{required: "비밀번호를 입력하세요.", minlength:  "{0}자리 이상 입력하세요."},
        	userPwdconf:{required: "비밀번호를 다시 입력하세요.",equalTo: "같은 비밀번호를 입력하세요."},
        	userName: "이름을 입력하세요.",
        	userPhone:{required:"전화번호를 입력하세요.", minlength:  "{0}자리 이상 입력하세요."},
        	userEmail:{required:"이메일을 입력하세요.",email:"이메일 형식을 알맞게 입력하세요."},
        	userBirth: "생년월일을 입력하세요."
        }
	})
	$("#checkId").click(function(){
		let id = $("input[name='userId']").val();
		$.ajax({
			data:{id:id},
			type:"post",
			dataType:"text",
			url:"../user/checkId.do",
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
				flag=true;
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
	$("#formsub").click(function(){
		if(flag==false){
			$("#checkMessage").html("중복체크를 눌러주세요");
			$("#checkType").attr("class","modal-content panel-warning");
			$("#checkModal").modal("show");
		}else{			
			$("form").method = "post";
			$("form").submit();
		}
	})
	
	var autoHypenPhone = function(str){
	      str = str.replace(/[^0-9]/g, '');
	      var tmp = '';
	      if( str.length < 4){
	          return str;
	      }else if(str.length < 7){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3);
	          return tmp;
	      }else if(str.length < 11){
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 3);
	          tmp += '-';
	          tmp += str.substr(6);
	          return tmp;
	      }else{              
	          tmp += str.substr(0, 3);
	          tmp += '-';
	          tmp += str.substr(3, 4);
	          tmp += '-';
	          tmp += str.substr(7);
	          return tmp;
	      }
	  
	      return str;
	}

	$("#userPhone").keyup(function(){
	  console.log($(this).val());
	  $(this).val(autoHypenPhone($(this).val()))  
	})
})