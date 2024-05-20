<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Date" %>

<%@ include file="./header.jsp" %>

<%
	Date date = Calendar.getInstance().getTime();
%>
현재시간: <%=date %>
</body>
</html>