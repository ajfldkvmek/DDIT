<%@page import="member.vo.MemberVO"%>
<%@page import="lecture.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="kr.or.ddit.comm.vo.AtchFileVO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LectureVO lv = (LectureVO) request.getAttribute("lv");
	List<LectureVO> lecList = (List<LectureVO>) request.getAttribute("lecList");
	MemberVO mem = (MemberVO) session.getAttribute("LOGIN_USER"); //이거	
	
// 	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/include/header.jsp" %>
</head>
<!-- **************** MAIN CONTENT START **************** -->
<main>
<!-- =======================
Page content START -->
<section class="pt-5 pb-0">
	<div class="container">
		<div class="row g-0 g-lg-5">

			<!-- Left sidebar START -->
			<div class="col-lg-4">
				<div class="row">
					<div class="col-md-6 col-lg-12">
						<!-- Instructor image START -->
            <div class="card shadow p-2 mb-4 text-center">
              <div class="rounded-3">
                <!-- Image -->
                <img src="assets/images/instructor/07.jpg" class="card-img" alt="course image">
              </div>
    
              <!-- Card body -->
              <div class="card-body px-3">
                <!-- Rating -->
                <ul class="list-inline">
                  <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                  <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                  <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                  <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                  <li class="list-inline-item me-0 small"><i class="fas fa-star-half-alt text-warning"></i></li>
                  <li class="list-inline-item ms-2 h6 fw-light mb-0">4.5/5.0</li>
                </ul>
                <!-- Social media button -->
                <ul class="list-inline mb-0">
                  <li class="list-inline-item"> <a class="btn px-2 btn-sm bg-facebook" href="#"><i class="fab fa-fw fa-facebook-f"></i></a> </li>
                  <li class="list-inline-item"> <a class="btn px-2 btn-sm bg-instagram-gradient" href="#"><i class="fab fa-fw fa-instagram"></i></a> </li>
                  <li class="list-inline-item"> <a class="btn px-2 btn-sm bg-twitter" href="#"><i class="fab fa-fw fa-twitter"></i></a> </li>
                  <li class="list-inline-item"> <a class="btn px-2 btn-sm bg-linkedin" href="#"><i class="fab fa-fw fa-linkedin-in"></i></a> </li>
                </ul>
              </div>
            </div>
						<!-- Instructor image END -->
					</div>

					<div class="col-md-6 col-lg-12">
						<div class="card card-body shadow p-4 mb-4">

							<!-- Education START -->
							<!-- Title -->
							<h4 class="mb-3">Education</h4>

							<!-- Education item -->
							<div class="d-flex align-items-center mb-4">
								<span class="icon-md mb-0 bg-light rounded-3"><i class="fas fa-graduation-cap"></i></span>
								<div class="ms-3">
									<h6 class="mb-0">Harvard University</h6>
									<p class="mb-0 small">Bachelor in Computer Graphics</p>
								</div>
							</div>

							<!-- Education item -->
							<div class="d-flex align-items-center mb-4">
								<span class="icon-md mb-0 bg-light rounded-3"><i class="fas fa-graduation-cap"></i></span>
								<div class="ms-3">
									<h6 class="mb-0">University of Toronto</h6>
									<p class="mb-0 small">Master in Computer Graphics</p>
								</div>
							</div>

							<!-- Education item -->
							<div class="d-flex align-items-center mb-4">
								<span class="icon-md mb-0 bg-light rounded-3"><i class="fas fa-graduation-cap"></i></span>
								<div class="ms-3">
									<h6 class="mb-0">East Ray University</h6>
									<p class="mb-0 small">Bachelor in Computer Graphics</p>
								</div>
							</div>
							<!-- Education END -->

							<hr> <!-- Divider -->

							<!-- Skills START -->
							<h4 class="mb-3">Skills</h4>

							<!-- Progress item -->
							<div class="overflow-hidden mb-4">
								<h6 class="uppercase">Graphic design</h6>
								<div class="progress progress-sm bg-primary bg-opacity-10">
									<div class="progress-bar bg-primary aos" role="progressbar" data-aos="slide-right" data-aos-delay="200" data-aos-duration="1000" data-aos-easing="ease-in-out" style="width: 90%;" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100">
										<span class="progress-percent-simple h6 mb-0">90%</span>
									</div>
								</div>
							</div>

							<!-- Progress item -->
							<div class="overflow-hidden mb-4">
								<h6 class="uppercase">Web design</h6>
								<div class="progress progress-sm bg-success bg-opacity-10">
									<div class="progress-bar bg-success aos" role="progressbar" data-aos="slide-right" data-aos-delay="200" data-aos-duration="1000" data-aos-easing="ease-in-out" style="width: 80%;" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100">
										<span class="progress-percent-simple h6 mb-0">80%</span>
									</div>
								</div>
							</div>

							<!-- Progress item -->
							<div class="overflow-hidden mb-4">
								<h6 class="uppercase">HTML/CSS</h6>
								<div class="progress progress-sm bg-warning bg-opacity-15">
									<div class="progress-bar bg-warning aos" role="progressbar" data-aos="slide-right" data-aos-delay="200" data-aos-duration="1000" data-aos-easing="ease-in-out" style="width: 60%;" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100">
										<span class="progress-percent-simple h6 mb-0">60%</span>
									</div>
								</div>
							</div>

							<!-- Progress item -->
							<div class="overflow-hidden mb-4">
								<h6 class="uppercase">UI/UX</h6>
								<div class="progress progress-sm bg-danger bg-opacity-10">
									<div class="progress-bar bg-danger aos" role="progressbar" data-aos="slide-right" data-aos-delay="200" data-aos-duration="1000" data-aos-easing="ease-in-out" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">
										<span class="progress-percent-simple h6 mb-0">50%</span>
									</div>
								</div>
							</div>
							<!-- Skills END -->

						</div>
					</div>
				</div> <!-- Row End -->
			</div>
			<!-- Left sidebar END -->
				
			<!-- Main content START -->
			<div class="col-lg-8">
			
				<!-- Title -->
				<h5 class="mb-0"><%= lv.getLecGrade() %></h5>
				<h1 class="mb-0"><%= lv.getLecTitle() %></h1>
				<p><%= lv.getMemName() %></p>
				<!-- Content -->
				<p class="mt-4"><%= lv.getLecCont() %></p>
				<!-- Personal info -->
				<ul class="list-group list-group-borderless">
					<li class="list-group-item px-0">
						<span class="h6 fw-light"><i class="fas fa-fw fa-map-marker-alt text-primary me-1 me-sm-3"></i>Address:</span>
						<span><%= lv.getLecLoc() %></span>
					</li>
					<li class="list-group-item px-0">
						<span class="h6 fw-light"><i class="fas fa-fw fa-envelope text-primary me-1 me-sm-3"></i>Email:</span>
						<span><%= lv.getMemEmail() %></span>
					</li>
					<li class="list-group-item px-0">
						<span class="h6 fw-light"><i class="fas fa-fw fa-headphones text-primary me-1 me-sm-3"></i>Phone number:</span>
						<span><%= lv.getMemTel() %></span>
					</li>
					<li class="list-group-item px-0">
						<span class="h6 fw-light"><i class="fas fa-fw bi bi bi-person-plus-fill text-primary me-1 me-sm-3" ></i>recruitment:</span>
						<span><%= lv.getLecCnt() %> / <%= lv.getLecMax() %></span>
					</li>
					
				</ul>

				<!-- Counter START -->
				<div class="row mt-4 g-3">
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4">
						<div class="d-flex align-items-center">
							<span class="icon-lg text-success mb-0 bg-success bg-opacity-10 rounded-3"><i class="fas fa-play"></i></span>
							<div class="ms-3">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="10"	data-purecounter-delay="200">0</h5>
									<span class="mb-0 h5">+</span>
								</div>
								<p class="mb-0 h6 fw-light">Total Courses</p>
							</div>
						</div>
					</div>
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4">
						<div class="d-flex align-items-center">
							<span class="icon-lg text-purple bg-purple bg-opacity-10 rounded-3 mb-0"><i class="fas fa-users"></i></span>
							<div class="ms-3">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="36"	data-purecounter-delay="200">0</h5>
									<span class="mb-0 h5">K+</span>
								</div>
								<p class="mb-0 h6 fw-light">Total Students</p>
							</div>
						</div>
					</div>
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4">
						<div class="d-flex align-items-center">
							<span class="icon-lg text-orange bg-orange bg-opacity-10 rounded-3 mb-0"><i class="fas fa-trophy"></i></span>
							<div class="ms-3">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="11" data-purecounter-delay="200">0</h5>
									<span class="mb-0 h5">+</span>
								</div>
								<p class="mb-0 h6 fw-light">Years in Experience</p>
							</div>
						</div>
					</div>
				</div>
				<!-- Counter END -->

				<!-- create button -->
				<br>
				<div class="d-sm-flex justify-content-end">
					<button type="editbutton" class="btn btn-primary mb-0" onclick="location.href='update.do?lecNo=<%=lv.getLecNo() %>'">수정하기</button>
					&nbsp;
					<button type="deletebutton" class="btn btn-primary mb-0" onclick="location.href='delete.do?lecNo=<%=lv.getLecNo() %>'"> 삭제하기</button>
				</div>
				<br>
				<div class="d-sm-flex justify-content-end">
					<button type="editbutton" class="btn btn-primary mb-0" onclick="location.href='involve.do?lecNo=<%=lv.getLecNo() %>'">신청하기</button>
				</div>
				<!-- Course START -->
				<div class="row g-4 mt-4">
					<!-- Title -->
					<h2>강의 리스트</h2>

	<%
    int cardCount = 0; // 현재 행의 카드 수를 세는 변수

    for (LectureVO lecVO : lecList) {
        // lecVO의 속성에 직접 액세스할 수 있습니다. 추가적인 루프가 필요하지 않습니다.
        // 카드 생성 로직은 필요에 따라 조정하세요.

        if (cardCount % 2 == 0) {
            // 두 개의 카드마다 새로운 행 시작
%>
            <div class="row">
<%
        }
%>
                <!-- 카드 아이템 시작 -->
                <div class="col-sm-6">
                    <div class="card shadow h-100">
                        <!-- 이미지 -->
                        <img src="assets/images/courses/4by3/07.jpg" class="card-img-top" alt="코스 이미지">
                        <div class="card-body pb-0">
                            <!-- 뱃지와 즐겨찾기 -->
                            <div class="d-flex justify-content-between mb-2">
                                <a href="#" class="badge bg-success bg-opacity-10 text-success">초보자</a>
                                <a href="#" class="text-danger"><i class="fas fa-heart"></i></a>
                            </div>
                            <!-- 제목 -->
                            <h5 class="card-title fw-normal"><a href="#"><%= lecVO.getLecTitle() %> </a></h5>
                            <p class="mb-2 text-truncate-2"><%= lecVO.getLecCont() %></p>
                            <!-- 별점 -->
                            <ul class="list-inline mb-0">
                                <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                                <!-- 필요에 따라 다른 별점 추가 -->
                                <li class="list-inline-item ms-2 h6 fw-light mb-0">4.0/5.0</li>
                            </ul>
                        </div>
                        <!-- 카드 푸터 -->
                        <div class="card-footer pt-0 pb-3">
                            <hr>
                            <div class="d-flex justify-content-between">
                                <span class="h6 fw-light mb-0"><i class="far fa-clock text-danger me-2"></i>18h 56m</span>
                                <span class="h6 fw-light mb-0"><i class="fas fa-table text-orange me-2"></i>99 강의</span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 카드 아이템 종료 -->
<%
        cardCount++;

        if (cardCount % 2 == 0) {
            // 두 개의 카드마다 행 종료
%>
            </div>
<%
        }
    }
%>

					
      </div>
      </div>
      </section>
      </main>
      <body>
			<!-- Main content END -->

		<!-- Row END -->
	

<!-- =======================
Page content END -->
<script>

// 현재 로그인한 사용자와 강의를 만든 사용자의 아이디 설정
var loggedInUserId = "<%= mem.getMem_id() %>";
var lectureCreatorId = "<%= lv.getMemId() %>";

// 버튼 요소 가져오기
var editButton = document.querySelector('[type="editbutton"]');
var deleteButton = document.querySelector('[type="deletebutton"]');

// 로그인한 사용자 아이디와 강의를 만든 사용자 아이디 비교
if (loggedInUserId === lectureCreatorId) {
    // 사용자 권한이 있는 경우: 수정, 삭제 버튼 표시
    editButton.style.display = "inline-block"; // 수정 버튼을 보이도록 설정
    deleteButton.style.display = "inline-block"; // 삭제 버튼을 보이도록 설정
} else {
    // 사용자 권한이 없는 경우: 수정, 삭제 버튼 감추기
    editButton.style.display = "none"; // 수정 버튼을 감추도록 설정
    deleteButton.style.display = "none"; // 삭제 버튼을 감추도록 설정
}

</script>
</body>
</html>