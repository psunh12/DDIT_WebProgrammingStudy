package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청시 전송 데이터 가져오기
		/*String userId = request.getParameter("mem_id");
		//요청시 전송 데이터 가져오기 - mem_id, mem_name, mem_bir, mem_mail,mem
		// MemberVO에 저장
		MemberVO vo = new MemberVO();
		*/
		
		// commons - beanutils 라이브러리를 이용헤서 전체 데이터를 가져온다
		// 클라이언트 html form의 name속성에 값이 vo의 속성값과 일치해야된다.
		MemberVO vo =new MemberVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		// service메소드 호출하기 - 결과값 받기 - int
		int res = service.insertMember(vo);

		// 결과값을 request에 저장
		request.setAttribute("res", res);
		
		// view페이지로 이동
		request.getRequestDispatcher("memberview/insert.jsp").forward(request, response);
	}

}
