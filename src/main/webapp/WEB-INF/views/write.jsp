<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" %>
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

	<div class="container" style="padding-top: 20px; padding-bottom: 40px; font-weight: bold;" >
        <form action="writeAction" method="post" onsubmit="return check()">
        	<div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">����</label>
            <input type="text" name="bbsTitle" class="form-control"  placeholder="������ �Է����ּ��� ">
          </div>
    
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">����</label>
            <textarea name="bbsContent" class="form-control"  rows="10" placeholder="������ �Է����ּ���"></textarea>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">��й�ȣ</label>
            <input id='bbsSecret' type="password" name="bbsSecret">
        </div>
          <input type="submit" value="����ϱ�" class="btn btn-primary">
          <a href="main" class="btn btn-danger">�������</a>
        </form>
    </div>
	<script type="text/javascript">
		function check(){
			var pw = $('#bbsSecret').val();
			if(pw == ''){
				alert('��й�ȣ�� �����ּ���');
				return false;	
			}else{
				return true;
			}
		}
	</script>
</body>
</html>