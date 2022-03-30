package com.test.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 기존의 Action
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	// req,res받아서 경로(String)만을 반환 -> ViewResolver
}
