<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL PAGE</title>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css'
	integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN'
	crossorigin='anonymous'>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
</head>
<body>
	<main class="jumbotron mt-3">
		<section class="container">
				<div class="card">
					<div class="card-header">
						<b>${pb.name }</b>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							
							<tr>
								<th>이름</th>
								<td>${pb.name }</td>
							</tr>
							<tr>
								<th>극적</th>
								<td>${pb.nation }</td>
							</tr>
							<tr>
								<th>성별</th>
								<td>${pb.gender }</td>
							</tr>
							<tr>
								<th>닉네임</th>
								<td>${pb.nickName }</td>
							</tr>
							<tr>
								<th>성별</th>
								<td>${pb.gender }</td>
							</tr>
							<tr>
								<th>취미</th>
								<td>${pb.hobby }</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${pb.email }</td>
							</tr>
							<tr>
								<th>직업</th>
								<td>${pb.job }</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>${pb.address }</td>
							</tr>
							<tr>
								<th>우편번호</th>
								<td>${pb.zipCode }</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>${pb.phone1 }-${pb.phone2 }-${pb.phone3 }</td>
							</tr>
						</table>
					</div>
					<div class="card-footer">
						<button type="button" class="btn btn-default form-control" id="back">뒤로가기</button>
					</div>
				</div>
		</section>
	</main>
</body>
<script>
$('#back').on('click', function() {
	location.href='/test/addressBook.do';
})
</script>
</html>