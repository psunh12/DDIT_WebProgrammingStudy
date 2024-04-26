<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.mybatis.config.MybatisUtil"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 전송시 데이터 값 받기
//parksunhye hi= hello;
// db에서 crud처리
// SqlSession 객체가 필요
SqlSession dbsession = MybatisUtil.getSqlSession();

// 
// List<LprodVO> list = selectList("namespace이름.select의 id이름");
List<LprodVO> list = dbsession.selectList("lprod.selectLprod");

// list를 json객체배열을 생성 - 응답하기
%>

[
<%
for(int i=0;i<list.size();i++){
	LprodVO vo = list.get(i);
	
	if(i>0) out.print(",");	
%>
	{
		"lprod_id" : "<%=vo.getLprod_id() %>",
		"lprod_gu" : "<%=vo.getLprod_gu() %>",
		"lprod_nm" : "<%=vo.getLprod_nm() %>"

	}

<%
}
%>	

]
