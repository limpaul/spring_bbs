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

	<div id="viewContent" class="container" style="padding-top: 50px;">
		<table class="table table-bodered caption-top">
			<caption>일반 게시판</caption>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Bbs> list = (List<Bbs>)request.getAttribute("list");
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getBbsID()%></td>
					<td><a href="content?bbsID=<%=list.get(i).getBbsID()%>"><%=list.get(i).getBbsTitle()%></a></td>
					<td><%=list.get(i).getUserID()%></td>
					<td><%=list.get(i).getBbsDate()%></td>
					<td><input id="removePassword<%=list.get(i).getBbsID()%>" type="hidden"><button onclick="removeContent(<%=list.get(i).getBbsID() %>)" class="btn btn-danger">삭제</button></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
		<a href="write" class="btn btn-primary">작성하기</a>
		<a href="main" class="btn btn-secondary">메인으로 돌아가기</a>
	</div>
	<script>
		var form = $("<form></form>");
		var cnt = true;
		function removeContent(bbsID){
			if(cnt){
				removeBbsContentId = $("#removePassword"+bbsID);
				removeBbsContentId.attr("type","password");
				cnt = false;
			}else{
				   var param ={
					        bbsID : bbsID,
					        bbsSecret : removeBbsContentId.val()
					      }
					    $.ajax({
					        type:'POST',
					        url:'http://localhost:8080/bbs/api/removeContent',
					        data: JSON.stringify(param),
					        contentType:'application/json',
					        async:false,
					        success:function(res){
					            console.log("성공!!!");
					            $('#viewContent').load(window.location.href+'#viewContent')
					            if(res == 'false'){
					            	alert('비밀번호가 올바르지 않습니다.')
					            }
					        	
					        },
					        error:function(err){
					            console.log('실패!!!!');
					        }
					    });
			}
		}
	</script>
</body>
</html>