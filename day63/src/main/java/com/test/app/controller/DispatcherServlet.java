package com.test.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
// DS은 FrontController의 역할!
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자(브라우저,클라이언트)의 요청을 추출
		String uri=request.getRequestURI();
		String command=uri.substring(uri.lastIndexOf("/"));
		System.out.println(command);

		// 2. 요청을 분기처리
		// -> HandlerMapping을 통해서 command에 해당하는 Controller객체를 반환
		Controller ctrl = handlerMapping.getController(command);
		String viewName = ctrl.handleRequest(request, response);
		// 1) 싱글톤패턴 유지
		// 2) 가독성 향상
		
		if(!viewName.contains(".do")) {
			viewName = viewResolver.getView(viewName);
		}
		response.sendRedirect(viewName);
				
		
	}

}
