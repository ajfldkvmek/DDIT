<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<title>AjaxRegisterForm</title>
</head>
<body>
	<h1>9. Ajax 방식 요청처리</h1>
	
	
	<form>
		<p>userId: <input type="text" name="userId" id="userId"/> </p>
		<p>password: <input type="text" name="password" id="password"/> </p>
	</form>

	<p>3) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리 </p>
	<button id="registerBtn03">registerBtn03</button>
	
	
	
	<p>5) 요청 URL에 쿼리 파라메터를 붙여서 전달하면 문자열 매개변수로 처리한다 .</p>
	<button id="registerBtn05">registerBtn05</button>
	
	<p>7) 객체배열 타입의 JSON요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 지정하여 처리</p>
	<button id="registerBtn07">registerBtn07</button>
	
	
	<p>8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리</p>
	<button id="registerBtn08">registerBtn08</button>
	
	
	<p>9) 중첩된 객체 타입(컬렉션 List) JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리 </p>
	<button id="registerBtn09">registerBtn09</button>
	
	
	<script>
		$(function(){
			
			var registerBtn03 = $("#registerBtn03");
			var registerBtn05 = $("#registerBtn05");
			var registerBtn07 = $("#registerBtn07");
			var registerBtn08 = $("#registerBtn08");
			var registerBtn09 = $("#registerBtn09");
			
			
			registerBtn03.on("click", function(){
				var userId= $("#userId").val();
				var password= $("#password").val();
				
				var userObject = {
					userId : userId,
					password : password
				};
				
				$.ajax({
					type: "post",
					url: "/ajax/register03",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(userObject),
					success: function(result){
						console.log("result>> " + result);
						
						if(result==="SUCCESS"){
							alert(result);
						}
					}
				})
			});
			
			
			//5) 요청 URL에 쿼리 파라메터를 붙여서 전달하면 문자열 매개변수로 처리한다 .
			registerBtn05.on("click", function(){

				var userId= $("#userId").val();
				var password= $("#password").val();
				
				var userObject = {
					userId : userId,
					password : password
				};
				
				$.ajax({
					url: "/ajax/register05?userId="+userId,
					type: "post",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(userObject),
					success: function(result){
						console.log("result>> " + result);
						
						if(result==="SUCCESS"){
							alert(result);
						}
					}
				});
				
			});
		
		
			//7) 객체배열 타입의 JSON요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 지정하여 처리
			registerBtn07.on("click", function(){

				var userObjectArray = [
					{userId: "name01",password: "pw1"},
					{userId: "name02",password: "pw2"}
				];
				
				$.ajax({
					type: "post",
					url: "/ajax/register07",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(userObjectArray),
					success: function(result){
						console.log("result>> " + result);
						
						if(result==="SUCCESS"){
							alert(result);
						}
					}
				});
				
			});
			
			//8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리
			registerBtn08.on("click", function(){
				
				var userId = $("#userId").val();
				var password = $("#password").val();
				
				var userObject = {
					userId: userId,
					password: password,
					address: {
						postCode : "00000",
						location : "ㅋㅋ"
					}
				};
				
				$.ajax({
					type : "post",
					url : "/ajax/register08",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(userObject),
					success : function(result){
						console.log(result);
						if(result==="SUCCESS"){
							alert(result);
						}
					}
				})
			});
			
			//9) 중첩된 객체 타입(컬렉션 List) JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리
			registerBtn09.on("click", function(){
				var userId= $("#userId").val();
				var password= $("#password").val();
				
				var userObject = {
					userId : userId,
					password : password,
					cardList : [ {no: "12345", validMonth: "20231010"}, 
								{no: "23456", validMonth: "20241010"} ]
				};
				
				$.ajax({
					type: "post",
					url: "/ajax/register09",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(userObject),
					success: function(result){
						console.log("result>> " + result);
						
						if(result==="SUCCESS"){
							alert(result);
						}
					}
				})
			});
			
			
			
		});
	</script>
</body>
</html>