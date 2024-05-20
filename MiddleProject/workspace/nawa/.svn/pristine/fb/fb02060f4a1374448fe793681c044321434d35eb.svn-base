<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="member.vo.MemberVO" %>

<%
	List<MemberVO> searchList = (List<MemberVO>) request.getAttribute("searchList");
	
	String msg = session.getAttribute("msg") == null ? "" 
			:(String) session.getAttribute("msg");
	
	session.removeAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%
		
		if(searchList.size() == 0) {
			
		%>
		<tr>
			<td colspan="5">회원 정보가 존재하지 않습니다.</td>
		</tr>
		<%
		} else { 
			for(MemberVO mv : searchList) {
		%>
		<tr>
		<%-- <td><%=mv.getNo() %></td>
		<td><%=mv.getName() %></td> --%>
		</tr>
		<%
			}
		}  
		%>
		
	</table>

</body>
</html>