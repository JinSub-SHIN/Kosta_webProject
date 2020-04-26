<%@page import="model.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<script>
$(function(){
	$('#empty').click(function(){
		$.ajax({
			url : "deleteAll",
			data : "userId="+"<%=request.getAttribute("userId") %>"
		});//end ajax
	});//end click
	
	onclick="window.open('write.html','상품등록','width=700,height=540,location=no,status=no,scrollbars=yes');"
	
	
	$('#purchase').click(function(){
		console.log(1);
	//	location.href="cart/purchaseComplete.jsp";
	
		window.open('purchaseComplete.jsp', '구매완료', 'width=700,height=540,location=no,status=no,scrollbars=yes');
		
	});//end click
	
	
	$('[name=delete]').click(function(){
		var prodId=$().val();
		var userId = $('input[type=number]').val();
		$.ajax({
			url : "delete",
			data : "prodId="+"??"+"&userId="+"<%=request.getAttribute("userId") %>"
		});//end ajax
	});//end click
	
	$('#list').click(function(){
		location.href="index.jsp";
	});//end click
	
	
});//end ready
</script>
</head>
<body>
<%=request.getAttribute("userId") %>
<% List<Product> cartList = (List<Product>)request.getAttribute("cartList"); %>
<%=cartList %> <!-- 확인용  -->
<%
	int total=0;
	for(Product p:cartList){
		total += p.getPrice();
	}
%>
<c:forEach items="<%=cartList %>" var="product" varStatus="state">
${product} / ${state.index} / ${state.count}<br>
${product.id} / ${product.name} / ${product.price} / ${product.description}
</c:forEach>

<div class="container">
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
							</div>
							<div class="col-xs-6">
								<button type="button" class="btn btn-primary btn-sm btn-block" id="list">
									<span class="glyphicon glyphicon-share-alt" ></span> 수강신청 목록으로 돌아가기
								</button>
							</div>
						</div>
					</div>
				</div>
				<c:forEach items="<%=cartList %>" var="product" varStatus="state">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">
						</div>
						<div class="col-xs-4">
							<h4 class="product-name"><strong>${product.name}</strong></h4><h4><small>${product.description}</small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right" value="1" name="price">
								<h6><strong>${product.price}<span class="text-muted">원</span></strong></h6>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" value="1">
							</div>
							<div class="col-xs-2">
								<button type="button" class="btn btn-link btn-xs" name="delete">
									<span class="glyphicon glyphicon-trash"> </span>
								</button>
							</div>
						</div>
					</div>
					<hr>
					</c:forEach>
					
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right"> </h6>
							</div>
							<div class="col-xs-3">
								<button type="button" class="btn btn-default btn-sm btn-block" id="empty">
									카트 비우기
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong><%=total %></strong></h4>
						</div>
						<div class="col-xs-3">
							<button type="button" class="btn btn-success btn-block" id="purchase">
								구매하기
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>