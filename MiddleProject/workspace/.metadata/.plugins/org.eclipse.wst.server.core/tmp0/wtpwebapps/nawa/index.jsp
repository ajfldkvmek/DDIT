'<%@ page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<% if((MemberVO) session.getAttribute("LOGIN_USER") == null) { %>
 <%@include file="./include/header.jsp" %>


<%  } else { %>

 <%@include file="./include/loginheader.jsp" %> 
 
 <%} %>


<%@include file="./include/home.jsp" %>
<%@include file="./meet/famousmeet.jsp" %>
 

<%@include file="./include/footer.jsp" %>

</body>
</html>