package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요처ㅇ시 전송 데이타 받기 - id
		String userId = request.getParameter("id");
		
		//service객ㄱ체 얻기 
		IMemberService  service = MemberServiceImpl.getService();
		
		
		//service메소드 호출  결과값 가져오기 - string 
		String res = service.selectById(userId);
		// null  또는 a001, b001, c001, ~ x001
		
		//결과값에 request에 저장 
		request.setAttribute("skdxsofxlkdfsodifsdj", res);
			
		
		//view페이지로 이동 
		request.getRequestDispatcher("memberview/idcheck.jsp").forward(request, response);
		
	}

}














