package com.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {		// Action인터페이스를 구현? 상속받은 클래스객체는 Action인터페이스에 있는 Result클래스를 무조건 객체생성 해야한다. 
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
