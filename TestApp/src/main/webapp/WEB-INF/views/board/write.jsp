<%@ page contentType="text/html;charset=UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/javascript">

// 게시판 목록을 비동기로 가져와서 동적으로 디자인을 출력하되 (React를 이용하자)
function getList() {
	
}



function regist() {
	var formArray = $("form").serializeArray();
	var json={};
	for(var i = 0; i < formArray.length; i++) {
		json[formArray[i].name] = formArray[i].value;
	}
	console.log("전송 전 json 구성 : ", json);
	
	$.ajax({
		url:"/board/regist",
		type:"post",
		data:JSON.stringify(json),
		contentType:"application/json;charset=utf-8",
		success:function(result, status, xhr) {
			alert(result.msg);
			getList();
		},
		error:function(xhr, status, error) {
			alert(error.msg);
		}
	})
	
}

$(function() {
	
});


</script>
<body>
	<form>
		<table width="70%" align="center" border="1px">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><button type="button" onClick="regist()">등록</button>
				<button type="button" onClick="location.href='borad/list';">목록</button></td>
			</tr>
		</table>
	</form>
	<div id="listArea">
	
	<table width="70%" align="center" border="1px">
	<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회</th>
				<th>등록일</th>
			</tr>
			<thead>
			
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
	
	
	
	</div>
</body>
</html>