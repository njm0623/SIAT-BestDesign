<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>새글등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://sdk.amazonaws.com/js/aws-sdk-2.1.24.min.js"></script>

<script type="text/javascript">
    AWS.config.update({

        accessKeyId: 'AKIA2CQDNWZGZSNNZDLD',
        secretAccessKey: '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'

    });

    AWS.config.region = 'ap-northeast-2';
</script>

<script>
    $(function () {
        $("#button").click(function () {
            
            let bucket = new AWS.S3({ params: { Bucket: 'bestdesign' } });
            let fileChooser = document.getElementById('file');
            let file = fileChooser.files[0];

            if (file) {
                var params = {
                    Key: file.name,
                    ContentType: file.type,
                    Body: file,
                    ACL: 'public-read' // 접근 권한
                };

                bucket.putObject(params, function (err, data) {
                    // 업로드 성공
                	$("#fileUploadForm").submit();
                });

                //bucket.putObject(params).on('httpUploadProgress',
                //    function (evt) {
                //        console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total) + '%');
                //    }).send(function (err, data) {
                //        alert("File uploaded successfully.");
                //    });
            }
        });
    });
</script>

</head>
<body>
      <h1>글 등록</h1>      
      <hr>
      <!-- 1. 폼태그에 속성 추가  -->
      <!-- ****************************************** 
            (1) method ="post"
            (2) enctype="multipart/form-data"
            (3) post방식이 아니면 절대 파일 안넘어간다.
            -->
      <form action="saveBoard.do" method="post" enctype="multipart/form-data" id="fileUploadForm"> 
         <table border="1" cellpadding="0" cellspacing="0">
            <!-- 2. 각 항목에  name 맞추기 -->
            <tr>
               <td bgcolor="orange" width="70">제목</td>
               <td align="left"><input type="text" name="b_title"/></td>
            </tr>
            <tr>
               <td bgcolor="orange">작성자</td>
               <td align="left"><input type="text" size="10" name="b_name"/></td>
            </tr>
            <tr>
               <td bgcolor="orange">내용</td>
               <td align="left"><textarea cols="40" rows="10" name="b_content"></textarea></td>
            </tr>
            <!-- 추가항목 시작 -->
            <tr>
               <td bgcolor="orange">이메일</td>
               <td align="left"><input type="text" name="b_email"/></td>
            </tr>
            <tr>
               <td bgcolor="orange">비밀번호</td>
               <td align="left"><input type="text" name="b_pwd"/>
               <input type="hidden" name="b_ip" value="<%=request.getRemoteAddr()%>"> 
               </td>
            </tr>
            <tr>
               <td bgcolor="orange" width="70">파일추가</td><td align="left">
               <input type="file" name="file" maxlength="60" size="40" id="file"></td>
            </tr>
            <!-- 추가항목 끝 -->
            <tr>
               <td colspan="2" align="center"><input type="button" value=" 새글 등록 " id="button"/></td>
            </tr>
         </table>
      </form>
      <hr>
      <a href="getBoardList.do">글 목록 가기</a>
</body>
</html>