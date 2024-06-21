<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String c = request.getParameter("chicken");
	String s = request.getParameter("size");
	String a = request.getParameter("amount");
%>
<html>
<head>
<meta charset="UTF-8">
<title>chicken</title>
</head>
<body>
	치킨 : <%=c %>
	사이즈 : <%=s %>
	수량 : <%=a %>
</body>
</html>