<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
	<%
		ProductVO product = (ProductVO)request.getAttribute("product");
		System.out.println(product);
	%>
	
	<form action="/mvc/update-ok.product" method="get">
		<input name="id" type="hidden" value=<%=product.getId() %> />
		<div>
			<span>상품명</span><input name="productName" value=<%=product.getProductName() %> />
		</div>
		<div>
			<span>상품가격</span><input name="productPrice" value=<%=product.getProductPrice() %> />
		</div>
		<div>
			<span>상품재고</span><input name="productStock" value=<%=product.getProductStock() %> />
		</div>
		<button>수정 완료</button>
	</form>
</body>
</html>