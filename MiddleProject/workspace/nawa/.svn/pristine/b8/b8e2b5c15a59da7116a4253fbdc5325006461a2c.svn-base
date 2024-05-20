<%@page import="member.vo.MemberVO"%>
<%@page import="atch.vo.BoardAtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="board.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
	if(mv == null) { %>
		<script>alert("로그인이 필요합니다"); location.href="/nawa/member/signin.jsp"</script>
	<%} 
%>
<%
	PostVO pv = (PostVO) request.getAttribute("pv");
%>

<%@include file="/include/header.jsp"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  
<style>
#buttonContainer {
padding: 10px;
}
.updateButton{
border: 2px dashed teal;
border-radius: 10px;
background-color: white;
padding: 0px 13px;
font-family: 'Dongle', sans-serif;
font-size: 150%;
}
#updateContainer {
padding: 10px;
}
</style>
<!-- </head> -->

<!-- <body> -->

<section class="py-4">
<div class="container">
<div class="row">

<div class="col-sm-8 text-left">
<%--   	<form id="commUpdateForm" action="${pageContext.request.contextPath}/board/commUpdate.do"  --%>
  	<form id="commUpdateForm" action="./commUpdate.do" 
  		method="post" enctype="multipart/form-data">
  		<input type="hidden" name="postNo" value="<%=pv.getPostNo() %>">
  		
  		<div id="commUpdateContainer" class="form-group">
  				
  				<label for="commNo">댓글번호: </label>
<%-- 				<input type="number" name="commNo" id="commNo" class="form-control" value="<%=pv.getCommNo() %>" disabled> --%>
				<input type="number" name="commNo" id="commNo" class="form-control" value="<%=pv.getCommNo() %>" readonly>
				
				<label for="commWriter">작성자: </label>
				<input type="text" name="commWriter" id="commWriter" class="form-control" value="<%=pv.getCommWriter() %>" readonly>
				
				<label for="commDate">작성일: </label>
				<input type="text" name="commDate" id="commDate" class="form-control" value="<%=pv.getCommDate() %>" readonly>

				<label for="commContent">내용: </label>
				<textarea name="commContent" id="commContent" class="form-control" ><%=pv.getCommContent() %></textarea>
				
  			<div id="buttonContainer" class="btn-group">
<%-- 			<button type="button" class="btn btn-default" onclick="location.href='./list.do?postNo=${pv.getPostNo()}'">list</button> --%>
				<button type="button" class="btn btn-dark" onclick="location.href='./list.do'">list</button>
<%--    		<button type="submit" class="btn btn-primary" onclick="location.href='./update.do?postNo=${pv.getPostNo()}'">edit</button> --%>
   				<button type="submit" class="btn btn-success">edit</button>
  			</div>	
  		</div>
 			
	</form>
</div>
</div>
</div>
</section>
<script>

</script>

<%@include file="/include/footer.jsp"%>

</body>

</html>