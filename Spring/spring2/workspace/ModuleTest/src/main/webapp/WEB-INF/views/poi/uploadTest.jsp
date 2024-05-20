<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>엑셀업로드 테스트</title>
</head>
<body>

	<form id="form1" action="/poi/uploadExcel.do" method="post" enctype="multipart/form-data">
		<input type="file" id="fileInput" name="fileInput">
		
		<input type="submit" value="가라잇">
	</form>
	<div id="result"></div>
	
</body>
</html>