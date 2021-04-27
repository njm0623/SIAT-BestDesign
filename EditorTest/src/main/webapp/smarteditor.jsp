<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
	$(function() {
		$("#save").click(function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
<form id="frm" action="board" method="post" >
	<table width="100%">
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="91" id="ir1" name="content" style="width:766px; height:412px;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="save" value="저장"/><input type="button" id ="cancel" value="취소"/></td>
		</tr>
	</table>
</form>
</body>
<script>
	var oEditors = [];
	
	nhn.husky.EZCreator.createInIFrame({
	  oAppRef : oEditors,
	  elPlaceHolder : "ir1",
	  sSkinURI : "resources/editor/SmartEditor2Skin.html",
	  fCreator : "createSEditor2",
	  htParams : {
		  // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseToolbar : true,
		  // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseVerticalResizer : false,
		  // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseModeChanger : false,
		  fOnBeforeUnload : function(){
			  
		  }
		},
		fOnAppLoad : function(){
			//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
			oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
		}
	});
</script>
</html>