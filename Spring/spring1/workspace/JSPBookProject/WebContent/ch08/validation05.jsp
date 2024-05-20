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
						<form action="validation05_process.jsp" method="post" name="member" >
							아이디 : <input type="text" name="id" /><br /> 
							비밀번호 : <input type="text" name="pw" /><br /> 
							이름 : <input type="text" name="name" /><br /> 
							
							연락처:
							<select name="phone1">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="019">019</option>
							</select>
							<input type="text" name="phone2" size="4" maxlength="4"/>-
							<input type="text" name="phone3" size="4" maxlength="4"/><br/>
							
							이메일: <input type="text" name="email"/><br/>
							
							<input type="button" value="전송"	 onclick="CheckMember()" />
						</form>

						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>
	<%@ include file="/pageModule/footerPart.jsp" %>
	
	
	<script>
	//정규표현식 사용하기
	// ^:시작, $끝
	
	//아이디는 영문 대소문자 한글 한글의 자음과 모음만 검사하다록 정규식
	//비밀번호는 숫자만 검사하도록
	//이름은 한긂나 검사하도록
	//전화번호는 전화번호 형태인지 검사하도록
	//이메일은 이메일 형식인지 검사하도록
	function CheckMember() {
		
		var regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ가-힣]*$/;
		var regExpPasswd = /^[0-9]*$/;
		var regExpName =/^[가-힣]*$/;
		var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		
		var regExpEmail = /^[0-9a-zA-Z]([-_/.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_/.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		
		var form = document.member;
		
		var id = form.id.value;
		var pw = form.pw.value;
		var name = form.name.value;
		var phone = form.phone1.value +"-" + form.phone2.value+"-"+form.phone3.value
		var email = form.email.value;
		
		
		if(!regExpId.test(id)){
			alert("아이디는 문자로 시작");
			form.id.select();
			return false;
		}
		
		if(!regExpPasswd.test(pw)){
			alert("비밀번호는 숫자만");
			form.pw.select();
			return false;
		}
		
		if(!regExpName.test(name)){
			alert("이름ㅇ느 한글만")
			form.name.select();
			return false;
		}
		if(!regExpEmail.test(email)){
			alert("이메일 형식 맞춰서")
			form.email.select();
			return false;
		}
		form.submit();
	}
		
	</script>
</body>
</html>