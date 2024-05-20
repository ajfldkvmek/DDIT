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
							String name;
							String value;
							
							//세션에 저장된 모든 세션 속송명을 가져오도록 session내장 객체의
							//getAttributeNames() 메서드를 작성
							//세션 이름들의 집합을 Enumeration 타입으로 이관(조력자의 도움 구하기)
							Enumeration en = session.getAttributeNames();
							int i = 0;
							
							while(en.hasMoreElements()){
								//세션명 꺼내기
								name = en.nextElement().toString();
								//세션값 꺼내기
								value = session.getAttribute(name).toString();
								
								out.println("설정된 세션의 속성 이름[" + i + "]" + name + "<br/>");
								out.println("설정된 세션의 속성 값[" + i + "]" + value + "<br/>");
								i++;
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