<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장한 데이타 꺼내기 
int res = (Integer)request.getAttribute("reskey");
if(res > 0) {
%>

  {
     "sw"  : "성공. 가입축하~~"
  }	
	
<% }else{ %>
	
   {
     "sw"  : "실패. 앗 이럴 수가~~"
   }	

<%	
}
%>