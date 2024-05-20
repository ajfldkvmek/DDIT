<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");


%>
<%
	if (mv == null) {
%>
<script>
	alert("로그인이 필요합니다");
	location.href = "../../index.jsp"; 
<%
	}
%>



<%@include file="/include/header.jsp"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<style type="text/css">
#insertContainer {
	padding: 10px;
}

#buttonContainer {
	padding: 10px;
}

.insertButton {
	border: 2px dashed teal;
	border-radius: 10px;
	background-color: white;
	padding: 0px 13px;
	font-family: 'Dongle', sans-serif;
	font-size: 150%;
}

textarea {
	resize: none;
	width: 80%;
	height: 300px;
}
</style>
<!-- </head> -->



<!-- <body> -->
<div class="col-sm-8 text-left">
	<%-- 	<form action="${pageContext.request.contextPath}/board/insert.do" method="post" enctype="multipart/form-data"> --%>
	<form action="./mbInsert" method="post" enctype="multipart/form-data"
		onsubmit="convertTextarea()">
		<div id="insertContainer" class="form-group">
			<label for="postWriter">작성자: </label> <input type="text"
				class="form-control" id="postWriter" name="postWriter"
				value="<%=mv.getMem_id()%>" disabled> <label for="postCate">분류:
			</label>
			 <select name="postCate" id="postCate" class="form-control">
				<option value="100">잡담</option>
				<option value="999">공지사항</option>
				<option value="200">후기</option>
				<option value="300">기대평</option>
				<!-- <option value="9">제재</option>
				<option value="0">공지사항</option> -->
				
			</select> <label for="postTitle">제목: </label> <input type="text"
				class="form-control" id="postTitle" name="postTitle">
				
				
				 <labelfor="postContent">내용: </label>
			<textarea class="form-control" id="postContent" name="postContent"
				maxlength="1000" placeholder="본문을 쓰세요."></textarea>
			<div></div>
			<label for="fileInput" class="form-label">첨부파일: </label>
			 <input
				type="file" id="fileInput" name="fileInput" class="form-control">
		</div>

		<div id="buttonContainer" class="btn-group">
			<button type="button" class="btn btn-dark-soft"
				onclick="location.href='./list.do'">글목록</button>
			<button type="submit" class="btn btn-dark-soft">글쓰기</button>

		</div>

	</form>
</div>
<script>
	function convertTextarea() {
		// textarea의 내용을 가져옴
		let postContentValue = document.getElementById("postContent").value;

		// \r\n을 <br>로 치환
		let convertedValue = postContentValue.replace(/(\n|\r\n)/g, "<br>");

		// 변환된 값을 다시 textarea에 설정
		document.getElementById("postContent").value = convertedValue;
	}
</script>


<%@include file="/include/footer.jsp"%>

</body>
</html>