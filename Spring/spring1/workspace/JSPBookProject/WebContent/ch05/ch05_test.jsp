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
					아이디 비밀번호 이름 성별 폰번호 주소를 입력받을 폼 우성하고 process페이지로 넘겨주세요
					성별의 경우 남자는 M, 여자는 G로 설정해 주세요
					ch05_test_process.jsp 경로로 입력받은 데이터를 전송		
					
					[예시]
					아이디:ㅁㅇㅁㄴㅇㅁㄴ
					비반:ㅇㅁㄴㅇㅁㄴ
					
					ㅇㅁㄴㅇㅁㄴㅇㅁㅇㅁㄴㅇㅁㄴㅇ
					ㅁㅇㅁㅇㅁㅇㄴ
					ㅁㅇㅁㄴ
					
					출력완료되고 5초후 네이버로 이동			
					 -->
					 
					 <form action="ch05_test_process.jsp" method="post">
					 
					 아이디: <input type="text" name="id"><br/>
					 비이번: <input type="password" name="pw"><br/>
					 이이름: <input type="text" name="nm"><br/>
					 서엉별: 남: <input type="radio" name="gn" value="M">
					 			여: <input type="radio" name="gn" value="G"><br/>
					 폰번호: <input type="text" name="pn"><br/>
					 주소: <input type="text" name="ad"><br/>
					 
					 <input type="submit" value="마! 가라">
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