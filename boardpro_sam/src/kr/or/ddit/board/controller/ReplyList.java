package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송 데이타 가져오기 - bonum
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//service객체 얻어오기 
		IBoardService  service = BoardServiceImpl.getService();
		
		//service메소드 호출하기  - List
		List<ReplyVO>  list = service.selectReply(bonum);
		
		//request에 저장
		request.setAttribute("sdfsdfSDF", list);
		
		//view페이지로 이동 
		request.getRequestDispatcher("boardview/replyList.jsp").forward(request, response);
		
	}

}







