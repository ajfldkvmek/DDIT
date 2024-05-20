<%@page import="member.vo.MemberVO"%>
<%@page import="meet.vo.MeetVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MeetVO mv = (MeetVO) request.getAttribute("mv");
	//MemberVO mem = (MemberVO) request.getAttribute("LOGIN_USER"); 이거말고
	MemberVO mem = (MemberVO) session.getAttribute("LOGIN_USER"); //이거	

%>
<%@include file="../include/header.jsp"%>


<!-- **************** MAIN CONTENT START **************** -->
<main>
	<!-- =======================
Main banner START -->
	<section class="pt-0">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Card item START -->
					<div class="card overflow-hidden h-400px h-xl-600px rounded-3"
						style="background-image: url(assets/images/bg/08.jpg); background-position: center left; background-size: cover;">
						<!-- Background dark overlay -->
						<div class="bg-overlay bg-dark opacity-6"></div>

						<!-- Card image overlay -->
						<div class="card-img-overlay d-flex align-items-start flex-column">
							<!-- Card overlay Top -->
							<div class="w-100 mb-auto d-flex justify-content-end">
								<button class="btn btn-sm btn-white mb-0">
									<i class="bi bi-share"></i> Share
								</button>
							</div>
							<!-- Card overlay bottom -->
							<div class="w-100 mt-auto">
								<div class="row p-0 p-sm-3">
									<div class="col-11 col-lg-7">
										<!-- Title -->
										<h1 class="text-white"><%=mv.getMeet_name()%></h1>
										<p class="text-white mb-0"><%=mv.getMeet_info()%></p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Card item END -->
				</div>
			</div>
		</div>
	</section>
	<!-- =======================
Main banner END -->

	<!-- =======================
Page content START -->
	<section class="pt-0">
		<div class="container">
			<div class="row g-4 g-lg-5">

				<!-- Main content START -->
				<div class="col-lg-8 order-2">
					<!-- Organization and time -->
					<div class="bg-light rounded-3 p-3 mb-4">
						<div class="row g-4">
							<!-- Organization -->
							<div class="col-md-4">
								<h6 class="small ">모임장</h6>
								<div class="d-flex align-items-center">
									<!-- Avatar -->
									<div class="avatar align-middle">
										<div class=" avatar-img rounded-1 bg-danger">
											<span
												class="  text-white position-absolute top-50 start-50 translate-middle fw-bold bi bi-person-circle"></span>
										</div>
									</div>
									<!-- Info -->
									<div class="ms-2">
										<h6 class="mb-0"><%=mv.getMem_id()%></h6>
										<!-- <small>2.4k followers</small> -->
									</div>
								</div>
							</div>

							<!-- Location -->
							<div class="col-md-4">
								<h6 class="small">Location:</h6>
								<div class="d-flex align-items-center">
									<!-- Avatar -->
									<div class="avatar align-middle flex-shrink-0">
										<div class="avatar-img rounded-2 bg-dark">
											<span
												class="position-absolute top-50 start-50 translate-middle text-white"><i
												class="bi bi-geo-alt-fill"></i></span>
										</div>
									</div>
									<h6 class="fw-normal mb-0 ms-2"><%=mv.getMeet_loc()%></h6>
								</div>
							</div>

							<!-- Date & Time -->
							<div class="col-md-4">
								<h6 class="small">모임시간:</h6>
								<div class="d-flex align-items-center">
									<!-- Avatar -->
									<div class="avatar align-middle flex-shrink-0">
										<div class="avatar-img rounded-2 bg-dark">
											<span
												class="position-absolute top-50 start-50 translate-middle text-white"><i
												class="bi bi-calendar-fill"></i></span>
										</div>
									</div>
									<div class="ms-2">
										<h6 class="fw-normal mb-0"><%=mv.getMeet_day()%></h6>
										<small><%=mv.getMeet_time()%></small>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content -->
					<h5>< 소모임 상세설명 ></h5>
					<p><%=mv.getMeet_info()%></p>
					<!-- <p>We focus a great deal on the</p> -->
					<!-- Counter -->
					<div class="card card-body bg-light p-4 mt-5">
						<div class="row g-2">
							<div class="col-sm-4">
								<!-- Visitors -->
								<div class="d-flex">
									<i class="bi bi-globe fs-4"></i>
									<div class="ms-3">
										<p class="mb-0">level</p>
										<h5 class="mb-0"><%=mv.getMeet_level()%></h5>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<!-- Registered -->
								<div class="d-flex">
									<i class="bi bi-person-plus fs-4"></i>
									<div class="ms-3">
										<p class="mb-0">후기</p>
										<h5 class="mb-0">356개(바꿔야함)</h5>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<!-- Attendance -->
								<div class="d-flex">
									<i class="bi bi-people fs-4"></i>
									<div class="ms-3">
										<p class="mb-0">참여인원</p>
										<h5 class="mb-0"><%=mv.getMeet_cnt()%>명/<%=mv.getMeet_limit()%>명
										</h5>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!-- Main content END -->


				<!-- Left sidebar START -->
				<div class="col-lg-4 order-1 order-lg-2">
					<div class="card card-body shadow">
						<!-- 쿼리스트링으로 모임번호보내기 ? 로  -->
						<!-- <a class="btn btn-primary w-100" href="#"> 모임 신청하기 페이지로(만들어야함) </a> -->

						<!-- 버튼만들기------------------ -->
						
						<li class="page-item mb-0">
							<!-- <a class="page-link" href="#" onclick="goToInsertMeet()">글 작성</a> -->
							<button type="button"
								onClick="location.href='<%=request.getContextPath()%>/mbList?meetNo=<%=mv.getMeet_no()%>'"
								class="btn btn-primary w-100">게시판이동하기</button>

						</li>
						
						
						<li class="page-item mb-0">
							<!-- <a class="page-link" href="#" onclick="goToInsertMeet()">글 작성</a> -->
							<button type="button"
								onClick="location.href='<%=request.getContextPath()%>/meetJoin?meetNo=<%=mv.getMeet_no()%>'"
								class="btn btn-primary w-100 bi bi-send-fill">신청하기</button>

						</li>


						<!-- <!-- 모달창 클릭 만들기----------------------------------------- -->

						<!-- 
						Button to Open the Modal
						<button type="button" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#myModal">모임 신청하기
						</button>

						The Modal
						<div class="modal" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">

									Modal Header
									<div class="modal-header">
										<h4 class="modal-title">Modal Heading</h4>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal"></button>
									</div>

									Modal body
									<div class="modal-body">Modal body..</div>

									Modal footer
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div>


 -->


						<div class="mt-4">
							<ul class="list-unstyled mb-4">
								<!-- <li class="d-flex justify-content-between mb-3"> <span class="w-150px">Ticket Price:</span> <h6 class="text-end mb-0"> $210.00 </h6></li>
							<li class="d-flex justify-content-between mb-3"> <span class="w-150px">Entry fees:</span> <h6 class="text-end mb-0"> $1 per ticket </h6></li> -->
								<li class="d-flex justify-content-between mb-3"><span
									class="w-150px">Address:</span>
									<h6 class="text-end mb-0">
										<%=mv.getMeet_loc()%><%=mv.getMeet_loc_detail()%>
									</h6></li>
							</ul>
							<!-- 지도부분 -->
							<!-- <iframe class="w-100 d-block rounded-bottom" height="230"
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.9663095343008!2d-74.00425878428698!3d40.74076684379132!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c259bf5c1654f3%3A0xc80f9cfce5383d5d!2sGoogle!5e0!3m2!1sen!2sin!4v1586000412513!5m2!1sen!2sin"
								style="border: 0;" aria-hidden="false" tabindex="0"></iframe> -->
							<div id="map" style="width: 100%; height: 350px;"></div>


						</div>
					</div>
					<br>
					
					<div class="row">
						<div class ="col-md-6 mb-2">
							<button id="editButton_" class ="btn btn-primary w-100">수정
								<a href="./meetUpdate?meetNo=<%=mv.getMeet_no()%>"></a>
							</button>
						</div>
						
						<div class="col-md-6 mb-2">
        					<button id="deleteButton_" class="  btn btn-primary w-100 bi bi-trash3-fill">삭제
           						 <a href="./meetDelete?meetNo=<%=mv.getMeet_no()%>">
           						 
           						 </a>
        					</button>
    					</div>
					</div>
				<!-- Left sidebar END -->

			</div>
			<!-- 오른쪽 사이드바 끝 -->
		</div>
		</div>
	</section>
	<!-- 페이지 콘텐츠 끝 -->
</main>



<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임정보 상세</title>
</head>
<body>
	<table border="1">
		 
		<tr>
			<td>no</td>
			<td><%=mv.getMeet_no() %></td>
		</tr>
		<tr>
			<td>소모임명</td>
			<td><%=mv.getMeet_name()%></td>
		</tr>
		
		<tr>
			<td>소모임소개</td>
			<td><%=mv.getMeet_info()%></td>
		</tr>
		<tr>
			<td>소모임난이도</td>
			<td><%=mv.getMeet_level() %></td>
			
		</tr>
		<tr>
			<td colspan="2">
			<a href="./meetList">목록</a>
			<a href="./meetUpdate?meetNo=<%=mv.getMeet_no()%>">수정</a>
			<a href="./meetDelete?meetNo=<%=mv.getMeet_no()%>">삭제</a>
		</tr>
	</table> --%>




<%@include file="../include/footer.jsp"%>

<!-- Back to top -->
<div class="back-top">
	<i
		class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i>
</div>

<!-- Bootstrap JS -->
<script
	src="/nawa/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="/nawa/assets/js/functions.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79549d33b8659b656efac22c4abff096&libraries=services"></script>
<script>
var addressData = {
        meetLoc: '<%=mv.getMeet_loc()%>',
        meetLocDetail: '<%=mv.getMeet_loc_detail()%>'
	};

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	//지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	//주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					addressData.meetLoc + ' ' + addressData.meetLocDetail,
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">모일 장소!</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
	
</script>


<script>
    // 예제로 로그인한 회원 아이디와 해당 페이지의 모임을 만든 회원 아이디를 설정
    var loggedInUserId = "<%=mem.getMem_id()%>";
    var meetupCreatorId = "<%=mv.getMem_id()%>";

    // 버튼 요소 가져오기
    var editButton = document.getElementById("editButton_");
    var deleteButton = document.getElementById("deleteButton_");
    console.log(editButton);

    // 로그인한 회원 아이디와 모임을 만든 회원 아이디 비교
    if (loggedInUserId === meetupCreatorId) {
        // 권한이 있는 경우: 수정, 삭제 버튼 활성화
        editButton.style.display = "block"; // 수정 버튼을 보이도록 설정
        deleteButton.style.display = "block"; // 삭제 버튼을 보이도록 설정
    } else {
        // 권한이 없는 경우: 수정, 삭제 버튼 비활성화 및 모달창 표시
        editButton.style.display = "none"; // 수정 버튼을 감추도록 설정
        deleteButton.style.display = "none"; // 삭제 버튼을 감추도록 설정

        // 모달창 띄우기 등 추가 작업을 수행할 수 있습니다.
		//alert("권한이 없습니다!");
    }
</script>



</body>
</html>