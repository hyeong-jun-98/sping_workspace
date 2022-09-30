<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					<td>No</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회</td>
					<td>등록일</td>
				</tr>
				
				<tr>
					<td colspan="5">
					<button onClick="location.href='/board/writeform';">글 등록</button>
					</td>
				</tr>
			<tbody>
	</table>
</body>
</html>