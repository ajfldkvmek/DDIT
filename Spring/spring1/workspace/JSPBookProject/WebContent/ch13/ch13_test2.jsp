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
                        <li>CH13</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

	<%
		String v = request.getParameter("v");
		
		if(v != null && v.equals("2")){
		%>
			<script type="text/javascript">
				alert("로그인 세션이 1분으로 연장됨");
			</script>
		<%
		} else {
			session.setMaxInactiveInterval(30);
		}
		int maxInterval = session.getMaxInactiveInterval();
	 %>
	
	<c:set value= "<%=maxInterval %>" var="time"/>
		
    <section class="about-us section">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-lg-12 col-md-12 col-12">
                    <div class="content-left wow fadeInLeft" data-wow-delay=".3s">
						<!-- 내용을 입력해주세요 -->
						<!-- 
							1.초기 세션 만료시간을 30초로 설정해주세요
							2.세션 만료시간이 15초일 때, "곧 세션이 만료됩니다 연장하시겠습니까?"라는 알림장이 나타나고
								확인 버튼 클릭시 세션 을 60초로 연장후 해당 페이지에서 60초부터 세션 만료 시간이 관리 될 수 있도록 설정
								취소 버튼 클릭시 세션만료가 그대로 진행되고 0이되면 "세션이 만료되어 자동 로그아웃됩니다" 출력
						 -->
						 						 
						 <p>설정된 세션 시간은 ${time }초 입니다</p>
						 <p id="timer"></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>
	<%@ include file="/pageModule/footerPart.jsp" %>
	
	<script>
		
		$(function() {
			var time = "${time}";
			setInterval(() => {
				$("#timer").html(time);
				if(time == 15) {
					if(confirm("세션 연장 허쉴???")){
						location.href = "ch13_test2_process.jsp";
					}
				} else if(time == 0) {
					location.href="ch13_test2_exit.jsp";
				}
				
				time--;
			}, 1000);
		});
	
	</script>
</body>
</html>