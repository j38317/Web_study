package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		HttpSession session=req.getSession();
		session.invalidate();
		
		return forward;
	}

}
