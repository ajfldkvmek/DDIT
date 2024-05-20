<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.Date" %>
<%@ page import = "java.lang.Math" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();
	double a = Math.pow(5, 2);
%>

현재 날짜: <%=date %><br/>
5의 제곱: <%=a %>
</body>
</html>