>
<%@page import="com.academy.springdb.model.domain.News"%>
<%
	News news =(News) request.getAttribute("news");

%>

<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;	
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
#comments-list {
	border:1px solid red;
	overflow:hidden;
}

#comments-list * {
	float:left;
}

.title-style {
	width:80%;
}
.writer-style {
	width:10%;
}
.regdate-style {
	width:10%;
}

#inputArea input[name='detail'] {
	width:65%;
}

#inputArea input[name='author'] {
	width:15%;
}

#inputArea input[type='button'] {
	width:15%;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
function edit() {
	
	if(confirm("수정하시겠습니까?")) {
		form1.action="/board/edit";
		form1.method="post";
		form1.submit();
	}
}

function del() {
	if(confirm("삭제하시겠습니까?")) {
		location.href="/board/delete?notice_id=<%=news.getNews_id()%>";
	}
}
</script>
</head>
<body>

<div class="container">

  <form name ="form1">
    <input type="hidden"  name="notice_id" value="<%=news.getNews_id() %>">
    <input type="text"  name="title" value="<%=news.getTitle() %>">
    <input type="text"  name="writer"  value="<%=news.getWriter() %>">
    <textarea  name="content" placeholder="내용 작성" style="height:200px"  ><%=news.getContent()%></textarea>

    <input type="button" value="등록" onClick = "regist()">
    <input type="button" value="목록" onClick = "location.href = '/board/list'">
    <input type="button" value="수정" onClick = "edit()">
    <input type="button" value="삭제" onClick = "del()">
  </form>
	
	<div id="inputArea">
		<input type="text" name="detail">
		<input type="text" name="author">
		<input type="button" value="댓글동록">

	</div>  
  
  
</div>

</body>
</html>
