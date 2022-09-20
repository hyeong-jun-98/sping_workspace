<%@page import="java.util.List"%>
<%@page import="com.academy.shopping.model.domain.TopCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Advanced form elements</title>
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
            <h1>상품등록</h1>
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
        <form>
        <div class="card card-primary">
          <div class="card-header">
            <h3 class="card-title">상품 등록</h3>

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
                     <input type="text" class="form-control col-md-10" name="category_name">
                     <button class="btn btn-primary col-md-2" onClick="registTop()">등록</button>
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
                     <input type="text" class="form-control col-md-10" name="category_name">
                     <button class="btn btn-primary col-md-2" onClick="registSub()">등록</button>
                     </div>
                     <select name="subcategory.subcategory_id" class="form-control select" style="width: 100%;" size="7" name="subcategory.subcategory_id">
                     </select>
                   </div>
                                 
                   </div>
                </div>
                
                <!-- 우측 9 시작 -->
                
	               <div class="col-md-9">
	               	<input type="text" class="form-control" placeholder="상품명" name="product_name">
	               	<input type="text" class="form-control" placeholder="브랜드" name="brand">
	               	<input type="number" class="form-control" placeholder="원 가격" name="price">
	               	<input type="number" class="form-control" placeholder="할인 가격" name="discount">
	               	
					<textarea class="form-control" placeholder="간략보기"  name="memo"></textarea>               	
					<textarea class="form-control" placeholder="상품 상세설명" id="summernote"  name="detail"></textarea>               	
	                <input type="file" class="form-control" placeholder="상품 이미지 선택" name="photo">
	
						<button type="button" class="btn btn-info" onClick="registProduct()">상품 등록</button>               
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



$(function(){
	$('#summernote').summernote({
		height:200
	});
	getTopList();   
   $($("select")[0]).change(function(){
      //alert("당신이 선택한 아이템의 value값은 "+ $(this).val())
      getSubList($(this).val());
   });     
})

</script>
</body>
</html>