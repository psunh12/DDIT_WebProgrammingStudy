<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
	color : red;
}
p{
	font-size: 1.5rem;
}

table{
/* 빛의3원색 표현. 0,0,0 이면 검정색 , 구글 16진수 색상표 참조가능*/
	border :2px solid #9696FF;
}
td{
	width :200px;
	height :50px;
	text-align:center;

}
</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>

<p>클라이언트 요청시 전송 데이터를 받아서 처리하는 백앤드 프로그램</p>
<p>html기반에서 java언어를 사용하여 로직을 구현한다</p>
<p>html코드안에서 java언어를 사용시 &lt;%  &nbsp;&nbsp;&nbsp;&nbsp;   %> 기호 안에서 기술한다.
<p>처리된 자바변수를 출력할때는 &lt;%=   &nbsp;&nbsp;&nbsp;&nbsp;%>기호안에 작성한다</p>
<%


	request.setCharacterEncoding("UTF-8"); // 한글 깨지지 않도록 !

	// 클라이언트가 입력한 데이터를 가져온다 - request 객체를 이용 -jsp의 내장 객체
 	String userId = request.getParameter("id");
 	String userPass = request.getParameter("pass");
 	String userName = request.getParameter("name");
 	//db에서 일치하는 데이터 정보가 있는지 검색
 	
 	//검색결과에 따라서 응답데이터를 생성한다.
	String sname=userName;
	
 	if(userName == null) sname = "이름없음";
	
%>
<table border="1">
 <tr>
	<td>아이디</td>
	<td><%=userId %></td>
 </tr>

 <tr>
	<td>이름</td>
	<td><%=sname %></td>
 </tr>

</table>


</body>
</html>