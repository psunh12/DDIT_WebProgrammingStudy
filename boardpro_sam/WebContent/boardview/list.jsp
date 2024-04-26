<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   //서블릿에서 저장한 데이타 꺼내기 
   
  List<BoardVO>  list =( List<BoardVO>) request.getAttribute("list");
   int  sp =(Integer)request.getAttribute("startpage");
   int  ep =(Integer)request.getAttribute("endpage");
   int  tp =(Integer)request.getAttribute("totalpage");
  %>
  [
  <%
    for(int i=0; i<list.size(); i++){
    	BoardVO  vo = list.get(i);
    	if(i > 0) out.print(",");
 %>
   {
      "num"      :  "<%= vo.getNum() %>",
      "writer"   : "<%= vo.getWriter() %>",
      "subject"  : "<%= vo.getSubject() %>",
      "content"  : "<%= vo.getContent() %>",
      "hit"      : "<%= vo.getHit() %>",
      "wdate"    : "<%= vo.getWdate() %>",
      "mail"     : "<%= vo.getMail() %>"
    }
    	
<%   	
    }
  %>
  ]
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   