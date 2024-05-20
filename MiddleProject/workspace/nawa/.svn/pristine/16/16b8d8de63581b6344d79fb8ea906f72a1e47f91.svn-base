<%@page import="member.vo.MemberVO"%>
<%@page import="atch.vo.BoardAtchFileVO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%	
	if (session.getAttribute("LOGIN_USER") == null) {
%>
      	<script> alert("로그인이 필요합니다");
      	location.href = "../../index.jsp"; </script> 
	<% } %>
 	
<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<%
	List<PostVO> postList = (List<PostVO>)request.getAttribute("postList");
// 	BoardAtchFileVO bv = request.getAttribute("bv");
	
	String msg = session.getAttribute("msg") == null ? "" 
	: (String) session.getAttribute("msg");
	session.removeAttribute("msg");

	List<PostVO> searchList = (List<PostVO>)request.getAttribute("searchList");
	List<PostVO> catePostsList = (List<PostVO>)request.getAttribute("catePostsList");
	List<PostVO> bNotiList = (List<PostVO>)request.getAttribute("bNotiList");
%>

<%@include file="/include/loginheader.jsp"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&family=Noto+Sans+Mono:wght@200&family=Roboto+Flex:opsz,wght@8..144,200&display=swap" rel="stylesheet">

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script> -->



<style>
#listJsp {
padding: 10px;
}
th {
text-align: center;
}
#postCate {
color: black;
}
#searchContainer, #searchForm {
  display: flex;
  justify-content: center;
  margin: 0px;
  padding: 0px;
}
#searchOptions, #searchBox, #searchButton{
padding: 4px;
}
#postNo, #postCate, #postWriter, #postDate, #listViewCnt {
text-align: center;
}
body {
	background-image: url(assets/images/pattern/05.png)
}
</style>
              







<!-- =======================
Page Banner START -->
<section class="bg-light position-relative">
  <!-- Svg decoration -->
  <figure class="position-absolute bottom-0 start-0 d-none d-lg-block">
    <svg width="822.2px" height="301.9px" viewBox="0 0 822.2 301.9">
      <path class="fill-warning opacity-5" d="M752.5,51.9c-4.5,3.9-8.9,7.8-13.4,11.8c-51.5,45.3-104.8,92.2-171.7,101.4c-39.9,5.5-80.2-3.4-119.2-12.1 c-32.3-7.2-65.6-14.6-98.9-13.9c-66.5,1.3-128.9,35.2-175.7,64.6c-11.9,7.5-23.9,15.3-35.5,22.8c-40.5,26.4-82.5,53.8-128.4,70.7 c-2.1,0.8-4.2,1.5-6.2,2.2L0,301.9c3.3-1.1,6.7-2.3,10.2-3.5c46.1-17,88.1-44.4,128.7-70.9c11.6-7.6,23.6-15.4,35.4-22.8 c46.7-29.3,108.9-63.1,175.1-64.4c33.1-0.6,66.4,6.8,98.6,13.9c39.1,8.7,79.6,17.7,119.7,12.1C634.8,157,688.3,110,740,64.6 c4.5-3.9,9-7.9,13.4-11.8C773.8,35,797,16.4,822.2,1l-0.7-1C796.2,15.4,773,34,752.5,51.9z"></path>
    </svg>
  </figure>
  <div class="container position-relative">
    <div class="row">
      <div class="col-12">
        <div class="row align-items-center">
          <!-- Image -->
          <!-- <div class="col-6 col-md-3 text-center order-1">
            <img src="assets/images/element/category-1.svg" alt="">
          </div> -->
          <!-- Content -->
          <!-- <div class="col-md-6 px-md-5 text-center position-relative order-md-2 mb-5 mb-md-0">
 -->
            <!-- Svg decoration -->
            <figure class="position-absolute top-0 start-0">
              <svg width="22px" height="22px" viewBox="0 0 22 22">
                <polygon class="fill-orange" points="22,8.3 13.7,8.3 13.7,0 8.3,0 8.3,8.3 0,8.3 0,13.7 8.3,13.7 8.3,22 13.7,22 13.7,13.7 22,13.7 "></polygon>
              </svg>
            </figure>
            <!-- Svg decoration -->
            <figure class="position-absolute top-0 start-50 translate-middle mt-n6 d-none d-md-block">
              <svg width="27px" height="27px">
                <path class="fill-purple" d="M13.122,5.946 L17.679,-0.001 L17.404,7.528 L24.661,5.946 L19.683,11.533 L26.244,15.056 L18.891,16.089 L21.686,23.068 L15.400,19.062 L13.122,26.232 L10.843,19.062 L4.557,23.068 L7.352,16.089 L-0.000,15.056 L6.561,11.533 L1.582,5.946 L8.839,7.528 L8.565,-0.001 L13.122,5.946 Z"></path>
              </svg>
            </figure>
            <!-- Title -->
            <h1 class="mb-3">What do you want to share?</h1>
            <p class="mb-3">Talk about what you love and what you want to do with kindred spirits online</p>
            <!-- Search -->
<!--             <form class="bg-body rounded p-2">
              <div class="input-group">
                <input class="form-control border-0 me-1" type="search" placeholder="Search course ">
                <button type="button" class="btn btn-dark mb-0 rounded">Search</button>
              </div>
            </form> -->
          </div>
          <!-- Image -->
          <div class="col-6 col-md-3 text-center order-3">
<%--     		<%@include file="/assets/images/element/04.svg" %> --%>
            <img src="/assets/images/element/category-2.svg" alt="a woman with glasses, sitting on a comfortable-looking chair">
<!-- 			<img src="/assets/images/element/04.svg" alt="a woman listening with a headphone with a notebook on her laptop and a man holding a book spread and talking"> -->
          </div>
          
        </div> <!-- Row END -->
      </div>
    </div> <!-- Row END -->
</section>
<!-- =======================
Page Banner END -->




<section class="py-4">
<div class="container">
<div id="listJspContainer" class="row">
<div class="text-center">

<%-- <%@include file="/assets/images/element/01.svg" %> --%>
</div>







<div id="listContainer" class="col-sm-12 text-left">
<!-- <div id="listContainer"> -->

		<table id="mainList" class="table table-hover">
			<thead class="table-dark" style="height:10px;">
				<tr>
					<th>No.</th>
<!-- 					<th>Cate.</th> --> 
					<th id="cateTh" width="110px" style="color:black;">
					<!-- 카테고리별 정렬 -->
					<form action="./catelist.do" method="post" enctype="multipart/form-data" name="postCate"
						style="height:20px; padding:0px; margin:0px;">
								<select name="postCate" id="postCate" class="form-select form-select" 
									style="margin: top; height: 40px; transform: translateY(-23%); color:black;"
									onchange="this.form.submit()">
									<option selected value="">Cate.</option>
									<option value="1">일반</option>
									<option value="2">질문</option>
									<option value="3">홍보</option>
									<option value="0">공지사항</option>
								</select>
					</form>
					</th>
					<th style="width: 40%">Title</th>
					<th style="width: 15%">Name</th>
					<th style="width: 20%">Date</th>
					<th>View</th>
<!-- 					<th>Attach.</th> -->
					<th><i class="bi bi-download"></i></th>
				</tr>
			</thead>
			<tbody>
				<%
					if(postList.size() == 0 ) {
				%>
				<tr>
					<td colspan="6">게시물 정보가 존재하지 않습니다.</td>

				</tr>
				<%
					}else{
							for(PostVO pv3 : bNotiList) {
				%>
				<tr style="background-color:rgb(239, 247, 254);">
						<td id="postNo"><%=pv3.getPostNo() %></td>
				<%
				String j = null;
				int num = pv3.getPostCate();
					switch(num) {
					case 0: j ="공지사항"; break;
					case 1: j ="일반"; break;
					case 2: j ="질문"; break;
					case 3: j ="홍보"; break;
					case 8: j ="튜터신청"; break;
					case 9: j ="제재"; break;
					default: break;
					}
				%>
						<td id="postCate"><%= j%></td>
						<td id="postTitle">
							<a class="listTitle" style="text-decoration:none" href="./detail.do?postNo=<%=pv3.getPostNo() %>" 
								data-bs-toggle="tooltip" ><%=pv3.getPostTitle() %></a>
<%-- 								 <font style="font-size:80%">[<%=pv3.getCommCnt() %>]</font> --%>
						</td>
					<td id="postWriter"><%=pv3.getPostWriter() %></td>
					<td id="postDate"><%=pv3.getPostDate() %></td>
					<td id="listViewCnt"><%=pv3.getViewCnt() %></td>
					<td id="postAtch">
			<%-- 					<%=pv.getBoardAtchFileId() %> --%>
			<!-- 					<i class="bi bi-box-arrow-in-down"></i> -->
					<%
					int tch = 0;
					if (tch <= 0) {
					%>
					<%
					}else {
					%>
					<i class="bi bi-download"></i>
					<%
					}
					%>						
					</td>
					<!-- 잘못한게 없는거같은데 에러가 난다면? -> 탭 껐다 켜기 -->
					<!-- JSP 수정했을 땐 서버 껐다 켤 필요 X -->
				</tr>
			<%
			}
							for(PostVO pv : postList) {
				%>
				<tr>
		 			<td id="postNo"><%=pv.getPostNo() %></td>
				<%
				String j = null;
				int num = pv.getPostCate();
					switch(num) {
					case 0: j ="공지사항"; break;
					case 1: j ="일반"; break;
					case 2: j ="질문"; break;
					case 3: j ="홍보"; break;
					case 8: j ="튜터신청"; break;
					case 9: j ="제재"; break;
					default: break;
					}
				%>
 		 			<td id="postCate"><%= j%></td>
		 			<td id="postTitle">
		 				<a class="listTitle" style="text-decoration:none" href="./detail.do?postNo=<%=pv.getPostNo() %>" 
		 					data-bs-toggle="tooltip" ><%=pv.getPostTitle() %></a> <font style="font-size:80%">[<%=pv.getCommCnt() %>]</font>
<%-- 		 					title="<%=pv.getPostContent() %>" --%>
		 			</td>
					<td id="postWriter"><%=pv.getPostWriter() %></td>
					<td id="postDate"><%=pv.getPostDate() %></td>
					<td id="listViewCnt"><%=pv.getViewCnt() %></td>
					<td id="postAtch">
<%-- 					<%=pv.getBoardAtchFileId() %> --%>
<!-- 					<i class="bi bi-box-arrow-in-down"></i> -->
					<%
					int tch = 0;
					if (tch <= 0) {
					%>
					<%
					}else {
					%>
					<i class="bi bi-download"></i>
					<%
					}
					%>						
					</td>
					<!-- 잘못한게 없는거같은데 에러가 난다면? -> 탭 껐다 켜기 -->
					<!-- JSP 수정했을 땐 서버 껐다 켤 필요 X -->
				</tr>
		<%
		}
	}
	%>
		</tbody>
	</table>
</div>




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


	<!-- 목록 버튼	 -->
	<button type="button" class="btn btn-dark-soft" style="float:left;" onclick="location.href='./list.do'">글목록</button>
    <button type="submit" class="btn btn-dark-soft" id="writeButton" style="float:right;" onclick="location.href='./insert.do'">글쓰기</button>
    
    
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

<!-- 글쓰기 버튼	 -->
<!-- <button type="submit" class="btn btn-dark" id="writeButton" style="height:34px" onclick="location.href='./insert.do'">write</button> -->
    

</div>
<!-- 페이징 처리된 페이지 목록 끝 -->




<!-- 검색하기  -->
	<div class="text-center" id="searchContainer">
			<form method="get" name="search" action="./search.do" id="searchForm">
					<div id="searchOptions">
						<select class="form-control" name="searchField">
							<option value="postTitle">제목</option>
							<option value="postContent">제목+내용</option>
							<option value="postWriter">작성자</option>
						</select>
					</div>
				<div id="searchBox">
					<input type="text" class="form-control" placeholder="검색어 입력" 
							name="searchText" maxlength="100">
				</div>
				<div id="searchButton">
					<button type="submit" class="btn btn-outline-success">검색</button>
				</div>
			</form>
	</div>
<!-- 검색하기 끝 -->
















<%
	if(msg.equals("성공")) {
%>	
<script>
	alert('정상적으로 처리되었습니다.');
</script>
<%
	}
%>


</div>
</div>
</section>

<script>
  <%-- console.log("Current Page:", <%= currentPage %>); --%>
  
/*   $(document).ready(function(){
	  //실행내용
	  
	}) */

</script>

<%@include file="/include/footer.jsp"%>

</body>

</html>