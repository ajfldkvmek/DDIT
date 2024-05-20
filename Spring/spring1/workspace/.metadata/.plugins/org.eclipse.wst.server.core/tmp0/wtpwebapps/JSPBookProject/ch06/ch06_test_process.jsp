<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>쉽게 배우는 JSP 웹 프로그래밍</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="/pageModule/headPart.jsp"%>
</head>
<body>
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
						<li>CH06</li>
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
						<!-- 내용을 입력해주세요 -->
						<!--
							넘겨받은 모든 데이털르 아래와 같은 형식으로 출력
							
							[결과]
							아이디: 
							비밀번호:
							이름:
							휴대폰번호:
							성별:
							취미: 운동 독서 음악
							가압인사:
							ㅇㅁㄴㅇㅁㄴㅇㅁㅇㅁㅇㅁㄴㅁㄴㅁㄴㅇㅁㄴ
							
							
							스크립트 태그를 이용한 방법
							jstl을 이용한 방법 
							둘 다 사용해보기
						  -->


						<%
							request.setCharacterEncoding("utf-8");
						String id = request.getParameter("id");
						String pw = request.getParameter("pw");
						String name = request.getParameter("name");
						String phone = request.getParameter("phone1");
						phone += "-" + request.getParameter("phone2");
						phone += "-" + request.getParameter("phone3");
	
						//String[] hob = request.getParameterValues("hobby");
						String gender = request.getParameter("gender").equals("M") ? "남성" : "여성";

						String hobby = "";
						if (request.getParameter("hobby1") != null)
							hobby += "운동 ";
						if (request.getParameter("hobby2") != null)
							hobby += "독서 ";
						if (request.getParameter("hobby3") != null)
							hobby += "음악 ";
						if (request.getParameter("hobby4") != null)
							hobby += "영화 ";

						String comment = request.getParameter("comment");
						%>


						<p>스크립트 태그를 이용한 방법</p>
						<p>
							아이디:
							<%=id%></p>
						<p>
							비밀번호:
							<%=pw%></p>
						<p>
							이름:
							<%=name%></p>
						<p>
							전화번호:
							<%=phone%></p>
						<p>
							성별:
							<%=gender%></p>
						<p>
							취미:
							<%=hobby%></p>
						<p style="white-space: pre-wrap;">가입인사:	<%=comment %></p>


						<p>jstl을 이용한 방법</p>
						<c:set var="id" value="${param.id}" />
						<c:set var="pw" value="${param.pw}" />
						<c:set var="name" value="${param.name}" />
						<c:set var="phone1" value="${param.phone1}" />
						<c:set var="phone2" value="${param.phone2}" />
						<c:set var="phone3" value="${param.phone3}" />
						<c:set var="gender" value="${param.gender == 'M' ? '남성' : '여성'}" />
						<c:set var="hobby1" value="${param.hobby1 != null ? '운동' : ''} " />
						<c:set var="hobby2" value="${param.hobby2 != null ? '독서' : ''}" />
						<c:set var="hobby3" value="${param.hobby3 != null ? '음악' : ''}" />
						<c:set var="hobby4" value="${param.hobby4 != null ? '영화' : ''}" />
						<c:set var="comment" value="${param.comment}" />
						<p>아이디: ${id}</p>
						<p>비밀번호: ${pw}</p>
						<p>이름: ${name}</p>
						<p>번화번호: ${phone1}-${phone2}-${phone3}</p>
						<p>성별: ${gender}</p>
						<p>취미: ${hobby1} ${hobby2} ${hobby3} ${hobby4}</p>
						<p style="white-space: pre-wrap;">가입인사: ${comment}</p>

						
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/pageModule/footer.jsp"%>

	<%@ include file="/pageModule/footerPart.jsp"%>
</body>
</html>