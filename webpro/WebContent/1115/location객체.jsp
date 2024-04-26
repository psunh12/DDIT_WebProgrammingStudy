<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border:2px solid blue;
}
td{
	height:50px;
	width:300px;

}
</style>
</head>
<body>
<%
  String userId =request.getParameter("id");
  String userName = request.getParameter("name");
  
  // db을 이용해서 crud처리를 한다
  // 처리후 결과물을 생성 -html
%>

<table border="1">
 <tr>
 	<td>아이디</td>
 	<td><%= userId %></td>
 </tr>	

 <tr>
 	<td>이름</td>
 	<td><%= userName %></td>
 </tr>	
</table>
</body>
</html>