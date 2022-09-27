<%@page import="com.academy.shopping.model.domain.OrderSummary"%>
<%@page import="com.academy.shopping.model.domain.Paymethod"%>
<%@page import="com.academy.shopping.model.domain.Member"%>
<%@page import="com.academy.shopping.model.domain.Cart"%>
<%@page import="com.academy.shopping.model.util.CurrencyFormatter"%>
<%@page import="java.util.Currency"%>
<%@page import="com.academy.shopping.model.domain.Product"%>
<%@page import="com.academy.shopping.model.domain.SubCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	
	OrderSummary orderSummary = (OrderSummary) request.getAttribute("orderSummary");
%>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>

   <%@include file="../inc/css.jsp" %>
</head>

<body>
    
    <%@ include file="../inc/topbar.jsp" %>

  <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->
    
        <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
			<h2><%=orderSummary.getMember().getCustomer_name() %>주문이 완료되었습니다.</h2>
			<table width="100%" border="1px">
				<tr>
					<td>주문번호</td>
					<td><%=orderSummary.getOrdersummary_id() %></td>
				</tr>
				<tr>
					<td>총 결제금액</td>
					<td><%=orderSummary.getTotalpay() %></td>
				</tr>
				<tr>
					<td colspan="2"><a href="/shop">쇼칭 계속하기</a></td>
				</tr>
			</table>
         </div>
     </section>
        <!-- Checkout Section End -->


<!-- <%@include file="../inc/insta.jsp" %> -->
<%@include file="../inc/footer.jsp" %>
<%@include file="../inc/search.jsp" %>
<%@include file="../inc/plugin.jsp" %>
<script>

function delCart(product_id) {
	if(confirm("장바구니를 삭제할까요?")) {
		location.href="/shop/cart/delete?product_id="+product_id;	
	}
}


function updateCart() {
	if(confirm("장바구니를 수정하시겠어요?")) {
		$("#cart-form").attr({
			action:"/shop/cart/update",
			method:"post"
		})
		
		$("#cart-form").submit();
		
	}
}

function pay() {
	if(confirm("결제하시겠습니까?")) {
		$("#pay-form").attr({
			action:"/shop/pay",
			method:"post"
		})	
	
		
		$("#pay-form").submit();
	}	
	
}

$(function(){
  

})

</script>
</body>
</html>