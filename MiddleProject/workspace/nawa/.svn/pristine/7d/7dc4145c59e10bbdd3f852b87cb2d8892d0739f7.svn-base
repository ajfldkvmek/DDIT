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
		/* location.href = "../../index.jsp"; */ 
		location.href = "/nawa/index.jsp";
		</script>
<%
	}
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
%>
<%
	PostVO pv =(PostVO)request.getAttribute("pv");
	List<PostVO> searchList = (List<PostVO>)request.getAttribute("searchList");

	String msg = session.getAttribute("msg") == null ? "" 
	: (String) session.getAttribute("msg");
	session.removeAttribute("msg");
%>

<%@include file="/include/header.jsp"%>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&family=Noto+Sans+Mono:wght@200&family=Roboto+Flex:opsz,wght@8..144,200&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<style>
#listContainer {
padding: 10px;
}
th {
text-align: center;
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
</style>





<section class="py-4">
<div class="container">

<!-- <div id="listContainer" class="col-sm-8 text-left"> -->
<div id="listContainer" class="row">

		<table id="mainList" class="table table-hover">
			<thead class="table-dark">
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
				</tr>
			</thead>
			<tbody>
				<%
					if(searchList.size() == 0 ) {
				%>
				<tr>
					<td colspan="6">게시물 정보가 존재하지 않습니다.</td>
				</tr>
				<%
					}else{
										for(PostVO pv2 : searchList) {
				%>
				<tr>
		 			<td id="postNo"><%=pv2.getPostNo() %></td>
		 			<%
						String j = null;
						int num = pv2.getPostCate();
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
		 				<a class="listTitle" style="text-decoration:none" href="./detail.do?postNo=<%=pv2.getPostNo() %>"><%=pv2.getPostTitle() %></a> <font style="font-size:80%">[<%=pv2.getCommCnt() %>]</font>
		 			</td>
					<td id="postWriter"><%=pv2.getPostWriter() %></td>
					<td id="postDate"><%=pv2.getPostDate() %></td>
					<td id="listViewCnt"><%=pv2.getViewCnt() %></td>
<%-- 					<td id="postAtch"><%=pv.getAtchFileId() %></td> --%>
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
<div id="pagination">
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
	<button type="button" class="btn btn-dark" style="float:left;" onclick="location.href='./list.do'">글목록</button>
    <button type="submit" class="btn btn-dark" id="writeButton" style="float:right;" onclick="location.href='./insert.do'">글쓰기</button>
    
    
    <!-- '이전' 버튼 -->
    <div class="container text-center col-sm-12">
    	<ul class="pagination justify-content-center">
	<%
		if(currentPage > 1) {
	%>
	
			<li class="page-item">
			<a href="./search.do?searchField=<%=pv.getSearchField() %>&searchText=<%=pv.getSearchText() %>&searchPage=<%= currentPage - 1 %>" class="page-link">이전</a>
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
	%> 

	<!-- 페이지 목록 -->
	<%
	if (startPage > 1) {
	%>
		<li class="page-item">
		<a href="./search.do?searchField=<%=pv.getSearchField() %>&searchText=<%=pv.getSearchText() %>&searchPage=1" 
			class="page-link">1</a>
	<%
	}
	if (startPage > 2) {
	%>
		</li>
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
			<a href="./search.do?searchField=<%=pv.getSearchField() %>&searchText=<%=pv.getSearchText() %>&searchPage=<%= i %>" class="page-link"><%= i %></a>
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
			<a href="./search.do?searchField=<%=pv.getSearchField() %>&searchText=<%=pv.getSearchText() %>&searchPage=<%= totalPages %>" class="page-link"> <%= totalPages %></a>
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
				<a href="./search.do?searchField=<%=pv.getSearchField() %>&searchText=<%=pv.getSearchText() %>&searchPage=<%= currentPage + 1 %>" class="page-link">다음</a>
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
<!-- 글쓰기 버튼	 -->
<!-- <button type="submit" class="btn btn-default" id="writeButton" style="height:34px" onclick="location.href='./insert.do'">write</button> -->
    

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
					<button type="submit" class="btn btn-success">검색</button>
				</div>
			</form>
	</div>
<!-- 검색하기 끝 -->


</div>
</section>


<%
	if(msg.equals("성공")) {
%>	
<script>
	alert('정상적으로 처리되었습니다.');
</script>
<%
	}
%>



<script>
<%--   console.log("Current Page:", <%= currentPage %>); --%>
</script>

<%@include file="/include/footer.jsp"%>

</body>

</html>