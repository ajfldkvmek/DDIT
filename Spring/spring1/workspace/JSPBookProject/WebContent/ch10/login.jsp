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
                        <li>CH10</li>
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
							시큐리티
							- 허가된 사용자만이 특정 웹 페이지에 접근할 수 이도록 제한하는 보안기능
							
							tomcat-user.xml에서 설정한 역할 당 계정ㄱ들 중,
							인증을 진행할 역할과 동일한 계정으로 인증시 정상적인 요청 및 인증이므로
							로그인이 진핼될 수 있다 하지만
							인증을 진행할 역할과 다른 역할의 계쩡으로 인증시 403 forbidden에러로 엑세스 거부 발생
							
							로그인 읹으 처리를ㄹ 위한 form 태그 작성
							- 폼 기반 인증을 처리하도록 action속성값을 j_security_check로
							- 아이디(username)의 name속성값을 j_username로
							- 비밀번호(userpassowrd)의 name속성값을 j_password로
						 -->
						<form action="j_security_check" method="post">
							아이디: <input type="text" name="j_username"/><br/>
							비밀번호: <input type="text" name="j_password"/><br/>
							<input type="submit" value="전송">
						</form>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>