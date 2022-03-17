package controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 추출하기
		String uri = request.getRequestURI();			// /day52/*.do
		String cp = request.getContextPath();			// /day52
		String command = uri.substring(cp.length());	// /*.do
		
		// 2. 추출한 요청에 맞는 Action클래스 execute() 호출하기
		ActionForward forward = null;
		
		if(command.equals("/main.do")) {
			System.out.println("로그 : FC : 메인페이지 출력 요청");
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/login.do")){
			System.out.println("로그 : FC : 로그인 요청");
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(command.equals("/logout.do")){
			System.out.println("로그 : FC : 로그아웃 요청");
			try {
				forward=new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/fav.do")){
			System.out.println("로그 : FC : 좋아요 요청");
			try {
				forward=new FavAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/signup.do")){
			System.out.println("로그 : FC : 회원가입 페이지 출력 요청");
			try {
				forward=new SignupAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/insertReply.do")){
			System.out.println("로그 : FC : 댓글쓰기 요청");
			try {
				forward=new InsertReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/insertBoard.do")){
			System.out.println("로그 : FC : 글 쓰기 요청");
			try {
				forward=new InsertBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/deleteBoard.do")){
			System.out.println("로그 : FC : 글 삭제 요청");
			try {
				forward=new DeleteBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else if(command.equals("/deleteReply.do")){
			System.out.println("로그 : FC : 댓글 삭제 요청");
			try {
				forward=new DeleteReplyAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 3. dispatcher이용해서 응답하기(View 이동)
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
					
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		PrintWriter out =response.getWriter();
		out.println("<script>alert('요청작업 실패!');history.go(-1);</script>");
	}

}
