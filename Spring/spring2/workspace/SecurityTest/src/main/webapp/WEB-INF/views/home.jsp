<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<sec:authorize access="isAnonymous()">
		<a href="login">로그인</a>
	</sec:authorize>
	<br/>

	<sec:authorize access="isAuthenticated()">
		<a href="/logout">로그아웃</a>
	</sec:authorize> <br/>
	

	<a href="/board/list">board list</a> <br/>
	<a href="/notice/list">notice list</a> <br/>

</body>
</html>