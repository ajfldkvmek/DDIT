<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String uId = (String) request.getParameter("id");

	//jdbc로 db접근하기

	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	Connection conn = DriverManager.getConnection(url, "team5_202310M", "java");
	Statement stmt = conn.createStatement();
	String sql = "select mem_id from member where mem_id =  '" + uId +  "'  ";
	
	ResultSet rs = stmt.executeQuery(sql);
	
	if(rs.next()) {
		//중복값 사용 불가 응답 결과 생성
		%>
		{"rst":"fail", "msg":"사용불가"}
	<%} else { %>
		{"rst":"ok", "msg":"사용가능"}
	<% } 
	%>