<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"
	crossorigin="anonymous">
	
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
	
</head>
<body>

	<div class="container" style="padding-top: 20px; padding-bottom: 40px; font-weight: bold;" >
        <form action="writeAction" method="post" onsubmit="return check()">
        	<div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">제목</label>
            <input type="text" name="bbsTitle" class="form-control"  placeholder="제목을 입력해주세요 ">
          </div>
    
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">내용</label>
            <textarea name="bbsContent" class="form-control"  rows="10" placeholder="내용을 입력해주세요"></textarea>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
            <input id='bbsSecret' type="password" name="bbsSecret">
        </div>
          <input type="submit" value="등록하기" class="btn btn-primary">
          <a href="main" class="btn btn-danger">목록으로</a>
        </form>
    </div>
	<script type="text/javascript">
		function check(){
			var pw = $('#bbsSecret').val();
			if(pw == ''){
				alert('비밀번호를 적어주세요');
				return false;	
			}else{
				return true;
			}
		}
	</script>
</body>
</html>