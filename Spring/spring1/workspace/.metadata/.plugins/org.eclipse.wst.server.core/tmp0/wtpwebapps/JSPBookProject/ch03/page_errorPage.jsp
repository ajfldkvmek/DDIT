<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="page_errorPage_error.jsp"%>
<!-- 
	현재 페이지에서 오류 발생하면 오류페이지로 이동하기 위한 page의 디렉티브 태그를사용
 -->

<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>쉽게 배우는 JSP 웹 프로그래밍</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="/pageModule/headPart.jsp"%>
</head>
<body>
	<%@ include file="/pageModule/header.jsp"%>

	<div class="breadcrumbs" style="padding-top: 40px;">
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
						
						<%
							//부트스트랩 하다보면 브라우저 에러가 발생하는 경우가 많다
							//서버에러500코드, nullpoint에러가 가장 많음
							//브라우저 화면상에는 500에러가 나와야 하지만
							//out.print에서 발생한 에러를 브라우저에서
							//제대로된 소스로 인식하지 않고 완전하지 않은 소스라고 분류하여
							//에러가난 시점에서 브라우저 상의 화면그리기를 멈추고 다음과 같은 에러를 발생시킬 수 있ㅆ음
							//"to load resource: net::ERR_IMCOMPLETE_CHUNKED_ENCODING"
							//여러상황에서 발생할 수 있는 에러로 페이지를 그려낼 때 완전하기 못한 소스가 있으면 발생함
							
							//[해결방법]
							//-현재 레이아웃 상태를 점검(include되는 레이아웃의 구조에 이상이 없는지)
							//-브라우저 설정 확인 및 변경
							//-오타확인
							//일부러 nulporint error발생시
							String str = null;
							out.println(str.toString());
						%>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/pageModule/footer.jsp"%>

	<%@ include file="/pageModule/footerPart.jsp"%>
</body>
</html>