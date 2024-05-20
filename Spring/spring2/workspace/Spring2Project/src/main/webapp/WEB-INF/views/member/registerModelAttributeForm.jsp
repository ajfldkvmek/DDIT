<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>3/ @ModelAttribute 어노테이션</h3>
	<hr/>
	
	
	<p>1) 기본 자료형은 매개변수로 선언했을 때 전달되는지 확인</p>
	<form action="/modelattribute/register01" method="post"><br/>
		userId: <input type="text" name="userId" id="userId" value="hongkd"/><br/>
		password: <input type="text" name="password" id="password" value="1234"/><br/>
		<input type="submit"  value="전송"/>
	</form>
	
	
	
	<p>2) 기본 자료형은 매개변수에 @ModelAttribute 어노테이션 지정하여 더이터 전달</p>
	<form action="/modelattribute/register02" method="post"><br/>
		userId: <input type="text" name="userId" id="userId" value="hongkd"/><br/>
		password: <input type="text" name="password" id="password" value="1234"/><br/>
		<input type="submit"  value="전송"/>
	</form>
	
	
	
	
	<p>3) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다</p>
	<form action="/modelattribute/register03" method="post"><br/>
		userId: <input type="text" name="userId" id="userId" value="hongkd"/><br/>
		password: <input type="text" name="password" id="password" value="1234"/><br/>
		<input type="submit"  value="전송"/>
	</form>
	
	
	
</body>
</html>