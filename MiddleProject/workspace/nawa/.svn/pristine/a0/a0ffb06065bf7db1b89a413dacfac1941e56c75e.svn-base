<%@page import="lecture.vo.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<%
	//대부분은 내장객체로 생성된상태(ex. request 등)
	//System.out.println(request.getAttribute("memList"));
	List<LectureVO> lecList = (List<LectureVO>)request.getAttribute("pageList");	

	String msg = session.getAttribute("msg") == null ? "" 
			:(String) session.getAttribute("msg");
	
	session.removeAttribute("msg");
	
%>
<%@include file="/include/header.jsp" %>
<!-- **************** MAIN CONTENT START **************** -->
<main>

<!-- =======================
Page Banner START -->
<section class="bg-dark align-items-center d-flex" style="background:url(assets/images/pattern/04.png) no-repeat center center; background-size:cover;">
	<!-- Main banner background image -->
	<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Title -->
					<h1 class="text-white">레슨</h1>
					<!-- Breadcrumb -->
					<div class="d-flex">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb breadcrumb-dark breadcrumb-dots mb-0">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
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
	<div class="container">
		<!-- Search option START -->
		<div class="row mb-4 align-items-center">
			<!-- Search bar -->
			<div class="col-sm-6 col-xl-4">
				<form class="border rounded p-2">
					<div class="input-group input-borderless">
						<input class="form-control me-1" type="search" placeholder="Search course">
						<button type="button" class="btn btn-primary mb-0 rounded"><i class="fas fa-search"></i></button>
					</div>
				</form>
			</div>

			<!-- Select option -->
			<div class="col-sm-6 col-xl-3 mt-3 mt-lg-0">
				<form class="border rounded p-2 input-borderless">
					<select class="form-select form-select-sm js-choice" aria-label=".form-select-sm">
						<option value="">Category</option>
						<option>All</option>
						<option>Development</option>
						<option>Design</option>
						<option>Accounting</option>
						<option>Translation</option>
						<option>Finance</option>
						<option>Legal</option>
						<option>Photography</option>
						<option>Writing</option>
						<option>Marketing</option>
					</select>
				</form>
			</div>

			<!-- Select option -->
			<div class="col-sm-6 col-xl-3 mt-3 mt-xl-0">
				<form class="border rounded p-2 input-borderless">
					<select class="form-select form-select-sm js-choice" aria-label=".form-select-sm">
						<option value="">Sort by</option>
						<option>Free</option>
						<option>Most viewed</option>
						<option>Popular</option>
					</select>
				</form>
			</div>

			<!-- Button -->
			<div class="col-sm-6 col-xl-2 mt-3 mt-xl-0 d-grid">
				<a href="#" class="btn btn-lg btn-primary mb-0">Filter Results</a>
			</div>
		</div>
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
                    <!-- 이미지 -->
                   <%--  <div class="col-md-4">
                        <img src="<%= lv.getImageUrl() %>" alt="카드 이미지">
                    </div> --%>

                    <!-- 카드 본문 -->
                    <div class="col-md-8">
                        <div class="card-body">
                            <!-- 제목 -->
                            <div class="d-flex justify-content-between mb-2">
                                <h5 class="card-title mb-0"><a href="detail.do?lecNo=<%=lv.getLecNo() %>"><%=lv.getLecTitle() %></a></h5>
                                <!-- 위시리스트 아이콘 -->
                                <a href="#"><i class="fas fa-heart text-danger"></i></a>
                            </div>
                            <!-- 콘텐츠 -->
                            <!-- 정보 -->
                            <ul class="list-inline mb-1">
                                <li class="list-inline-item h6 fw-light mb-1 mb-sm-0">
                                    <i class="far fa-clock text-danger me-2"></i><%= lv.getLecGrade() %>
                                </li>
                                <li class="list-inline-item h6 fw-light mb-1 mb-sm-0">
                                    <i class="fas fa-table text-orange me-2"></i><%= lv.getPrice() %>
                                </li>
                                <li class="list-inline-item h6 fw-light">
                                    <i class="fas fa-signal text-success me-2"></i><%= lv.getLecGrade() %>
                                </li>
                            </ul>
                            <!-- 평점 -->
                            <ul class="list-inline mb-0">
                                <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                                <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                                <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                                <li class="list-inline-item me-0 small"><i class="fas fa-star text-warning"></i></li>
                                <li class="list-inline-item me-0 small"><i class="fas fa-star-half-alt text-warning"></i></li>
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
   <!-- =======================
Page content END -->

<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>강의번호</th>
			<th>강사번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>가격</th>
			<th>정원</th>
			<th>현재인원</th>
		</tr>
		<%
		
		if(lecList.size() == 0) {
			
		%>
		<tr>
			<td colspan="7">회원 정보가 존재하지 않습니다.</td>
		</tr>
		<%
		} else { 
			for(LectureVO lv : lecList) {
		%>
		<tr>
			<td><%=lv.getLecNo() %></td>
			<td><%=lv.getTutNo() %></td>
			<td><a href="detail.do?lecNo=<%=lv.getLecNo() %>"><%=lv.getLecTitle() %></a></td>
			<td><%=lv.getLecCont() %></td>
			<td><%=lv.getPrice() %></td>
			<td><%=lv.getLecMax() %></td>
			<td><%=lv.getLecCnt() %></td>
		</tr>
		<%
			}
		}  
		%>
		
	</table> --%>

<%@include file="/include/footer.jsp" %>
</body>
</html>