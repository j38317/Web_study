package com.test.app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;
import com.test.app.controller.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBid(bid);
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
		
		return "main.do";
	}

}
