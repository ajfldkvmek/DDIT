<%@page import="lecture.vo.LectureVO"%>
<%-- <%@page import="kr.or.ddit.comm.vo.AtchFileVO"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LectureVO lv = (LectureVO) request.getAttribute("lv");

	/* List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의정보 변경</title>
</head>
<body>

	<form action="./update.do" method="post">
	<!-- enctype="multipart/form-data" 첨부파일 -->
		<input type="hidden" name="lecNo" value="<%=lv.getLecNo()%>"> 
		<%-- <input type="hidden" name="atchFileId" value="<%=lv.getAtchFileId()%>">  --%>
		<table>
			<tr>
				<td>강의번호:</td>
				<td><%=lv.getLecNo()%></td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="lecTitle" value="<%=lv.getLecTitle()%>"></td>
			</tr>
			<tr>
				<td>내용:</td>
			<td><textarea name="lecCont" ><%=lv.getLecCont()%></textarea></td>
			</tr>
			<tr>
				<td>가격:</td>
				<td><input type="text" name="price" value="<%=lv.getPrice()%>"></td>
			</tr>
			<tr>
				<td>정원:</td>
				<td><input type="text" name="lecMax" value="<%=lv.getLecMax()%>"></td>
			</tr>
			<%-- <tr>
			<td>기존 첨부파일</td>
			<td>
				<%if(atchFileList != null){ 
					for(AtchFileVO fileVO : atchFileList){
						
				%>
					<div>
						<a href="<%=request.getContextPath() %>/fileDownload.do?fileId=<%=fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn()%>"><%=fileVO.getOrignlFileNm()%></a>
					</div>
				<%
					} 
				}
					%>
			</td> 
		</tr>
		<tr>
			<td>신규 첨부파일</td>
			<td>
				<input type="file", name="atchFile" multiple="multiple"/>
			</td>
		</tr> --%>
		</table>
		<input type="submit" value="회원정보 수정">

	</form>
</body>
</html>