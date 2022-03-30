package com.test.app.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.app.controller.board.DeleteBoardController;
import com.test.app.controller.board.InsertBoardController;
import com.test.app.controller.board.MainController;
import com.test.app.controller.board.SearchController;
import com.test.app.controller.board.UpdateBoardController;
import com.test.app.controller.member.LoginController;
import com.test.app.controller.member.LogoutController;

// 어떤 요청처리 로직을 가진 클래스(==Action,Controller)를 반환해야하는지 알려주는 클래스
public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/main.do", new MainController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/search.do", new SearchController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
