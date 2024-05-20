<%@ page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
%>
		
<% if(mv == null) { %>
 <%@include file="./include/header.jsp" %>


<%  } else { %>

 <%@include file="./include/loginheader.jsp" %> 
 
 <%} %>


<%@include file="./include/home.jsp" %>
<%@include file="./meet/famousmeet.jsp" %>



 
 <a href="./meetList">리스트 보기</a>

<%@include file="./include/footer.jsp" %>

</body>
</html>