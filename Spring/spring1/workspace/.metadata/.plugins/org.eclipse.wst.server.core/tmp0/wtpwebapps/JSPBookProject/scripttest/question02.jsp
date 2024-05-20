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
	
	<script>
	$(function() {
 		var html = "";
		var ele1 = null;
		var ele2 = null;
		
		var print = $("#process");
		
 		$("td").on("click", function(){
			
			if(ele1 == null || ele2 == null){
				
				if(ele1 == null) {
					ele1 = $(this);
					ele1.css("background-color", "yellow");
				} else {
					ele2 = $(this);
					ele2.css("background-color", "yellow");
					print.html(ele1.text() + "님과 " + ele2.text() + "님을 변경");
					var temp = ele1.text();
					ele1.text(ele2.text());
					ele2.text(temp);
					
					ele1.css("background-color", "transparent");
					ele2.css("background-color", "transparent");
					
					ele1 = null;
					ele2 = null;
				}
			} 
		});
		
 		//animation: blink-effect 1s step-end infinite;
 		//animation: textLoop 10s linear infinite;
/* 		$("#clickBtn").on("click", function(){
		    var table = $("table");
		    //.css('animation', 'blink-effect 1s step-end infinite')
		    table.find("td:contains('김현태')").css( {"color": "blue", "animation": "textLoop 10s linear infinite;"} );
		    var tt = "<table class='table table-bordered' style='text-align:center; font-size:24px;'>" + table.html() +"</table>";
		    table.find("td:contains('김현태')").css("color", "black");
		    //tt.find("td:contains('김현태')").css("color", "blue");
		    //console.log(tt);
		    $("#output").html( tt );
		}); */
		
		
 		// 출력 버튼 클릭시(현재 앉은 자리 출력 위한 이벤트)
 		$("#clickBtn").on("click", function(){
 			$("#output").html("");
 			var tds = document.getElementsByTagName("td");
 			var html = "<table class='table table-bordered' style='text-align:center; font-size:24px;'><tr>";
 			for(var i = 1; i <= tds.length; i++){
 				if(tds[i-1].innerText == "김현태"){
 					html += "<td width='10%'><marquee><font color='blue'>"+tds[i-1].innerText+"</font></marquee></td>";	
 				}else{
 					html += "<td width='10%'>" + tds[i-1].innerText + "</td>";
 				}
 				if(i % 9 == 0){
 					html += "</tr>";
 				}
 			}
 			html += "</table>";
 			$("#output").html(html);
 		});
	});
		
		
	</script>
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
						<div class="table-responsive">
							<caption>앞(SEM PC 자리)</caption>
							<table class="table table-bordered" style="text-align:center; font-size:24px;">
								<tr height="80px">
									<td width="10%">민경선</td>
									<td width="10%">성이수</td>
									<td width="10%">이명문</td>
									<td width="10%">조재훈</td>
									<td width="20%"></td>
									<td width="10%">최윤서</td>
									<td width="10%">안희재</td>
									<td width="10%">권예은</td>
									<td width="10%"></td>
								</tr>
								<tr height="80px">
									<td>신하림</td>
									<td>이영주</td>
									<td>김나혜</td>
									<td>김영상</td>
									<td></td>
									<td>최현명</td>
									<td>최소희</td>
									<td>홍진영</td>
									<td>임민혁</td>
								</tr>
								<tr height="80px">
									<td>김다애</td>
									<td>송현지</td>
									<td>김현태</td>
									<td>김태원</td>
									<td></td>
									<td>이수진</td>
									<td>선민수</td>
									<td>서어진</td>
									<td></td>
								</tr>
								<tr height="80px">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>백지은</td>
									<td>최현흠</td>
									<td></td>
								</tr>
							</table>
						</div>
						<p id="count"></p>
						<h4 id="process"></h4>
						
						<hr/><br/>
						<button type="button" class="btn btn-primary" id="clickBtn">출력</button>
						<div id="output"></div>
						
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>

	<%@ include file="/pageModule/footerPart.jsp" %>
</body>
</html>