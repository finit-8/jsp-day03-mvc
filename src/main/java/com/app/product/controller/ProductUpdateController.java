package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.exception.ProductNotFoundException;
import com.app.vo.ProductVO;

public class ProductUpdateController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
		ProductDAO productDAO = new ProductDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		
		try {
			ProductVO foundProduct = productDAO.select(id).orElseThrow(ProductNotFoundException::new);		// 왜 리턴값이 optional<ProductVO>이 아니라 ProductVO지?
			req.setAttribute("product", foundProduct);					// WriteController와 다르게 
		} catch (ProductNotFoundException e) {
			result.setPath("/error.jsp");
			req.setAttribute("message", "상품을 찾을 수 없습니다.");
			System.out.println("ProductUpdateController Product Not Found Error");
		}
		
		result.setPath("/update.jsp");
		return result;
	}

}
