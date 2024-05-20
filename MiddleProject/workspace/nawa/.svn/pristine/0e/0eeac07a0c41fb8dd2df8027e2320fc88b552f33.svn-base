<%@page import="java.util.List"%>
<%@page import="lecture.vo.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	LectureVO lv = (LectureVO) request.getAttribute("lv");
	List<LectureVO> lecList = (List<LectureVO>) request.getAttribute("lecList");	

%>
<head>
<meta charset="UTF-8">
<title>새 강의 등록</title>
</head>
<body>
	<!-- **************** MAIN CONTENT START **************** -->
	<%@include file="/include/header.jsp" %>
<main>
	
<!-- =======================
Page Banner START -->
<section class="pt-0">
	<!-- Main banner background image -->
	<div class="container-fluid px-0">
		<div class="bg-blue h-100px h-md-200px rounded-0" style="background:url(assets/images/pattern/04.png) no-repeat center center; background-size:cover;">
		</div>
	</div>
	<div class="container mt-n4">
		<div class="row">
			<!-- Profile banner START -->
			<div class="col-12">
				<div class="card bg-transparent card-body p-0">
					<div class="row d-flex justify-content-between">
						<!-- Avatar -->
						<div class="col-auto mt-4 mt-md-0">
							<div class="avatar avatar-xxl mt-n3">
								<img class="avatar-img rounded-circle border border-white border-3 shadow" src="assets/images/avatar/01.jpg" alt="">
							</div>
						</div>
						<!-- Profile info -->
						<div class="col d-md-flex justify-content-between align-items-center mt-4">
							<div>
								<h1 class="my-1 fs-4">Lori Stevens <i class="bi bi-patch-check-fill text-info small"></i></h1>
								<ul class="list-inline mb-0">
									<li class="list-inline-item h6 fw-light me-3 mb-1 mb-sm-0"><i class="fas fa-star text-warning me-2"></i>4.5/5.0</li>
									<li class="list-inline-item h6 fw-light me-3 mb-1 mb-sm-0"><i class="fas fa-user-graduate text-orange me-2"></i>12k Enrolled Students</li>
									<li class="list-inline-item h6 fw-light me-3 mb-1 mb-sm-0"><i class="fas fa-book text-purple me-2"></i>25 Courses</li>
								</ul>
							</div>
							<!-- Button -->
							<div class="d-flex align-items-center mt-2 mt-md-0">
								<a href="instructor-create-course.html" class="btn btn-success mb-0">Create a course</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Profile banner END -->

				<!-- Advanced filter responsive toggler START -->
				<!-- Divider -->
				<hr class="d-xl-none">
				<div class="col-12 col-xl-3 d-flex justify-content-between align-items-center">
					<a class="h6 mb-0 fw-bold d-xl-none" href="#">Menu</a>
					<button class="btn btn-primary d-xl-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasSidebar" aria-controls="offcanvasSidebar">
						<i class="fas fa-sliders-h"></i>
					</button>
				</div>
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
					
				</div>
				<!-- Responsive offcanvas body END -->
			</div>
			<!-- Left sidebar END -->

			<!-- Main content START -->
			<div class="col-xl-9">
				<!-- Edit profile START -->
				<div class="card bg-transparent border rounded-3">
					<!-- Card header -->
					<div class="card-header bg-transparent border-bottom">
						<h3 class="card-header-title mb-0">강의 등록하기</h3>
					</div>
					<!-- Card body START -->
					<div class="card-body">
						<!-- Form -->
						<!-- enctype="multipart/form-data" -->
						<form action="<%=request.getContextPath() %>/lecture/insert.do" method="post" class="row g-4" enctype="multipart/form-data">

							<!-- Profile picture -->
							<div class="col-12 justify-content-center align-items-center">
								<label class="form-label">Profile picture</label>
								<div class="d-flex align-items-center">
									<label class="position-relative me-4" for="uploadfile-1" title="Replace this pic">
										<!-- Avatar place holder -->
										<span class="avatar avatar-xl">
											<img id="uploadfile-1-preview" class="avatar-img rounded-circle border border-white border-3 shadow" src="assets/images/avatar/07.jpg" alt="">
										</span>
										<!-- Remove btn -->
										<button type="button" class="uploadremove"><i class="bi bi-x text-white"></i></button>
									</label>
									<!-- Upload button -->
									<label class="btn btn-primary-soft mb-0" for="uploadfile-1">Change</label>
									<input id="uploadfile-1" class="form-control d-none" type="file">
								</div>
							</div>

							<!-- Full name -->
							<div class="col-12">
								<label class="form-label">제 목 </label>
								<div class="input-group">
									<input type="text" class="form-control" name="lecTitle" placeholder="Title">
								</div>
							</div>

							<!-- Location -->
							<div class="col-md-6">
								<label class="form-label">지 역</label>
								<input class="form-control" type="text" name="lecLoc" placeholder="location">
							</div>
							
							<!-- 정원 -->
							<div class="col-md-6">
								<label class="form-label">정 원</label>
								<input class="form-control" type="text" name="lecMax" placeholder="Capacity">
							</div>
							
							<!-- 난이도 -->
							<div class="col-md-6">
								<label class="form-label">난이도</label>
								<select name = "lecGrade">
								<optgroup label="난이도">
									<option value ="easy">easy</option>
									<option value ="normal">normal</option>
									<option value ="hard">hard</option>
								</optgroup>
							</select>
							</div>
							
							<!-- 카테고리 -->
							<div class="col-md-6">
								<label class="form-label">카테고리</label>
								<select name = "lecCata">
								<optgroup label="카테고리">
									<option value ="c001">운동</option>
									<option value ="c002">음악 </option>
									<option value ="c003">어학 </option>
									<option value ="c004">개발 </option>
									<option value ="c005">게임 </option>
									<option value ="c006">공예 </option>
									<option value ="c007">기타 </option>
								</optgroup>
								</select>
							</div>
							
							<!-- 가격 -->
							<div class="col-md-6">
								<label class="form-label">가 격</label>
								<input class="form-control" type="text" name ="price" placeholder="Price">
							</div>
							
							
							<div class="col-12">
								<label class="form-label">내 용</label>
								<textarea class="form-control" name ="lecCont" rows="20" placeholder="Please enter the content.."></textarea>
								<div class="form-text">Brief description for your profile.</div> 
							</div>
 

							<!-- create button -->
							<div class="d-sm-flex justify-content-end">
								<button type="button" class="btn btn-primary mb-0" onclick="addBtnclicked()">등록하기</button>
							</div>
						</form>
					</div>
					<!-- Card body END -->
				</div>
				<!-- Edit profile END -->
				
				<div class="row g-4 mt-3">
					<!-- Linked account START -->
					<div class="col-lg-6">
						<div class="card bg-transparent border rounded-3">
							<!-- Card header -->
							<div class="card-header bg-transparent border-bottom">
								<h5 class="card-header-title mb-0">Linked account</h5>
							</div>
							<!-- Card body START -->
							<div class="card-body pb-0">
								<!-- Google -->
								<div class="position-relative mb-4 d-sm-flex bg-success bg-opacity-10 border border-success p-3 rounded">
									<!-- Title and content -->
									<h2 class="fs-1 mb-0 me-3"><i class="fab fa-google text-google-icon"></i></h2>
									<div>
										<div class="position-absolute top-0 start-100 translate-middle bg-white rounded-circle lh-1 h-20px">
											<i class="bi bi-check-circle-fill text-success fs-5"></i>
										</div>
											<h6 class="mb-1">Google</h6>
											<p class="mb-1 small">You are successfully connected to your Google account</p>
											<!-- Button -->
											<button type="button" class="btn btn-sm btn-danger mb-0">Invoke</button>
											<a href="#" class="btn btn-sm btn-link text-body mb-0">Learn more</a>
									</div>
								</div>

								<!-- Linkedin -->
								<div class="mb-4 d-sm-flex border p-3 rounded">
									<!-- Title and content -->
									<h2 class="fs-1 mb-0 me-3"><i class="fab fa-linkedin-in text-linkedin"></i></h2>
									<div>
										<h6 class="mb-1">Linkedin</h6>
										<p class="mb-1 small">Connect with Linkedin account for a personalized experience</p>
										<!-- Button -->
										<button type="button" class="btn btn-sm btn-primary mb-0">Connect Linkedin</button>
										<a href="#" class="btn btn-sm btn-link text-body mb-0">Learn more</a>
									</div>
								</div>

								<!-- Facebook -->
								<div class="mb-4 d-sm-flex border p-3 rounded">
									<!-- Title and content -->
									<h2 class="fs-1 mb-0 me-3"><i class="fab fa-facebook text-facebook"></i></h2>
									<div>
										<h6 class="mb-1">Facebook</h6>
										<p class="mb-1 small">Connect with Facebook account for a personalized experience</p>
										<!-- Button -->
										<button type="button" class="btn btn-sm btn-primary mb-0">Connect Facebook</button>
										<a href="#" class="btn btn-sm btn-link text-body mb-0">Learn more</a>
									</div>
								</div>
							</div>
							<!-- Card body END -->
						</div>
					</div>
					<!-- Linked account end -->

					<!-- Social media profile START -->
					<div class="col-lg-6">
						<div class="card bg-transparent border rounded-3">
							<!-- Card header -->
							<div class="card-header bg-transparent border-bottom">
								<h5 class="card-header-title mb-0">Social media profile</h5>
							</div>
							<!-- Card body START -->
							<div class="card-body">
								<!-- Facebook username -->
								<div class="mb-3">
									<label class="form-label"><i class="fab fa-facebook text-facebook me-2"></i>Enter facebook username</label>
									<input class="form-control" type="text" value="loristev" placeholder="Enter username">
								</div>
								
								<!-- Twitter username -->
								<div class="mb-3">
									<label class="form-label"><i class="bi bi-twitter text-twitter me-2"></i>Enter twitter username</label>
									<input class="form-control" type="text" value="loristev" placeholder="Enter username">
								</div>

								<!-- Instagram username -->
								<div class="mb-3">
									<label class="form-label"><i class="fab fa-instagram text-instagram-gradient me-2"></i>Enter instagram username</label>
									<input class="form-control" type="text" value="loristev" placeholder="Enter username">
								</div>

								<!-- Youtube -->
								<div class="mb-3">
									<label class="form-label"><i class="fab fa-youtube text-youtube me-2"></i>Add your youtube profile URL</label>
									<input class="form-control" type="text" value="https://www.youtube.com/in/Eduport-05620abc" placeholder="Enter username">
								</div>

								<!-- Button -->
								<div class="d-flex justify-content-end mt-4">
									<button type="button" class="btn btn-primary mb-0">Save changes</button>
								</div>
							</div>
							<!-- Card body END -->
						</div>
					</div>
					<!-- Social media profile END -->

					<!-- EMail change START -->
				</div>
			</div>
			<!-- Main content END -->
		</div><!-- Row END -->
	</div>
</section>
<!-- =======================
Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->
<script>
function addBtnclicked(){
	document.addForm.submit();
}
</script>
</body>
</html>