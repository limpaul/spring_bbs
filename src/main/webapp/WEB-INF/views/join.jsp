<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
</head>
<body>
	<h1>회원 가입 페이지</h1>
	<div class="container" style="padding-top: 20px; padding-bottom: 40px; font-weight: bold;" >
        <form action="joinAction" method="post">
           	<div style="padding-top: 20px;">
           		<input type="text" name="userID" class="form-control-lg col-lg-4"  placeholder="아이디" ><br />
	        	<input type="password" name="userPassword" class="form-control-lg col-lg-4"  placeholder="비밀번호" width="20%"><br />
	        	<input type="password" name="userRePassword" class="form-control-lg col-lg-4"  placeholder="비밀번호 확인"><br />
	            <input type="text" name="userName" class="form-control-lg col-lg-4"  placeholder="이름"><br />
			     <input type="text" name="userEmail" class="form-control-lg col-lg-4"  placeholder="이메일"><br />
			     <select name="userGender">
					<option value="m">남자</option>
					<option value="f">여자</option>
				</select> <br/>
	          <input type="submit" value="등록하기" class="btn btn-primary">
	          <a href="main.do" class="btn btn-danger">목록으로</a>
           	</div>
        </form>
    </div>
</body>
</html>