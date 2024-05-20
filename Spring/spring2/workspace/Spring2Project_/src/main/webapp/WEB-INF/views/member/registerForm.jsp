<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm</title>
</head>
<body>

<h1>registerForm</h1>
<hr/>

	
	<h4>1.컨트롤러 메소드 매개변수(요청 처리)</h4>
	<br/>
	
	<p>1) URL 경로상의 쿼리 파라메터 정보로부터 요청 데이타를 취득 할 수 있다</p>
	<a href="/register?userId=hongkd&passowrd=1234">Button01</a><br/>
	
	<p>2) URL 경로상의 경로변수로 부터 요청 데이타를 취득 할 수 있다</p>
	<a href="/register/hongkd">Button02</a><br/>
	
	<p>3) HTML Form 필드명과 컨트롤러 매개변수 명이 일치하면 요청데이터를 취득할 수 있다</p>
	<form action="/register01" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	<br/>
	
	<p>4) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 데이터를 취득하는가? </p>
	<form action="/register02" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	<br/>
	
	
	
	<h4>3. 요청 데이터 처리 어노테이션</h4>
	<hr/>
	
	<p>1) URL 경로상의 경로변수로 부터 요청 데이타를 취득 할 수 있다</p>
	<a href="/register/hongkd/100">data</a><br/>
	
	<p>2) @RequestParam 어노테이션을 사용하여 특정한 html from의 필드명을 지정하여 요청</p>
	<form action="/register0202" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	<br/>
	
	
	<h4>4. 요청 데이터 처리 자바빈즈</h4>
	<hr/>
	
	<p>1) 폼 텍스트 필드 요소값을 자바빈즈 매개벼수로 처리</p>
	<form action="/beans/register01" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	<p>2) 여러 개의 폼 텍스트 필드 요소값을 매개변수 수선에 상관없이 매개변수 명을 기준으로 처리한다</p>
	<form action="/beans/register03" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	
	
	<h4>4. Date 타입 처리</h4>
	<hr/>
	
	<p>1) 쿼리 파라메터(dateOfbirth=12341234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환이 실패?</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=12341234">Button4</a><br/>
	
	<p>2) 쿼리 파라메터(dateOfbirth=2024-02-23)로 전달받은 값이 변환 되나?</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2024-02-23">Button5</a><br/>
	
	<p>3) 쿼리 파라메터(dateOfbirth=2024/02/23)로 전달받은 값이 변환 되나?</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2024-02-23">Button6</a><br/>
	
	
	
	<p>4) Member 매개변수와 쿼리 파라메터(dateOfBirth-20240223)로 전달받은 값이 날짜나 문자열 형식으로 들어가나?</p>
	<form action="/registerByGet02?dateOfBirth=202402223" method="post">
		userId : <input type="text" name="userId" value="honkkd"/> <br/>
		passwd : <input type="text" name="password" value="1234"/> <br/>
		c o i n: <input type="text" name="coin" value="100"/> <br/> 
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	
	<h4>7. 폼 방식 요청 처리</h4> <hr/>
		
	<p>1) 폼 텍스트 필드 요소 값을 기본데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerUserId" method="post">
		userId : <input type="text" name="userId" /> <br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	<p>2) 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리</p>
	<form action="/registerPassword" method="post">
		password : <input type="password" name="password" /> <br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	<p>3) 폼 라디오 버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerRadio" method="post">
		<input type="radio" name="gender" value="male" checked="checked">남자
		<input type="radio" name="gender" value="female" />야자
		<input type="radio" name="gender" value="other" />기타
		
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	<p>4) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerSelect" method="post">
		<select name="nationality">
			<option value="korea">한국</option>
			<option value="japan">일본</option>
			<option value="germany">독일</option>
			<option value="canada">캐나다</option>
		</select>
		
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	
	<p>5) 복수 선택 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerMultipleSelect01" method="post">
		cars: <br/>
		<select name="cars" multiple="multiple" size='5'>
			<option value="bmw">bmw</option>
			<option value="benz">benz</option>
			<option value="audi">audi</option>
			<option value="volvo">volvo</option>
			<option value="zeep">zeep</option>
			<option value="ford">ford</option>
		</select>
		
		<input type="submit" value="전송"/><br/> <br/>
	</form>
	
	<p>6) 복수 선택 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 배열타입 매개변수로 처리</p>
	<form action="/registerMultipleSelect02" method="post">
		cars: <br/>
		<select name="carArray" multiple="multiple" size='5'>
			<option value="bmw">bmw</option>
			<option value="benz">benz</option>
			<option value="audi">audi</option>
			<option value="volvo">volvo</option>
			<option value="zeep">zeep</option>
			<option value="ford">ford</option>
		</select>
		
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>7) 복수 선택 가능한 폼 셀렉트 박스 요소값을 리스트로 매개변수로 처리</p>
	<form action="/registerMultipleSelect03" method="post">
		cars: <br/>
		<select name="carList" multiple="multiple" size='5'>
			<option value="bmw">bmw</option>
			<option value="benz">benz</option>
			<option value="audi">audi</option>
			<option value="volvo">volvo</option>
			<option value="ford">ford</option>
		</select>
		
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>8) 폼 체크박스 요속박스를 기본 데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerCheckBox01" method="post">
		hobby: <br/>
		<input type="checkbox" name="hobby" value="sports">sports<br/>
		<input type="checkbox" name="hobby" value="music">"music"<br/>
		<input type="checkbox" name="hobby" value="movie">movie<br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>9) 폼 체크박스 요속박스를 기본 데이터 타입인 문자열 타입 매개변수로 처리</p>
	<form action="/registerCheckBox02" method="post">
		hobbyArray: <br/>
		<input type="checkbox" name="hobbyArray" value="sports">sports<br/>
		<input type="checkbox" name="hobbyArray" value="music">"music"<br/>
		<input type="checkbox" name="hobbyArray" value="movie">movie<br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>10) 폼 체크박스 요속박스를  리스트 타입 매개변수로 처리</p>
	<form action="/registerCheckBox03" method="post">
		hobbyList: <br/>
		<input type="checkbox" name="hobbyList" value="sports">sports<br/>
		<input type="checkbox" name="hobbyList" value="music">"music"<br/>
		<input type="checkbox" name="hobbyList" value="movie">movie<br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>11) 폼 체크박스 요속박스를 기본 데이터 타입인 불린 타입 매개변수로 처리</p>
	<form action="/registerCheckBox04" method="post">
		foreigner: <br/>
		<input type="checkbox" name="foreigner" value="true">외국인<br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	
	<p>12) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다</p>
	<!-- 객체 형태로 저장됐을 경우 address.postCode처럼 따로 접근자 설정을 해줘야 한다 -->
	<form action="/registerUserAdress" method="post">
		postCode: <input type="text" name="address.postCode" ><br/>
		location: <input type="text" name="address.location" ><br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
	<p>13) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다</p>
	<form action="/registerUserCardlist" method="post">
		카드1- 번호: <input type="text" name="cardList[0].no" ><br/>
		카드1- 유효기간: <input type="text" name="cardList[0].validMonth" ><br/>
		카드2- 번호: <input type="text" name="cardList[1].no" ><br/>
		카드2ㄴ- 유효기간: <input type="text" name="cardList[1].validMonth" ><br/>
		<input type="submit" value="전송"/><br/> <br/>
	</form><br/>
	
	
</body>
</html>