<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
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
	Date date = Calendar.getInstance().getTime();
%>

현재시간은: <%=date %><br/>
<%
response.setHeader("Refresh", "5");
%>
<a href='response_data.jsp'>google 홈페이지로 이동하기</a>

</body>
</html>