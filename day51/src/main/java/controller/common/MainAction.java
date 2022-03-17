package controller.common;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.BoardSet;
import model.vo.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		String a = req.getParameter("a");
		int b=3;
		if(req.getParameter("b")!=null) {
			b=Integer.parseInt(req.getParameter("b"));
		}

		
		
		System.out.println("로그 a: "+a);
		System.out.println("로그 b: "+b);
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setMid(a);
		
		ArrayList<BoardSet> datas=dao.selectAll(vo, b);
		req.setAttribute("datas", datas);
		req.setAttribute("a", a);
		req.setAttribute("b", b);
		
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
	

}
