<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>쉽게 배우는 JSP 웹 프로그래밍</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="/pageModule/headPart.jsp"%>

<script>
	 function naver(){
         setTimeout("location.href='https://www.naver.com'",50);
      }
</script>
</head>

<body onLoad="javascript:naver()">
	<%@ include file="/pageModule/header.jsp"%>

	<div class="breadcrumbs" style="padding-top: 40px;">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-6 col-12">
					<div class="breadcrumbs-content">
						<h1 class="page-title">JSP 개요</h1>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-12">
					<ul class="breadcrumb-nav">
						<li><a href="/">INDEX</a></li>
						<li>CH05</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<section class="about-us section">
		<div class="container">
			<div class="row align-items-center justify-content-center">
				<div class="col-lg-12 col-md-12 col-12">
					<div class="content-left wow fadeInLeft" data-wow-delay=".3s">
						<%
						String id = request.getParameter("id");
						String pw = request.getParameter("pw");
						String nm = request.getParameter("nm");
						String gn = request.getParameter("gn");
						String pn = request.getParameter("pn");
						String ad = request.getParameter("ad");
						
						String gender = gn.equals("M") ? "남자" : "여자";
						%>
						
						<table>
						<tr>
							<td>아이디: </td>
							<td><c:out value="<%=id %>"/></td>
						</tr>
						<tr>
							<td>비번: </td>
							<td><%=pw %></td>
						</tr>
						<tr>
							<td>이름: </td>
							<td><%=nm %></td>
						</tr>
						<tr>
							<td>성별: </td>
							<td><%=gender %></td>
						</tr>
						<tr>
							<td>폰번호: </td>
							<td><%=pn %></td>
						</tr>
						<tr>
							<td>주소: </td>
							<td><%=ad %></td>
						</tr>
						
						</table>
						<p id="p1"></p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/pageModule/footer.jsp"%>

	<%@ include file="/pageModule/footerPart.jsp"%>
	
	<script>
	var a = 0;
	var pTag = document.getElementById("p1");
	setInterval(() => {
		a++;
		if(a == 5) {
			
		}
			
	}, 1000);
	
	</script>

</body>
</html>