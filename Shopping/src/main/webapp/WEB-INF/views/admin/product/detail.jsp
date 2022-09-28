<%@page import="com.academy.shopping.model.domain.Product"%>

<%@page import="com.academy.shopping.model.domain.TopCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Product product= (Product) request.getAttribute("product");

	// 최상위 카테고리 가져오기
	int topcategory_id = product.getSubcategory().getTopcategory().getTopcategory_id();
	

%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>상품상세</title>
   <%@ include file="../inc/header_link.jsp" %>
   
   <style>
   .col-md-9 * {
   	magin:2px;
   }

   </style>
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <%@ include file="../inc/topbar.jsp" %>
  <%@ include file="../inc/sidebar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>상품상세</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Advanced Form</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- SELECT2 EXAMPLE -->
        
        <div class="card card-primary">
        <form>
        <input type="hidden" name="product_id" value="<%=product.getProduct_id() %>">
        <input type="hidden" name="product_img" value="<%=product.getProduct_img() %>">
        
          <div class="card-header">
            <h3 class="card-title">상품 상세</h3>

            <div class="card-tools">
              <button type="button" class="btn btn-tool" data-card-widget="collapse">
                <i class="fas fa-minus"></i>
              </button>
              <button type="button" class="btn btn-tool" data-card-widget="remove">
                <i class="fas fa-times"></i>
              </button>
            </div>
          </div>
          <!-- /.card-header -->
          <div class="card-body">
            <div class="row">
               <div class="col-md-3">
                  <div class="col-md-12">
                   <div class="form-group">
                     <label>상위 카테고리</label>
                     <div class="row">
                     <input type="text" class="form-control col-md-10" name="category_name" value="<%=product.getSubcategory().getTopcategory().getCategory_name()%>">
                     </div>
                     <select class="form-control select" style="width: 100%;" size="7" name="topcategory.topcategory_id">
                     </select>
                   </div>
                                 
                   </div>
                   <!-- /.form-group -->
                 <div class="col-md-12">
                   <div class="form-group">
                     <label>하위 카테고리</label>
                     
                     <div class="row">
                     <input type="text" class="form-control col-md-10" name="category_name" value="<%=product.getSubcategory().getCategory_name()%>">
                     </div>
                     <select name="subcategory.subcategory_id" class="form-control select" style="width: 100%;" size="7" name="subcategory.subcategory_id">
                     </select>
                   </div>
                                 
                   </div>
                </div>
                
                <!-- 우측 9 시작 -->
               
	               <div class="col-md-9">
	               	<input type="text" class="form-control" name="product_name" value="이름 : <%=product.getProduct_name()%>">
	               	<input type="text" class="form-control" placeholder="브랜드" name="brand" value="브랜드 : <%=product.getBrand()%>">
	               	<input type="number" class="form-control" placeholder="원 가격" name="price" value="<%=product.getPrice()%>">
	               	<input type="number" class="form-control" placeholder="할인 가격" name="discount" value="<%=product.getDiscount()%>">
	               	
					<textarea class="form-control" placeholder="간략보기"  name="memo">간단 설명 : <%= product.getMemo()%></textarea>               	
					<textarea class="form-control" placeholder="상품 상세설명" id="summernote"  name="detail">상세설명 : <%=product.getDetail() %></textarea>               	
	                <input type="file" class="form-control" placeholder="상품 이미지 선택" name="photo">
	
						<button type="button" class="btn btn-info" onClick="editProduct()">상품 수정</button>               
						<button type="button" class="btn btn-info" onClick="deleteProduct()">상품 삭제</button>               
						<button type="button" class="btn btn-info" onClick="location.href='/admin/product/list'">목록 보기</button>               
	               </div>
	             
              
               <!-- 우측 끝 -->
              
                <!-- /.form-group -->
              </div>
              <!-- /.col -->
            </div>
            <!-- /.row -->     
          <!-- /.card-body -->
          <div class="card-footer">
          </div>
          </form>
        </div>
        <!-- /.card -->

        
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 3.2.0
    </div>
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="/static/admin/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/static/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="/static/admin/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="/static/admin/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="/static/admin/plugins/moment/moment.min.js"></script>
<script src="/static/admin/plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- date-range-picker -->
<script src="/static/admin/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="/static/admin/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="/static/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap Switch -->
<script src="/static/admin/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- BS-Stepper -->
<script src="/static/admin/plugins/bs-stepper/js/bs-stepper.min.js"></script>
<!-- dropzonejs -->
<script src="/static/admin/plugins/dropzone/min/dropzone.min.js"></script>
<!-- Summernote -->
<script src="/static/admin/plugins/summernote/summernote-bs4.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/admin/dist/js/adminlte.min.js"></script>
  <%@ include file="../inc/footer_link.jsp" %>
<!-- AdminLTE for demo purposes -->
<!-- Page specific script -->
<script>
function getTopList(){
   $.ajax({
      url:"/rest/admin/topcategory",
      type:"get",
      success:function(result, status, xhr){
         printTopList(result);
      }
   });
}
function printTopList(jsonList){
   var sel=$("select[name='topcategory.topcategory_id']");
   $(sel).empty();  //기존 카테고리 초기화
   var tag="";
   for(var i=0; i<jsonList.length; i++){
      var topcategory=jsonList[i];
      tag+="<option value=\""+topcategory.topcategory_id+"\">"+topcategory.category_name+"</option>";
   }
   $(sel).append(tag);
   
   $(sel).val(<%=topcategory_id %>);
   getSubList(<%=topcategory_id%>);
}

//선택한 상위 카테고리에 소속된 하위 목록 가져오기
function getSubList(topcategory_id){
   $.ajax({
      url:"/rest/admin/subcategory/"+topcategory_id,
      type:"get",
      success:function(result, status, xhr){
         printSubList(result);
      },
      error:function(xhr, status, error){
         
      }
   });
}

function printSubList(jsonList){
   var sel=$("select[name='subcategory.subcategory_id']");
   $(sel).empty();  //기존 카테고리 초기화
   var tag="";
   for(var i=0; i<jsonList.length; i++){
      var subcategory=jsonList[i];
      tag+="<option value=\""+subcategory.subcategory_id+"\">"+subcategory.category_name+"</option>";
   }
   $(sel).append(tag);
   
   $(sel).val(<%=product.getSubcategory().getSubcategory_id()%>);
}

function registProduct(){
	if(confirm("상품을 등록하시겠어요?")) {
		$("form").attr({
			"action":"/admin/product/regist",
			"method" : "post",
			"enctype":"multipart/form-data"
			
		})
		$("form").submit();l
	}
}

function editProduct() {
	if(confirm("상품을 수정하시겠습니까?")) {
		$("form").attr({
			"action":"/admin/product/edit",
			"method" : "post",
			"enctype":"multipart/form-data"
			
		})
		$("form").submit();
	}
}

// 비동기 전송 시 json으로 key-value를 일일히 form을 포기학 작성해야 하는건 머무 불편하다
// -> html5 이후부터 Formdata() 객체를 이용하여 전송할 폼을 프로그래밍적으로 생성할 수 있다.
function deleteProduct() {
	// 기존의 폼양식을 전송할 수 있도록 쪼개자 (직렬화 분해)
	var formArray = $("form").serializeArray();
	
	// 서버에 전송 시 json으로 보내기...
	var json ={};
	for(var i=0; i < formArray.length; i++) {
		json[formArray[i].name] = formArray[i].value;
	}
	console.log(json);
	

	if(confirm("상품을 삭제하시겠습니까?")) {
	 $.ajax({
		url:"/rest/admin/product/delete",
		type:"post",
		contentType:"application/json;charset=utf-8",		// 서버에게 이 자료가 json 형태라는 것을 알려준다 (헤더에서)
		data:	JSON.stringify(json),  // json은 자체로 객체이므로 전송하려면 문자열화 시켜야 한다.
		
		// processData:false,		// query string화 시키지 않도록 방지한다.
		success:function(result, status, xhr) {
			alert(result);
			location.href="/admin/product/list";
		}
		
	 })
	 
	}
	
}



$(function(){
	$('#summernote').summernote({
		height:200
	});
	getTopList();   
   $($("select")[0]).change(function(){
      //alert("당신이 선택한 아이템의 value값은 "+ $(this).val())
      getSubList($(this).val());
   });  
   
   $($("select")[0]).val(1);
   
})

</script>
</body>
</html>