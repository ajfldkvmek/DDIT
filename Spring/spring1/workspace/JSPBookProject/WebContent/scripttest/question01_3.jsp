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
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	
	
	<script>

	$(function() {
 		var html = "";
		var ele = null;
		$("td").on("click", function(){
			
			ele = $(this); //현재 클릭한 td Element 담아두기
			
			var chkVal = $("#chk:checked").val();
			
			if(chkVal == "Y"){
				html += ele.text() + "<br/>";
			} else {
				html = "";
				html += "<p id = 'p'>" + ele.text() + "</p>";
				html += "<button class='btn btn-warning' id = 'udtBtn'>수정</button>";
				html += "<button class='btn btn-danger' id = 'delBtn'>삭제</button>";
			}
			$("#output").html(html);
		});
		
		
		/* 		
	 	$("#udtBtn").on("click", function(){
			처럼하며 안되고
		}); 
		*/
		//아래처럼 해야함
		
		$('#output').on("click","#udtBtn", function(){
		var text = $(this).text();	// 버튼 text
		
		//	동적으로 생성된 수정버튼을 클릭하게 되면 수정 버튼은 확인버튼으로 변경되고 수정 될 준비를 한다.
		//	수정이 완료되면 다시 수정버튼으로 활성화되어 수정을 할 수 있도록 버튼이 변경된다.
		if(text == "수정"){
			// 출력란에 출력된 텍스트르 가져온다.
			var pText = $("#output").find("#p").text();
			// 가져온 텍스트를 input 입력 요소에 담기 위한 준비
			$("#p").html("<input type='text' class='form-control' id='pText' value='"+pText+"'/>");
			$(this).text("확인");// 버튼 텍스트를 수정에서 확인으로 변경한다.
		}else{	// 동적으로 생성된 확인 버튼을 클릭 했을 때
			// input 입력 요소에 value인 text를 가져와 p태그에 출력
			$("#p").html($("#output").find("#pText").val());
			// 수정된 텍스트가 있는 p태그 내의 텍스트를 가져와 td요소를 클릭했을 때 담아뒀던 Element에 출력
			ele.html($("#output").find("#p").text());
			$(this).text("수정");// 버튼의 text를 수정으로 변경한다.
			html = "";	// 담아웠던 텍스트 초기화
		}
	});
/* 		$("#output").on("click", "#udtBtn", function(){
			var text = $(this).text(); //버튼text
			
			//동적으로 생성된 수정 버튼을 클릭하게 되면 수정 버튼은 확인버튼으로 변경되고 수정이 될 준비를 한다
			//수정이 완료되면 다시 수정버튼으로 활성회되어 수정을 할 수 있도록 버튼이 변경된다
			if(text == "수정"){
				//출력란에 출력된 텍스트를 가져옴
				var pText = $("#output").find("#p").text();
				//가져온 텍스트를 input입력 요소에 담기위한 준비
				$("#p").html("<input type='text' class='form-control' id='pText' value='" + pText +"'/>");
				$(this).text("확인");//버튼의 텍스트를 수정에서 확인으로 변경
			} else {
				//동적으로 생성된 확인 버튼을 클릭했을 때
				//input입력 요소에 value인 text가져와서 p태그 출력
				$("#p").html($("#output").find("#pText").val());
				ele.html($("#ouput").find("#p").text()); //수정된 텍스트가 있는 p태그 내의 텍스트를 가져와 td요소를 클릭했을 때 담아뒀던 element에 출력
				$(this).text("수정");//버튼의 text를 수정으로 변경
				html = ""; // html초기화
			}
		}); */


		$("#output").on("click", "#delBtn", function(){
			$("#output").find("#p").html("");	//출력란의 p태그 초기화
			ele.html(""); //선택된 td element 초기화
		});
		
		// append 체크 이벤트
		// append 체크 이벤트가 발생했을 때 html 변수를 ""으로 처리해준다
		$("#chk").on("change", function(){
			html="";
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
							<table class="table table-bordered table-hover" id="tbl" width="100%" id="tb">
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
									<!-- <input type="text" id="input" value="" class="form-control"/> -->
									<p id="output" class="text-info">출력란
									</p>
<!-- 									<div id="btn-area">
										<input type="button" id="mod" value="수정" class="btn btn-primary"/>
										<input type="button" id="del" value="삭제" class="btn btn-warning"/>
									</div> -->
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
</body>
</html>