<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	//전달 받은 값
	String Id = request.getParameter("memberId");
	String Pw = request.getParameter("memberPw");
	String Name = request.getParameter("memberName");
	String intro = request.getParameter("intro");
	
	// 추가된 값
	String msg = (String)request.getAttribute("msg");
	
%>
<html>
<head>
<meta charset="UTF-8">
<title><%=Name %>님 가입 결과</title>
</head>
<body>
	
	<ul>
		<li>아이디 : <%=request.getParameter("memberId") %></li>
		<li>비밀번호 : <%=Pw %></li>
		<li>이름 : <%=Name %></li>
		<li>자기소개 : <%=intro %></li>
	</ul>
	
	<h1><%=msg %></h1>
	
</body>
</html>