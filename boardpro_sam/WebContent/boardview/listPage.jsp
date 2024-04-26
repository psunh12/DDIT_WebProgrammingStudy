<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
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
   
  /*  
   //json데이타를 만드는 라이브러리  _Gson
   //Gson  gson =  new Gson();
  // String  result = gson.toJson(list);
  
   Gson gson = new GsonBuilder().setPrettyPrinting().create();
   String  result = gson.toJson(list);
   
   out.print(result);
   out.flush(); */
   
   
   JsonObject  obj = new JsonObject();
   obj.addProperty("sp", sp);
   obj.addProperty("ep", ep);
   obj.addProperty("tp", tp);
   
   Gson  gson =  new Gson();
   JsonElement   result =  gson.toJsonTree(list);
   
   obj.add("datas", result);
   
   out.print(obj);
   out.flush();
 %>
  
