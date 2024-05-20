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
						
						<%	
							request.setCharacterEncoding("utf-8");
							String id = request.getParameter("id");
							String pw = request.getParameter("pw");
							String name = request.getParameter("name");
							String phone1 = request.getParameter("phone1");
							String phone2 = request.getParameter("phone2");
							String phone3 = request.getParameter("phone3");
							String gender = request.getParameter("gender");
							String hobby1 = request.getParameter("hobby1");
							String hobby2 = request.getParameter("hobby2");
							String hobby3 = request.getParameter("hobby3");
							
							
							
							if(hobby1 != null)
								hobby1 = "독서";
							if(hobby2 != null)
								hobby2 = "운동";
							if(hobby3 != null)
								hobby3 = "영화";
							
							String comment = request.getParameter("comment");
						%>
						
						<p>아이디: <%=id %></p>
						<p>비밀번호:	<%=pw %></p>
						<p>이름:	<%=name %></p>
						<p>연락처:	<%=phone1 %>-<%=phone2 %>-<%=phone3 %></p>
						<p>성별:	<%=gender %></p>
						<p>취미:	<%=hobby1 %>, <%=hobby2 %>, <%=hobby3 %></p>
						<!-- 브라우저 스펙에 따라 wrap="hard"속성에 따른 출력이 제대로 적용되지 않을 수 있어 css를 설정해줌 -->
						<p style="white-space: pre-wrap;">가입인사:	<%=comment %></p>
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>