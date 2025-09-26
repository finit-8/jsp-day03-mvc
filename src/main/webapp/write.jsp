<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<form action="/mvc/write-ok.product" method="get">
		<div>
			<span>상품명</span><input name="productName" />
		</div>
		<div>
			<span>상품가격</span><input name="productPrice" />
		</div>
		<div>
			<span>상품재고</span><input name="productStock" />
		</div>
		<button>등록 완료</button>
	</form>
</body>
</html>