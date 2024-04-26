<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장한 값 꺼내기 + 형변환
	List<ProdVO> list = (List<ProdVO>)request.getAttribute("keylist");
%>

[
<%
	for(int i=0; i<list.size(); i++){
		ProdVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
	{
		"prod_id" : "<%= vo.getProd_id() %>",
		"prod_name" : "<%= vo.getProd_name() %>"
	}
<%	
	// for문이 끝나는 중괄호
	}
%>
]