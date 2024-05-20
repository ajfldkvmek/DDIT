<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dao.BoardRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>쉽게 배우는 JSP 웹 프로그래밍</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<%@ include file="/pageModule/headPart.jsp" %>
</head>


<style>
    table {
      width: 100%;
      border-collapse: collapse;
      border: 1px solid #dddddd; 
    }
    th, td {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }
  </style>
<body>
	<%@ include file="/pageModule/header.jsp" %>

    <div class="breadcrumbs" style="padding-top:40px;">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6 col-12">
                    <div class="breadcrumbs-content">
                        <h1 class="page-title">JSP 개요</h1>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-12">
                    <ul class="breadcrumb-nav">
                        <li><a href="/">INDEX</a></li>
                        <li>CH01</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <section class="about-us section">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-lg-12 col-md-12 col-12">
                    <div class="content-left wow fadeInLeft" data-wow-delay=".3s">
					<!-- 
						1. 게시판 목록을 출력해주세요.
							> JSTL을 활용해주세요.
							> 초기 화면에서는 데이터가 없으므로 '조회하실 게시글이 존재하지 않습니다.'를 출력해주세요.
							> 데이터가 있는 경우엔 제목, 작성자, 작성일, 조회수를 맞춰서 데이터를 출력해주세요.
									
							** 초반 데이터는 없습니다.
										제목						작성자		작성일			조회수
						─────────────────────────────────────────────────────────────────────────────
											조회하실 게시글이 존재하지 않습니다.
						─────────────────────────────────────────────────────────────────────────────						
						[ 게시글 등록하기  ]
						
							** 데이터가 있는 경우 아래와 같이 출력됩니다.
									제목						작성자		작성일			조회수
						─────────────────────────────────────────────────────────────────────────────
							게시판 제목입니다......! 1			허나훔		2022-12-12		1245
							게시판 제목입니다......! 2			송서영		2022-12-12		1245
							게시판 제목입니다......! 3			채진영		2022-12-12		1245
							게시판 제목입니다......! 4			배영호		2022-12-12		1245
							게시판 제목입니다......! 5			조은혁		2022-12-12		1245
							게시판 제목입니다......! 6			조현수		2022-12-12		1245
							.....
						─────────────────────────────────────────────────────────────────────────────
						 [ 게시글 등록하기  ]
						
						2. 시큐리티 적용
							> 게시판 등록 페이지를 시큐리티 보호자원으로 설정해주세요.
								- 시큐리티 인증방식 : FORM
								- 시큐리티 로그인 
							> 등록 페이지는 역할명 admin만 접근 가능토록 해주세요.
								- id : admin
								- pw : a1234
							> 로그인 인증 시, loginSecurity.jsp로 이동하여 인증을 진행 할 수 있도록 해주세요.
							> 로그인 인증 실패 시, loginFailed.jsp로 이동할 수 있도록 해주세요.
								  
						3. 게시글 클릭 시, 해당 게시글 상세보기 페이지로 이동합니다.
							> 상세보기 페이지로 이동할 때, 조회수가 상승합니다.
					 -->
						
						<%
							BoardRepository br = BoardRepository.getInstance();
							List<BoardVO> boardList = br.selectBoardList(); //전체 글 가져오기
							System.out.println(boardList);
							if(boardList.size() == 0){
								System.out.println("값이 없는딩?");
							}
						%>
						<table>
							  <colgroup>
							    <col style="width: 10%;">
							    <col style="width: 60%;">
							    <col style="width: 10%;">
							    <col style="width: 10%;">
							    <col style="width: 10%;">
							  </colgroup>
							<tr>
								<th>번호 </th>
								<th>제목 </th>
								<th>작성자 </th>
								<th>작성일 </th>
								<th>조회수 </th>
							</tr>
							
							<%
								if(boardList.size() == 0){ %>
									<tr>
									<td colspan="5">글이 없는딩?</td>
									</tr>
								<% }
							%>
							
						</table>
						<!-- 이때 시큐리티처리 인증으로 가기  -->
						<input type="button" value="등록" onclick="location.href='loginForm.jsp'"/> 
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>