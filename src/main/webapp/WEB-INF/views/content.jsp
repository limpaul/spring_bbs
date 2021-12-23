<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Web Socket Example</title>
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
	<div class="container" style="padding-top: 20px; padding-bottom: 40px; font-weight: bold;" >
        <form action="update" method="post">
        	<div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">제목</label>
            <input value="${bbs.getBbsTitle()}" type="text" name="userTitle" class="form-control"  placeholder="제목을 입력해주세요 ">
          </div>
    
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">내용</label>
            <textarea name="bbsContent" class="form-control"  rows="10" placeholder="내용을 입력해주세요"> ${bbs.getBbsContent()}</textarea>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
            <input type="password" class="form-control" placeholder="비밀번호 입력해주세요 ">
        </div>
          <input type="submit" value="수정하기" class="btn btn-primary">
          <a href="list" class="btn btn-danger">목록으로</a>
        </form>
    </div>
</body>
</html>


