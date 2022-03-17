package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.vo.MemberVO;

public class SignupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMid(req.getParameter("mid"));
		vo.setMname(req.getParameter("mname"));
		vo.setMpw(req.getParameter("mpw"));
		
		if(dao.insert(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			
		}else {
			throw new Exception("회원가입 실패");
			
		}
		
		return forward;
	}

}
//if(memberDAO.insert(mvo)){
//	out.println("<script>alert('회원가입 완료!');window.close();</script>");
//}
//else{
//	out.println("<script>alert('회원가입 실패!!!');history.go(-1);</script>");
//}
