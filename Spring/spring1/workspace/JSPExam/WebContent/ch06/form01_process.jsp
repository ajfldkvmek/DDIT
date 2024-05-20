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
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String mail = request.getParameter("mail");
%>

	이름: <%=name %><br/>
	주소: <%=addr %><br/>
	이메일: <%=mail %><br/>
</body>
</html>