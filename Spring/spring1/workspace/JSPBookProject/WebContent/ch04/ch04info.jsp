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
                        <li>CH0</li>
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
						<p>
						
							자바 빈즈란? <br/>
							
							 동적 컨텐츠 개발을 위해 자바 코드를 사용하여 자바 클래스로 로직을 작성하는 방법<br/>
							 즉 JSP페이지에서 화면을 표한하기 위한 계산식이나 자료의 처리를 담당하느 코드를 따로 분리하여 작성하는것<br/>
							 ex) 데이터를 저장하기 위해 만든 VO객체 <br/>
							 <br/>
							
							1.리다이렉트
								두개의 요청과 두개의 응답<br/>
								첫 요청 request의 url과 새롭게 요청되는 request의 url<br/>
								데이터를 주고 받을 대 사용하는 scope: session<br/>
								<br/>
							2.포워딩<br/>
								하나의 요청과 하나의 응답<br/>
								데이터를 주고 받을 때 사용하는 scope: request, response<br/>
							
						</p>
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>