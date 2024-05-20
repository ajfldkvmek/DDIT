
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>쉽게 배우는 JSP 웹 프로그래밍</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="/pageModule/headPart.jsp"%>
</head>
<body>
	<%@ include file="/pageModule/header.jsp"%>

	<div class="breadcrumbs" style="padding-top: 40px;">
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
						<li>CH02</li>
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


						<select id="orderSelect">
							<option value="">선택</option>
							<option value="1">가로</option>
							<option value="2">세로</option>
						</select>

					</div>
					
					<%
					String color = "";
					out.println("<table class='table table-border'>");
					for (int i = 1; i < 10; i++) {
						out.print("<tr align='center'>");
						for (int j = 1; j < 10; j++) {
							if (i % 2 == 0) {
						color = "red";
							} else {
						color = "black";
							}
							out.println("<td><font-color='" + color + "'>" + (i) + "x" + (j) + "=" + (i * j) + "</font></td>");
						}
						out.println("</tr>");
					}
					out.println("</table>");
					%>



				</div>
			</div>
		</div>
	</section>

	<%@ include file="/pageModule/footer.jsp"%>
	<%@ include file="/pageModule/footerPart.jsp"%>

	<script>
		$(function(){
			var orderSelect = $("#orderSelect");
			
			$("#t1").css("transform", "scale(1)");
			$("#t2").css("transform", "scale(1)");
			
			orderSelect.on("change", function(){
				var value = $(this).val();
				
				if(value == '1'){
					$("#t1").show();
					$("#t1").css("transform", "scale(1.05)").css("transition", ".8s");
					$("#t2").hide();
				} else {
					$("#t2").show();
					$("#t2").css("transform", "scale(1.05)").css("transition", ".8s");
					$("#t1").hide();
				}
			})
		})
	</script>

</body>
</html>