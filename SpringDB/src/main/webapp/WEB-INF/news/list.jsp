
<%@page import="com.academy.springdb.model.domain.News"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List <News> newsList = (List) request.getAttribute("newsList");
	out.print(newsList.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
   border-collapse: collapse;
   border-spacing: 0;
   width: 100%;
   border: 1px solid #ddd;
}

th, td {
   text-align: left;
   padding: 16px;
}

tr:nth-child(even) {
   background-color: #f2f2f2;
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

.page-style{
   font-size:20px;
   font-weight:bold;
   color:red;
}
</style>
</head>
<body>

   <table>
      <tr>
         <th width="5%">No</th>
         <th width="75%">기사제목</th>
         <th width="5%">작성자</th>
         <th width="10%">작성일</th>
         <th width="5%">조회수</th>
      </tr>
      
    <%for (int i = 0; i < newsList.size(); i++) { %>
    <%News news = newsList.get(i); %>
      <tr>
         <td><%=news.getNews_id() %></td>
         <td>
         	<a href = "/news/content?news_id=<%=news.getNews_id() %>"><%=news.getTitle() %></a>
         	[<%=news.getCommentsList().size() %>]
         </td>
         <td><%=news.getWriter() %></td>
         <td><%=news.getRegdate()%></td>
         <td><%=news.getHit() %></td>
      </tr>
    <%} %>
      <tr>
         <td colspan="5" style="text-align:center">	<!-- 아래 가운데 페이지 수 -->
         
         </td>
      </tr>
      <tr>
         <td colspan="5"><input type="button" value="글 작성" onclick="location.href='/news/regist.jsp';"></td>
      </tr>
   </table>

</body>
</html>