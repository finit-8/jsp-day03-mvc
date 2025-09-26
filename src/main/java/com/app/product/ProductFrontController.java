package com.app.product;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.product.controller.ProductDeleteOkController;
import com.app.product.controller.ProductListController;
import com.app.product.controller.ProductReadController;
import com.app.product.controller.ProductUpdateController;
import com.app.product.controller.ProductUpdateOkController;
import com.app.product.controller.ProductWriteController;
import com.app.product.controller.ProductWriteOkController;

public class ProductFrontController extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = null;
		
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		System.out.println(target);			// list.jsp는 다른 서비스에서도 다 쓰이기에 타겟으로 둔다? interface를 만들어서 개발자에게 강제성을 부여해야한다?

		
		if(target.equals("write")) {
			result = new ProductWriteController().execute(req, resp);
		} else if(target.equals("write-ok")) {
			System.out.println("QA 1");				// 리다이렉트 되는데 qa를 읽을 수 있나???
			result = new ProductWriteOkController().execute(req, resp);
		} else if(target.equals("list")) {
			result = new ProductListController().execute(req, resp);
			System.out.println("QA 2");
		} else if(target.equals("read")) {
			result = new ProductReadController().execute(req, resp);
			System.out.println("QA 3");
		} else if(target.equals("update")) {
			result = new ProductUpdateController().execute(req, resp);
		} else if(target.equals("update-ok")) {
			result = new ProductUpdateOkController().execute(req, resp);
		} else if(target.equals("delete-ok")) {
			result = new ProductDeleteOkController().execute(req, resp);
		} else {
//			404 not found
		}
		
		if(result != null) {							// frontcontroller가 controller가 지정하는
			if(result.isRedirect()) {					// 웹경로랑 처리방식(포워드인지, 리다이렉트인지)을 
				resp.sendRedirect(result.getPath());	// 서비스단위로 가져와서 처리하는 로직
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
