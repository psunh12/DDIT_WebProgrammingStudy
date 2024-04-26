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
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/BoardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    request.setCharacterEncoding("UTF-8");
	    
	    //전송 데이타 받기 - writer, subject , mail, content, password 
	    //vo에 저장 
	   BoardVO   vo = new BoardVO();
	   
	   	try {
		   BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	vo.setWip(request.getRemoteAddr());
	   	
	   	//serviceㄱ개체ㅔ 
	   	IBoardService service = BoardServiceImpl.getService();
	   	
	   	//service메소드 호출 - 결과값 받기 - int 
	   	int aaaaa= service.insertBoard(vo);
	   	
	   	//request에 저장 
	   	request.setAttribute("result", aaaaa);
		
		//view페이지 이동 
		request.getRequestDispatcher("boardview/result.jsp").forward(request, response);
		
	   
	  
	   
	}

}












