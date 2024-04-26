<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장데이터를 꺼내기
	String result = (String)request.getAttribute("reskey");

	if(result ==null){
%>
	{
		"sw" : "사 용가능 합니다."
	}

<%	}else{ %>
	{
		"sw" : "사용 불가능 합니다."
	}
<%
}
%>

