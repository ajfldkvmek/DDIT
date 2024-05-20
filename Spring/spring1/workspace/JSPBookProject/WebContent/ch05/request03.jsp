<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

						<table class="table table-bordered">
							<tr>
								<th></th>
								<th>r값</th>
								<th>설명</th>
							</tr>
							<tr>
								<td width="20%">클라이언트IP</td>
								<td width="20%"><%=request.getRemoteAddr()%></td>
								<td width="60%">웹브라우저 ip의 주소를 가져옵니다</td>
							</tr>

							<tr>
								<td>요청청보 길이</td>
								<td width="20%"><%=request.getContentLength()%></td>
								<td width="60%">웹브라우저의 요청파라메터 길이를 가져오</td>
							</tr>

							<tr>
								<td>요청청보 인코딩</td>
								<td width="20%"><%=request.getCharacterEncoding()%></td>
								<td width="60%">웹브라우저의 인코딩을 가져오</td>
							</tr>

							<tr>
								<td>요청 정보 프로토콜</td>
								<td width="20%"><%=request.getProtocol()%></td>
								<td width="60%">웹브라우저의 프로토콜 가져옵니다</td>
							</tr>

							<tr>
								<td>요청 정보 전송방식</td>
								<td width="20%"><%=request.getMethod()%></td>
								<td width="60%">웹브라우저의 요청메소드(post/get)를 가져옵니다</td>
							</tr>

							<tr>
								<td>요청 url</td>
								<td width="20%"><%=request.getRequestURL()%></td>
								<td width="60%">웹브라우저가 요청한 URL경로를 가져옵니다</td>
							</tr>

							<tr>
								<td>요청 uri</td>
								<td width="20%"><%=request.getRequestURI()%></td>
								<td width="60%">웹브라우저가 요청한 URI경로를 가져옵니다</td>
							</tr>

							<tr>
								<td>컨텍스트 경로</td>
								<td width="20%"><%=request.getContextPath()%></td>
								<td width="60%">현재 페이지의 웹애플리케이션 컨텍스트 경로 가져옵니다</td>
							</tr>

							<tr>
								<td>서버 이름</td>
								<td width="20%"><%=request.getServerName()%></td>
								<td width="60%">서버의 이름을 가져옵니다</td>
							</tr>

							<tr>
								<td>서버 포트</td>
								<td width="20%"><%=request.getServerPort()%></td>
								<td width="60%">현재 페이지의 웹애플리케이션 컨텍스트 경로 가져옵니다</td>
							</tr>

							<tr>
								<td>쿼리문</td>
								<td width="20%"><%=request.getQueryString()%></td>
								<td width="60%">웹 브라우저의 전체 요청파라미터 문자열을 가져옴</td>
							</tr>


						</table>

					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/pageModule/footer.jsp"%>

	<%@ include file="/pageModule/footerPart.jsp"%>
</body>
</html>