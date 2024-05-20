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
							
							<!-- 구구단 출력 
								
								짝수 단이면 빨간색 출력
								출력기준은 가로 or 세로
								selectbox제공하고 그에 따라 출력
														
							-->
							<select id="guguSelect" onchange="gugu()">
								<option value="">선택</option>
								<option value="garo">가로</option>
								<option value="sero">세로</option>
							</select>
							
	                    </div>
	                    <%
	                    	//가로
	                    	out.print("<table id='garo' style='display: none;'>");
	                    	for(int a = 1; a < 10; a++) {
	                    		out.print("<tr>");
	                    		for(int b=1; b < 10; b++){
	                    			out.print("<td>");
	                    			if(a%2 == 0) { out.print("<span style='color: red;'>"); }
	                    			out.print(a + " * " + b + " = " + (a*b) + "&emsp;");
	                    			out.println("</span>");
	                    			out.println("</td>");
	                    			
	                    		}
	                    		out.print("</tr>");
	                    	}
	                    	out.print("</table>");
	                    
	                    	
	                    	
	                    	//세로
	                    	out.print("<table id='sero' style='display: none;'>");
	                    	for(int a = 1; a < 10; a++) {
	                    		out.print("<tr>");
	                    		for(int b=1; b < 10; b++){
	                    			out.print("<td>");
	                    			if(b%2 == 0) { out.print("<span style='color: red;'>"); }
	                    			out.print(b + " * " + a + " = " + (a*b) + "&emsp;");
	                    			out.println("</span>");
	                    			out.println("</td>");
	                    			
	                    		}
	                    		out.print("</tr>");
	                    	}
	                    	out.print("</table>");
	                    %>
	                    
	                    
	                    
	                </div>
	            </div>
	        </div>
	    </section>
	    
		<%@ include file="/pageModule/footer.jsp" %>
		<%@ include file="/pageModule/footerPart.jsp" %>
		
		<script>
		 function gugu() {
	            var selectedOption = document.getElementById("guguSelect").value;

	            // Hide all tables
	            document.getElementById("garo").style.display = "none";
	            document.getElementById("sero").style.display = "none";

	            // Show the selected table
	            if (selectedOption === "garo") {
	                document.getElementById("garo").style.display = "block";
	            } else if (selectedOption === "sero") {
	                document.getElementById("sero").style.display = "block";
	            }
	        }
		</script>
		
	</body>
	</html>