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
	
	<%!String greeting = "마 여기가 도서관이다!";%>
	   
	<div class="jumbotron">
		<div class="container">
			<h1 class="dispaly-3">
				<%=greeting%>
			</h1>
		</div>
	</div>
	
	
	<div class="container">
			<a href="./bookList.jsp">도서목록페이지로 이동</a>
		</div>
	<!-- footer 영역 -->
	<%@ include file="./footer.jsp" %>

</body>
</html>