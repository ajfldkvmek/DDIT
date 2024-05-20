<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0104</title>
</head>
<body>

	<h3>4. 표현언어(EL)을 이용하여 출력</h3>
	
	<p>1) Map컬랙션에서 프로퍼티 조회할 경우 속성명.키 or 속성명[키] 지정</p>
	
	
	<table border="1">
	
		<tr>
			<td>\${memberMap.userId }</td>
			<td>${memberMap["userId"]}</td>
		</tr>
		
		<tr>
			<td>\${memberMap.password }</td>
			<td>${memberMap["password"]}</td>
		</tr>
		
		<tr>
			<td>\${memberMap.email }</td>
			<td>${memberMap.email }</td>
		</tr>
		
		<tr>
			<td>\${memberMap.userName }</td>
			<td>${memberMap.userName}</td>
		</tr>
		
		
		
		
		
	</table>
	
	
</body>
</html>