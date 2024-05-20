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
        document.addEventListener("DOMContentLoaded", function() {
            var text;
            var tds = document.querySelectorAll("td");
            var mod = document.getElementById("mod");
            var ok = document.getElementById("ok");
            var del = document.getElementById("del");
            var output = document.getElementById("output");
            var modText = document.getElementById("modText");
            var chk = document.getElementById("chk");
            
            // 각 td를 클릭할 때마다 해당 td의 내용을 가져와 출력란에 표시
            tds.forEach(function(td) {
            	
                td.addEventListener("click", function() {
                	text = this.textContent;
                	if (chk.checked) {
                		 output.innerHTML += text;
                		 mod.style.display = "none";
                         del.style.display = "none";
                	} else {
                		output.textContent = text;
                        mod.style.display = "inline-block";
                        del.style.display = "inline-block";
                        ok.style.display = "none"; 
                	}
                });
            });

            // 수정 버튼 클릭 시 수정 폼 표시
            mod.addEventListener("click", function() {
                output.style.display = "none"; 
                modText.style.display = "inline-block"; 
                modText.value = text; 
                this.style.display = "none"; 
                ok.style.display = "inline-block"; 
            });

            // 확인 버튼 클릭 시 선택한 td의 내용 수정
			ok.addEventListener("click", function() {
				var newText = modText.value;
				tds.forEach(function(td) {
					if (td.textContent === text) {
						td.textContent = newText;
					}
				});
				output.textContent = newText;
				output.style.display = "inline-block";
				modText.style.display = "none";
				mod.style.display = "inline-block";
				this.style.display = "none";
			});

            // 삭제 버튼 클릭 시 선택한 td의 내용 삭제
            del.addEventListener("click", function() {
                tds.forEach(function(td) {
                    if (td.textContent === text) {
                        td.textContent = ""; // 선택한 td의 내용 삭제
                    }
                });
                output.textContent = ""; 
                output.style.display = "inline-block";
                modText.style.display = "none"; 
                mod.style.display = "inline-block";
                ok.style.display = "none";
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
							<table class="table table-bordered table-hover" width="100%" id="tb">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
								<tr>
									<td>10</td>
									<td>네이버웍스 비정기 업데이트 소식</td>
									<td>관리자</td>
									<td>2022-11-16</td>
									<td>1455</td>
								</tr>
								<tr>
									<td>9</td>
									<td>네이버웍스 일부 기능의 사양 변경 및 종료 안내</td>
									<td>관리자</td>
									<td>2022-11-15</td>
									<td>234</td>
								</tr>
								<tr>
									<td>8</td>
									<td>[프로모션 공지] 네이버웍스 X 워크플레이스 결합 서비스 신규 가입 20%추가 할인(~12.31)</td>
									<td>관리자</td>
									<td>2022-11-14</td>
									<td>23444</td>
								</tr>
								<tr>
									<td>7</td>
									<td>[중요] 네이버웍스 V3.5 정기 업데이트 소식</td>
									<td>관리자</td>
									<td>2022-11-13</td>
									<td>12466</td>
								</tr>
								<tr>
									<td>6</td>
									<td>[프로모션 사전 공지] 네이버웍스 X 워크플레이스 결합 서비스 20% 추가 할인</td>
									<td>관리자</td>
									<td>2022-11-12</td>
									<td>111</td>
								</tr>
								<tr>
									<td>5</td>
									<td>드라이브 서비스 DB 업그레이드 작업 사전 안내</td>
									<td>관리자</td>
									<td>2022-11-11</td>
									<td>2233</td>
								</tr>
							</table>
						</div>
						<hr/><br/>
						<div class="col-md-12 stretch-card grid-margin">
							<div class="card">
								<div class="card-body">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox" id="chk" value="Y"> 
										<label class="form-check-label" for="" chk"">append 여부</label>
									</div>
										<h6>선택한 td안에 있는 글자를 아래 P태그에 출력해주세요!</h6>
									<p id="output" class="text-info">출력란</p>
									<input style="display:none; width:1000px" name="modText" id="modText" type="text"><br/>
									<input style="display:none;" name="mod" id="mod" type="button" value="수정">
									<input style="display:none;" name="ok" id="ok" type="button" value="확인">
									<input style="display:none;" name="del" id="del" type="button" value="삭제">
								</div>
							</div>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	<%@ include file="/pageModule/footer.jsp" %>
	<%@ include file="/pageModule/footerPart.jsp" %>
	
	<script>
		
	</script>
	
</body>
</html>