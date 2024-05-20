<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>쉽게 배우는 JSP 웹 프로그래밍</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
	<%@ include file="/pageModule/headPart.jsp" %>
</head>
<body>
	<%@ include file="/pageModule/header.jsp" %>

    <div class="breadcrumbs" style="padding-top:40px;">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6 col-12">
                    <div class="breadcrumbs-content">
                        <h1 class="page-title">JSP 개요</h1>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-12">
                    <ul class="breadcrumb-nav">
                        <li><a href="/">INDEX</a></li>
                        <li>CH07</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <section class="about-us section">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-lg-12 col-md-12 col-12">
                    <div class="content-left wow fadeInLeft" data-wow-delay=".3s">
						<!-- 내용을 입력해주세요 -->
						<%
									
							//common-FileUpload를 이용하여 파일을 업로드 하려면 먼저
							//common-FileUpload에 포함되어 있는
							//DiskFileUpload파일 객체를 생성
							//DiskFileUpload 클래스가 제공하는 메소드를 사용하여
							//웹브라우저가 전송한 multipart/from-data 유형의 요청 파라메터를 가져온다
							//그리고 FileItem클래스의 메소드를 사용하여 요청 파라메터가 일반 데이터인지 파일인지 분석 및 처리하여 파일을 업로드한다
							
							
							String fileUploadPath = "C:\\upload";
						
							File tempFile = new File(fileUploadPath);
							if(!tempFile.exists()){ // 설정한 경로에 폴더가 없으면
								tempFile.mkdirs();
							}
							
							
							//폼페이지 에서 전송된 요청 파라메터를 전달받도록 DiskFileUpload
							//객체타입의 parseRequest 메소드 작성
							DiskFileUpload upload = new DiskFileUpload();
							List items = upload.parseRequest(request);
							
							//폼페이지에서 전송된 요청 파라메터를 iterator 클래스로 변환
							Iterator params = items.iterator();
							
							while(params.hasNext()){
								FileItem fileItem = (FileItem)params.next();
							
								if(!fileItem.isFormField()){ // 파일일 때
									String fileName = fileItem.getName();
								%>
									<p><%=fileName %>이 저장되었습니다!</p>
								<% 
									File file = new File(fileUploadPath + "/"+ fileName);
									fileItem.write(file);
								}%>
							<%} %>
							
							
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>