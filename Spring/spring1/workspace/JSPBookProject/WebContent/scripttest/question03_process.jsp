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
	<style type="text/css">
		table, tr, td {
			border : 1px solid black;
		}
	</style>
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
                        <li>CH01</li>
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
							request.setCharacterEncoding("UTF-8");
							String n = request.getParameter("nArr");
							/* String p = request.getParameter("pArr");
							String c = request.getParameter("cArr"); */
							
							/* String[] name = n.split(",");
							String[] price = p.split(",");
							String[] count = c.split(","); */
							//int sum = 0;
							
							System.out.println(n);
						%>
						
						<table class='table table-bordered text-center' width='100%' >
							<thead>
								<tr style='font-size:9px;'>
								<th id='menu'>메뉴명</th>
								<th id='quant'>수량</th>
								<th id='price'>금액</th></tr></thead>
							<tbody id='order-table'>
								
							<%-- <%
								for( int i = 0; i < name.length; i++) { %>
									<tr>
										<td><%=name[i] %></td>
										<td><%=count[i] %></td>
										<td><%=price[i] %></td>
									</tr>
								<% 
									//sum += Integer.parseInt(count[i])*Integer.parseInt(price[i]);
								}
								%> --%>
							
							</tbody></table>
							<h5>총 금액 : <font id=" + sum + "></font></h5>
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>