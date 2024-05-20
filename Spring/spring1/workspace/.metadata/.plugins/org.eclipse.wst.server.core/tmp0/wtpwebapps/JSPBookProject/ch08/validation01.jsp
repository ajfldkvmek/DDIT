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
                        <li>CH08</li>
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
						<h3>JS 버전</h3>
						<form action="process.jsp" method="post" name="loginForm" id="loginForm">
							아이디 : <input type="text" name="id"/><br/>							
							비밀번호 : <input type="text" name="pw"/><br/>	
							<input type="button" value="전송" onclick="checkForm()"/>						
						</form>
						
						
						<h3>JQUERY 버전</h3>
						<form action="process.jsp" method="post" id="loginForm2">
							아이디 : <input type="text" id="id2"/><br/>							
							비밀번호 : <input type="text" id="pw2"/><br/>	
							<input type="button" value="전송" id="sendBtn"/>						
						</form>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>
	<%@ include file="/pageModule/footerPart.jsp" %>
	
	
	<script>
	
		function checkForm(){
			alert("아이디: " + document.loginForm.id.value + "\n" +
					"비밀번호 " + document.loginForm.pw.value);
			document.loginForm.submit();
		}
	
		//jquery방식
		//방법1
		$(function() {
			var sendBtn = $("#sendBtn");
			var loginForm2 = $("#loginForm2");
			
			sendBtn.on("click", function() {
				alert("아이디: " + $("#id2").val() + "\n" +"비밀번호 : " + $("#pw2").val());
				loginForm2.submit();
			});
		})
		
		//방법2
		sendBtn.on("click", checkFormJquery);
		function checkFormJquery() {
			alert("아이디: " + $("#id2").val() + "\n" +"비밀번호 : " + $("#pw2").val());
			loginForm2.submit();
		}
	
		
		
	</script>
</body>
</html>