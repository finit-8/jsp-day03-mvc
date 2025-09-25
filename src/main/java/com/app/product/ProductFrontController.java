package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.product.controller.ProductWriteOkController;

public class ProductFrontController extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = null;
		
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		System.out.println(target);
		
		
		if(target.equals("write")) {
			
		} else if(target.equals("write-ok")) {
			result = new ProductWriteOkController().execute(req, resp);
		} else if(target.equals("list")) {
//			목록 가져와서 뿌린다.
//			포워드(list.jsp)							list.jsp가 다른데서도 다 쓰여서 인터페이스로(개발자에게 강제성 부여) 만들어서 호출해서 쓴다. --> Action.java 인터페이스
		} else if(target.equals("read")) {
			
		} else if(target.equals("update")) {
			
		} else if(target.equals("update-ok")) {
	
		} else if(target.equals("delete-ok")) {
	
		} else {
//			404 not found
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			} else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
