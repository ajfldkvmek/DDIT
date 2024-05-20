<%@page import="java.util.Calendar"%>
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
							[문제]
							- 아이디, 비밀번호, 이름, 성별, 핸드폰번호, 주소를 입력받을 폼을 구성해주세요.
							  > 성별의 데이터는 남자일때 M, 여자일때 G로 설정해주세요.
							- ch05_test_process.jsp 경로로 입력받은 데이터를 전송해주세요.
						 -->
						<form action="ch05_test_process.jsp" method="post">
							<div class="mb-3 row">
								<label for="id" class="col-sm-1 col-form-label">아이디</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="id" name="id">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="pw" class="col-sm-1 col-form-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="pw" name="pw">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="name" class="col-sm-1 col-form-label">이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="gender" class="col-sm-1 col-form-label">성별</label>
								<div class="col-sm-10">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender" id="genderM" value="M">
										<label class="form-check-label" for="genderM">남자</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender" id="genderG" value="G">
										<label class="form-check-label" for="genderG">여자</label>
									</div>
								</div>
							</div>
							<div class="mb-3 row">
								<label for="phone" class="col-sm-1 col-form-label">핸드폰번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="phone" name="phone">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="address" class="col-sm-1 col-form-label">주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="address" name="address">
								</div>
							</div>
							<input class="btn btn-primary" type="submit" value="전송"/>
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