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
        <p>ȸ������</p>
        <form action="joinAction" method="post">
            <input type="text" name="userEmail" placeholder="�̸���"> <button onclick="duplicateId()">�ߺ�Ȯ��</button></button><br />
            <input type="text" name="userID" placeholder="���̵�"><br />
            <input type="password" name="userPassword" placeholder="��й�ȣ" width="20%"><br />
            <input type="password" name="userRePasswo"  placeholder="��й�ȣ Ȯ��"><br />
            <input type="text" name="userName" placeholder="�̸�"><br />
            
            <select name="userGender">
                <option value="m">����</option>
                <option value="f">����</option>
            </select> <br />
            <input type="submit" value="����ϱ�" class="btn btn-primary">
            <a href="main.do" class="btn btn-danger">�������</a>
        </form>
    </div>

    <script src="http://localhost:8080/bbs/resources/js/join.js"></script>
</body>
</html>