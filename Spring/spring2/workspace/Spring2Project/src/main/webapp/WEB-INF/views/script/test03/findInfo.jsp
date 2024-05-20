<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
</head>
<body>
	<!-- 
		아이디찾기, 비밀번호찾기를 진행해주세요.
		
		# 아이디찾기
		1) 이름, 이메일을 입력 후, 아이디 찾기 버튼을 클릭 시 비동기 통신을 활용해 아이디를 출력해주세요.
			> 조회된 아이디 정보는 아이디 찾기 안에 있는 card-body 클래스명을 가진 div안에 출력해주세요.
			> 존재하지 않는 정보라면 "존재하지 않습니다"를 출력해주세요.
			
		# 비밀번호 찾기
		1) 아이디, 이름, 이메일을 입력 후, 비밀번호 찾기 버튼을 클릭 시 비동기 통신을 활용해 비밀번호를 출력해주세요.
			> 조회된 비밀번호 정보는 비밀번호 찾기 안에 있는 card-body 클래스명을 가진 div안에 출력해주세요.
			> 존재하지 않는 정보라면 "존재하지 않습니다"를 출력해주세요.	
	
	 -->
	<div class="row">
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					아이디 찾기
				</div>
				<div class="card-body">
					<form action="" method="post">
						<div class="input-group mb-3">
							<input class="form-control" type="text" name="memName" id="memNameId" placeholder="이름을 입력해주세요."/>
						</div>
						<div class="input-group mb-3">
							<input class="form-control" type="text" name="memEmail" id="memEmailId" placeholder="이메일을 입력해주세요."/>
						</div>
					</form>
				</div>
				<div class="card-footer">
					<button type="button" id="idBtn" class="btn btn-primary mb-2">아이디찾기</button>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="card">
				<div class="card-header">
					비밀번호 찾기
				</div>
				<div class="card-body">
					<form action="" method="post">
						<div class="input-group mb-3">
							<input class="form-control" type="text" name="memId" id="memIdPw" placeholder="아이디를 입력해주세요."/>
						</div>
						<div class="input-group mb-3">
							<input class="form-control" type="text" name="" id="memNamePw" placeholder="이름을 입력해주세요."/>
						</div>
						<div class="input-group mb-3">
							<input class="form-control" type="text" name="memEmail" id="memEmailPw" placeholder="이메일을 입력해주세요."/>
						</div>
					</form>
				</div>
				<div class="card-footer">
					<button type="button" id="pwBtn" class="btn btn-primary mb-2">비밀번호찾기</button>
				</div>
			</div>
		</div>
		<div class="col-md-6 mb-2">
			<button type="button" id="backBtn"class="btn btn-primary mb-2">뒤로가기</button>
		</div>
	</div>
	
	<script>
	 
		$(function(){
			
			var idBtn = $("#idBtn");
			var pwBtn = $("#pwBtn");
			var backBtn = $("#backBtn");
			
			var cardBody = $(".card-body:first");
			var cardBody2 = $(".card-body:eq(1)");
			
			
			
			idBtn.on("click", function(){
				var memName = $("#memNameId").val(); 
				var memEmail = $("#memEmailId").val();
				var memberObj = {
					memName : memName,
					memEmail : memEmail
				}
				
				$.ajax({
					type: "post",
					url: "/test03/finId.do",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(memberObj),
					success: function(result){
						console.log("result>> " + result);
						html = "";
						if(result == null || result == ""){
							html += "일치하는 계정이 없습니다.";
						} else {
							html += "당신의 Id는 ";
							html += result;
							html += "입니다";
						}
			            cardBody.html(html);
					}	
				});
			
			});
			
			pwBtn.on("click", function(){
				var memId = $("#memIdPw").val();
				var memName = $("#memNamePw").val();
				var memEmail = $("#memEmailPw").val();
				
				var memberObj2 = {
						memName : memName,
						memEmail : memEmail,
						memId : memId
					}
					
				$.ajax({
					
					type: "post",
					url: "/test03/findPw.do",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(memberObj2),
					success: function(result){
						console.log("result>> " + result);
						html = "";
						if(result == null || result == ""){
							html += "일치하는 계정이 없습니다.";
						} else {
							html += "해당 계정의 비밀번호는 ";
							html += result;
							html += "입니다";
						}
			            cardBody2.html(html);
					}	
				});	
				
				
			});
			
					
			backBtn.on("click", function(){
				location.href = "/test03/login.do"
			});
		});
	
	</script>
</body>
</html>