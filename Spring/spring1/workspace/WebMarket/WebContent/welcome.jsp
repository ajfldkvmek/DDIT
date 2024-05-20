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
	
	<%!String greeting = "Welcome to Web Shopping Mall";
	   String tagline = "welcome to Web Market";%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="dispaly-3">
				<%=greeting%>
			</h1>
		</div>
	</div>

	<div class="container">
		<div class="text-center">
			<h3>
				<%=tagline%>
			</h3>
			<%
				Date day = new Date();
				String am_pm;
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				
				if(hour/12==0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
				}
				
				String CT = hour +":"+minute+":"+second+":"+am_pm;
				out.print("현재 접속 시간: " + CT);
			%>
		</div>
		<hr/>
	</div>
	
	<!-- footer 영역 -->
	<%@ include file="footer.jsp" %>

</body>
</html>