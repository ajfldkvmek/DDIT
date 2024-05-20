<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li>CH17</li>
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
							JSTL은 JSP 페이지에서 스크립트 요소로 인한 
							코드의 복잡함을 해결하기 위한 일종의 사용자 정의 태그의 표준
							
							JSP페이지에서 JSP의 스크립트 요소읜  HTML코드를 혼용하면 편리하게 개발할 수 있으나 코드의 복잡성이 증가함
							
							따라서 JSP 페이지에서 로직을 담당하는 if, for, while 등등과 관련된 코드를 JSTL로 대치하여 
							코드를 깔끔하고 가독성 있는 프로그래밍이 가능하게 함
							
							request.getHeader('User-Agent');
							request 내장 객체를 이용해 가져온 header
							User-Agent를 EL 에서 header['User-Agent']로 작성 가능
						 -->
						
						browser 변수값 설정<br/>
						
						<c:set var="hd" value="${header }"/>
						
						User-Agent			: <c:out value="${hd['User-Agent']}"/><br/>
						Host				: <c:out value="${hd['Host'] }"/><br/>
						Accept				: <c:out value="${hd['Accept'] }"/><br/>
						Accept-Language		: <c:out value="${hd['Accept-Language'] }"/><br/>
						Accept-Encoding		: <c:out value="${hd['Accept-Encoding'] }"/><br/>
						Referer				: <c:out value="${hd['Referer'] }"/><br/>
						Connection			: <c:out value="${hd['Connection'] }"/><br/>
						Cache-Control		: <c:out value="${hd['Cache-Control'] }"/><br/>
					
					
						<hr/>
						
						<c:set value="${header['User-Agent']}" var="userAgent"/>
						userAgent = <c:out value="${userAgent}"/><br/>
						
						<p>browser 변수 값 제거 후 </p>
						<c:remove var="userAgent"/>
						userAgent = <c:out value="${userAgent}"/><br/>							
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>