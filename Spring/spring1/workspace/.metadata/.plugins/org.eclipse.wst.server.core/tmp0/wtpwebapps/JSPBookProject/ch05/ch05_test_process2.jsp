<%@page import="java.util.Calendar"%>
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
                        <h1 class="page-title">내장객체</h1>
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
						<!-- 
							ch05_test.jsp 에서 전송받은 
							아이디, 비밀번호, 이름, 성별, 핸드폰번호, 주소를
							taglib를 이용하여 출력해주세요
							
							[출력 예시]
							아이디 : a001
							비밀번호 : 1234
							이름 : 홍길동
							성별 : 남자
							핸드폰번호 : 010-1234-1234
							주소 : 대전시 서구 오류동 123  
							
							[여기까지 가능한 분은 진행!]
							출력을 완료하였으면, 5초 뒤에 www.naver.com 홈페이지로 이동시켜주세요
						 -->
						 <%
							request.setCharacterEncoding("utf-8");
							String id = request.getParameter("id");
							String pw = request.getParameter("pw");
							String name = request.getParameter("name");
							String gender = request.getParameter("gender");
							if(gender.equals("M")){
								gender = "남자";
							}else{
								gender = "여자";
							}
							String phone = request.getParameter("phone");
							String addr = request.getParameter("address");
						 %>
						 아이디 : <c:out value="<%=id %>"/> <br/>
						 비밀번호 : <c:out value="<%=pw %>"/> <br/>
						 이름 : <c:out value="<%=name %>"/> <br/>
						 성별 : <c:out value="<%=gender %>"/> <br/>
						 핸드폰 : <c:out value="<%=phone %>"/> <br/>
						 주소 : <c:out value="<%=addr %>"/> <br/>
						 
						<br/>
						<p id="p1"></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
<script type="text/javascript">
	var a = 0;
	var pTag = document.getElementById("p1");
	
	// [방법 1]
	setInterval(() => {
		a++;
		pTag.innerHTML = a + "초 뒤에 이동합니다!";
		if(a == 5)
			location.href = "https://www.naver.com";
	}, 1000);
	
	// [방법 2]
// 	setTimeout(() => {
// 		location.href = "https://www.naver.com";
// 	}, 5000);
</script>
</html>