<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="login-box">
  <div class="card">
    <div class="card-body login-card-body">
      <h2 class="login-box-msg"><b>DDIT</b> BOARD</h2>
      
      <form action="/notice/loginCheck.do" method="post" id="signForm">
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="memId" name="memId" value="${member.memId }" placeholder="아이디를 입력해주세요">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
         <span class="error invalid-feedback" style="display:block;">${errors.memId }</span>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" id="memPw" name="memPw" placeholder="비밀번호를 입력해주세요">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div>
          </div>
          <div class="col-4">
            <button type="submit" id="signinBtn" class="btn btn-dark btn-block">로그인</button>
          </div>
        </div>
      </form>
      <p class="mb-1">
        <a href="/notice/forget.do">아이디 찾기&비밀번호 찾기</a> | 
        
      </p>
      <p class="mb-0">
        <a href="/notice/signup.do" class="text-center">회원가입</a>
      </p>
    </div>
  </div>
</div>
<script>
$(function(){
    
	var signinBtn = $("#signinBtn");
	var signForm = $("#signForm");
	
	
	
	signinBtn.on("click", function(){
		var id = $("#memId").val();
		var pw = $("#memPw").val();
	});
	
	
	if(id ==  null || id == ""){
		alert("아디입력 기기긱");
		return false;
	}
	if(pw ==  null || pw == ""){
		alert("비번 기기긱");
		return false;
	}
    signForm.submit();
});
</script>