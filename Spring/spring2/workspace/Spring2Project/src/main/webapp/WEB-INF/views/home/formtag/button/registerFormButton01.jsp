<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm01</title>
</head>
<body>


	<h2>Spring Form</h2>
	
	<p>이건 버튼 태그</p>
	
	<form:form modelAttribute="member" method="post" action="/formtag/register">
	
		<table border="1">
			
			<tr>
				<td>유저ID</td>
				<td>
					<form:input path="userId"/>
						<font color="red">
							<form:errors path="userId"/>
						</font>
				</td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
						<font color="red">
							<form:errors path="userName"/>
						</font>
				</td>
			</tr>
			
			
			<tr>
				<td>E-mail</td>
				<td>
					<form:input path="email"/>
						<font color="red">
							<form:errors path="email"/>
						</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>

</body>
</html>