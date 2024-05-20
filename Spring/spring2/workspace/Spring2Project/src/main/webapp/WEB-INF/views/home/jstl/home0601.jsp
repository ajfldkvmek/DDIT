<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- 
		c:choose / c:when / c:otherwise는 if else 조건문과같음
		
		if ,else if , else 의 조건문이 필요하다면
		c:when을 if , else if 의 조건문으로 사용가능
		
	 -->
	
	<c:choose>
		<c:when test="${member.gender == 'M' }">
			<p>남자</p>
		</c:when>
		<c:otherwise>
			<p>여자</p>
		</c:otherwise>
	</c:choose>

</body>
</html>