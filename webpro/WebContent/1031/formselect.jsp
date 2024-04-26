<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border : 1px solid blue;
margin : 10px auto;
}

td{
width : 200px;
height : 40px;
text-align : center ;
}

</style>
</head>
<body>
<%

	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String info = request.getParameter("area");
	
	info = info.replaceAll("\n", "<br>");
	
	String cars = request.getParameter("cars");

%>

<table border="1">
 <tr>
	<td>이름</td>
	<td><%= name %></td>
 </tr>

 <tr>
	<td>특징</td>
	<td><%= info %></td>
 </tr>
	
	<tr>
	<td>자동차</td>
	<td><%= cars %></td>
	</tr>

</table>
</body>
</html>