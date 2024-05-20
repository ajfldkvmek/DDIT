<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>쉽게 배우는 JSP 웹 프로그래밍</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="/pageModule/headPart.jsp"%>
</head>
<body>
	<%@ include file="/pageModule/header.jsp"%>

	<div class="breadcrumbs" style="padding-top: 40px;">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-6 col-12">
					<div class="breadcrumbs-content">
						<h1 class="page-title">파일 업로드</h1>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-12">
					<ul class="breadcrumb-nav">
						<li><a href="/">INDEX</a></li>
						<li>CH07</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- 
                    	1. 회원 목록 페이지를 작성해주세요.
                    	
                    	[ 등록 ]
                    	______________________________
                    	이미지	     회원정보			버튼
                    	______________________________
                    	[ 이	]     아이디 : a001      [상세]
                    	[ 미 ]     비번 : 1234
                    	[ 지 ]     이름 : 홍길동
                    	[ 란 ]     성별 : 남자
                    	______________________________
                    	[ 이	]     아이디 : a002      [상세]
                    	[ 미 ]     비번 : 1234
                    	[ 지 ]     이름 : 홍길순
                    	[ 란 ]     성별 : 여자
                    	______________________________
                    	... 
                     -->


	<div class="container">
		<%
			MemberDAO dao = MemberDAO.getInstance();
			List<MemberVO> list = dao.getMemberList();
		%>
		<input type="button" value="회원등록"
							onclick='location.href="ch07_test_signup.jsp"'>
		<% for(MemberVO mv : list) { %>
		<div class="row">
			<!--
			<div class="col-md-3" align="center">	
				<img src="${pageContext.request.contextPath }/resources/images/" width="60%">
			</div>
			-->
			
			
			<div class="col-md-4"> <!-- 사진 -->
				<img alt="" src="${pageContext.request.contextPath }/ch07/images/<%=mv.getFilename() %>"
					style="width: 100%; height: 300px" />
			</div>
			
			
			<div class="col-md-6">
				<p>아이디: <%=mv.getMem_id() %> </p>
				<p>비이번: <%=mv.getMem_pw() %> </p>
				<p>이르음: <%=mv.getMem_name()%> </p>
				<p>성벼얼: <%=mv.getMem_sex() %></p>
			</div>
			
			<div class="col-md-2" style="padding-top: 60px">
				<a href="ch07_test_signin.jsp"
					class="btn btn-secondary" role="button"> 상세정보 &raquo;</a>
			</div>
		</div>
		<hr>
		<%
			}
		%>
	</div>

	<%-- 
	<section class="about-us section">
		<div class="container">
			<!-- <div class="row align-items-center justify-content-center"> -->
				<div class="col-lg-12 col-md-12 col-12">
					<!-- <div class="content-left wow fadeInLeft" data-wow-delay=".3s"> -->
						<%
							MemberDAO dao = MemberDAO.getInstance();
						List<MemberVO> list = dao.getMemberList();
						%>
						<!-- 
                    	1. 회원 목록 페이지를 작성해주세요.
                    	
                    	[ 등록 ]
                    	______________________________
                    	이미지	     회원정보			버튼
                    	______________________________
                    	[ 이	]     아이디 : a001      [상세]
                    	[ 미 ]     비번 : 1234
                    	[ 지 ]     이름 : 홍길동
                    	[ 란 ]     성별 : 남자
                    	______________________________
                    	[ 이	]     아이디 : a002      [상세]
                    	[ 미 ]     비번 : 1234
                    	[ 지 ]     이름 : 홍길순
                    	[ 란 ]     성별 : 여자
                    	______________________________
                    	... 
                     -->
						<input type="button" value="회원등록"
							onclick='location.href="ch07_test_signup.jsp"'>

						<%
							for (MemberVO member : list) {
						%>

						<!-- 여기부터 반복문 -->
						<div class="col-md-4">
							<img alt=""
								src="${pageContext.request.contextPath }/ch07/images/<%=member.getFilename() %>"
								style="width: 100%" />
						</div>

						<div class="col-md-6">
							<b>상품 코드 : </b><span class="badge badge-danger"> </span>
							</p>
							<p>
								<b>제조사 : </b>
							</p>
							<p>
								<b>분류 : </b>
							</p>
							<p>
								<b>재고수 : </b>
							</p>
							<h4>as</h4>
							
						</div>
						
						<div class="col-md-3">
						<form action="addCart.jsp?id=" method="post" name="addForm">
								<p>
									<a href="#" class="btn btn-info">상품 주문 &raquo;</a> <a
										href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a> <a
										href="products.jsp" class="btn btn-secondary">상품 목록
										&raquo;</a>
								</p>
							</form>
						</div>
						<%
							}
						%>


					<!-- </div>sss -->
				</div>
			<!-- </div> -->
		</div>
	</section>
	--%>
	<%@ include file="/pageModule/footer.jsp"%>

	<%@ include file="/pageModule/footerPart.jsp"%>
</body>
</html>