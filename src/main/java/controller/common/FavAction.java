package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardVO;

public class FavAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		
		
		vo.setBid(Integer.parseInt(req.getParameter("bid")));
		
		if(dao.update(vo)) {
			forward = new ActionForward();

			forward.setPath("main.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("좋아요 처리중에 문제발생!");
		}
		
		return forward;
	}

}
//if(boardDAO.update(bvo)){
//	response.sendRedirect("controller.jsp?action=main");
//}
//else{
//	throw new Exception("좋아요 처리중에 문제발생!");
//}