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
						<%
							//고유 세션 내장 객체의 아이디를 가져오도록 session내장 객체의 getId작성
							String sessionId = session.getId();
						
							//세션에 마지막으로 접근한 시간
							//getLastAccessedTime 메소드 작성
							long last_time = session.getLastAccessedTime();
							
							//세션이 생성된 시간을 가져오도록
							//getCreationTime 메소드 작성
							long start_time = session.getCreationTime();
							long used_time = (last_time - start_time) / 60000;
							
							out.print("세션 아이디: " + sessionId + "<br/>");
							out.print("요청 시작 시간: " + start_time + "<br/>");
							out.print("요청 마지막 시간: " + last_time + "<br/>");
							out.print("웹사이트에서 경과 시간: " + used_time + "<br/>");
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