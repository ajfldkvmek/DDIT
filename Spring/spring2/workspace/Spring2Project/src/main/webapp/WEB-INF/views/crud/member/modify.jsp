<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>Modify</h2>
	
	
	<form action="/crud/member/modify" method="post" id="member">
		
		<input type="hidden" name="userNo" value="${member.userNo }">
		
		<table>
			
			<tr>
				<td>userId</td>
				<td><input type="text" id="userId" value="${member.userId }" name="userId" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td>userName</td>
				<td><input type="text" id="userName" name="userName" value="${member.userName } "></td>
			</tr>
			
			
			<tr>
				<td>auth-1</td>
				<td>
					
					<select name="authList[0].auth">
						<option>--선탟해라</option>
						<option value="ROLE_USER" <c:if test="${member.authList[0].auth eq  'ROLE_USER'}">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[0].auth eq  'ROLE_MEMBER'}">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[0].auth eq  'ROLE_ADMIN'}">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>auth-2</td>
				<td>
					<select name="authList[1].auth">
						<option>--선탟해라</option>
						<option value="ROLE_USER" <c:if test="${member.authList[1].auth eq  'ROLE_USER'}">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[1].auth eq  'ROLE_MEMBER'}">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[1].auth eq  'ROLE_ADMIN'}">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>auth-3</td>
				<td>
					<select name="authList[2].auth">
						<option>--선탟해라</option>
						<option value="ROLE_USER" <c:if test="${member.authList[2].auth eq  'ROLE_USER'}">selected</c:if>>사용자</option>
						<option value="ROLE_MEMBER" <c:if test="${member.authList[2].auth eq  'ROLE_MEMBER'}">selected</c:if>>회원</option>
						<option value="ROLE_ADMIN" <c:if test="${member.authList[2].auth eq  'ROLE_ADMIN'}">selected</c:if>>관리자</option>
					</select>
				</td>
			</tr>
			
		</table>
		
		
		<button type="button" id="modifyBtn">수정</button>
		<button type="button" id="cancelBtn">취소</button>
		
	</form>
	
	
	<script>
	
		$(function(){
			
			var modifyBtn = $("#modifyBtn");
			var cancelBtn = $("#cancelBtn");
			var member = $("#member");
			
			modifyBtn.on("click", function(){
				var userName = $("#userName").val();
				
				if(userName==null || userName==""){
					alert("이름을 입력해주세요");
					return false;
				}
				member.submit();
			})
			
			
			calcenBtn.on("click", function(){
				location.href="/crud/member/read?userNo=${member.userNo}";
			});
		})
	
	</script>
</body>
</html>