package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.exception.ProductNotFoundException;

public class ProductReadController implements Action {		// Action인터페이스를 구현? 상속받은 클래스객체는 Action인터페이스에 있는 Result클래스를 무조건 객체생성 해야한다. 

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		
		Long id = Long.parseLong(req.getParameter("id"));	// 화면(jsp)의 url에서 id를 이미 줬는데 받을 준비가 안되어 있어서 받을 준비해줌.
//		productDAO.select(id);								// db에서 id에 해당하는 상품정보 전체(mapper의 쿼리에 따라)를 가져옴. 
		try {
			req.setAttribute("product", productDAO.select(id).orElseThrow(ProductNotFoundException::new));
		} catch (ProductNotFoundException e) {
			req.setAttribute("message", "상품을 찾을 수 없습니다.");
			result.setPath("/error.jsp");
		}
		result.setPath("/read.jsp");
		return result;
	}

}
