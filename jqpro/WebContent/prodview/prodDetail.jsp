<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	 // jsp에서 <!-- 주석 쓰면 오류남!
	 // 서블릿에서 저장한 공유 데이터 꺼내기
	ProdVO vo =(ProdVO)request.getAttribute("keyvo");
 %>
 {
	 "prod_id" : "<%= vo.getProd_id() %>",
	 "prod_name" : "<%= vo.getProd_name() %>",
	 "prod_lgu" : "<%= vo.getProd_lgu() %>",
	 "prod_buyer" : "<%= vo.getProd_buyer() %>",
	 "prod_cost" : "<%= vo.getProd_cost() %>",
	 "prod_price" : "<%= vo.getProd_price() %>",
	 "prod_sale" : "<%= vo.getProd_sale() %>",
	 "prod_outline" : "<%= vo.getProd_outline() %>",
	 "prod_detail" : "<%= vo.getProd_detail() %>"

 }
