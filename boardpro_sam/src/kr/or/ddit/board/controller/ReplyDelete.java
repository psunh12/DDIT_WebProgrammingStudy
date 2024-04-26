package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//전송데이타 가져오기 - renum
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		//service객체 얻어오기 
		IBoardService  service = BoardServiceImpl.getService();
		
		//service메소드 호출하기 - int 
		int lskd= service.deleteReply(renum);
		
		//결과갑시을 저장 
		request.setAttribute("result", lskd);
		
		//view페이지로 이동 
		request.getRequestDispatcher("boardview/result.jsp").forward(request, response);
		
	}

}











