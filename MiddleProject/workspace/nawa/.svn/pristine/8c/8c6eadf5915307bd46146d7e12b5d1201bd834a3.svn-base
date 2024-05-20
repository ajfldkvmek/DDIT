<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>

<title>Eduport - LMS, Education and Course Theme</title>

<!-- Meta Tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Webestica.com">
<meta name="description"
	content="Eduport- LMS, Education and Course Theme">

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Google Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;700&family=Roboto:wght@400;500;700&display=swap">

<!-- Plugins CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/font-awesome/css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/bootstrap-icons/bootstrap-icons.css">

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css">

<script src="https://www.google.com/recaptcha/api.js" async defer></script>

</head>

<body>

	<!-- **************** MAIN CONTENT START **************** -->
	<main>
		<section
			class="p-0 d-flex align-items-center position-relative overflow-hidden">

			<div class="container-fluid">
				<div class="row">
					<!-- left -->
					<div
						class="col-12 col-lg-6 d-md-flex align-items-center justify-content-center bg-primary bg-opacity-10">
						<!-- 						class="col-12 col-lg-6 d-md-flex align-items-center justify-content-center bg-primary bg-opacity-10 vh-lg-100" style="height: 100%;"> -->
						<div class="p-3 p-lg-5">
							<!-- Title -->
							<div class="text-center">
								<h2 class="fw-bold">잘왔다 우리 커뮤니티에</h2>
								<p class="mb-0 h6 fw-light">함께 놀아보자!</p>
							</div>
						</div>
					</div>

					<!-- Right -->
					<div class="col-12 col-lg-6 m-auto">
						<div class="row my-5">
							<div class="col-sm-10 col-xl-8 m-auto">
								<!-- Title -->
								<img src="assets/images/element/03.svg" class="h-40px mb-2"
									alt="">

								<!-- Form START -->
								<form id="frm" action="<%=request.getContextPath()%>/signUp.do" method="post">
									<!-- <form id="frm"> -->
									<!-- ID 아이디-->
									<div class="mb-4">
										<label class="form-label">ID *</label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="bi "></i></span> <input type="text" id="id"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="ID" name="mem_id" required
												pattern="[a-zA-Z][a-zA-Z0-9]{3,7}">
										</div>
									</div>
									<div class="col-sm-6" style="text-align: left;">
										<span id="disp"></span>
									</div>
									<!-- Password -->
									<div class="mb-4">
										<label for="inputPassword5" class="form-label">Password
											*</label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="fas "></i></span> <input type="password"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="*********" name="mem_pass" required
												pattern="(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#_&amp;\+\|]).{10,}">
										</div>
									</div>

									<!-- 생년월일 -->
									<div class="mb-4">
										<label for="inputPassword6" class="form-label">생년월일 *</label>
										<div class="input-group input-group-lg">
											<input type="date" class="form-control" id="bir"
												name="mem_bir">
										</div>
									</div>

									<div class="mb-4">
										<label class="form-label">이름 *</label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="bi "></i></span> <input type="text" id="nick"
												name="mem_name"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="이름" required pattern="{2,8}">
										</div>
									</div>

									<div class="mb-4">
										<label class="form-label">별명 </label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="bi "></i></span> <input type="text" id="nick"
												name="nickNam"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="미 입력시 john doe로 고정">
										</div>
									</div>

									<div class="mb-4">
										<label class="form-label">전화번호 *</label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="bi "></i></span> <input type="text" id="phone" name="phone"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="'-'를 빼고 입력하세요" required
												pattern="[0][1][0-1]{1}[0-9]{3,4}[0-9]{4}">
										</div>
									</div>

									<!-- email -->
									<div class="mb-4">
										<label for="exampleInputEmail1" class="form-label">Email
											*</label>
										<div class="input-group input-group-lg">
											<span
												class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i
												class="bi "></i></span> <input type="email"
												class="form-control border-0 bg-light rounded-end ps-1"
												placeholder="Email" id="exampleInputEmail1" name="mem_mail"
												pattern="[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-z]+){1,2}">
										</div>
									</div>

									<!-- 주소 -->
									<div style='display: none' class="form-group">
										<label for="postno" class="control-label col-sm-2">우편번호<span
											class="rq"> *</span></label>
										<div class="col-sm-4">
											<input div style='display: none' type="text"
												class="form-control" id="postAddr" name="mem_zip">
										</div>
									</div>

									<div class="mb-4">
										<label class="form-label">주소 1 *</label>
										<div class="input-group input-group-lg">
											<input type="text" class="form-control"
												class="form-control border-0 bg-light rounded-end ps-1"
												id="addr1" name="mem_add1" required>
										</div>
									</div>

									<div class="mb-4">
										<label class="form-label">주소 2 </label>
										<div class="input-group input-group-lg">
											<input type="text" class="form-control"
												class="form-control border-0 bg-light rounded-end ps-1"
												id="addr2" name="mem_add2">
										</div>
									</div>
									<div class="mb-4">
										<div class="col-sm-2">
											<button type="button" id="addrBtn"
												class="btn btn-info btn-sm">주소검색</button>
										</div>
									</div>
									<!-- Check box -->
									<div class="mb-4">
										<div class="form-check">
											<input type="checkbox" class="form-check-input"
												id="checkbox-1"> <label class="form-check-label"
												for="checkbox-1">정보제공에 동의합니다</label>
										</div>
									</div>

									<div class="align-items-center mt-0">
										<div class="d-grid">
											<!-- <button class="btn btn-primary mb-0"  -->
											<button class="btn btn-primary mb-0" onclick='singUp()'>Sign
												Up</button>
										</div>
									</div>
							</div>

							</form>


							<!-- Social buttons -->
							<div class="row">
								<!-- Divider with text -->
								<div class="position-relative my-4">
									<hr>
									<p
										class="small position-absolute top-50 start-50 translate-middle bg-body px-5">Or</p>
								</div>
								<!-- Social btn -->
								<div class="col-xxl-6 d-grid">
									<a href="#" class="btn bg-google mb-2 mb-xxl-0"><i
										class="fab fa-fw fa-google text-white me-2"></i>Signup with
										Google</a>
								</div>
								<!-- Social btn -->
								<div class="col-xxl-6 d-grid">
									<a href="#" class="btn bg-facebook mb-0"><i
										class="fab fa-fw fa-facebook-f me-2"></i>Signup with Facebook</a>
								</div>
							</div>

							<!-- Sign up link -->
							<div class="mt-4 text-center">
								<span>Already have an account?<a href="sign-in.html">
										Sign in here</a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
		</section>
	</main>
	<!-- **************** MAIN CONTENT END **************** -->

	<!-- Back to top -->
	<div class="back-top">
		<i
			class="bi bi-arrow-up-short position-absolute top-50 start-50 translate-middle"></i>
	</div>


	<form action="captcha.do" method="post">
		<button class="g-recaptcha"
			data-sitekey="6LcjWFIpAAAAAOeiSZ-EriNEV_9mbRzZ731xKP1P"
			data-callback="onSubmit" data-action="submit">Submit</button>
	</form>



	<script src="https://www.google.com/recaptcha/api.js"></script>

	<script>
		function onSubmit(token) {
			document.getElementById("demo-form").submit();
		}
	</script>



	<!-- Bootstrap JS -->
	<script src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Template Functions -->
	<script src="assets/js/functions.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


	<script>
		//id 중복체크
		//$("#idChk").on('click', function() {});
		$('#id').on('keyup', function() {

			$.ajax({
				//type: '', 제이쿼리에서는 생략가능
				url : 'idChk.jsp',
				data : {
					id : $("#id").val()
				}, //제이쿼리에서는 객체형태도 key=value형태로 자동변환되어 넘어감
				success : function(data) {
					console.log(data);
					if (data.rst == "ok") {
						$('#disp').text(data.msg).css('color', 'green');
					} else {
						$('#disp').text(data.msg).css('color', 'red');
					}
				},
				error : function(xhr) {
					alert(xhr.status);
				},
				dataType : 'json' //생략시 넘어오는 응답 정보 타입을 자동으로 맞춰줌
			});
		});

		//주소검색 api
		$("#addrBtn").on('click', function() {

			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					// document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("addr1").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("addr2").focus();
				}
			}).open();

		});

		function singUp() {
			//checkbox-1
			const checkbox = document.getElementById('checkbox-1');
			if (!checkbox.checked) {
				event.preventDefault();
				alert("정보제공동의바람");
			}

		}
	</script>

</body>
</html>