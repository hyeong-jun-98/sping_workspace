<%@page import="com.academy.springmvcsimple.domain.Emp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Emp emp = (Emp) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <!-- Google Font: Source Sans Pro -->
  <%@ include file="/inc/header.jsp" %>
</head>
<body>
	<div class="card card-info">
		<div class="card-header">
			<h3 class="card-title">Horizontal Form</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<form class="form-horizontal">
			<div class="card-body">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">사원명</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="ename" value="<%=emp.getEname() %>">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망급여</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" name="sal" value="<%=emp.getSal() %>">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">입사일</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="hiredate" value="<%=emp.getHiredate().substring(0,16)%>">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">희망부서</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.dname" value="<%=emp.getDept().getDname() %>">
					</div>
				</div>
				
				
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">부서위치</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="dept.loc" value="<%=emp.getDept().getLoc()%>">
					</div>
				</div>
				
			</div>
			<!-- /.card-body -->
			<div class="card-footer">
				<button type="button" class="btn btn-info">사원 등록</button>
				<button type="submit" class="btn btn-default float-right">Cancel</button>
			</div>
			<!-- /.card-footer -->
		</form>
	</div>
	<%@ include file="/inc/footer.jsp" %>
	
	<script>
	
		$(function() {
			 //bsCustomFileInput.init();
		});
		
		$("button[type='button']").click(function() {
			$(".form-horizontal").attr({
				action:"/member/detail",
				method:"get"
			})
			
			$(".form-horizontal").submit();
		})
		
	</script>
</body>
</html>