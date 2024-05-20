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
                        <li>CH06</li>
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
							아이디 비밀번호 이름 핸드폰번호 성별 취미 가입인사 입력폼 양식 만들고
							ch06_test_process.jsp로 결과 전송
							연락처 첫번째 자리는 select
							성별은 남자일때 M 여자일때 G
							취미는 운동 독서 영화 음악 총 4가지 선택지 value는 모두 영문으로 설정
							가입 인사는 textarea
							-->
							
							
						<form action="ch06_test_process.jsp" method="post">
							<p>아이디: <input type="text" name="id"/></p>
							<p>비밀번호: <input type="text" name="pw"/></p>
							<p>이름: <input type="text" name="name"/></p>
							<p>
								<select name="phone1">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="019">019</option>
								</select>
								<input typ="text" name="phone2" maxlength="4" size="4">
								<input typ="text" name="phone3" maxlength="4" size="4">
							</p>
							<p>
							성별: 
							<input type="radio" name="gender" value="M" checked="checked"/>남성
							<input type="radio" name="gender" value="G"/>여성
							</p>
							<p>
							취미:
							<input type="checkbox" name="hobby1" value="exe">운동
							<input type="checkbox" name="hobby2" value="read">독서
							<input type="checkbox" name="hobby3" value="music">음악
							<input type="checkbox" name="hobby4" value="movie">영화
							</p>
							<p>
							<textarea rows="3" cols="30" name="comment"
							placeholder="가입인사를 입력해주세용" wrap="hard"></textarea>							
							
							<input type="submit" value="전송"> 
							</p>
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