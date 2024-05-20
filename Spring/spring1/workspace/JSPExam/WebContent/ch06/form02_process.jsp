<%@page import="java.util.Enumeration"%>
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

	request.setCharacterEncoding("utf-8");
	Enumeration profile = request.getParameterNames();
	
	String s = "";
	
	StringBuffer sb = new StringBuffer();
	while(profile.hasMoreElements()) {
		String name = (String) profile.nextElement();
		sb.append(name+ ": ");
		sb.append(request.getParameter(name) + "<br/>");
	}
	
	s = sb.toString();
%>

<%=s %>
	
</body>
</html>