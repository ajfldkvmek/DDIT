<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterAllForm</title>
</head>
<body>

	<h2>RegisterAllForm</h2>
	<hr/>
	
	<!-- 
		문제)
		유저id, 패스워드, 이름, 이메일, 생년월일 , 개발자여부, 외국인 여부, 국적, 소유차량, 취미, 우편번호, 주소
		
		카드1-번호 , 카드2-유효년월, 카드2번호, 카드2-유효년월
		소개, 개인정보 동의방침 여부
		
		위 항목을 데이터로 받을 form 작성하고 
		registerUser로 넘겨주세요
		
		id			: text
		pw			: password
		email		: text
		생년월일		: text
		성별			: radio
		개발자 여부	: checkbox
		외국인 여부	: checkbox
		국적			: select
		소유 차량		: select
		취미			: checkbox
		우편번호		: text
		주소			: text
		카드	-		: text
		소개			: textarea
		개인정보동의	: checkbox
	
		----------------------------------------------
		개발자 여부 선택 항목: 일반(N) 개발자(Y)
		외국인 여부 선택 항목: true  /  false
		국적:	한국(KOREA) 독일(GERMANY) 호주(AUSTRAILIA) 캐나다(CANADA) 미국(USA)
		소유차량: 뱀 아우디 현 볼 집
		취미: 운동(sport) 음악감상(music) 영화(movie) 공부(study) 독서(book) 개발(develop)
		--------------------------------------------------------------------------
		모든 항목ㅁ의 value는 영어로 처리
		
		
		# Resu1t

			아이디 •. a001
			비일번호 •. 1234
			이름 : 홍길동
			Emai1 : hongkd@naver.cotd
			생년월일 : 2024-02-23
			성별 : 남자
			개발자 여부 •. 일반 / 개발자 (선택 여부에 따라 출력)
			외국인 여부 •. 내국인 / 외국인 (선택 여부에 따라 출력)
			국적 : 대한민국
			소유차량 •. 현대
			취미 : 개발 운동 영화
			우편번호 : 12345
			-「그- : 대전광역시 중구 오류동
			카듸-번호 : 112233
			카듸-유효년월 : 2024-02-24 ( 꼭 이런 형태가 아니어도 됨 날짜 데이터가 출력만 되도
			카드2-번호 : 445566
			카드2-유효년월 : 2024-02-24 ( 꼭 이런 형태가 아니어도 됨 날짜 데이터가 출력만 되도
			소개 :
			반갑습니다! 403호 000입니다!
			살 부탁드립니다!
			개인정보동의 •. 동의함
			처럼 출력
	 -->
	
	<form action="/registerUser" method="post">
		<table border="1">
			<tr>
				<td>유저 ID</td>
				<td><input type="text" name="userId"/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="dateOfBirth"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="male" checked="checked"/>Male 
					<input type="radio" name="gender" value="female"/>Female 
					<input type="radio" name="gender" value="other"/>Other 
				</td>
			</tr>
			<tr>
				<td>개발자 여부</td>
				<td><input type="checkbox" name="developer" value="Y"/>개발자	</td>
			</tr>
			<tr>
				<td>외국인 여부</td>
				<td><input type="checkbox" name="foreigner" value="true"/></td>
			</tr>
			<tr>
				<td>국적</td>
				<td>
					<select name="nationality" class="jobs">
						<option value="korea">대한민국</option>
						<option value="germany">독일</option>
						<option value="austrailia">호주</option>
						<option value="canada">캐나다</option>
						<option value="usa">미국</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>소유차량</td>
				<td>
					<select name="cars" multiple="multiple">
						<option value="jeep">JEEP</option>
						<option value="bmw">BMW</option>
						<option value="audi">audi</option>
						<option value="volvo">VOLVO</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" value="sports"/>운동
					<input type="checkbox" name="hobby" value="music"/>음악감상 
					<input type="checkbox" name="hobby" value="movie"/>영화감상 
					<input type="checkbox" name="hobby" value="study"/>공부 
					<input type="checkbox" name="hobby" value="book"/>독서 
					<input type="checkbox" name="hobby" value="develop"/>개발 
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="address.postCode"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address.location"/></td>
			</tr>
			<tr>
				<td>카드1 - 번호</td>
				<td><input type="text" name="cardList[0].no"/></td>
			</tr>
			<tr>
				<td>카드1 - 유효년월</td>
				<td><input type="text" name="cardList[0].validMonth"/></td>
			</tr>
			<tr>
				<td>카드2 - 번호</td>
				<td><input type="text" name="cardList[1].no"/></td>
			</tr>
			<tr>
				<td>카드2 - 유효년월</td>
				<td><input type="text" name="cardList[1].validMonth"/></td>
			</tr>
			<tr>
				<td>소개</td>
				<td>
					<textarea rows="30" cols="10" name="introduction"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">개인정보동의 여부 <input type="checkbox" name="ok" value="true"/></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록"/>
					<input type="reset" value="리셋"/>
				</td>
			</tr>
		</table>
	</form>


</body>
</html>