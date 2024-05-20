<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Welcome</title>
</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="menu.jsp" %>
	
	<%!String greeting = "도서 웹 쇼핑몰";%>
	   
	<div class="jumbotron">
		<div class="container">
			<h1 class="dispaly-3">
				<%=greeting%>
			</h1>
		</div>
	</div>

	
	
	<!-- footer 영역 -->
	<%@ include file="./footer.jsp" %>

</body>
</html>