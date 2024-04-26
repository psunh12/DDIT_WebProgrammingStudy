package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;


@WebServlet("/prodServlet.do")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdServlet() {
 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청시 전송 데이터  받기 - lprod_gu
		String gu = request.getParameter("lprod_gu");
		
		// 2. service 객체 얻기
		IProdService service = ProdServiceImpl.getService();
		
		// 3. sevice 메소드 호출 - selectByLgu - 결과값 받기 - List
		List<ProdVO> list = service.selectByLgu(gu);
		
		// 4. 결과값을 request에 저장
		request.setAttribute("keylist", list);
		
		// 5. view 페이지 이동 - json 배열객체 생성
		request.getRequestDispatcher("prodview/lguList.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청시 전송 데이터  받기 - prod_id html저장해놓은것과 같은 파라미터 이름을 넣어야함
		String id = request.getParameter("prod_id");
		
		// 2. service 객체 얻기
		IProdService service = ProdServiceImpl.getService();
		
		// 3. sevice 메소드 호출 - selectById() - 결과값 받기 - ProdVO
		ProdVO vo = service.selectById(id);
		
		// 4. 결과값을 request에 저장
		request.setAttribute("keyvo", vo);
		
		// 5. view 페이지 이동 - json 객체 생성
		request.getRequestDispatcher("prodview/prodDetail.jsp").forward(request, response);
	}

}
