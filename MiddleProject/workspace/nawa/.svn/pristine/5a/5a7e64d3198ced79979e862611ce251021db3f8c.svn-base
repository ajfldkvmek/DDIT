<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="meet.vo.MeetVO"%>
<%@include file="../include/header.jsp"%>

<%
	//대부분은 내장객체로 생성된상태(ex. request 등)
//System.out.println(request.getAttribute("memList"));
List<MeetVO> meetList = (List<MeetVO>) request.getAttribute("meetList");

String msg = session.getAttribute("msg") == null ? "" : (String) session.getAttribute("msg");

session.removeAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임목록</title>
</head>

<!-- HTML에 다음 스크립트를 추가하세요 -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


<body>
	<!-- =======================Page Banner START -->
	<section class="py-4">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="bg-light p-4 text-center rounded-3">
						<h1 class="m-0">소모임 찾아보기</h1>
						<!-- Breadcrumb -->
						<div class="d-flex justify-content-center">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb breadcrumb-dots mb-0">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Course
										minimal</li>
								</ol>
							</nav>
						</div>
					</div>
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

			<!-- Filter bar START -->
			<form action="./meetSearch" method="post"
				class="bg-light border p-4 rounded-3 my-4 z-index-9 position-relative">
				<div class="row g-3">
					<!-- Input -->
					<div class="col-xl-3">
						<input class="form-control me-1" type="search" name="search"
							placeholder="모임명/모임장소">
					</div>

					<!-- Select item -->
					<div class="col-xl-8">
						<div class="row g-3">
							<!-- Select items -->
							<div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice"
									aria-label=".form-select-sm example" name="mcate_no">
									<option value="">Categories</option>
									<option value="c001">스포츠(운동)</option>
									<option value="c002">음악</option>
									<option value="c003">어학</option>
									<option value="c004">개발</option>
									<option value="c005">게임</option>
									<option value="c006">공예</option>
									<option value="c007">기타</option>

								</select>
							</div>

							<!-- Search item -->
							<div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice"
									name="meet_level" aria-label=".form-select-sm example">
									<option value="">난이도</option>
									<option value="1">초급</option>
									<option value="2">중급</option>
									<option value="3">고급</option>
								</select>
							</div>

							<!-- Search item -->

							<div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice"
									name="lcate_no" id="lcate_no"
									aria-label=".form-select-sm example">
									<option value="">구역</option>
									<option value="s001">서구</option>
									<option value="j001">중구</option>
									<option value="ys001">유성구</option>
									<option value="d001">동구</option>
									<option value="dd001">대덕구</option>
								</select>
							</div>

							<!-- Search 동 -->
							<div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice"
									name="local_com" id="local_com"
									aria-label=".form-select-sm example">
									<option value="local_com">동</option>
								</select>
							</div>
							<!-- <div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice" name="lcate_no"
									aria-label=".form-select-sm example">
									<option value="">구역</option>
									<option value="">대전 전체</option>
									<option value="s001">서구</option>
									<option value="j001">중구</option>
									<option value="ys001">유성구</option>
									<option value="d001">동구</option>
									<option value="dd001">대덕구</option>
								</select>
							</div>

							Search  동
							<div class="col-sm-6 col-md-3 pb-2 pb-md-0">
								<select class="form-select form-select-sm js-choice" name="meetLocDetail"
									aria-label=".form-select-sm example">
									<option value="">동</option>
									<option>구 전체</option>
									<option>둔산동</option>
									<option>갈마동</option>
									<option data-region="s001">둔산동</option>
        							<option data-region="s001">갈마동</option>
        							<option data-region="j001">동1</option>
        							<option data-region="j001">동2</option>
						
								</select>
							</div> -->
						</div>
						<!-- Row END -->
					</div>
					<!-- Button -->
					<div class="col-xl-1">
						<button type="submit"
							class="btn btn-primary mb-0 rounded z-index-1 w-100">
							검색 <i class="fas fa-search"></i>
						</button>

						<!-- <button type="button"
							onclick = "location.href='./meetlist'"
							class="btn btn-primary mb-0 rounded z-index-1 w-100">검색
							<i class="fas fa-search"></i>
						</button> -->
					</div>
				</div>
				<!-- Row END -->
			</form>
			<!-- Filter bar END -->
			<!-- 소모임 카드 형태 시작---------------------------------------------------------  -->
			<div class="row mt-3">
				<!-- Main content START -->
				<div class="col-12">

					<!-- Course Grid START -->
					<div class="row g-4">

						<%
							for (MeetVO mv : meetList) {
						%>

						<!-- Card item START -->
						<div class="col-sm-6 col-lg-4 col-xl-3">
							<div class="card shadow h-100">
								<!-- Image -->
								<img src="assets/images/courses/4by3/08.jpg"
									class="card-img-top" alt="course image">
								<!-- Card body -->
								<div class="card-body pb-0">
									<!-- Badge and favorite -->
									<div class="d-flex justify-content-between mb-2">
										<%
											String meetLevel = mv.getMeet_level();
										String badgeClass = "";
										String badgeText = "";

										if (meetLevel.equals("1")) {
											badgeClass = "badge bg-success bg-opacity-10 text-success";
											badgeText = "초급";
										} else if (meetLevel.equals("2")) {
											badgeClass = "badge bg-info bg-opacity-10 text-info";
											badgeText = "중급";
										} else if (meetLevel.equals("3")) {
											badgeClass = "badge bg-warning bg-opacity-10 text-warning";
											badgeText = "고급";
										} else {
											badgeClass = "badge bg-secondary bg-opacity-10 text-secondary";
											badgeText = "기타";
										}
										%>
										<a href="#" class="badge bg-purple bg-opacity-10 text-purple"><%=badgeText%></a>
										<a href="#" class="h6 fw-light mb-0"><i
											class="far fa-heart"></i></a>
									</div>
									<!-- Title -->
									<h5 class="card-title">
										<a href="./meetDetail?meetNo=<%=mv.getMeet_no()%>"><%=mv.getMeet_name()%></a>
									</h5>
									<!-- Rating star -->
									<ul class="list-inline mb-0">
										<li class="list-inline-item me-0 small"><i
											class="fas fa-star text-warning"></i></li>
										<li class="list-inline-item me-0 small"><i
											class="fas fa-star text-warning"></i></li>
										<li class="list-inline-item me-0 small"><i
											class="fas fa-star text-warning"></i></li>
										<li class="list-inline-item me-0 small"><i
											class="fas fa-star text-warning"></i></li>
										<li class="list-inline-item me-0 small"><i
											class="far fa-star text-warning"></i></li>
										<li class="list-inline-item ms-2 h6 fw-light mb-0"><%=mv.getMeet_score()%>.0/5.0</li>
									</ul>
								</div>
								<!-- Card footer -->
								<div class="card-footer pt-0 pb-3">
									<hr>
									<div class="d-flex justify-content-between">
										<span class="h6 fw-light mb-0"><i
											class="bi bi-person text-danger me-2 "></i><%=mv.getMem_id()%></span>
										<span class="h6 fw-light mb-0"><i
											class="fas fa-table text-orange me-2"></i><%=mv.getMeet_loc()%></span>
									</div>
								</div>
							</div>
						</div>
						<!-- Card item END -->
						<%
							}
						%>
					</div>

				</div>
	</section>
	<!-- =======================
Page content END -->


	<!-- 여기서부터 목록 나오는 내가한부분-->

	<%-- 	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%
			if (meetList.size() == 0) {
		%>
		<tr>
			<td colspan="5">회원 정보가 존재하지 않습니다.</td>
		</tr>
		<%
			} else {
		for (MeetVO mv : meetList) {
		%>
		<tr>
			<td><a href="./meetDetail?meetNo=<%=mv.getMeet_no()%>"><%=mv.getMeet_no()%></td>
			<td><%=mv.getMeet_name()%></td>
		</tr>
		<%
			}
		}
		%>  --%>
	<!-- Pagination START -->
	<div class="col-12">
		<nav class="mt-4 d-flex justify-content-center"
			aria-label="navigation">
			<ul
				class="pagination pagination-primary-soft d-inline-block d-md-flex rounded mb-0">
				<li class="page-item mb-0"><a class="page-link" href="#"
					tabindex="-1"><i class="fas fa-angle-double-left"></i></a></li>
				<li class="page-item mb-0"><a class="page-link" href="#">1</a></li>
				<li class="page-item mb-0 active"><a class="page-link" href="#">2</a></li>
				<li class="page-item mb-0"><a class="page-link" href="#">..</a></li>
				<li class="page-item mb-0"><a class="page-link" href="#">6</a></li>
				<li class="page-item mb-0"><a class="page-link" href="#"><i
						class="fas fa-angle-double-right"></i></a></li>


				<!-- 글 작성 버튼 추가 -->
				<li class="page-item mb-0">
					<!-- <a class="page-link" href="#" onclick="goToInsertMeet()">글 작성</a> -->
					<button type="button" onClick="location.href='./meetInsert'"
						class="page-link">글작성하기</button>

				</li>

			</ul>
		</nav>
	</div>
	<!-- Pagination END -->


	<!-- </table> -->
	<!-- <button type="button" onClick="location.href='./meetInsert'">글작성</button> -->


	<!-- <script>
	
	function goToInsertMeet() {

        window.location.href = '../meet/insertMeet'; 
    }
	
	</script>
	
	 -->


	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		// 각 구역에 대한 동의 목록 정의
		var regions = {
			's001' : ['복수동', '도마동', '도안동', '정림동', '변동', '용문동', '탄방동', '둔산동', '관저동', '괴정동', '가장동', '내동', '갈마동', '월평동', '만년동', '가수원동', '기성동'],
			'j001' : [ '목동', '중촌동', '대흥동', '문창동', '석교동', '옥계동', '호동', '대사동', '부사동', '용두동', '오류동', '태평동', '유천동', '문화동', '산성동', '사정동', '안영동', '구완동', '무수동' ],
			'ys001' : ['성북동', '세동', '송정동', '원내동', '방동', '교촌동', '대정동', '용계동', '학하동', '계산동', '덕명동', '구암동', '원신흥동', '봉명동', '상대동', '복용동', '장대동', '죽동', '노은동', '궁동', '어은동', '구성동', '갑동', '장대동', '노은동', '지족동', '죽동'],
			'd001' : [ '중앙동', '원동', '정동', '중동', '소제동', '신안동', '신인동', '인동', '신흥동', '효동', '천동', '가오동', '판암동', '삼정동', '용운동', '대동', '자양동', '가양동', '용전동', '성남동', '홍도동', '삼성동', '대청동', '추동', '효평동', '직동', '비룡동', '주산동', '용계동', '마산동', '세천동', '신상동', '신하동', '신촌동', '사성동', '내탑동', '오동', '주촌동', '산내동', '낭월동', '대별동', '이사동', '대성동' ],
			'dd001' : [ '회덕동', '읍내동', '연축동', '신대동', '와동', '장동', '대화동', '오정동', '비래동', '송촌동', '중리동', '법동', '신탄진동', '삼정동', '용호동', '이현동', '갈전동', '부수동', '황호동', '미호동', '석봉동', '덕암동', '상서동', '평촌동', '목상동', '문평동', '신일동' ]
		};

		$(document).ready(function() {
			// 두 번째 드롭다운의 초기 옵션을 저장합니다.
			var originalOptions = $('#local_com').html();

			// 첫 번째 드롭다운이 변경될 때
			$('#lcate_no').change(function() {
				// 선택한 옵션 값을 가져옵니다.
				var selectedValue = $(this).val();

				// 값이 선택된 경우
				if (selectedValue !== '') {
					// 선택한 값에 따라 두 번째 드롭다운의 옵션을 업데이트합니다.
					updateSecondDropdown(selectedValue);
				} else {
					// 선택한 값이 없으면 두 번째 드롭다운을 초기 상태로 되돌립니다.
					$('#local_com').html(originalOptions);
				}
			});
		});

		// 두 번째 드롭다운을 업데이트하는 함수
		function updateSecondDropdown(selectedValue) {
			alert(selectedValue)
			// 선택한 값에 해당하는 동 목록을 가져옵니다.
			var regionOptions = regions[selectedValue];

			// 두 번째 드롭다운의 옵션을 초기화합니다.
			$('#local_com').html('<option value="">동</option>');

			// 동적으로 가져온 동 목록을 두 번째 드롭다운에 추가합니다.
			for (var i = 0; i < regionOptions.length; i++) {
				$('#local_com').append(
						'<option>' + regionOptions[i] + '</option>');
			}
		}
	</script>


	<%@include file="../include/footer.jsp"%>
</body>
</html>