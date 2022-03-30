package com.test.app.controller;

public class ViewResolver {
	private String prefix;
	private String suffix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// input: Controller가 어떤 View 로 이동해야하는지 반환
	// output: 다음 실행될 JSP 경로를 생성
	public String getView(String viewName) {
		return prefix+viewName+suffix;
	}
}
