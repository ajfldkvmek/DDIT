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
	
	<p>아이디: ${myUser.userId }</p>
	<p>비밀번호: ${myUser.password }</p>
	<p>이름: ${myUser.userName }</p>
	<p>Email: ${myUser.email }</p>
	<p>생년월일: ${myUser.dateOfBirtha }</p>
	<p>성별: ${myUser.gender }</p>
	<p>개발자 여부: ${myUser.developer }</p>
	<p>외국인 여부: ${myUser.foreign }</p>
	<p>국적: ${myUser.nation }</p>
	
	소유차량::
	<c:forEach var="car" items="${myUser.cars }">
		${car }
	</c:forEach>
	<br/>
	
	취미:
	<c:forEach var="hob" items="${myUser.hobby }">
		${hob }
	</c:forEach>
	
	<p>우편번호: ${myUser.address.postCode }</p>
	<p>주소: ${myUser.address.location }</p>
	<p>카드: ${myUser.cardList }</p>
	<p>자기소개: ${myUser.introduction }</p>
	<p>개인정보 동의 여부: ${myUser.dong }</p>
	
</body>
</html>