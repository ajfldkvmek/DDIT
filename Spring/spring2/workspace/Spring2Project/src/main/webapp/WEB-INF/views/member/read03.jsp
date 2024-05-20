<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>
</head>
<body>
	<h3>RESULT</h3>
	
	<!-- ${member.userId }의 .userId는 필드처럼 보이지만 실제로는 getter메서드임  -->
	user.userId: ${user.userId }<br/>
	user.password: ${user.password }<br/>
	user.userName: ${user.userName }<br/>
	user.email: ${user.email }<br/>
	user.birthDay: ${user.birthDay }<br/>
	
	
</body>
</html>