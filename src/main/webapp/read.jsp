<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>
	<h1>나 도착</h1>
	
	<%
		ProductVO product = (ProductVO)request.getAttribute("product");
		System.out.println(product);
	%>
	<div>
		<h1>상품명: <%=product.getProductName() %></h1>
		<p>상품가격: <%=product.getProductPrice() %></p>
		<p>상품재고: <%=product.getProductStock() %></p>
	</div>
	
	<div>
		<a href="/mvc/list.product">상품 목록</a>
		<a href="/mvc/update.product?id=<%=product.getId()%>">상품 수정</a>
		<a href="/mvc/delete-ok.product?id=<%=product.getId()%>">상품 삭제</a>
	</div>
</body>
</html>