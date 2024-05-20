<%@page import="member.vo.MemberVO"%>
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
	PostVO pv = (PostVO)request.getAttribute("pv");

	String msg = session.getAttribute("msg") == null ? "" 
			: (String) session.getAttribute("msg");
	session.removeAttribute("msg");
	
	System.out.println("[commInsertForm.jsp] pv: " + pv);
%>


<%@include file="/include/header.jsp" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<div class="col-sm-12 text-left">

<%-- /commInsert.do?postNo=<%= pv.getPostNo() --%>
<%-- 	<form action="./commInsert.do?postNo=<%= pv.getPostNo()%>" method="post" enctype="multipart/form-data"> --%>
	<form action="./commInsert.do" method="post" enctype="multipart/form-data">

 		<div id="insertContainer"  class="form-group">
				<label for="postWriter">작성자: </label>
				<input type="text" class="form-control" id="postWriter" name="postWriter">

				<label for="postContent">내용: </label>
				<textarea class="form-control" id="postContent" name="postContent" 
					maxlength="1000" 
					placeholder="본문을 쓰세요."></textarea>
		</div>
		
		<div id="buttonContainer" class="btn-group">

		<button type="button" class="btn btn-dark" onclick="location.href='./list.do'">list</button>
		<button type="submit" class="btn btn-success" >write</button>
<%-- commInsert.do?postNo=<%= pv.getPostNo() %> --%>
		</div>
	</form>
</div>


<script>

</script>


<%@include file="/include/footer.jsp"%>
</body>

</html>

