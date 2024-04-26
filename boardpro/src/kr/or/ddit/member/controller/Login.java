package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id와 pass값 받기
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		// service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		// service메소드 호출-결과값 받기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id",userId);
		map.put("mem_pass",userPass);
		
		MemberVO vo = service.loginProc(map);
		
		// 세션생성
		// 결과값을 request에 저장
		HttpSession hses = request.getSession();
		
		// 로그인 성공
		// -세션에 값을 저장
		if(vo !=null) {
			hses.setAttribute("loginok", vo);
			hses.setAttribute("check", "true");
		}else {
			// 로그인 실패
			hses.setAttribute("check", "false");
		}
		// view페이지로 이동 -logpro.jsp
		
	}

}
