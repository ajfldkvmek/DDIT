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

	<nav class="navbar navbar-expand navbar-dark bg-dark">

		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./welcome.jsp">Home</a>
			</div>
		</div>
	</nav>
	<%!String greeting = "Book Market Mall";
	   String tagline = "welcome to Book Market";%>
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
		</div>
	</div>
	
	<!-- <footer class="container">
		<p>&copy; WebMarket
	</footer> -->

</body>
</html>