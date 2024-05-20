<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>List</h2>
	
	<table border="1">
	
		<tr>
			<th align="center" width="60">번호</th>
			<th align="center" width="80">아이디</th>
			<th align="center" width="50">비밀번호</th>
			<th align="center" width="50">사용자명</th>
			<th align="center" width="180">작성일</th>
		</tr>
		
		<c:choose>
		
			<c:when test="${empty memberList }">
				<tr>
					<td colspan="5">조회하신 회원 정보가 없어요</td>
				</tr>
			</c:when>
			
			<c:otherwise>
			
				<c:forEach items="${memberList }" var="member">
				<tr>
					<td>${member.userNo }</td>
					<td>
						<a href = "/crud/member/read?userNo=${member.userNo }">
							${member.userId }
						</a>
					</td>
					<td>${member.userPw }</td>
					<td>${member.userName }</td>
					<td>
						<fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${member.regDate }"/>
					</td>
				</tr>
				</c:forEach>
			</c:otherwise>
			
		</c:choose>
		
	</table>

</body>
</html>