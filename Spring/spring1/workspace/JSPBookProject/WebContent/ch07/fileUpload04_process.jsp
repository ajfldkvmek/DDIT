<%@page import="com.itextpdf.text.pdf.PRAcroForm"%>
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
							String path="C:/upload";
							File tempFile = new File(path);
							
							if(!tempFile.exists()) {
								tempFile.mkdirs();
							}
							
							DiskFileUpload upload = new DiskFileUpload();
							
							//파일 최대 크기
							upload.setSizeMax(5*1024*1024);
							//메모리상 저장할 최대 크기
							upload.setSizeThreshold(4*1024*1024);
							//업로드된 파일을 입시로 저장할 경로
							upload.setRepositoryPath(path);
							
							List items = upload.parseRequest(request);		
							
							Iterator params = items.iterator();
							
							int maxSize = 4*1024*1024;
							
							while(params.hasNext()) {
								FileItem item = (FileItem) params.next();							
								
								//전송된 데이터가 일반 데이터면
								if(item.isFormField()) {
									
									String name=item.getFieldName();
									String value=item.getString("UTF-8");
									out.println(name+"="+value+"<br/>");
									
								} else {
									
									//요청 파라메터 이름
									String fileFieldName = item.getFieldName();
									
									//
									String fileName =	item.getName();
									
									String contentType = item.getContentType();
									
									long fileSize = item.getSize(); 
									
									File file = new File(path + "/" + fileName);
									
									if(maxSize < fileSize){
										out.println("사이즈 크기 초과<br/>");
									} else {
										item.write(file); //파일 복사
										out.println("-----------------------------<br/>");
										
										out.println("파라메터 이름: " +  fileFieldName + "<br/>");
										out.println("저정파일 이름: " +  fileName + "<br/>");
										out.println("파일 콘텐츠타입: " +  contentType + "<br/>");
										out.println("파일 크기: " +  fileSize + "<br/>");
									}
								}
							}
						%>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>