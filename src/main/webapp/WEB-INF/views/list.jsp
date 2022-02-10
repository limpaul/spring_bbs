<%@page import="com.board.www.bbs.dto.Bbs"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bbs/resources/css/list.css">
</head>
<body>
	 <div class="container">
        <table>
            <caption>< 일반 게시판 ></caption>
            <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                    <th scope="col">추천수</th>
                    <th scope="col">조회수</th>
                    <th scope="col">삭제</th>
                </tr>
            </thead>
            <tbody>
               
            </tbody>
        </table>
        <div class="move">
            <a  href="write">작성하기</a>
            <a href="main">메인으로 돌아가기</a>
        </div>
    </div>
	<script src="http://localhost:8080/bbs/resources/js/list.js"></script>
</body>
</html>