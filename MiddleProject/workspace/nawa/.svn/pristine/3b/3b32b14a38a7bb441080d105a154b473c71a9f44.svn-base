<%@page import="lecture.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%-- <%@page import="kr.or.ddit.comm.vo.AtchFileVO"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LectureVO lv = (LectureVO) request.getAttribute("lv");

	//System.out.println(lv);
// 	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 정보 상세</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>튜터번호:</td>
			<td><%=lv.getTutNo()%></td>
		</tr>
		<tr>
			<td>제 목:</td>
			<td><%=lv.getLecTitle()%></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=lv.getLecCont()%></td>
		</tr>
		<tr>
			<td>강의번호:</td>
			<td><%=lv.getLecNo()%></td>
		</tr>
		<tr>
			<td>가격:</td>
			<td><%=lv.getPrice()%></td>
		</tr>
		<tr>
			<td>정원:</td>
			<td><%=lv.getLecMax()%></td>
		</tr>
		<tr>
			<td>현재인원:</td>
			<td><%=lv.getLecCnt()%></td>
		</tr>
		<%-- <tr>
			<td>첨부파일</td>
			<td>
				<%if(atchFileList != null){ 
					for(AtchFileVO fileVO : atchFileList){
						
				%>
					<div>
						<a href="/ServletExam/fileDownload.do?fileId=<%=fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn()%> "><%=fileVO.getOrignlFileNm() %></a>
					</div>
				<%
					} 
				}
					%>
			</td>
		</tr> --%>
		<tr>
			<td colspan="7">
			<a href="./list.do">[목록]</a>
			<a href="./update.do?lecNo=<%=lv.getLecNo()%>">[회원정보 수정]</a>
			<a href="./delete.do?lecNo=<%=lv.getLecNo()%>">[회원정보 삭제]</a>
			</td>
			
			
		</tr>
	</table>
</body>
</html>