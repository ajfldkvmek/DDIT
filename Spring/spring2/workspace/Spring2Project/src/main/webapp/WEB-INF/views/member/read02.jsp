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
	member.userId: ${member.userId }<br/>
	member.password: ${member.password }<br/>
	member.userName: ${member.userName }<br/>
	member.email: ${member.email }<br/>
	member.birthDay: ${member.birthDay }<br/>
	
	
</body>
</html>