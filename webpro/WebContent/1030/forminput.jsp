<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	h1{
	color:red;
	text-align: center;
	}
	
	table{
	border: 3px solid blue;
	margin: 20px auto;
	}
	
	td{
	width:500px;
	height:50px;
/* 	text-align: center; */
 	padding:20px
	}
	
	th{
	width: 250px;
	background: skyblue;
	
	}	
	p{
	text-align: center;
	}
	
</style>
<body>
<h1>jsp:Java Server Page</h1>
<p>클라이언트의 요청시 전송데이터를 받아서 처리하고
그 처리결과로 응답 데이타를 생성하여 보여준다.</p>

<%

 request.setCharacterEncoding("UTF-8");
	//전송데이터 받기
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	String userGend = request.getParameter("gender");
	
	String frs[]=request.getParameterValues("fruit");
	
	String str="";
	
	for(int i=0; i<frs.length;i++){
		str += frs[i]+" ";	
	}
	
// 	for(String fr :frs){
// 		str+=fr+" ";
// 	}
	String text = request.getParameter("area");	// 엔터 기호(\r\n)가 포함되어있다.
	text = text.replaceAll("\n","<br>");
	// 엔터기호

	//첨부화일
	String fileName=request.getParameter("file");
	
	//db와 관련된 crud처리 한다
	
	
%>

<table border="1">
	<tr>
		<th>아이디</th>
		<td><%= userId %></td>
	
	</tr>
	<tr>
		<th>이름</th>
		<td><%= userName %></td>
	
	</tr>
	<tr>
		<th>성별</th>
		<td><%=userGend %></td>
	
	</tr>
	<tr>
		<th>좋아하는 과일</th>
		<td><%= str %></td>
	
	</tr>
	 
	<tr>
		<th>자기소개</th>
		<td><%=text %></td>
	
	<tr>
		<th>첨부파일</th>
		<td><%=fileName %></td>
	
	</tr>

</table>
</body>
</html>