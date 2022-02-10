<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bbs/resources/css/join.css">
</head>
<body>
	   <div>
        <p>회원가입</p>
        <form action="joinAction" method="post">
            <input type="text" name="userEmail" placeholder="이메일"> <button onclick="duplicateId()">중복확인</button></button><br />
            <input type="text" name="userID" placeholder="아이디"><br />
            <input type="password" name="userPassword" placeholder="비밀번호" width="20%"><br />
            <input type="password" name="userRePasswo"  placeholder="비밀번호 확인"><br />
            <input type="text" name="userName" placeholder="이름"><br />
            
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