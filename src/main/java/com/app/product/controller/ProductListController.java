package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;

public class ProductListController implements Action{		// Action인터페이스를 구현? 상속받은 클래스객체는 Action인터페이스에 있는 Result클래스를 무조건 객체생성 해야한다. 
   @Override
   public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      Result result = new Result();
      
      ProductDAO productDAO = new ProductDAO();					
      req.setAttribute("products",  productDAO.selectAll());	// DAO가 DB에서 상품목록 전체 가져와서 키를 "products"로 줌.
      
      result.setPath("/list.jsp");
      return result;	
   }
}








