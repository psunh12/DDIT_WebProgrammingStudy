package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  //
		request.setCharacterEncoding("UTF-8");
		
		//전송데이타 가져오기 renum, cont 
		ReplyVO  vo = new ReplyVO();
	   int renum = Integer.parseInt(request.getParameter("renum"));
	   String  cont = request.getParameter("cont");
	   
	   vo.setRenum(renum);
	   vo.setCont(cont);
	   
	   //service객체 얻기 
	   IBoardService  service = BoardServiceImpl.getService();
	   
	   //service메소드 호춯  - int 
	   int ddkj = service.updateReply(vo);
	   
	   //결과값 저장 
	   request.setAttribute("result", ddkj);
		
		//view페이지 이동 
		request.getRequestDispatcher("boardview/result.jsp").forward(request, response);
		
	}

}







