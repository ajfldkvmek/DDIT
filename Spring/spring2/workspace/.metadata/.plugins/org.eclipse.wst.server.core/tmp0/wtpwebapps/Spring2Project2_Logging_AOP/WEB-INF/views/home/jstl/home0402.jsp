<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String[] hobbyArray = {"Music", "Movie"};
	%>
	
	<!-- 
		EL에서 발생한 에러가 아니라 자바식에서 발생한 에러 정보든 ex와 같은 변수에 담아 에러정보 출력 가능
		
		EL 자체 에러는 확인하기 어려우므로 디버깅 쉽지않다
		오타에서 발생하는 에러 없도록 꼼꼼하게 체크
	 -->
	<c:catch var="ex">
		<%=hobbyArray[3] %>
	</c:catch>
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>
	</p>
	
</body>
</html>