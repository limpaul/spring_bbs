<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bbs/resources/css/login.css">
</head>
<body>
	<div>
		<p><로그인></p>
		<form action="loginAction?page=main" method="post" onsubmit="return check()">
			<input id="userID" name="userID" type="text" placeholder="아이디"><br>
			<input id="userPW" name="userPassword" type="password"
				placeholder="비밀번호"><br> <input type="submit"
				value="로그인">
		</form>
		<a href="join">회원가입</a> <a href="main">메인으로 돌아가기</a>
	</div>
	<script src="http://localhost:8080/bbs/resources/js/login.js"></script>
</body>
</html>