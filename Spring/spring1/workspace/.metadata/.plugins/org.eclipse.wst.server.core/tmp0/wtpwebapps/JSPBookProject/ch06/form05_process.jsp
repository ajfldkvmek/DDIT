<%@page import="java.util.Enumeration"%>
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
                        <li>CH06</li>
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
						<table class="table table-bordered">
							<tr>
								<th>요청 마라메터 이름</th>
								<th>요청 파라메터 값</th>
							</tr>
							
							<%
								request.setCharacterEncoding("utf-8");
							
								//getParameterNames()
								//모든 입력양식의 요청 파라메터 이름을 순서에 상관없이 enumration형태로 전달받음
								
								Enumeration paramNames = request.getParameterNames();
								
								while(paramNames.hasMoreElements()) {
									//nextElemet(): Enumeration 요소를 반환함
									//폼 페이지에서 전송된 요청 파라메터의 이름을 가져옴
									String name = (String) paramNames.nextElement();
									
									out.println("<tr><td>" + name + "</td>");
									
									//폼페이지에서 전송된 요청 파라메터의 값을 얻어옴
									String paramValue = request.getParameter(name);
									
									//name이 hobby인 요소는 같은 name의 데이터가 여러개이므로
									//별도의 처리로 진행한다
									//getParameter("hobby")로 값을 꺼내면 여러개의 데이터 중
									//1개의 데이터만 get
									//하여 getParamterValues를 이용하여 여러개의 데이터를 꺼낸 후
									//하나의 데이터로 가공
									if(name.equals("hobby")) {
										paramValue="";
										String[] hobbyArr =
												request.getParameterValues(name);
										for(int i = 0; i < hobbyArr.length; i++){
											paramValue += hobbyArr[i] + " ";
										}
									}
									
									out.println("<td>" + paramValue + "</td></tr>");
								}
							%>
						</table>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>