<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%	
	if (session.getAttribute("LOGIN_USER") == null) {
%>
      	<script> alert("로그인이 필요합니다");
      	location.href = "/nawa/index.jsp"; </script> 
	<% } %>
 	
<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<%@include file="/include/loginheader.jsp"%>


<!-- **************** MAIN CONTENT START **************** -->
<main>
<!-- =======================
Page Banner START -->
<section class="bg-light py-5">
	<div class="container">
		<div class="row g-4 g-md-5 position-relative">
			<!-- SVG decoration -->
			<figure class="position-absolute top-0 start-0 d-none d-sm-block">	
				<svg width="22px" height="22px" viewBox="0 0 22 22">
					<polygon class="fill-purple" points="22,8.3 13.7,8.3 13.7,0 8.3,0 8.3,8.3 0,8.3 0,13.7 8.3,13.7 8.3,22 13.7,22 13.7,13.7 22,13.7 "></polygon>
				</svg>
			</figure>

			<!-- Title and Search -->
			<div class="col-lg-10 mx-auto text-center position-relative">
				<!-- SVG decoration -->
				<figure class="position-absolute top-50 end-0 translate-middle-y">
					<svg width="27px" height="27px">
						<path class="fill-orange" d="M13.122,5.946 L17.679,-0.001 L17.404,7.528 L24.661,5.946 L19.683,11.533 L26.244,15.056 L18.891,16.089 L21.686,23.068 L15.400,19.062 L13.122,26.232 L10.843,19.062 L4.557,23.068 L7.352,16.089 L-0.000,15.056 L6.561,11.533 L1.582,5.946 L8.839,7.528 L8.565,-0.001 L13.122,5.946 Z"></path>
					</svg>
				</figure>
				<!-- Title -->
				<h1 class="display-6">뭘 도와드릴까요?</h1>
				<!-- Search bar -->
				<div class="col-lg-8 mx-auto text-center mt-4">
					<form class="bg-body shadow rounded p-2">
						<div class="input-group">
							<input class="form-control border-0 me-1" type="text" placeholder="Ask a question...">
							<button type="button" class="btn btn-blue mb-0 rounded">Submit</button>
						</div>
					</form>
				</div>
			</div>

			<!-- Category START -->
      <div class="col-12">
				<div class="row g-4 text-center">
				  <p class="mb-0">Choose a category to quickly find the help you need</p>
					<!-- Category item -->
					<div class="col-sm-6 col-md-3">
						<div class="card card-body card-border-hover p-0">
							<a href="#" class="p-3">
								<h2><i class="fas fa-street-view transition-base"></i></h2>
								<h6 class="mb-0">User Guide</h6>
							</a>
						</div>
					</div>

					<!-- Category item -->
					<div class="col-sm-6 col-md-3">
						<div class="card card-body card-border-hover p-0">
							<a href="#" class="p-3">
								<h2><i class="fas fa-hands-helping transition-base"></i></h2>
								<h6 class="mb-0">Assistance</h6>
							</a>
						</div>
					</div>

					<!-- Category item -->
					<div class="col-sm-6 col-md-3">
						<div class="card card-body card-border-hover p-0">
							<a href="#" class="p-3">
								<h2><i class="fas fa-exclamation-circle transition-base"></i></h2>
								<h6 class="mb-0">General guide</h6>
							</a>
						</div>
					</div>

					<!-- Category item -->
					<div class="col-sm-6 col-md-3">
						<div class="card card-body card-border-hover p-0">
							<a href="#" class="p-3">
								<h2><i class="fas fa-flag transition-base"></i></h2>
								<h6 class="mb-0">Getting started</h6>
							</a>
						</div>
					</div>
				</div> <!-- Row END -->
      </div>
			<!-- Category END -->
		</div>
	</div>
</section>
<!-- =======================
Page Banner END -->

<!-- =======================
Page content START -->
<section class="pt-5 pb-0 pb-lg-5">
	<div class="container">
	
		<div class="row g-4 g-md-5">
			<!-- Main content START -->
			<div class="col-lg-8">
				<!-- Title -->
				<h3 class="mb-4">FAQ: 자주 묻는 질문들</h3>

				<!-- FAQ START -->
				<div class="accordion accordion-icon accordion-bg-light" id="accordionExample2">
					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-1">
							<button class="accordion-button fw-bold rounded d-inline-block collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-1" aria-expanded="true" aria-controls="collapse-1">
								How can we help?
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-1" class="accordion-collapse collapse show" aria-labelledby="heading-1" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								(답변내용)
							</div>
						</div>
					</div>

					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-2">
							<button class="accordion-button fw-bold rounded d-inline-block collapsed d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-2" aria-expanded="false" aria-controls="collapse-2">
								How to edit my Profile?
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-2" class="accordion-collapse collapse" aria-labelledby="heading-2" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								마이페이지로 가시면 됩니다
							</div>
						</div>
					</div>

					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-3">
							<button class="accordion-button fw-bold collapsed rounded d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-3" aria-expanded="false" aria-controls="collapse-3">
								모임을 만들려면 어떻게 해야 하나요?
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-3" class="accordion-collapse collapse" aria-labelledby="heading-3" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								글을 쓰세요
							</div>
						</div>
					</div>

					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-4">
							<button class="accordion-button fw-bold collapsed rounded d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-4" aria-expanded="false" aria-controls="collapse-4">
								레슨은 뭐고 튜터는 뭔가요?
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-4" class="accordion-collapse collapse" aria-labelledby="heading-4" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								<p>레슨이란 이런거고</p>
								<p class="mb-0">튜터란 저런거고</p>
							</div>
						</div>
					</div>

					<!-- Item -->
					<div class="accordion-item mb-3">
						<h6 class="accordion-header font-base" id="heading-5">
							<button class="accordion-button fw-bold collapsed rounded d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-5" aria-expanded="false" aria-controls="collapse-5">
								질문질문
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-5" class="accordion-collapse collapse" aria-labelledby="heading-5" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								답변답변
							</div>
						</div>
					</div>

					<!-- Item -->
					<div class="accordion-item">
						<h6 class="accordion-header font-base" id="heading-6">
							<button class="accordion-button fw-bold collapsed rounded d-block pe-5" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-6" aria-expanded="false" aria-controls="collapse-6">
								모임과 레슨의 차이가 뭔가요?
							</button>
						</h6>
						<!-- Body -->
						<div id="collapse-6" class="accordion-collapse collapse" aria-labelledby="heading-6" data-bs-parent="#accordionExample2">
							<div class="accordion-body mt-3">
								모임은 모여서 주로 취미생활을 하는 거고 레슨은 자격증이 있는 전문가가 가르치는 겁니다
							</div>
						</div>
					</div>
				</div>
				<!-- FAQ END -->
			</div>
			<!-- Main content END -->

			<!-- Right sidebar START -->
			<div class="col-lg-4">
				<div class="row mb-5 mb-lg-0">
					<div class="col-12 col-sm-6 col-lg-12">
						<!-- Category START -->
						<div class="mb-4">
							<div class="d-flex justify-content-between align-items-center bg-info bg-opacity-10 rounded p-2 position-relative mb-3">
								<h6 class="m-0 text-info">Last Question</h6>
								<a href="#" class="badge bg-info stretched-link">2D ago</a>
							</div>
							<div class="d-flex justify-content-between align-items-center bg-danger bg-opacity-10 rounded p-2 position-relative mb-3">
								<h6 class="m-0 text-danger">Total Question</h6>
								<a href="#" class="badge bg-danger stretched-link">15,525</a>
							</div>
							<div class="d-flex justify-content-between align-items-center bg-success bg-opacity-10 rounded p-2 position-relative mb-3">
								<h6 class="m-0 text-success">Answer</h6>
								<a href="#" class="badge bg-success stretched-link">12536</a>
							</div>
						</div>
						<!-- Category END -->

						<!-- Related Topic START -->
						<div class="card card-body shadow p-4 mb-4">
							<!-- Title -->
							<h4 class="mb-3">Related Topic</h4>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Business</a>
								<span class="small">(21)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Development</a>
								<span class="small">(86)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Design</a>
								<span class="small">(92)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Marketing</a>
								<span class="small">(62)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Technology</a>
								<span class="small">(31)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Course Taking</a>
								<span class="small">(06)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Getting Started</a>
								<span class="small">(28)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Mobile</a>
								<span class="small">(18)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Payment Option</a>
								<span class="small">(32)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center mb-2">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Account & Profile</a>
								<span class="small">(56)</span>
							</div>
							<!-- Item -->
							<div class="d-flex justify-content-between align-items-center">
								<a href="#" class="h6 fw-light"><i class="fas fa-caret-right text-orange me-2"></i>Course taking</a>
								<span class="small">(45)</span>
							</div>
						</div>
						<!-- Related Topic END -->
					</div>

					<div class="col-12 col-sm-6 col-lg-12">
						<!-- Tags START -->
						<div class="card card-body shadow p-4">
							<h4 class="mb-3">Popular Tags</h4>
							<ul class="list-inline mb-0">
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">blog</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">business</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">theme</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">bootstrap</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">data science</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">web development</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">tips</a></li>
								<li class="list-inline-item"><a class="btn btn-outline-light btn-sm" href="#">machine learning</a></li>
							</ul>
						</div>
						<!-- Tags END -->
					</div>
				</div><!-- Row End -->
			</div>
			<!-- Right sidebar END -->
		</div><!-- Row END -->
	</div>
</section>
<!-- =======================
Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- =======================
Footer START -->
<footer class="pt-5 bg-light">
	<div class="container">
		<!-- Row START -->
		<div class="row g-4">

			<!-- Widget 1 START -->
			<div class="col-lg-3">
				<!-- logo -->
				<a class="me-0" href="index.html">
					<img class="light-mode-item h-40px" src="/nawa/assets/images/logo.svg" alt="logo">
					<img class="dark-mode-item h-40px" src="/nawa/assets/images/logo-light.svg" alt="logo">
				</a>
				<p class="my-3">Eduport education theme, built specifically for the education centers which is dedicated to teaching and involve learners. </p>
				<!-- Social media icon -->
				<ul class="list-inline mb-0 mt-3">
					<li class="list-inline-item"> <a class="btn btn-white btn-sm shadow px-2 text-facebook" href="#"><i class="fab fa-fw fa-facebook-f"></i></a> </li>
					<li class="list-inline-item"> <a class="btn btn-white btn-sm shadow px-2 text-instagram" href="#"><i class="fab fa-fw fa-instagram"></i></a> </li>
					<li class="list-inline-item"> <a class="btn btn-white btn-sm shadow px-2 text-twitter" href="#"><i class="fab fa-fw fa-twitter"></i></a> </li>
					<li class="list-inline-item"> <a class="btn btn-white btn-sm shadow px-2 text-linkedin" href="#"><i class="fab fa-fw fa-linkedin-in"></i></a> </li>
				</ul>
			</div>
			<!-- Widget 1 END -->

			<!-- Widget 2 START -->
			<div class="col-lg-6">
				<div class="row g-4">
					<!-- Link block -->
					<div class="col-6 col-md-4">
						<h5 class="mb-2 mb-md-4">Company</h5>
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link" href="#">About us</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Contact us</a></li>
							<li class="nav-item"><a class="nav-link" href="#">News and Blogs</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Library</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Career</a></li>
						</ul>
					</div>
									
					<!-- Link block -->
					<div class="col-6 col-md-4">
						<h5 class="mb-2 mb-md-4">Community</h5>
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link" href="#">Documentation</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Faq</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Forum</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Sitemap</a></li>
						</ul>
					</div>

					<!-- Link block -->
					<div class="col-6 col-md-4">
						<h5 class="mb-2 mb-md-4">Teaching</h5>
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link" href="#">Become a teacher</a></li>
							<li class="nav-item"><a class="nav-link" href="#">How to guide</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Terms &amp; Conditions</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- Widget 2 END -->

			<!-- Widget 3 START -->
			<div class="col-lg-3">
				<h5 class="mb-2 mb-md-4">Contact</h5>
				<!-- Time -->
				<p class="mb-2">
					Toll free:<span class="h6 fw-light ms-2">+1234 568 963</span>
					<span class="d-block small">(9:AM to 8:PM IST)</span>
				</p>

				<p class="mb-0">Email:<span class="h6 fw-light ms-2">example@gmail.com</span></p>

				<div class="row g-2 mt-2">
					<!-- Google play store button -->
					<div class="col-6 col-sm-4 col-md-3 col-lg-6">
						<a href="#"> <img src="/nawa/assets/images/client/google-play.svg" alt=""> </a>
					</div>
					<!-- App store button -->
					<div class="col-6 col-sm-4 col-md-3 col-lg-6">
						<a href="#"> <img src="/nawa/assets/images/client/app-store.svg" alt="app-store"> </a>
					</div>
				</div> <!-- Row END -->
			</div> 
			<!-- Widget 3 END -->
		</div><!-- Row END -->

		<!-- Divider -->
		<hr class="mt-4 mb-0">

		<!-- Bottom footer -->
		<div class="py-3">
			<div class="container px-0">
				<div class="d-lg-flex justify-content-between align-items-center py-3 text-center text-md-left">
					<!-- copyright text -->
					<div class="text-body text-primary-hover"> Copyrights ©2023 Eduport. Build by <a href="https://www.webestica.com/" target="_blank" class="text-body">Webestica</a></div>
					<!-- copyright links-->
					<div class="justify-content-center mt-3 mt-lg-0">
						<ul class="nav list-inline justify-content-center mb-0">
							<li class="list-inline-item">
								<!-- Language selector -->
								<div class="dropup mt-0 text-center text-sm-end">
									<a class="dropdown-toggle nav-link" href="#" role="button" id="languageSwitcher" data-bs-toggle="dropdown" aria-expanded="false">
										<i class="fas fa-globe me-2"></i>Language
									</a>
									<ul class="dropdown-menu min-w-auto" aria-labelledby="languageSwitcher">
										<li><a class="dropdown-item me-4" href="#"><img class="fa-fw me-2" src="/nawa/assets/images/flags/uk.svg" alt="">English</a></li>
										<li><a class="dropdown-item me-4" href="#"><img class="fa-fw me-2" src="/nawa/assets/images/flags/gr.svg" alt="">German </a></li>
										<li><a class="dropdown-item me-4" href="#"><img class="fa-fw me-2" src="/nawa/assets/images/flags/sp.svg" alt="">French</a></li>
									</ul>
								</div>
							</li>
							<li class="list-inline-item"><a class="nav-link" href="#">Terms of use</a></li>
							<li class="list-inline-item"><a class="nav-link pe-0" href="#">Privacy policy</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- =======================
Footer END -->
					
<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="/nawa/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="/nawa/assets/js/functions.js"></script>



</body>
</html>