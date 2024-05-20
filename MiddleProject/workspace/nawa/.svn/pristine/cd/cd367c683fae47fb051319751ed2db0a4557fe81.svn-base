<%@page import="lecture.vo.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<%
	//대부분은 내장객체로 생성된상태(ex. request 등)
	//System.out.println(request.getAttribute("memList"));
	List<LectureVO> lecList = (List<LectureVO>)request.getAttribute("pageList");	
	String msg = session.getAttribute("msg") == null ? "" 
			:(String) session.getAttribute("msg");
	
	session.removeAttribute("msg");
	System.out.println(">>>>>" + lecList.size());
	
%>
<%@include file="/include/header.jsp"%>
<!-- **************** MAIN CONTENT START **************** -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<main>

	<!-- =======================
Page Banner START -->
	<section class="bg-dark align-items-center d-flex"
		style="background: url(assets/images/pattern/04.png) no-repeat center center; background-size: cover;">
		<!-- Main banner background image -->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Title -->
					<h1 class="text-white">
					<a href="<%=request.getContextPath() %>/lecture/list.do" style="color: white">레슨</a>
					</h1>
					<!-- Breadcrumb -->
					<div class="d-flex">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb breadcrumb-dark breadcrumb-dots mb-0">
								<li class="breadcrumb-item"><a href="<%=request.getContextPath() %>/index.jsp">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Courses</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- =======================
Page Banner END -->

	<!-- =======================
Page content START -->
	<section class="pt-5">
		<div class="container" style="position: relative;">
			<!-- Search option START -->
			<form action="<%=request.getContextPath() %>/lecture/lecSearch" method="post">
			<div class="row mb-4 align-items-center">
				<!-- Search bar -->
				<div class="col-sm-6 col-xl-4">
						<div class="input-group input-borderless border rounded p-2">
							<input class="form-control me-1" name="search" type="search"
								placeholder="Search course">
						</div>
				</div>

				<!-- Select option -->
				<div class="col-sm-6 col-xl-3 mt-3 mt-lg-0">
						<select class="form-select form-select-sm js-choice"
							aria-label=".form-select-sm" name="lcate_no">
							<option value="">카테고리</option>
							<option value="">All</option>
							<option value="c001">운동</option>
							<option value="c002">음악</option>
							<option value="c003">어학</option>
							<option value="c004">개발</option>
							<option value="c005">게임</option>
							<option value="c006">공예</option>
							<option value="c007">기타</option>
						</select>
				</div>

				<!-- Select option -->
				<div class="col-sm-6 col-xl-3 mt-3 mt-xl-0">
						<select class="form-select form-select-sm js-choice"
							aria-label=".form-select-sm" name="lcate_no2">
							<option value="">정렬</option>
							<option value="1">평점순</option>
							<option value="2">낮은 가격순</option>
						</select>
				</div>

				<!-- Button -->
				<div class="col-sm-6 col-xl-2 mt-3 mt-xl-0 d-grid">
					<button type="submit"
							class="btn btn-primary mb-0 rounded z-index-1 w-100">
							검색 <i class="fas fa-search"></i>
						</button>
				</div>
			</div>
			</form>
			<!-- Search option END -->
			<!-- 소모임 카드 형태 시작---------------------------------------------------------  -->

			<%
    for (int i = 0; i < lecList.size(); i++) {
        LectureVO lv = lecList.get(i);
        // 홀수 번째 카드일 때, 새로운 행 시작
        if (i % 2 == 0) {
%>
			<div class="row">
				<%
        }
%>

				<!-- 카드 항목 시작 -->
				<div class="col-lg-10 col-xxl-6">
					<div class="card rounded overflow-hidden shadow">
						<div class="row g-0">
							<%--   <!-- 이미지 -->
                     <div class="col-md-4">
                        <img src="<%= lv.getImageUrl() %>" alt="카드 이미지">
                    </div>   --%>

							<!-- 카드 본문 -->
							<div class="col-md-8">
								<div class="card-body">
									<!-- 제목 -->
									<div class="d-flex justify-content-between mb-2">
										<h5 class="card-title mb-0">
											<a href="./detail.do?lecNo=<%=lv.getLecNo() %>&tutNo=<%=lv.getTutNo()%>"><%=lv.getLecTitle() %></a>
										</h5>
										<!-- 위시리스트 아이콘 -->
										 <a class="heartBtn" onclick="toggleHeart(this)">
    <span class="heart-icon" data-is-heart="false">
        <!-- 빈 하트 아이콘 -->
        <span class="empty-heart"><a href="<%=request.getContextPath() %>/lecture/heart.do?lecNo=<%=lv.getLecNo() %>&tutNo=<%=lv.getTutNo()%>">&#x2661;</a></span>
        <!-- 채워진 하트 아이콘 -->
        <span class="filled-heart" style="display:none;">&#x2665;</span>
    </span>
</a>
									</div>
									<!-- 콘텐츠 -->
									<!-- 정보 -->
									<ul class="list-inline mb-1">
										<li class="list-inline-item h6 fw-light mb-1 mb-sm-0"><i
											class="bi bi-people fs-4"></i> <%= lv.getLecCnt() %> / <%= lv.getLecMax() %>
											<%-- <i class="far fa-clock text-danger me-2"></i><%= lv.getLecCnt() %> / <%= lv.getLecMax() %> --%>
										</li>
										<li class="list-inline-item h6 fw-light mb-1 mb-sm-0"><i
											class="bi bi-cash-coin"> </i>&#8361;<%= lv.getPrice() %></li>
										<li class="list-inline-item h6 fw-light"><i
											class="bi bi-dice-6"> </i><%= lv.getLecGrade() %></li>
									</ul>
									<!-- 평점 -->
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
											class="fas fa-star-half-alt text-warning"></i></li>
										<li class="list-inline-item ms-2 h6 fw-light"><%= lv.getLecScore() %></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 카드 항목 끝 -->
				<%
        // 짝수 번째 카드일 때, 행 닫기
        if (i % 2 != 0 || i == lecList.size() - 1) {
%>
			</div>
			<%
        }
    }
%>
		</div>

		</div>
	</section>

	<section>
		<!-- 페이징 처리된 페이지 목록 시작 -->
		<div id="pagination" class="container">
			<%
    Integer currentPageObj = (Integer) request.getAttribute("currentPage");
    Integer totalPagesObj = (Integer) request.getAttribute("totalPages");

    int currentPage = (currentPageObj != null) ? currentPageObj : 1;
    int totalPages = (totalPagesObj != null) ? totalPagesObj : 1;

    int maxPagesToShow = 5; // 보여줄 최대 페이지 수

    int startPage = Math.max(1, currentPage - maxPagesToShow / 2);
    int endPage = Math.min(startPage + maxPagesToShow - 1, totalPages);
    
    System.out.println("start.end" + startPage + " . " + endPage);
    %>


			<!-- 목록 버튼	 -->
			<button type="button" class="btn btn-dark" style="float: left;"
				onclick="location.href='./list.do'">처음으로</button>
			<button type="button" class="btn btn-dark" id="writeButton"
				style="float: right;" onclick="location.href='./insert.do'">글쓰기</button>


			<!-- '이전' 버튼 -->
			<div class="container text-center col-sm-12">
				<ul class="pagination justify-content-center">
					<%
		if(currentPage > 1) {
	%>
					<li class="page-item"><a
						href="./list.do?page=<%= currentPage - 1 %>" class="page-link">이전</a>
					</li>
					<%
		}else{
	%>
					<%
		}
	%>

					<!-- 페이지 목록 -->
					<%
	if (startPage > 1) {
	%>
					<li class="page-item"><a href="./list.do?page=1"
						class="page-link">1</a></li>
					<li class="page-item"><span class="ellipsis">...</span></li>
					<%
	}

	for (int i = startPage; i <= endPage; i++) {
		if (i == currentPage) {
	%>
					<li class="page-item active"><a class="page-link" href="#">
							<span class="current-page"> <%= i %>
						</span>
					</a></li>
					<%
		} else {
	%>
					<li class="page-item"><a href="./list.do?page=<%= i %>"
						class="page-link"><%= i %></a></li>
					<%
		}
	}

	if (endPage < totalPages) {
	%>
					<li class="page-item"><span class="ellipsis">...</span></li>
					<li class="page-item"><a
						href="./list.do?page=<%= totalPages %>" class="page-link"> <%= totalPages %></a>
					</li>
					<%
	}
	%>
					<!-- 페이지 목록 끝 -->


					<!-- '다음' 버튼 -->
					<%
		if(currentPage < totalPages) {
		%>
					<li class="page-item"><a
						href="./list.do?page=<%= currentPage + 1 %>" class="page-link">다음</a>
					</li>
					<%
		}else{
		%>

					<%
		}
		%>
					<!-- '다음' 버튼 끝 -->
				</ul>
			</div>

		</div>
		<!-- 페이징 처리된 페이지 목록 끝 -->
	</section>
</main>

<script>
function toggleHeart(heartBtn) {
    let heartIcon = heartBtn.querySelector(".heart-icon");
    let isHeart = heartIcon.dataset.isHeart === "true";
    // 상태 변경
    isHeart = !isHeart;

    // 아이콘 및 색상 변경
    updateHeartStatus(heartIcon, isHeart);

    // 상태 업데이트
    heartIcon.dataset.isHeart = isHeart.toString();

    // 로그 출력
    if (isHeart) {
        console.log("하트를 눌렀습니다.");
    } else {
        console.log("하트를 취소했습니다.");
    }
    
    
    
}

function toggleHeart(heartBtn) {
    let heartIcon = heartBtn.querySelector(".heart-icon");
    let isHeart = heartIcon.dataset.isHeart === "true";

    // 상태 변경
    isHeart = !isHeart;

    // 아이콘 및 색상 변경
    updateHeartStatus(heartIcon, isHeart);

    // 상태 업데이트
    heartIcon.dataset.isHeart = isHeart.toString();

    // 로그 출력
    if (isHeart) {
        console.log("하트를 눌렀습니다.");
    } else {
        console.log("하트를 취소했습니다.");
    }
}

function updateHeartStatus(heartIcon, isHeart) {
    // 클래스를 토글하여 하트 아이콘의 색상을 변경
    heartIcon.classList.toggle("red-heart", isHeart);

    // 채워진 하트와 빈 하트를 토글하여 표시 여부를 변경
    let filledHeart = heartIcon.querySelector(".filled-heart");
    let emptyHeart = heartIcon.querySelector(".empty-heart");

    if (isHeart) {
        filledHeart.style.display = "inline";
        emptyHeart.style.display = "none";
    } else {
        filledHeart.style.display = "none";
        emptyHeart.style.display = "inline";
    }
}
</script>

<%@include file="/include/footer.jsp"%>
</body>
</html>