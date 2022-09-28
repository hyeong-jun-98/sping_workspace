<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background: yellow">

	<%
	RuntimeException e = (RuntimeException) request.getAttribute("e");
	out.print("이용에 불편을 드려서 죄송합니다.<p>");
	out.print(e);
	%>
	
	<div>
	<p>인증이 필요한 서비스입니다.</p> 
	<a href="/admin/loginform">로그인</a> 하세요.
</div>

</body>
</html>