<%@page import="meet.controller.meetList"%>
<%@page import="meet.vo.MbVO"%>
<%@page import="meet.vo.MeetVO"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("LOGIN_USER") == null) {
%>
<script>
	alert("로그인이 필요합니다");
	location.href = "<%=request.getContextPath() %>/index.jsp";
</script>
<%
	}
%>

<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<%@include file="../include/loginheader.jsp"%>


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
							<!-- Advanced filter responsive toggler START -->
				<!-- Divider -->
				<hr class="d-xl-none">
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
						<h3 class="card-header-title mb-0">정보 수정</h3>
					</div>
					
					<!-- Card body START -->
					<div class="card-body">
						<!-- Form -->
						<form class="row g-4" action="<%=request.getContextPath() %>/member/editProfile.do" method="post">

							<!-- Profile picture -->
							<div class="col-12 justify-content-center align-items-center">
								<label class="form-label">프로필 사진</label>
								<div class="d-flex align-items-center">
									<label class="position-relative me-4" for="uploadfile-1" title="Replace this pic">
										<!-- Avatar place holder -->
										<span class="avatar avatar-xl">
										<!-- 기존프로필파일 -->
											<img id="uploadfile-1-preview" class="avatar-img rounded-circle border border-white border-3 shadow" src="../assets/images/avatar/07.jpg" alt="">
										</span>
										<!-- Remove btn -->
										<button type="button" class="uploadremove"><i class="bi bi-x text-white"></i></button>
									</label>
									<!-- Upload button -->
									<label class="btn btn-primary-soft mb-0" for="uploadfile-1">Change</label>
									<input id="uploadfile-1" class="form-control d-none" type="file" name="atchFile">
								</div>
							</div>

					
							<!-- Username -->
							<div class="col-md-6">
								<label class="form-label">닉네임</label>
								<div class="input-group">
									<input type="text" class="form-control" placeholder="john doe" name="mem_nick">
								</div>
							</div>

							<!-- Email id -->
							<div class="col-md-6">
								<label class="form-label">Email</label>
								<input class="form-control" type="email" placeholder="Email" name="mem_email">
							</div>

							<!-- Phone number -->
							<div class="col-md-6">
								<label class="form-label">전화 번호</label>
								<input type="text" class="form-control" name="mem_telno" placeholder="'-'를 빼고 입력하세요"
												pattern="[0][1][0-1]{1}[0-9]{3,4}[0-9]{4}">
							</div>

							<!-- Location -->
							<div class="col-md-6">
								<label class="form-label">지역</label>
								<input class="form-control" type="text" placeholder="xx구 xx동 형태로 입력" name="add">
							</div>
							
							<div class="col-md-6">
								<label class="form-label">새 비밀번호</label>
								<input class="form-control" type="password" placeholder="변경할 번호 입력" name="new_pw"
								pattern="(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#_&amp;\+\|]).{10,}"
								>
							</div>
							
							<div class="col-md-6">
								<label class="form-label">현재 비밀번호</label>
								<input class="form-control" type="password" placeholder="현재 비밀번호 입력" name="old_pw"
								required>
							</div>
												
							<!-- Save button -->
							<div class="d-sm-flex justify-content-end">
								<button type="submit" class="btn btn-primary mb-0">회원정보 수정</button>
							</div>
						</form>
					</div>
					<!-- Card body END -->
				</div>
				<!-- Edit profile END -->
				

			</div>
			<!-- Main content END -->
		</div><!-- Row END -->
	</div>
</section>
<!-- =======================
Page content END -->

</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- =======================
Footer START -->

<!-- =======================
Footer END -->

<!-- Back to top -->
<div class="back-top"><i class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i></div>

<!-- Bootstrap JS -->
<script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Functions -->
<script src="../assets/js/functions.js"></script>

<%@include file="../include/footer.jsp"%>
</body>
</html>