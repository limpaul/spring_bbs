<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bbs/resources/css/join.css">
</head>
<body>
	 <div>
        <h1> &lt; 회원가입 &gt;</h1>
        <form action="joinAction" method="post" onsubmit="return checkForm()">
            <p id="warnUserEmail" class="warn"></p>
            <input id="user_email" onchange="duplicateEmail()"  type="text" name="userEmail" placeholder="이메일"> <button onclick="duplicateId()">중복확인</button></button><br />   
            <p id="warnUserId" class="warn"></p>
            <input id="user_id" onchange="duplicateId()" type="text" name="userID" placeholder="아이디"><br />
            <input id="user_password" type="password" name="userPassword" placeholder="비밀번호" width="20%"><br />
            <input id="user_repassword" type="password" name="userRePasswo"  placeholder="비밀번호 확인"><br />
            <input id="user_name" type="text" name="userName" placeholder="이름"><br />
            
            <select name="userGender">
                <option value="m">남자</option>
                <option value="f">여자</option>
            </select> <br />
            <input type="submit" value="등록하기" class="btn btn-primary">
            <a href="main.do" class="btn btn-danger">목록으로</a>
        </form>
    </div>

    <script src="http://localhost:8080/bbs/resources/js/join.js"></script>
</body>
</html>