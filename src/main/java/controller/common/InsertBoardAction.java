package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardVO;

public class InsertBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setMid(req.getParameter("mid"));
		vo.setContent(req.getParameter("content"));
		
		if(dao.insertBoard(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("글 작성중에 문제발생!");
		}
		
		return forward;
	}

}
//if(boardDAO.insertBoard(bvo)){
//	response.sendRedirect("controller.jsp?action=main");
//}
//else{
//	throw new Exception("글 작성중에 문제발생!");
//}