package com.test.app.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;
import com.test.app.controller.Controller;

public class MainController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 검색 로직 추가할 예정
		BoardVO vo=new BoardVO();
		BoardDAO boardDAO=new BoardDAO();
		List<BoardVO> datas=boardDAO.getBoardList(vo);
		///// request등에 datas 저장할 예정
		HttpSession session=request.getSession();
		session.setAttribute("datas", datas);
		
		return "main";
	}

}
