package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyInsert
 */
@WebServlet("/ReplyInsert.do")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		request.setCharacterEncoding("UTF-8");
		
		//전송데이타 받ㄱ기 - bonum, name, cont 
		ReplyVO   rvo = new ReplyVO();
		
		
		try {
			BeanUtils.populate(rvo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//,service객체 얻기 
		 IBoardService  service = BoardServiceImpl.getService();
		
		//service메소드 호출  - 결과값 int 
		int sldkfsl = service.insertReply(rvo);
		
		
		//request에 결과값 저장 
		request.setAttribute("result", sldkfsl);
		
		//view페이지로 이동 
		request.getRequestDispatcher("boardview/result.jsp").forward(request, response);
		
	}

}












