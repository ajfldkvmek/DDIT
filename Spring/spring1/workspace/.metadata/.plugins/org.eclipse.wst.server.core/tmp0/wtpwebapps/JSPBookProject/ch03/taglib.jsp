<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                        <li>CH03</li>
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
						<h5>1) 변수 k가 1부터 10까지 1씩 증가하도록 jstl의 core태그 반복문을 작성</h5>
						<!--k를 1부터 10까지 1씩 증가 -->
						<c:forEach var = "k" begin="1" end="10" step="1">
							<c:out value="${k }"/>
						</c:forEach>
						
						<hr/><br/>
						<h5>2) 변수 k가 1부터 10까지 근데 짝수만 출력</h5>
						<c:forEach var="k" begin="1" end="10" step="1">
							<c:if test="${k%2==0 }">
								<c:out value="${k }"/>
							</c:if>
						</c:forEach>
						<hr/><br/>
						
						<h5>3) 스크립틀릿과 표현문 / JSTL을 통해 str출력</h5>
						<p>(스크립틀릿으로 선언)</p>
						<%
							String str = "스크립틀릿으로 선언한 개똥이";
						%>
						<%=str %>
						<br/>
						
						(JTSL의 코어 태그를 통한 출력)
						<c:set var = "str" value="코어태그로 선언한 개똥이"/>
						<c:out value="${str} "/>
						
						<hr/><br/>
						
						<h5>3) 스크립틀릿과 표현문 / JSTL을 통해 Collection출력</h5>
						<p>(스크립틀릿으로 선언)</p>
						<%
							List<String> list = new ArrayList<>();
							list.add("개똥이");
							list.add("말숙이");
							list.add("짱뚱이");
						%>
						<%=list %>
						
						<br/>
						
						<p>(JSTL의 Core태그 forEach를 통해 Collection 출력)
						<c:set var="listItem" value="<%=list %>"/> <!-- 표현문 방식으로 jstl에 데이터 입력 -->
						<!-- items에는 컬렉션에 해당하는 데이터틀을 집어넣을 수 있음 -->
						<c:forEach var="item" items="${listItem }" varStatus="stat">
							<p>${item }</p>
							<p>[count: ${stat.count }] | [index: ${stat.index }]</p>
						</c:forEach>
						
						<hr/><br/>
						
						<h5>5) JSTL을 통해 범위 내 값 출력</h5>
						<p>choose when/otherwise활용</p> <!--otherwise가 else의 역할임  -->
						<c:set var="money" value="5000"/>
						<p>내가 가진돈은 ${money }원인디</p>
						<c:choose>
							<c:when test="${money <= 0 }">
								그지
							</c:when>
							<c:when test="${money >= 5000 and money <= 10000 }">
								커피는 가능
							</c:when>
							<c:otherwise>
								 고기먹자
							</c:otherwise>
						
						</c:choose>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>
	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>