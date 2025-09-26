<%@page import="com.app.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<h1>나 도착</h1>
	 <% // request.getAttribute("products"); %>						<!-- 포워드방식만 request 쓸 수 있음, 그리고 현재 업캐스팅 된 상태임(getAttribute의 리턴값이 최상위클래스 Object) -->
	 <% 
	 	List<ProductVO> products = (List<ProductVO>)request.getAttribute("products"); 	// 이제 다운캐스팅해서 +@ 쓸 수 있음 
	 %> 	
 	<table>
 		<tr>
 			<th>상품번호</th>
 			<th>상품이름</th>
 			<th>상품가격</th>
 			<th>상품재고</th>
 		</tr>
 		
 		<%
	 		for(ProductVO product: products) {
 		%>
 		
 		<tr>
 			<td><%=product.getId() %></td>
 			<td>
 				<a href='/mvc/read.product?id=<%=product.getId() %>'><%=product.getProductName() %></a>
 			</td>
 			<td><%=product.getProductPrice() %></td>
 			<td><%=product.getProductStock() %></td>	 			
 		</tr>

		 <%
		 	}
		 %>
		 
 	</table>
		 <div>
		 	<a href="/mvc/write.product">상품등록</a>
		 </div>
	
</body>
</html>