<%@ page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
	if(session.getAttribute("LOGIN_USER") == null){ %>
		
		<script>
			alert("로그인이 필요합니다");
			location.href='<%=request.getContextPath()%>/index.jsp';
		</script>
		<% } else {
			MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
			
		}%>
	


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <a href="list.do">리스트 보기</a>


 
<!--  <input type = "button" value="검색" onclick="func()" > -->
 
 <form name="searchTest" method="post" action="search.do">
 	<input id="search" name="search">
 	<input type="submit" value="검색">
 </form>

<<<<<<< .mine

<!--  <script>
 
 	function func() {
 		let str = document.getElementById('search').value;
 		//alert();
 		
 		if(str != null) {
 			
 			
 			
 		} else return;
 	}
 	
 	
 </script> -->


 <a href="${requestScope.kakaoAuthUrl}">카카오 로그인</a>

>>>>>>> .r384831
</body>
</html>