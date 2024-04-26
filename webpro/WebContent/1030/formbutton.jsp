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
h1{
text-align : center;
}
<h1>JSP : Java Server Page</h1>
<%
//전송 데이타 가져 오기
 String id = request.getParameter("id");
String name = request.getParameter("name");

String qty = request.getParameter("qty");
String price = request.getParameter("price");

   int res = Integer.parseInt(qty) * Integer.parseInt(price);
         

//db처리 crud처리


//db처리 결과로 응답데이터를 생성

%>

<table border="1">
   <tr>
      <td>아이디</td>
      <td><%= id %></td>
   </tr>
   
   <tr>
      <td>이름</td>
      <td><%= name %></td>
   </tr>
   
   <tr>
      <td>가격</td>
      <td><%= price %></td>
   </tr>
   
   <tr>
      <td>수량</td>
      <td><%= qty %></td>
   </tr>
   
   <tr>
      <td>총금액</td>
      <td><%= res %></td>
   </tr>


</table>
</body>
</html>