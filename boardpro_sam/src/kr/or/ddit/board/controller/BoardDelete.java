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
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //num 가져오기 
		int bnum = Integer.parseInt(request.getParameter("num"));
		
		
		//service개겣 얻기 
		IBoardService  service = BoardServiceImpl.getService();
		
	//service메솓,ㅡ 호출 - 결과값 받ㄴ기 
		int res = service.deleteBoard(bnum);
		
		//겨과값 request에 저장 
		request.setAttribute("result", res);
		
		//view페이지 이동 
		request.getRequestDispatcher("boardview/result.jsp").forward(request, response);
		
		

	}

}











