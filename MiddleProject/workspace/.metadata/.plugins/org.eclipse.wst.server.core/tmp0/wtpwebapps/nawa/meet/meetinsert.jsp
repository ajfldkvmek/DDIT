<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임삭제</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
/* .form-group{
width :100%;
 height : 50px; 
 background: skyblue;
} */

.form-group {
	width: 70%
}

.form-loc1-name,.form-loc2-name ,.form-loc3-name {
	width :100%;
 	height : 60px; 
 	/* background: skyblue; */

}



.a1 {
	width: 10%;
}
.a2 {

	width: 100%;
}


/* .a1, .a2, .a3 {
    display: inline-block; /* 또는 display: inline; */
    width: 33.33%; /* 각 클래스가 가로로 1/3 차지하도록 설정 */
    box-sizing: border-box; /* 요소의 크기에 padding과 border를 포함하도록 설정 */
    padding: 10px; /* 각 클래스 사이의 여백을 설정할 수 있습니다. */
    /* 추가적인 스타일 규칙들... */
} */
</style>
<body>
<div class="container">
  <h1></h1>
  <p>만들 모임 정보를 입력하세요</p><br>
  <form action="./meetInsert" method="post">
  
  	<!-- <div class="form-group form-name">
      <label for="meetName">모임번호:</label>
      <input type="text" class="form-control" id="meetNo" name="meetNo">
    </div> -->
    <div class="form-group form-name">
      <label for="meetName">모임명:</label>
      <input type="text" class="form-control" id="meetName" name="meetName">
    </div>
    <div class="form-group">
      <label for="meetInfo">모임정보:</label>
     <!--  <input type="text" class="form-control" id="meetInfo" name="meetInfo"> -->
     <textarea class="form-control" rows="5" id="meetInfo" name="meetInfo"></textarea>
    </div>
    <div class="form-group">
      <label for="meetLevel">모임요일:</label>
      <input type="text" class="form-control" id="meetDay" name="meetDay">
    </div>
    <div class="form-group">
      <label for="meetLevel">모임시간:</label>
      <input type="text" class="form-control" id="meetTime" name="meetTime">
    </div>
    <div class="form-group">
      <label for="meetLevel">모임난이도:</label>
      <input type="text" class="form-control" id="meetLevel" name="meetLevel">
    </div>
    <div class="form-group">
      <label for="meetCapacity">모임정원:</label>
      <input type="text" class="form-control" id="meetLimit" name="meetLimit">
    </div>
     <!-- <div class="form-group">
      <label for="meetLoc">모임장소:</label>
      <input type="text" class="form-control" id="meetLoc" name="meetLoc">
    </div> -->
    
    <!-- 우편번호 및 주소 검색 -->
    <div class="form-group form-loc1-name">
        <label for="add1" class="control-label col-sm-2 a1">
        	<span class="rq a1-1">
        	우편번호
        	</span>
        </label>
        <div class="col-sm-4">
            <input type="text" class="form-control a2" id="postAddr" name="mem_zip" required>
        </div> 
        <div class="col-sm-2">
            <div class="col-sm-2 text-right">
    <button type="button" id="addrBtn" class="btn btn-info btn-sm a3">주소검색</button>
</div>
        </div>
       
    </div>

	
   
    <div class="form-group form-loc2-name">
        <label for="add1" class="control-label col-sm-2 a4">주소<span class="rq"></span></label>
        <div class="col-sm-6">
            <input type="text" class="form-control a5" id="addr1" name="meetLoc" required>
        </div>
    </div>

    <!-- 상세주소 -->
    <div class="form-group form-loc3-name">
        <label for="add2" class="control-label col-sm-2 a6">상세주소<span class="rq"></span></label>
        <div class="col-sm-6">
            <input type="text" class="form-control a7" id="addr2" name="meetLocDetail" required>
        </div>
    </div>

    <!-- 제출 버튼 -->
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">글 제출하기</button>
        </div>
    </div>
</form>
</div>
<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	//주소api
	$('#addrBtn').on('click',function() {
				new daum.Postcode({
										oncomplete : function(data) {
										// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

										// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
										// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
										var roadAddr = data.roadAddress; // 도로명 주소 변수
										var extraRoadAddr = ''; // 참고 항목 변수

										// 법정동명이 있을 경우 추가한다. (법정리는 제외)
										// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
										if (data.bname !== ''
												&& /[동|로|가]$/g
														.test(data.bname)) {
											extraRoadAddr += data.bname;
										}
										// 건물명이 있고, 공동주택일 경우 추가한다.
										if (data.buildingName !== ''
												&& data.apartment === 'Y') {
											extraRoadAddr += (extraRoadAddr !== '' ? ', '
													+ data.buildingName
													: data.buildingName);
										}
										// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
										if (extraRoadAddr !== '') {
											extraRoadAddr = ' ('
													+ extraRoadAddr + ')';
										}

										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										document.getElementById('postAddr').value = data.zonecode;
										document.getElementById("addr1").value = roadAddr;
										//   document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

									}
								}).open();
					});
	
	</script>
<%@include file="../include/footer.jsp" %>
</body>   
</html>