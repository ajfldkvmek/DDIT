<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER ALLFORM</title>
</head>
<body>
	<h2>Register All Form</h2>
	<hr/>
	
	<!-- 
		문제)
		유저ID, 패스워드, 이름, Email, 생년월일, 성별, 개발자여부, 외국인여부,
		국적, 소유차량, 취미, 우편번호, 주소, 
		카드1-번호, 카드1-유효년월, 카드2-번호, 카드2-유효년월,
		소개, 개인정보동의방침 여부
		
		위 항목을 데이터로 받을 form요소를 생성하고, /registerUser로 넘겨주세요.
		넘겨받은 데이터를 이클립스 내 console log로 출력해주세요.
		
		유저ID : input text
		패스워드 : input password
		이름 : input text
		Email : input text
		생년월일 : input text
		성별 : radio
		개발자 여부 : checkbox
		외국인여부 : checkbox
		국적 : select
		소유차량 : select
		취미 : checkbox
		우편번호 : text
		주소 : text
		카드(번호/유효년월) text
		소개 : textarea
		개인정보동의 : checkbox
		
		# Result
		아이디 : a001
		비밀번호 : 1234
		이름 : 홍길동
		Email : hongkd@naver.com
		생년월일 : 2024-02-23
		성별 : 남자
		개발자 여부 : 일반 / 개발자 (선택 여부에 따라 출력)
		외국인 여부 : 내국인 / 외국인 (선택 여부에 따라 출력)
		국적 : 대한민국
		소유차량 : 현대
		취미 : 개발 운동 영화
		우편번호 : 12345
		주소 : 대전광역시 중구 오류동 
		카드1-번호 : 112233
		카드1-유효년월 : 2024-02-24 ( 꼭 이런 형태가 아니어도 됨 날짜 데이터가 출력만 되도 Ok )
		카드2-번호 : 445566
		카드2-유효년월 : 2024-02-24 ( 꼭 이런 형태가 아니어도 됨 날짜 데이터가 출력만 되도 Ok )
		소개 : 반갑습니다! 403호 OOO입니다!
			   잘 부탁드립니다!
		개인정보동의 : 동의함
		
		_____________________________________________
		개발자 여부 선택 항목 : 일반(N), 개발자(Y)
		외국인 여부 선택 항목 : true / false
		국적 : 대한민국(korea), 독일(germany), 호주(austrailia), 캐나다(canada), 미국(usa)
		소유차량 : BMW(bmw), AUDI(audi), VOLVO(volvo), JEEP(jeep)
		취미 : 운동(sports), 음악감상(music), 영화시청(movie), 공부(study), 독서(book), 개발(develop)
		______________________________________________
		# 모든 항목의 데이터(value)는 영문으로 설정하여 데이터 처리합니다
	 -->
	
	<form action="/registerUser" method="post">
		<table>
			
		</table>
	</form>
</body>
</html>