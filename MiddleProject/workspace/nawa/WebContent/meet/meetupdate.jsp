 <%@page import="meet.vo.MeetVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MeetVO mv = (MeetVO)request.getAttribute("mv");

%>
<%@include file="../include/header.jsp" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소모임 수정하기</title>
</head>
<body>
	<form action="./meetUpdate" method="post" >
		
			
		<table>
			<tr>
				<td>소모임번호:</td>
				<td><%=mv.getMeet_no()%></td>
				<td><input type="hidden" name="meetNo"
					value="<%=mv.getMeet_no()%>"></td>
			</tr>
			<tr> 
				<td>소모임명:</td>
				<td><input type="text" name="meetName"
					value="<%=mv.getMeet_name()%>"></td>
			</tr>
			<tr>
				<td>소모임설명:</td>
				<td><input type="text" name="meetInfo"
					value="<%=mv.getMeet_info()%>"></td>
			</tr>
			<tr>
				<td>소모임레벨:</td>
				<td><input type="text" name="meetLevel"
					value="<%=mv.getMeet_level()%>"></td>
			</tr>
			<tr>
				<td>소모임정원:</td>
				<td><input type="text" name="meetLimit"
					value="<%=mv.getMeet_limit()%>"></td>
			</tr>
			<tr>
				<td>소모임장소:</td> 
				<td><textarea name="meetLoc"><%=mv.getMeet_loc()%></textarea></td>
			</tr>
			
			
			
		</table>
		<input type="submit" value="회원정보 수정">

	</form>
<%@include file="../include/footer.jsp" %>
</body>
</html> 