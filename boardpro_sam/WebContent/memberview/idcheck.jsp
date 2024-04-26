<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 저장된 데잍타 꺼내기 
String result =(String) request.getAttribute("skdxsofxlkdfsodifsdj");

if(result == null){
%>
   {
      "sw"  : "사용가능 합니다"
   }
	
<% }else{  %>

  {
      "sw"  : "사용 불가능 합니다"
  }
  

<%
}
%>