<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<h2>READ</h2>
	<table border="1">
		
		<tr>
			<td>userId</td>
			<td>${member.userId }</td>
		</tr>
		
		<tr>
			<td>userName</td>
			<td>${member.userName }</td>
		</tr>
		
		<tr>
			<td>auth-1</td>
			<td>${member.authList[0].auth }</td>
		</tr>
		<tr>
			<td>auth-2</td>
			<td>${member.authList[1].auth }</td>
		</tr>
		<tr>
			<td>auth-3</td>
			<td>${member.authList[2].auth }</td>
		</tr>
	
	</table>
	
	<form action="/crud/member/remove" id="delForm" method="post">
		<input type="hidden" name="userNo" value="${member.userNo }">
	</form>
	
	<button type="button" id="modifyBtn">수정</button>
	<button type="button" id="deleteBtn">삭제</button>
	<button type="button" id="listBtn">목록</button>
	
	
	<script>
		$(function() {
			var delForm = $("#delForm");
			var modifyBtn = $("#modifyBtn");
			var deleteBtn = $("#deleteBtn");
			var listBtn = $("#listBtn");
			
			modifyBtn.on("click", function(){
				delForm.attr("method", "get");
				delForm.attr("action", "/crud/member/modify");
				delForm.submit();	
			});
		
			deleteBtn.on("click", function() {
				if(confirm("진심 삭제???")) delForm.submit();
			});
		
			listBtn.on("click", function() {
				location.href="/crud/member/list"
			});
		});
	
		
		
	</script>
</body>
</html>