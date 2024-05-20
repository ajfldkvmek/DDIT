<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>LOGIN</h1>
	<h2>${error }</h2> <!-- 에러발생시 출력메세지  -->
	<h2>${logout }</h2> <!-- 로그아웃시 출력메세지  -->
	
	<!-- 
		시큐리티에서 정한 규칙에 따라 액션 name을 정해줘야함
	 -->
	<form method="post" action="/login">
	
		username : <input type="text" name="username"/><br/>	
		password : <input type="text" name="password"/><br/>	
		<input type="checkbox" name="remember-me"/> REMEBER ME
		<input type="submit" value="로그인"/>
		
		<sec:csrfInput/>
		
	</form>
	
</body>
</html>