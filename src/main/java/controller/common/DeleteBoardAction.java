package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardVO;

public class DeleteBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setBid(Integer.parseInt(req.getParameter("bid")));
		
		if(dao.deleteBoard(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("글 삭제중에 문제발생!");
		}
		return forward;
	}

}
//if(boardDAO.deleteBoard(bvo)){
//	response.sendRedirect("controller.jsp?action=main");
//}
//else{
//	throw new Exception("글 삭제중에 문제발생!");
//}