<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
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
	<!-- loginAction.do -->
	<%
	String viewPage = request.getParameter("page");
	%>
	<div class="container" style="padding-top: 50px">
		<form action="loginAction" method="post" onsubmit="return check()">
			<input id="userID" name="userID" type="text" class="form-control-lg col-lg-4" placeholder="아이디"><br> 
			<input id="userPW" name="userPassword" type="password" class="form-control-lg col-lg-4" placeholder="비밀번호"><br>
			<input type="hidden" name="page" value="<%=viewPage%>"> 
			<input type="submit" class="btn btn-primary btn-lg col-lg-4" value="로그인"> 
		</form>
		<a href="join">회원가입</a> <a href="main">메인으로 돌아가기</a>
	</div>
	<script>
		function check(){
			const userID = $('#userID').val();
			const userPW = $('#userPW').val();
			if(userID == ''){
				alert('아이디를 입력해주세요.');		
				return false;
			}
			if(userPW == ''){
				alert('비밀번호를 입력해주세요.')	
				return false;
			}
			if(userID && userPW){
				return true;
			}
		}
	</script>
</body>
</html>