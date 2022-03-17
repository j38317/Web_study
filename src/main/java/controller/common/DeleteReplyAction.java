package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.ReplyVO;

public class DeleteReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		ActionForward forward = null;
		
		BoardDAO dao = new BoardDAO();
		ReplyVO vo = new ReplyVO();
		
		vo.setRid(Integer.parseInt(req.getParameter("rid")));
		
		if(dao.deleteReply(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("글 삭제중에 문제발생!");
		}
		return forward;
	}

}
//if(boardDAO.deleteReply(rvo)){
//	response.sendRedirect("controller.jsp?action=main");
//}
//else{
//	throw new Exception("글 삭제중에 문제발생!");
//}
