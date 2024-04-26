package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn.do")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//id와 pass값 받기 
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		//service개겣 얻기 
		IMemberService  service = MemberServiceImpl.getService();
		
		//service메소드 호출 - 결과값 받기 
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("mem_id", userId);
		map.put("mem_pass", userPass);
		
		MemberVO   vo = service.loginProc(map);
					
		//세션생성 
		HttpSession  hses = request.getSession();
		
		//로그인 성공 
		  //-세션에  결과 값을 저장 
		if(vo !=null ) {
			hses.setAttribute("loginok", vo);
			hses.setAttribute("check", "true");
		}else {
			//로그인 실패 
			hses.setAttribute("check", "false");
		}
	
		//view페이지로 이동 - logpro.jsp
		request.getRequestDispatcher("/member/logpro.jsp").forward(request, response);	
		
		
		
		
		
		
		
	}

}








