<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/loginheader.jsp"%>


<style>

</style>

<!-- **************** MAIN CONTENT START **************** -->
<main>
	
<!-- =======================
Page Banner START -->
<section class="pt-0">
	<div class="container-fluid px-0">
		<div class="card bg-blue h-100px h-md-200px rounded-0" style="background:url(assets/images/pattern/04.png) no-repeat center center; background-size:cover;">
		</div>
	</div>
	<div class="container mt-n4">
		<div class="row">
			<div class="col-12">
				<div class="card bg-transparent card-body pb-0 px-0 mt-2 mt-sm-0">
					<div class="row d-sm-flex justify-sm-content-between mt-2 mt-md-0">
						<!-- Avatar -->
						<div class="col-auto">
						<!-- 여기 이미지 보이게 바꾸기  -->
							<div class="avatar avatar-xxl position-relative mt-n3">
								<img class="avatar-img rounded-circle border border-white border-3 shadow" src="<%=request.getContextPath() %>/image/profile/default.png" alt="">
							</div>
						</div>
						<!-- Profile info -->
						<div class="col d-sm-flex justify-content-between align-items-center">
							<div>
								<h1 class="my-1 fs-4"><%=mmv.getMem_nick() %></h1>
								<!-- <ul class="list-inline mb-0">
									<li class="list-inline-item me-3 mb-1 mb-sm-0">
										<span class="h6">255</span>
										<span class="text-body fw-light">points</span>
									</li>
									<li class="list-inline-item me-3 mb-1 mb-sm-0">
										<span class="h6">7</span>
										<span class="text-body fw-light">Completed courses</span>
									</li>
									<li class="list-inline-item me-3 mb-1 mb-sm-0">
										<span class="h6">52</span>
										<span class="text-body fw-light">Completed lessons</span>
									</li>
								</ul> -->
							</div>
						</div>
					</div>
				</div>

				<!-- Advanced filter responsive toggler 255 points -->
				<!-- Divider -->
				<hr class="d-xl-none">
				<!-- <div class="col-12 col-xl-3 d-flex justify-content-between align-items-center">
					<a class="h6 mb-0 fw-bold d-xl-none" href="#">Menu</a>
					<button class="btn btn-primary d-xl-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
						<i class="fas fa-sliders-h"></i>
					</button>
				</div> -->
				<!-- Advanced filter responsive toggler END -->
			</div>
		</div>
	</div>
</section>
<!-- =======================
Page Banner END -->

<!-- =======================
Page content START -->
<section class="pt-0">
	<div class="container">
		<div class="row">

			<!-- Left sidebar START -->
			<div class="col-xl-3">
				<!-- Responsive offcanvas body START -->
				<div class="offcanvas-xl offcanvas-end" tabindex="-1" id="offcanvasSidebar">
					<!-- Offcanvas header -->
					<div class="offcanvas-header bg-light">
						<h5 class="offcanvas-title" id="offcanvasNavbarLabel">My profile</h5>
						<button  type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasSidebar" aria-label="Close"></button>
					</div>
					<!-- Offcanvas body -->
					<div class="offcanvas-body p-3 p-xl-0">
						<div class="bg-dark border rounded-3 p-3 w-100">
							<!-- Dashboard menu -->
							<div class="list-group list-group-dark list-group-borderless collapse-list">
								<a class="list-group-item active" href="#"><i class="bi bi-ui-checks-grid fa-fw me-2"></i>내 정보</a>
								<a class="list-group-item active" href="student-subscription.html"><i class="bi bi-card-checklist fa-fw me-2"></i>내 레슨</a>
								<a class="list-group-item active" href="student-subscription.html"><i class="bi bi-card-checklist fa-fw me-2"></i>내 모임</a>
								<a class="list-group-item active" href="student-course-list.html"><i class="bi bi-basket fa-fw me-2"></i>내 글 목록</a>
								<a class="list-group-item active" href="student-course-resume.html"><i class="far fa-fw fa-file-alt me-2"></i>내가 찜한 모임</a>
								<a class="list-group-item active" href="student-quiz.html"><i class="bi bi-question-diamond fa-fw me-2"></i>내가 찜한 레슨</a>
								<a class="list-group-item active" href="student-payment-info.html"><i class="bi bi-credit-card-2-front fa-fw me-2"></i>신청중인 모임</a>
								<a class="list-group-item active" href="./edit_profile.jsp"><i class="bi bi-trash fa-fw me-2"></i>회원정보 수정</a>
								<a class="list-group-item active" href="./edit_profile.jsp"><i class="bi bi-trash fa-fw me-2"></i>회원탈퇴</a>
								<a class="list-group-item text-danger bg-danger-soft-hover" href="<%=request.getContextPath()%>/logout.do"><i class="fas fa-sign-out-alt fa-fw me-2"></i>로그 아웃</a>
								
								<!-- Submenu -->
								<ul class="nav collapse flex-column" id="collapseauthentication" data-bs-parent="#navbar-sidebar">
									<li class="nav-item"> <a class="nav-link" href="#">Dropdown item</a></li>
									<li class="nav-item"> <a class="nav-link" href="#">Dropdown item</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Responsive offcanvas body END -->
			</div>
			<!-- Left sidebar END -->

			<!-- Main content START -->
			<div class="col-xl-9">

				<!-- Counter boxes START -->
				<div class="row mb-4">
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4 mb-3 mb-lg-0">
						<div class="d-flex justify-content-center align-items-center p-4 bg-orange bg-opacity-15 rounded-3">
							<span class="display-6 lh-1 text-orange mb-0"><i class="fas fa-tv fa-fw"></i></span>
							<div class="ms-4">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="9"	data-purecounter-delay="200">0</h5>
								</div>
								<p class="mb-0 h6 fw-light">작성 글 수</p>
							</div>
						</div>
					</div>
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4 mb-3 mb-lg-0">
						<div class="d-flex justify-content-center align-items-center p-4 bg-purple bg-opacity-15 rounded-3">
							<span class="display-6 lh-1 text-purple mb-0"><i class="fas fa-clipboard-check fa-fw"></i></span>
							<div class="ms-4">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="52"	data-purecounter-delay="200">0</h5>
								</div>
								<p class="mb-0 h6 fw-light">내가 참여한 모임</p>
							</div>
						</div>
					</div>
					<!-- Counter item -->
					<div class="col-sm-6 col-lg-4 mb-3 mb-lg-0">
						<div class="d-flex justify-content-center align-items-center p-4 bg-success bg-opacity-10 rounded-3">
							<span class="display-6 lh-1 text-success mb-0"><i class="fas fa-medal fa-fw"></i></span>
							<div class="ms-4">
								<div class="d-flex">
									<h5 class="purecounter mb-0 fw-bold" data-purecounter-start="0" data-purecounter-end="8" data-purecounter-delay="300">0</h5>
								</div>
								<p class="mb-0 h6 fw-light">받은 레슨 </p>
							</div>
						</div>
					</div>
				</div>
				<!-- Counter boxes END -->

				<div class="card bg-transparent border rounded-3">
					<!-- Card header START -->
					<div class="card-header bg-transparent border-bottom">
					
						<!-- 여기를 왼쪽 사이드바에 맞게 수정해서 출력 -->
						<h4 class="mb-0">작성글 목록</h4>
					</div>
					<!-- Card header END -->

					<!-- Card body START -->
					<div class="card-body">

						<!-- Search and select START -->
						<div class="row g-3 align-items-center justify-content-between mb-4">
							<!-- Content -->
							<div class="col-md-8">
								<form class="rounded position-relative">
									<input class="form-control pe-5 bg-transparent" type="text" placeholder="Search" aria-label="Search">
									<button class="bg-transparent p-2 position-absolute top-50 end-0 translate-middle-y border-0 text-primary-hover text-reset" type="submit">
								<i class="fas fa-search fs-6 "></i>
							</button>
								</form>
							</div>

							<!-- Select option -->
							<!-- <div class="col-md-3">
								Short by filter
								<form>
									<select class="form-select js-choice border-0 z-index-9 bg-transparent" aria-label=".form-select-sm">
										<option value="">Sort by</option>
										<option>Free</option>
										<option>Newest</option>
										<option>Most popular</option>
										<option>Most Viewed</option>
									</select>
								</form>
							</div> -->
						</div>
						<!-- Search and select END -->

						<!-- Course list table START -->
						<div class="table-responsive border-0">
							<table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
								<!-- Table head -->
								<thead>
									<tr>
										<th scope="col" class="border-0 rounded-start">Course Title</th>
										<th scope="col" class="border-0">Total Lectures</th>
										<th scope="col" class="border-0">Completed Lecture</th>
										<th scope="col" class="border-0 rounded-end">Action</th>
									</tr>
								</thead>

								<!-- Table body START -->
								<tbody>
									<!-- Table item -->
									<tr>
										<!-- Table data -->
										<td>
											<div class="d-flex align-items-center">
												<!-- Image -->
a													<img src="./assets/images/courses/4by3/08.jpg" class="rounded" alt="">
												</div>
												<div class="mb-0 ms-2">
													<!-- Title -->
													<h6><a href="#">Building Scalable APIs with GraphQL</a></h6>
													<!-- Info -->
													<div class="overflow-hidden">
														<h6 class="mb-0 text-end">85%</h6>
														<div class="progress progress-sm bg-primary bg-opacity-10">
															<div class="progress-bar bg-primary aos" role="progressbar" data-aos="slide-right" data-aos-delay="200" data-aos-duration="1000" data-aos-easing="ease-in-out" style="width: 85%" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100">
															</div>
														</div>
													</div>
												</div>
											</div>
										</td>

										<!-- Table data -->
										<td>56</td>

										<!-- Table data -->
										<td>40</td>

										<!-- Table data -->
										<td>
											<a href="#" class="btn btn-sm btn-primary-soft me-1 mb-1 mb-md-0"><i class="bi bi-play-circle me-1"></i>Continue</a>
										</td>
									</tr>

								</tbody>
								<!-- Table body END -->
							</table>
						</div>
						<!-- Course list table END -->

						<!-- Pagination START -->
						<div class="d-sm-flex justify-content-sm-between align-items-sm-center mt-4 mt-sm-3">
							<!-- Content -->
							<p class="mb-0 text-center text-sm-start">Showing 1 to 8 of 20 entries 여기를 페이징</p>
							<!-- Pagination -->
							<nav class="d-flex justify-content-center mb-0" aria-label="navigation">
								<ul class="pagination pagination-sm pagination-primary-soft d-inline-block d-md-flex rounded mb-0">
									<li class="page-item mb-0"><a class="page-link" href="#" tabindex="-1"><i class="fas fa-angle-left"></i></a></li>
									<li class="page-item mb-0"><a class="page-link" href="#">1</a></li>
									<li class="page-item mb-0 active"><a class="page-link" href="#">2</a></li>
									<li class="page-item mb-0"><a class="page-link" href="#">3</a></li>
									<li class="page-item mb-0"><a class="page-link" href="#"><i class="fas fa-angle-right"></i></a></li>
								</ul>
							</nav>
						</div>
						<!-- Pagination END -->
					</div>
					<!-- Card body START -->
				</div>
			<!-- Main content END -->
			</div><!-- Row END -->
		</div>
	</div>	
</section>
<!-- =======================
Page content END -->

</main>


<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Vendors -->
<script src="assets/vendor/choices/js/choices.min.js"></script>
<script src="assets/vendor/purecounterjs/dist/purecounter_vanilla.js"></script>
<script src="assets/vendor/aos/aos.js"></script>

<!-- Template Functions -->
<script src="assets/js/functions.js"></script>

<%@include file="../include/footer.jsp" %>
</body>
</html>