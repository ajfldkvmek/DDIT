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
                        <li>CH14</li>
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
						<%
							//쿠키 정보를 얻어오도록 request 내장 객체의 getCookies() 메소드를 작성
							
							Cookie[] cookies = request.getCookies();
							out.println("현재 설정한 쿠키의 갯수>> " + cookies.length + "<br/>");
							
							out.println("==================================<br/>");
							
							for(int i = 0; i < cookies.length; i++) {
								//얻어온 쿠키 정보에서 쿠키이름과 값을 하나씩 출력 할 수 있또록
								//Cookie객체의 getName, getValue 메소드 작성
								out.println("설정된 쿠키의 속성 이름[" + i + "]" + cookies[i].getName() + "<br/>");
								out.println("설정된 쿠키의 속성 값[" + i + "]" + cookies[i].getValue() + "<br/>");
								out.println("----------------------------------<br/>");
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