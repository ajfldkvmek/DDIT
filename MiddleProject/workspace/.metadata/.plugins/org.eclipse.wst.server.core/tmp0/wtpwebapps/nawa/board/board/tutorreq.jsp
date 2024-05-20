<%@page import="member.service.MemberServiceImpl"%>
<%@page import="board.vo.PostVO"%>
<%@page import="java.util.List"%>
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

<%
	List<PostVO> tutuorReqList = (List<PostVO>)request.getAttribute("tutuorReqList");
	List<MemberVO> tutorDetail = (List<MemberVO>)request.getAttribute("tutorDetail");

	String msg = session.getAttribute("msg") == null ? ""
	: (String) session.getAttribute("msg");
	session.removeAttribute("msg");

%>


<%@include file="/include/loginheader.jsp"%>


<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- Page content START -->
<div class="page-content">
	
	<!-- Page main content START -->
	<div class="page-content-wrapper border">

		<!-- Title -->
		<div class="row mb-3">
			<div class="col-12">
				<h1 class="h3 mb-2 mb-sm-0">튜터 신청 Tutor Requests</h1>
			</div>
		</div>

		<!-- Main card START -->
		<div class="card bg-transparent border">
			<!-- Card body START -->
			<div class="card-body">
				<!-- Instructor request table START -->
				<div class="table-responsive border-0">
					<table class="table table-dark-gray align-middle p-4 mb-0 table-hover">

						<!-- Table head -->
						<thead class="table table-dark">
							<tr>
								<th scope="col" class="border-0 rounded-start">Tutor name</th>
								<th scope="col" class="border-0">Subject</th>
								<th scope="col" class="border-0">Requested Date</th>
								<th scope="col" class="border-0 rounded-end">Action</th>
							</tr>
						</thead>

						<!-- Table body START -->
						<tbody>
							<!-- Table row -->
						<%

					if(tutuorReqList == null || tutuorReqList.size() == 0 ) {
				%>
				<tr>
					<td colspan="6">신청자가 없습니다.</td>

				</tr>
				<%
					}else{
							for(PostVO pv : tutuorReqList) {
				%>
				<tr>
		 			
					<td id="postWriter"><%=pv.getPostWriter() %></td>
		 			<td id="postTitle">
<%-- 		 				<a class="listTitle" style="text-decoration:none" href="./detail.do?postNo=<%=pv.getPostNo() %>"  --%>
<!-- 		 					data-bs-toggle="tooltip" > -->
		 					<%=pv.getPostTitle() %>
<!-- 		 					</a> -->
		 			</td>
					<td id="postDate"><%=pv.getPostDate() %></td>
					<td>
									<a href="#" class="btn btn-success-soft me-1 mb-1 mb-lg-0">Accept</a>
									<a href="#" class="btn btn-secondary-soft me-1 mb-1 mb-lg-0">Reject</a>
									<a href="#" class="btn btn-primary-soft me-1 mb-0" data-bs-toggle="modal" data-bs-target="#appDetail">View App</a>
									<a href="#" class="btn btn-success me-1 mb-1 mb-md-0 disabled">Accepted</a>
					</td>
				</tr>
		<%
		}
	}
	%>
		</tbody>
	</table>
</div>
</div>


<div class="card-footer bg-transparent pt-0">
				<!-- Pagination START -->
<!-- 				<div class="d-sm-flex justify-content-sm-between align-items-sm-center"> -->
					<!-- Content -->
<!-- 					<p class="mb-0 text-center text-sm-start">Showing 1 to 8 of 20 entries</p> -->
					<!-- Pagination -->
<!-- 					<nav class="d-flex justify-content-center mb-0" aria-label="navigation"> -->

<!-- 페이징 처리된 페이지 목록 시작 -->
<div id="pagination" class="container mt-3">
    <%
    Integer currentPageObj = (Integer) request.getAttribute("currentPage");
    Integer totalPagesObj = (Integer) request.getAttribute("totalPages");

    int currentPage = (currentPageObj != null) ? currentPageObj : 1;
    int totalPages = (totalPagesObj != null) ? totalPagesObj : 1;

    int maxPagesToShow = 5; // 보여줄 최대 페이지 수

    int startPage = Math.max(1, currentPage - maxPagesToShow / 2);
    int endPage = Math.min(startPage + maxPagesToShow - 1, totalPages);
    %>



    <!-- '이전' 버튼 -->
    <div class="container text-center col-sm-12">
    	<ul class="pagination justify-content-center">
<!--     	<ul class="pagination pagination-primary-soft rounded justify-content-center"> -->
<!--     	<ul class="pagination pagination-outline rounded justify-content-center"> -->
	<%
		if(currentPage > 1) {
	%>
			<li class="page-item">
<%-- 			<a href="./list.do?page=<%= currentPage - 1 %>" class="page-link">이전</a> --%>
			<a href="./list.do?page=<%= currentPage - 1 %>" class="page-link"><i class="fas fa-angle-double-left"></i></a>
			</li>
	<%
		}else{
	%>
<%-- 			<a href="./list.do?page=<%= currentPage %>" class="page-link"></a> --%>
	<%
		}
	%> 
	

	<!-- 페이지 목록 -->
	<%
	if (startPage > 1) {
	%>
		<li class="page-item">
		<a href="./list.do?page=1" 
			class="page-link">1</a>
		</li>
	<%
	}
	if (startPage > 2) {
	%>
		<li class="page-item">
		<span class="page-item disabled" id="ellipsis"><a class="page-link" href="#">...</a></span>
		</li>
	<%
	}

	for (int i = startPage; i <= endPage; i++) {
		if (i == currentPage) {
	%>
			<li class="page-item active">
			<a class="page-link" href="#">
			<span class="current-page">
			<%= i %>
			</span>
			</a>
			</li>
	<%
		} else {
	%>
			<li class="page-item">
			<a href="./list.do?page=<%= i %>" class="page-link"><%= i %></a>
			</li>
	<%
		}
	}

	if (endPage < totalPages - 1) {
	%>
		<li class="page-item">
			<span class="page-item disabled" id="ellipsis"><a class="page-link" href="#">...</a></span>
		</li>
		<%
	}
	if (endPage < totalPages) {
	%>
		<li class="page-item">
			<a href="./list.do?page=<%= totalPages %>" class="page-link"> <%= totalPages %></a>
		</li>
	<%
	}
	%>
	<!-- 페이지 목록 끝 -->
	
	
    <!-- '다음' 버튼 -->
		<%
		if(currentPage < totalPages) {
		%>
			<li class="page-item">
<%-- 				<a href="./list.do?page=<%= currentPage + 1 %>" class="page-link">다음</a> --%>
				<a href="./list.do?page=<%= currentPage + 1 %>" class="page-link"><i class="fas fa-angle-double-right"></i></a>
			</li>
		<%
		}else{
		%>
<%-- 			<a href="./list.do?page=<%= currentPage %>" class="page-link"></a> --%>
				
		<%
		}
		%>    	 
	<!-- '다음' 버튼 끝 -->
	</ul>
</div>

</div>
<!-- 페이징 처리된 페이지 목록 끝 -->

<!-- </nav> -->
</div>
</div>

<!-- </div> -->
<!-- </div> -->
</div>
</div>


</main>
<!-- **************** MAIN CONTENT END **************** -->

<!-- Modal START -->
<div class="modal fade" id="appDetail" tabindex="-1" aria-labelledby="appDetaillabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg">
		<div class="modal-content">
			
			<!-- Modal header -->
			<div class="modal-header bg-dark">
				<h5 class="modal-title text-white" id="appDetaillabel">Applicant details</h5>
				<button type="button" class="btn btn-sm btn-light mb-0" data-bs-dismiss="modal" aria-label="Close"><i class="bi bi-x-lg"></i></button>
			</div>
		
			<%
			// 튜터 목록 가져오기
// 			List<PostVO> tutuorReqList = (List<PostVO>) request.getAttribute("tutuorReqList");
			
// 			if (tutorDetail != null && tutorDetail.size() > 0) {
// 				 = tutorDetail.get(0); // 예시로 첫 번째 객체 가져옴
// 			    String memName = tutorDetailObject.getMem_name();
			%>
			
			<!-- Modal body -->
			<div class="modal-body p-5">
				<!-- Name -->
				<span class="small">Applicant Name:</span>
				<h6 class="mb-3"></h6>

				<!-- Email -->
				<span class="small">Applicant Email id:</span>
				<h6 class="mb-3"></h6>

				<!-- Phone number -->
				<span class="small">Applicant Phone number:</span>
				<h6 class="mb-3"></h6>

				<!-- Summary -->
				<span class="small">Summary:</span>
				<%=
					tutuorReqList
				
				%>
				<p class="text-dark mb-2">We focus a great deal on the understanding of behavioral psychology and influence triggers which are crucial for becoming a well rounded Digital Marketer. We understand that theory is important to build a solid foundation, we understand that theory alone isn’t going to get the job done so that’s why this course is packed with practical hands-on examples that you can follow step by step.</p>
				<p class="text-dark mb-0">As it so contrasted oh estimating instrument. Size like body someone had. Are conduct viewing boy minutes warrant the expense? Tolerably behavior may admit daughters offending her ask own. Praise effect wishes change way and any wanted. Lively use looked latter regard had. Do he it part more last in.</p>
			</div>
			
			<%
// 			}
			%>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger-soft my-0" data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>   
<!-- Modal END -->



<%@include file="/include/footer.jsp"%>


</body>
</html>