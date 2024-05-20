<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="board.atch.vo.AtchFileVO"%>
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
	//List<AtchFileVO> atchList = (List<AtchFileVO>) session.getAttribute("atchList");
%>


<%
	PostVO pv =(PostVO)request.getAttribute("pv");
	
	/* //List<BoardAtchFileVO> atchFileList = (List<BoardAtchFileVO>) request.getAttribute("boardAtchFileList"); */ 
	List<PostVO> commList = (List<PostVO>) request.getAttribute("commList");
	List<AtchFileVO> atchList = (List<AtchFileVO>) request.getAttribute("atchList");
	
	String msg = session.getAttribute("msg") == null ? "" 
		: (String) session.getAttribute("msg");
	session.removeAttribute("msg");

	System.out.println("[detail.jsp] pv: " + pv);
	System.out.println("[detail.jsp] postNo: " + pv.getPostNo());
	System.out.println("[detail.jsp] commList: " + commList);
	System.out.println("[detail.jsp] atchList: " + atchList);
%>

<%@include file="/include/loginheader.jsp"%>



<style>
#detailContainer {
padding: 10px;
}
#buttonContainer, #commnetInsertContainer, #contContainer, #commentsContainer {
padding: 10px;
width: 100%;
}
#detailCate{
text-align: center;
}
#commInsertWriter, #commInsertCont {
padding: 2px;
margin: 2px;
}
#commentInsertContainer, #commentInsertForm {
  display: flex;
/*   justify-content: center; */
}
</style>

<section class="py-4">
<div class="container">
<div class="row">
<div id="detailContainer" class="col-sm-12 text-left">
	<div class="table-responsive" id="contContainer">  
<!-- 	<table width=100% class="table table-striped"> -->
	<table width=100% class="table">

		<tr>
			<th id="detailCate" class="table-dark" style="text-align:center; width:130px">제목</th>
			<td id="detailCate" class="table-dark" colspan="5"><%=pv.getPostTitle()%></td>
		</tr>
		<tr>
			<th id="detailCate" style="text-align:center; width:130px; background-color:whitesmoke">작성자</th>
			<td style="width:200px"><%=pv.getPostWriter()%></td>
			
			<th id="detailCate" style="text-align:center; width:130px; background-color:whitesmoke">등록일</th>
<%-- 			<td class="detailCate" width=15% colspan="2"><%=pv.getPostDate() %> --%>
			<td id="detailCate" style="text-align:center; width:130px"><%=pv.getPostDate()%>
			<th id="detailCate" style="text-align:center; width:130px; background-color:whitesmoke">조회수</th>
			<td id="detailCate" style="text-align:center; width:130px"><%=pv.getViewCnt()%></td>
		</tr>
		<tr>
			<th id="detailCate" style="text-align:center; background-color:whitesmoke">내용</th>
			<td colspan="5"><%=pv.getPostContent()%>
			
				<%
					for(AtchFileVO : av = atchList) {
						
					}
				%>
			</td>
		</tr>
		<tr>
			<th id="detailCate" style="text-align:center; width:130px; background-color:whitesmoke">첨부파일</th>
			<td colspan="5">
				<%
					if(atchList != null) { 
											for(AtchFileVO atchVO : atchList) {
				%>
					<div>
						<%-- <a href="<%=request.getContextPath()%>/fileDownload.do?fileId=<%=atchVO.getBoardFIndex()%>">
						<%=atchVO.getBoardOriName()%>
						</a> --%>
						<%=atchVO.getStreFileNm() %>.<%=atchVO.getFileExtsn() %>
					</div>
					<%
						}
										}
					%>
			</td>
		</tr>
	</table>
	</div>
	<div id="buttonContainer">
			<button type="button" class="btn btn-outline-secondary" onclick="location.href='./list.do'">목록</button>
			<button type="submit" class="btn btn-outline-secondary" onclick="authCheck(); location.href='./update.do?postNo=<%=pv.getPostNo()%>'">수정</button>
			<button type="submit" class="btn btn-outline-secondary" onclick="authCheck(); delCheck(); location.href='./delete.do?postNo=<%=pv.getPostNo()%>'">삭제</button>
	</div>

	<div id="commnetInsertContainer" class="form-group">
		<form action="./commInsert.do" method="post" enctype="multipart/form-data" id="commentInsertForm">
			<input type="hidden" name="postNo" value="<%=pv.getPostNo()%>">
<!-- 				<label for="commWriter" id="commInsertWriter" -->
<!-- 				<label for="commWriter" id="commInsertWriter">작성자: </label> -->
				<input type="text" class="form-control" id="commWriter" name="commWriter"
					style="text-align:center; width:130px"
					title="댓글 작성자" value="<%=mv.getMem_id() %>" disabled>
				
<!-- 				<label for="commContent" id="commInsertCont">내용: </label> -->
				<textarea class="form-control" id="commContent" name="commContent" 
					maxlength="1000" 
					placeholder="댓글 내용을 쓰세요."></textarea>
				
				<button type="submit" class="btn btn-dark-soft" >댓글 쓰기</button>
		</form>
	</div>


	<div id="commentsContainer">
	<table width=100% class="table table-striped">
				<%
					if(commList.size() == 0 ) {
				%>
				<tr>
					<td colspan="6">댓글이 없습니다.</td>

				</tr>
				<%
					}else{
				%>
				<tr>
					<th class="table-secondary" style="text-align:center; width:130px">작성자</th>
					<th class="table-secondary" style="text-align:center">내용</th>
					<th class="table-secondary" style="text-align:center; width:130px">작성일</th>
					<th class="table-secondary" style="text-align:center; width:130px"></th>
				</tr>
				
				<%
									for(PostVO pv2 : commList) {
								%>
				<tr>
					<td id="commWriter" style="text-align:center"><%=pv2.getCommWriter() %></td>
					<td id="commContent"><%=pv2.getCommContent() %></td>
					<td id="commDate" style="text-align:center"><%=pv2.getCommDate() %></td>
					<td>
					
						<script>
						function authCheckComm() {
							let memId = '<%= mv.getMem_id() %>';
							let pwt2 = '<%= pv2.getCommWriter() %>';
							let pn2 = <%=pv2.getCommNo()%>
							if (pwt2 != memId || pwt2 == null || pwt2 == "") {
	//					 		alert("memId: " + memId + " | pwt: " + pwt + " | pn: " + pn)
								alert("권한이 없습니다.");
								e.preventDefault();
							} else{
								return true;
							}
						}
						</script>
						
					<button type="submit" class="btn btn-outline-secondary btn-sm" onclick="authCheckComm(); location.href='./commUpdate.do?postNo=<%=pv2.getPostNo()%>&commNo=<%=pv2.getCommNo()%>'">수정</button>
					<button type="submit" class="btn btn-outline-secondary btn-sm" onclick="authCheckComm(); delCheck(); location.href='./commDelete.do?postNo=<%=pv2.getPostNo()%>&commNo=<%=pv2.getCommNo()%>'">삭제</button>


					</td>
				</tr>
					<%
					}
				}
				%>
	</table>
</div>

	<button type="button" class="btn btn-dark-soft" style="float:left;" onclick="location.href='./list.do'">글목록</button>
    <button type="submit" class="btn btn-dark-soft" id="writeButton" style="float:right;" onclick="location.href='./insert.do'">글쓰기</button>


<!-- 페이징 처리된 댓글 목록 시작 -->
<div id="commPagination">
    <%
    Integer currentCommPageObj = (Integer) request.getAttribute("currentCommPage");
    Integer totalCommPagesObj = (Integer) request.getAttribute("totalCommPages");

    int currentCommPage = (currentCommPageObj != null) ? currentCommPageObj : 1;
    int totalCommPages = (totalCommPagesObj != null) ? totalCommPagesObj : 1;

    int maxCommPagesToShow = 5; // 보여줄 최대 페이지 수

    int startCommPage = Math.max(1, currentCommPage - maxCommPagesToShow / 2);
    int endCommPage = Math.min(startCommPage + maxCommPagesToShow - 1, totalCommPages);
    		
    %>
</div>

	    <!-- '이전' 버튼 -->
    <div class="container text-center col-sm-12">
    	<ul class="pagination dark-soft justify-content-center">
	<%
		if(currentCommPage > 1) {
	%>
			<li class="page-item">
			<a href="./detail.do?postNo=<%= pv.getPostNo() %>&commPage=<%= currentCommPage - 1 %>" class="page-link">이전</a>
			</li>
	<%
		}else{
	%>
	<%
		}
	%> 
	<!-- '이전' 버튼 끝 -->
	

	<!-- 페이지 목록 -->
	<%
	if (startCommPage > 1) {
	%>
		<li class="page-item">
		<a href="./detail.do?postNo=<%= pv.getPostNo() %>commPage=1" 
			class="page-link">1</a>
		</li>
		<li class="page-item">
		<span class="ellipsis">...</span>
		</li>
	<%
	}

	for (int i = startCommPage; i <= endCommPage; i++) {
		if (i == currentCommPage) {
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
			<a href="./detail.do?postNo=<%=pv.getPostNo() %>&commPage=<%= i %>" class="page-link"><%= i %></a>
			</li>
	<%
		}
	}

	if (endCommPage < totalCommPages) {
	%>
		<li class="page-item">
			<span class="ellipsis">...</span>
		</li>
		<li class="page-item">
			<a href="./detail.do?postNo=<%= pv.getPostNo() %>&commPage=<%= totalCommPages %>" class="page-link"> <%= totalCommPages %></a>
		</li>
	<%
	}
	%>
	<!-- 페이지 목록 끝 -->
	
	
    <!-- '다음' 버튼 -->
		<%
		if(currentCommPage < totalCommPages) {
		%>
			<li class="page-item">
				<a href="./detail.do?postNo=<%=pv.getPostNo() %>&commPage=<%= currentCommPage + 1 %>" class="page-link">다음</a>
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
</div>	
</div>	
</section>	

<script>
	
// function authCheck(postWriter, memId) {
function authCheck() {
	let memId = '<%= mv.getMem_id() %>';
	let pwt = '<%= pv.getPostWriter() %>';
	let pn = <%=pv.getPostNo()%>
	if (pwt != memId || pwt == null || pwt == "") {
// 		alert("memId: " + memId + " | pwt: " + pwt + " | pn: " + pn)
		alert("권한이 없습니다.");
		e.preventDefault();
	} else{
		return true;
	}
}

function delCheck() {
	if(confirm("정말 삭제하시겠습니까?")){
	    alert("삭제를 누르셨습니다.");
	    return true;
	}else{
	    alert("삭제를 취소합니다.");
	    e.preventDefault();
	}
}

</script>

<%@include file="/include/footer.jsp"%>

</body>
</html>