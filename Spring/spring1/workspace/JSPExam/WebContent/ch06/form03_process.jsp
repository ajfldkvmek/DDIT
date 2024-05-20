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
	
	String[] fruit = request.getParameterValues("fruit");

%>

	<h3>선택한 과일</h3>
	<%for(int i = 0; i < fruit.length; i++) { %>
		<%=fruit[i] %>
	<%} %>
</body>
</html>