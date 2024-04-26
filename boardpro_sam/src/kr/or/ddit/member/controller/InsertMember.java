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

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전송 데이타 가져오기 -
		/* mem_id, mem_name. mem_bit, mem_hp, mem_mail, mem_zip, mem_add1, mem_add2
		/*
		 * String userId = request.getParameter("mem_id");
		 * 
		 * //MemberVO 에 저장
		 *  MemberVO vo = new MemberVO();
		 *  vo.setMem_id(userId);
		 */
		
		//commons-beanutils라이브러리를 이용해서 전체 데이타 가져온다 
		//클라이어트 html form 의 name속성에  값이 vo 의 속성값과 일치 해야 된다 
		MemberVO  vo = new MemberVO();
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//service객체 얻기 
		IMemberService  service = MemberServiceImpl.getService();
		
		//service메소드 호출하기  - 결과값 받기 - int 
		int res = service.insertMember(vo);
		
		//결과값을 request에 저장 
		request.setAttribute("ghjghjhfghdfgdfsd", res);
		
		//view페이지로 이동 
		request.getRequestDispatcher("memberview/insert.jsp").forward(request, response);
	}

}












