<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>ACCESS DENIED</h3>
	
	
	<!-- 
		${SPRING_SECURITY_403_EXCEPTION.message }는 ACCESS IS DENIED 문자열이 출력됨]
		security-context.xml 에서 security:access-denied-hander 태그 자체로 설정했을때 메세지가 출력됨
	
	 -->
	<h2>${SPRING_SECURITY_403_EXCEPTION.message }</h2>
	<h2>${msg }</h2>
</body>
</html>