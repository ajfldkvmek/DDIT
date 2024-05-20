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
                        <li>CH01</li>
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
							 input type button/submit은 아주 예전부터 익히 사용되어 왔던 대표적인 버튼 Element다
							 브라우저 엔진 버전과 html버전이 업그레이드 되면서 input type button/submit만이 대체 할 수 없는 부분들이 발견되어 새롭게 만들어진 태그가 button태그이다
							
							input type button/submit은 end 태그로서 의 활용이 어려워 css를 활용하여 또는 태그들을 활용하여 버튼을 꾸미는데 제약이 맣이 걸렸따
							button태그는 몸체를 꾸밀 수 있다는 장점도 있어 css를 활용하는 건 물론 버튼 태그 내에 다양한 태그를 활용하여 버튼을 꾸밀수 있따
							그리고 input type button에서 제공되는 click, submit또한 제공된다
							
							우리가 다양하게 사용하고 있는 버튼 이벤트들 중 submit이라는 이벤트는 기본적으로 form태그 내에 있는 input 요소들으 ㅣ데이터를 읽어 action에설정되어 있는 경로로
							데이터를 보내주는 역할을 하는데, submit이벤트 자체만으로 본다면 브라우저 마다의 엔진별 특징이 조금씩 다르다
							
							그리고 submit 이벤트 자체에 컨트롤이 생각보다 어렵기도 함
							
							대표적으로 브라우저 엔진별 처리 로직과 시점이다
							ㅏㅅ용자가 사용하는 다양한 환경의 needs를 맞춰 개발하기란 쉽지 않지만 누구나 사용가능한
							공통적인 처리로직을 구현하는건 어렵지 않다. 개발자들 사이에서 관례로 사용되는 내용들이 여기에도 포함된다(ex. serviceImpl)
							input type submit버튼에는 onclick요소를 활용하여 클릭 이벤트를 함계 주기 않는다
							>> click 과 submit 이벤트 시점과 브라우저 버전별 엔진 처리 로직의 차이 떄문
							
							# onsubmit 속성 이벤트 활용
								onsubmit이벤트는 모든 브라우저 지원
								onsubmit="return 함수명"으로 사용
								 >return을 부여하는 건 해당 함수가 실행될 때, 정상처리면 true 값의 필터에 의해 처리결과가 비정상일떈 false 리턴
								 이 때 submit이벤트가 발생되지 않는다
											
				
						
						 -->
						<!-- 자바스크립트 onsubmit이벤트 -->
						<form action="process.jsp" method="post" name="loginForm" id="loginForm"
						onsubmit="return submitEvent()">
							아이디 : <input type="text" name="id"/><br/>							
							비밀번호 : <input type="text" name="pw"/><br/>	
							<input type="submit" value="전송"/>						
						</form>
						
						<!-- jQuery form을 이용한 submit 이벤트 -->
						<form action="process.jsp" method="post" id="loginForm2">
							아이디 : <input type="text" name="id" id="id"/><br/>							
							비밀번호 : <input type="text" name="pw" id="pw"/><br/>	
							<input type="submit" value="전송"/>						
						</form>
						
						<!-- jQuery click 이벤트 -->
						<form action="process.jsp" method="post" id="loginForm3">
							아이디 : <input type="text" name="id" id="id2"/><br/>							
							비밀번호 : <input type="text" name="pw" id="pw2"/><br/>	
							<input type="button" value="전송" id="sendBtn"/>						
						</form>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
<script type="text/javascript">
// 자바스크립트 onsubmit 이벤트
function submitEvent(){
	console.log("submit Event..!");
	alert("submit Event!")
	
	var id = document.loginForm.id.value; // 아이디 값
	var pw = document.loginForm.pw.value; // 비밀번호 값
	
	if(id == ""){
		alert("아이디가 누락 되었습니다");
		return false;
	}
	
	if(pw == ""){
		alert("비밀번호가 누락 되었습니다");
		return false;
	}
}

// 제이쿼리
$(function(){
	var loginForm2 = $("#loginForm2");
	var loginForm3 = $("#loginForm3");
	var sendBtn = $("#sendBtn");
	
	loginForm2.submit(function(event){
		//submit이벤트를 block할 수 ㄴ 있지만 아래에서 submit 이벤트를 주면
		//다시 해당 이벤트가 발생하기 때문에 무한 루프에 빠진다
	//	event.preventDefault(); // 서브밋 이벤트 block
		var id = $("#id").val(); // 클래스 일 때는 . id일 때는 #
		var pw = $("#pw").val();
		
		if(id == ""){
			alert("아이디 누락");
			return false;
		}
		
		if(pw == ""){
			alert("비번 누락");
			return false;
		}
		//아래에 이벤트를 주게ㅐ되면 submit의 이벤트를 여러번 호출하게 되는 셈이기 떄문에 stack이 터져버림
	//	$(this).submit();
	});
	
	sendBtn.on("click",function(){
		var id = $("#id2").val();
		var pw = $("#pw2").val();
		
		if(id==""){
			alert("아이디가 누락되었습니다.");
			return false;
		}
		
		if(pw==""){
			alert("비밀번호가 누락되었습니다.");
			return false;
		}
		
		loginForm3.submit();
	});
});


</script>
</html>
