<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0301</title>
</head>
<body>

	<p>c:set활용</p>
	
	<c:set value="${member.userId }" var ="memberId"/>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId }</td>
		</tr>
	</table>	
	
	<!-- 넘겨받은 number 데이터 안에서 userId에 저장된 프러퍼티 값을 hongkildong으로 변경  -->
	<c:set target="${member }" property="userId" value="hongkildong"/>
	<c:set var ="memId"/>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId }</td>
		</tr>
	</table>	
	
	
	<c:remove var="memberId"/>
	<p>memberId 변수를 삭제처리함</p>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId }</td>
		</tr>
	</table>	
	
	
</body>
</html>