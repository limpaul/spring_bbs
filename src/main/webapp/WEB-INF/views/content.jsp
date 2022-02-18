<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Web Socket Example</title>
 <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="http://localhost:8080/bbs/resources/css/content.css">
</head>
<body>
	 <div>
        <h1><게시글></h1>
        <ul>
            <li>제목</li>
            <li>내용</li>
           
            <%
            	String sessionID = (String)session.getAttribute("userID");
            	if(sessionID == null){
            %>
            	 <li>
	                <button id="like" onclick="login()">추천</button>
	                <button id="like" onclick="login()">비추천</button>
                	<button>삭제</button>
            	</li>
            	<li><input id="review" type="text" placeholder="write review"><button onclick="login()">댓글달기</button></li>
            <%
            	}else{
            %>
            	 <li>
	                <button id="like" onclick="sendRecommend('<%=sessionID%>', true)">추천</button>
	                <button id="like" onclick="sendRecommend('<%=sessionID%>', false)">비추천</button>
	                <button>삭제</button>
            	</li>
            	<li><input id="review" type="text" placeholder="write review"><button onclick="writeReview('<%=sessionID%>')">댓글달기</button></li>
            <%
            	}
            %>
            <li id="reviews">
              <p> [댓글] </p>
            </li>
        </ul>
		<div id="page"></div>
    </div>

    <script src="http://localhost:8080/bbs/resources/js/content.js"></script>
</body>
</html>


