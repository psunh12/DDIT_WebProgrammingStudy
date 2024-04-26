package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전송데이타 받기 - page, stype, sword
		int spage = Integer.parseInt(request.getParameter("page")); //최초실행시 1
		String stype = request.getParameter("stype"); //최초실행시 값이 없다 
		String sword =  request.getParameter("sword"); //최초실행시 값이 없다 
		
		//service개겣
		IBoardService   service = BoardServiceImpl.getService();
		
		//메소드 호출 - 페이지 정보 값
		PageVO  vo = service.getPageInfo(spage, stype, sword);
		//리턴값 ㅣ: start, end, startPage, endPage, totalPage
		//ster, end - > 1페이지 :1~ 3  2페이지 4~6  3페이지 7-9 4페이지 10~12  5페이지 13-15 
		//startPage, endPage -> 1페이지 :1~ 2  2페이지1~2  3페이지 3~4 4페이지 3~4 5페이지 5~6  6페이지지5~6  7페이지: 7
		
		
		//해당 페이지에 따라 게시판글을 3개씩 가져오기 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);
				
		List<BoardVO> list = service.selectByPage(map);
		
		//list결과값을 request에 저장 
		request.setAttribute("list", list); //게시판 글 3개가 저장 
		request.setAttribute("startpage", vo.getStartPage()); //1
		request.setAttribute("endpage", vo.getEndPage());  //2
		request.setAttribute("totalpage", vo.getTotalPage());  // 7
		
		
		//request.getRequestDispatcher("boardview/list.jsp").forward(request, response);
		request.getRequestDispatcher("boardview/listPage.jsp").forward(request, response);
	}

}
















