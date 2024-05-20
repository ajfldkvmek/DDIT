<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>쉽게 배우는 JSP 웹 프로그래밍</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<%@ include file="/pageModule/headPart.jsp" %>
</head>
<body>
	<%@ include file="/pageModule/header.jsp" %>

    <div class="breadcrumbs" style="padding-top:40px;">
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
                        <li>CH13</li>
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
						<h3>세션 삭제 전</h3>
						<%
							String userId= (String) session.getAttribute("userId");
							String userPw= (String) session.getAttribute("userPw");
							
							out.println("설정된 세션 이름 userId: " + userId + "<br/>");
							out.println("설정된 세션 이름 userPw: " + userPw + "<br/>");
						
							if(request.isRequestedSessionIdValid()){
								out.println("세션이 유효합니다");
							}	else {
								out.println("세션이 ㄴㄴ");
							}
							
							//세션  초기화
							session.invalidate();
						%>

						<h3>세션 삭제 후 </h3>
						<%
							if(request.isRequestedSessionIdValid()){
								out.println("세션이 유효합니다");
							}	else {
								out.println("세션이 ㄴㄴ");
							}
							
						%>				
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>