package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SelectDong
 */
@WebServlet("/SelectDong.do")
public class SelectDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDong() {
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
		
		request.setCharacterEncoding("UTF-8");
			
		//요청시 전송데이타 받기 - dong
		String dong = request.getParameter("dong");
		
		//service객체 얻어오기
		IMemberService  service = MemberServiceImpl.getService();
		
		//service메소드 호출하기 -결과값 -  List<ZipVO> 
		List<ZipVO> list = service.selectByDong(dong);
			
		//결과값을 request에 저장 
		request.setAttribute("wiurkjfsrksrserjskerskv", list);
		
		//view페이지 이동 
		request.getRequestDispatcher("memberview/selectDong.jsp").forward(request, response);
		
		
	}
	

}





