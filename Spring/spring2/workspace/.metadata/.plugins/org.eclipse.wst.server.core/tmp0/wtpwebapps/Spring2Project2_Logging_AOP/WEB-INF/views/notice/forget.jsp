<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="">
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p class="h4">
				<b>아이디찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">아이디 찾기는 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post">
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="idmail" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" id="idname" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p id="yourId">
						
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" id="findId" class="btn btn-primary btn-block">아이디찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br />
	<div class="card card-outline card-primary">
		<div class="card-header text-center">
			<p href="" class="h4">
				<b>비밀번호찾기</b>
			</p>
		</div>
		<div class="card-body">
			<p class="login-box-msg">비밀번호 찾기는 아이디, 이메일, 이름을 입력하여 찾을 수 있습니다.</p>
			<form action="" method="post">
				<div class="input-group mb-3">
					<input type="text" id="pwId" class="form-control" placeholder="아이디를 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" id="pwEmail" class="form-control" placeholder="이메일을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<input type="text" id="pwName" class="form-control" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
					<p id="yourPw">
						
					</p>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="button" id="findPw" class="btn btn-primary btn-block">비밀번호찾기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br/>
	<div class="card card-outline card-secondary">
		<div class="card-header text-center">
			<h4>MAIN MENU</h4>
			<button type="button" class="btn btn-secondary btn-block">로그인</button>
		</div>
	</div>
</div>

<script>

$(function() {
	
	var findId = $("#findId");
	var findPw = $("#findPw");
	
	findId.on("click", function(){
		
		var memName = $("#idname").val();
		var memEmail = $("#idmail").val();
		var yourId = $("#yourId");
		//idForget.do
		var data = {
					memName : memName,
					memEmail : memEmail
					};
		$.ajax({    
			type : 'post',        
			url : '/notice/idForget.do', 
			contentType: 'application/json',
			dataType : 'text',  
			data : JSON.stringify(data),    
			success : function(result) { 
				if(result == null || result == ""){
					yourId.html("일치하는 정보가 없음");
				} else {
					yourId.html("아이디:" + result);
				}
			}    
		});
	});
	
	
	findPw.on("click", function(){
		
		var memName = $("#pwName").val();
		var memEmail = $("#pwEmail").val();
		var memId = $("#pwId").val();
		
		var yourPw = $("#yourPw");
		var data = {
					memName : memName,
					memEmail : memEmail,
					memId : memId
					};
		$.ajax({    
			type : 'post',        
			url : '/notice/pwForget.do', 
			contentType: 'application/json',
			dataType : 'text',  
			data : JSON.stringify(data),    
			success : function(result) { 
				if(result == null || result == ""){
					yourPw.html("일치하는 정보가 없음");
					console.log("ASdsasad")
				} else {
					console.log(result)
					yourPw.html("비번:" + result);
				}
			}    
		});
	});
});



</script>