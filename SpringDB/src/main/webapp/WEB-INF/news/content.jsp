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
</style >

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://unpkg.com/react@18/umd/react.development.js"crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"	crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/babel">

function edit() {
	
	if(confirm("수정하시겠습니까?")) {
		form1.action="/news/update";
		form1.method="post";
		form1.submit();
	}
}

function del() {
	if(confirm("삭제하시겠습니까?")) {
		location.href="/news/delete?news_id="+$("input[name='news_id']").val();
	}
}

// 데이터 출력용 tr을 컴포넌트로 정의한다. (재사용하기 위해 reusable UI Component)
function Row(props) {
	return (
		<tr>
			<td>{props.detail}</td>
			<td>{props.cwriter}</td>
			<td>{props.cregdate}</td>
		</tr>
	);
}

function printCommentsList(jsonArray) {

		var tag = [];
		for(var i = 0; i < jsonArray.length; i++) { 
			var comments = jsonArray[i];
			tag.push(<Row detail={comments.detail} cwriter={comments.author} cregdate={comments.writedate.substring(0,16)} />);		// 컴포넌트 1개를 변수에 추가 
		}
		var result =  (
			<table width="100%" border="1px">
				<tr>
					<th width="65%">댓글내용</th>				
					<th width="15%">작성자</th>				
					<th width="20%">작성일</th>				
				</tr>
				{tag}
			</table>
		
	);

	var root = ReactDOM.createRoot(document.getElementById("listArea"));
	root.render(result);
}

// 비동기 댓글 등록 요청
function registAsync() {
	$.ajax({
		url:"/rest/comments",
		type:"post",
		data:{
			detail:$("input[name='detail']").val(),
			author:$("input[name='author']").val(),
			news_id: $("input[name='news_id']").val()
		},
		success:function(result, status, xhr) {		// 서버의 응답이 성공하면 이 익명함수가 호출된다. 
			alert(result);
			getListAsync();
		}
	});
}

// 비동기 댓글 가져오기
function getListAsync() {
	$.ajax({
		url:"/rest/comments/"+$("input[name='news_id']").val(),
		type:"get",
		success:function(result, status, xhr) {
			console.log("댓글 수 : " + result.length);
			printCommentsList(result);	// json 배열을 넘기자.

		}
		
	})
}


// onLoad()
$(function() {
	getListAsync();
	
	
	//  댓글등록 이벤트 구현
	$("#inputArea input[type='button']").click(function() {
		registAsync();
	});

})



</script>
</head>
<body>

<div class="container">

  <form name ="form1">
  	<input type="hidden" name="news_id" value="<%=news.getNews_id()%>">
    <input type="hidden"  name="notice_id" value="<%=news.getNews_id() %>">
    <input type="text"  name="title" value="<%=news.getTitle() %>">
    <input type="text"  name="writer"  value="<%=news.getWriter() %>">
    <textarea  name="content" placeholder="내용 작성" style="height:200px"  ><%=news.getContent()%></textarea>

    <input type="button" value="등록" onClick = "regist()">
    <input type="button" value="목록" onClick = "location.href = '/news/list'">
    <input type="button" value="수정" onClick = "edit()">
    <input type="button" value="삭제" onClick = "del()">
  </form>
	
	<div id="inputArea">
		<input type="text" name="detail">
		<input type="text" name="author">
		<input type="button" value="댓글동록">
	</div>  

	<div id="listArea">
	
	
	</div>
</div>

</body>
</html>
