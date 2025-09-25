package com.app.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;

public class ProductWriteOkController implements Action {			// Action인터페이스를 구현? 상속받은 클래스객체는 이제 Action인터페이스에 있는 Result클래스를 무조건 객체생성 해야한다. 

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		result.setRedirect(true);
		
		// 여기에 이제 mapper코드 db쿼리 들어갈거다.
		
		result.setPath("list.product");
		return result;
	}

}
