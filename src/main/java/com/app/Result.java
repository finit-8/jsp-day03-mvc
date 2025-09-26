package com.app;

public class Result {				// Result클래스를 만든 이유는 FC가 결과값 두개를 받아서 두개를 반환할 수 없어서??? 클래스로 한 번에 받으려고 만든거고, 
									// 무조건 Result를 리턴할 수 있게(강제성 부여) 인터페이스(Action.java)를 만들어 리턴시킨다.
// 어떻게
	private boolean isRedirect;
	
// 어디로
	private String path;
	
	public Result() {;}
	public Result(boolean isRedirect, String path) {
		super();
		this.isRedirect = isRedirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Result [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
	
	
	
}
