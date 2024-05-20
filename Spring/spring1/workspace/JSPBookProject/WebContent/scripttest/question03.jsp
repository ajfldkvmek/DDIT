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
	
		let nn = document.getElementById("nArr");
		let pp = document.getElementById("pArr");
		let cc = document.getElementById("cArr");
		
		let form = document.getElementById('frm');
		
		var nameArr = []
		var priceArr = []
		var countArr = []
		
		var table = "";
		var ss ="";
		
		$(function(){
			
			$("td").on("click",function(){
				
					var tr = $(this);
					
					var name = tr.children('p:eq(0)').text(); 
					var price = parseInt(tr.children('code:eq(0)').text()); 
					
					if(nameArr.indexOf(name) < 0) {
						nameArr.push(name);
						priceArr.push(price);
						var size = nameArr.length - 1;
						countArr[size] = 1;
					} else {
						countArr[nameArr.indexOf(name)]+=1;
					}  
					
					str = "<tr>";
					sum = 0;
					for(var i = 0; i < nameArr.length; i++){
						
						str += "<td>"+ nameArr[i]  +"</td>"
						str += "<td>"+ countArr[i]  +"</td>"
						str += "<td>"+ priceArr[i]  +"</td></tr>"
						
						sum += countArr[i]*priceArr[i];
						
						table += str;
					}
					$("#order-table").html(str);
					$("#total").html(sum)
			});

			$("#orderBtn").on("click", function(){
				/* ss = "<table class='table table-bordered text-center' width='100%' ><thead>"
							+"<tr style='font-size:9px;'>"
							+"<th id='menu'>메뉴명</th>"
							+"<th id='quant'>수량</th>"
							+"<th id='price'>금액</th></tr></thead>"
							+"<tbody id='order-table'>"
							+ table
							+"</tbody></table>"
							+"<h5>총 금액 : <font id=" + sum + "></font></h5>"; */

			/* 	nn.value = nameArr;
				pp.value = priceArr;
				cc.value = countArr;  */
				
				alert(nameArr);
				/* nn.val(nameArr);
				pp.val(priceArr);
				cc.val(countArr); */
				
				form.submit();
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
						<div class="card">
							<div class="card-body">
								<p class="card-title text-info">DAEDEOK COFFEE MENU</p>
								
								<div class="row">
									<div class="col-md-4 grid-margin grid-margin-md-0 stretch-card">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">COFFEE & ESPRESSO</h4>
												<ul class="list-ticked">
													<li>
														스타벅스 돌체 라떼 <code class="text-primary">5600</code>원
													</li>
													<li>
														화이트 초콜릿 라떼 <code class="text-primary">5600</code>원
													</li>
													<li>
														카라멜 마끼아또 <code class="text-primary">5600</code>원
													</li>
													<li>
														볼론드 에스프레소 라떼 <code class="text-primary">5600</code>원
													</li>
													<li>
														카페 모카 <code class="text-primary">5100</code>원
													</li>
													<li>
														카푸 치노 <code class="text-primary">4600</code>원
													</li>
													<li>
														카페 라떼 <code class="text-primary">4600</code>원
													</li>
													<li>
														오늘의 커피 <code class="text-primary">3800</code>원
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-md-4 grid-margin grid-margin-md-0 stretch-card">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">TEAVANA</h4>
												<ul class="list-arrow">
													<li>
														제주 유기농 말차로 만든 라떼 <code class="text-primary">6100</code>원
													</li>
													<li>
														유자 민트 티 <code class="text-primary">5600</code>원
													</li>
													<li>
														라임 패션 티 <code class="text-primary">5600</code>원
													</li>
													<li>
														자몽 허니 블랙 티 <code class="text-primary">5100</code>원
													</li>
													<li>
														차이 티 라떼 <code class="text-primary">5100</code>원
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-md-4 grid-margin grid-margin-md-0 stretch-card">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">DAEDEOK FIZZIO</h4>
												<ul class="list-star">
													<li>
														요거트 주스 & 망고 젤리 피지오 <code class="text-primary">6100</code>원
													</li>
													<li>
														쿨 라임 피지오 <code class="text-primary">6600</code>원
													</li>
													<li>
														패션 망고 티 레모네이드 피지오 <code class="text-primary">7100</code>원
													</li>
													<li>
														그린 티 레모네이드 피지오 <code class="text-primary">7100</code>원
													</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-8 grid-margin grid-margin-md-0 stretch-card">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">주문 진행표</h4>
												<div class="table-responsive">
													<table class="table table-bordered text-center" width="100%">
														<tr height="100px">
															<td width="20%">
																<p>돌체 라떼<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>화이트<br/>초콜릿 라떼<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>카라멜<br/>마끼아또<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>볼론드<br/>에스프레소 라떼<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>카페모카<br/></p>
																<code class="text-primary">5100</code>
															</td>
														</tr>
														<tr height="100px">
															<td width="20%">
																<p>카푸치노<br/></p>
																<code class="text-primary">4600</code>
															</td>
															<td width="20%">
																<p>카페 라떼<br/></p>
																<code class="text-primary">4600</code>
															</td>
															<td width="20%">
																<p>오늘의 커피<br/></p>
																<code class="text-primary">3800</code>
															</td>
															<td width="20%">
															</td>
															<td width="20%">
															</td>
														</tr>
														<tr height="100px">
															<td width="20%">
																<p>제주 유기농<br/>말차로<br/>만든 라떼<br/></p>
																<code class="text-primary">6100</code>
															</td>
															<td width="20%">
																<p>유자<br/>민트 티<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>라임<br/>패션 티<br/></p>
																<code class="text-primary">5600</code>
															</td>
															<td width="20%">
																<p>자몽 허니<br/>블랙 티<br/></p>
																<code class="text-primary">5100</code>
															</td>
															<td width="20%">
																<p>차이<br/>티 라떼<br/></p>
																<code class="text-primary">5100</code>
															</td>
														</tr>
														<tr height="100px">
															<td width="20%">
																<p>망고 젤리<br/>피지오<br/></p>
																<code class="text-primary">6100</code>
															</td>
															<td width="20%">
																<p>쿨<br/>라임 피지오<br/></p>
																<code class="text-primary">6600</code>
															</td>
															<td width="20%">
																<p>레모네이드<br/>피지오<br/></p>
																<code class="text-primary">7100</code>
															</td>
															<td width="20%">
																<p>그린 티<br/>피지오<br/></p>
																<code class="text-primary">7100</code>
															</td>
															<td width="20%">
															</td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-4 grid-margin grid-margin-md-0">
										<div class="card">
											<div class="card-body">
												<h4 class="card-title">주문 내역</h4>
												<br/>
												<h6 id="ord-id">A-001</h6>
												<div class="table-responsive">
													<table class="table table-bordered text-center" width="100%" >
														<thead>
															<tr style='font-size:9px;'>
																<th id="menu">메뉴명</th>
																<th id="quant">수량</th>
																<th id="price">금액</th>
															</tr>
														</thead>
														<tbody id="order-table">
														
														</tbody>
													</table>
												</div>
												<div>
													<h5>총 금액 : <font id="total"></font></h5>
													<hr/>
													<button class="btn btn-primary" id="orderBtn">주문하기</button>
												</div>
												<form id="frm" method="post" action="question03_process.jsp">
													<input type="hidden" name="dataArr" id="nArr"/>
													<input type="hidden" name="dataArr" id="pArr"/>
													<input type="hidden" name="dataArr" id="cArr"/>
												</form>
											</div>
										</div>
									</div>
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