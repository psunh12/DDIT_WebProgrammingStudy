<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String userId=request.getParameter("id");
	String userPass=request.getParameter("pass");
%>
<p>아이디 : <%= userId %></p>
<p>비밀번호 : <%= userPass %></p>

</body>
</html>