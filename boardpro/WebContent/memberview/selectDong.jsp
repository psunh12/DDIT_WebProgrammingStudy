<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jsp주석--%>

<%
// 서블릿에서 저장된 데이터 꺼내기, 형변환
List<ZipVO> zipList = (List<ZipVO>)request.getAttribute("ziplist");
%>
[
<%
	for(int i=0; i<zipList.size(); i++){
		ZipVO vo = zipList.get(i);
		if(i > 0) out.print(",");
		
		String bunji =vo.getBunji();
		if(bunji == null) bunji =" ";
%>

	{
		"zipcode" 	: "<%= vo.getZipcode() %>",
		"addr" 		: "<%= vo.getSido() %> <%= vo.getGugun() %> <%= vo.getDong() %>",
		"bunji"		: "<%= bunji %>"
	}
<%
	}
%>
]