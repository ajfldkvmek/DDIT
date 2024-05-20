<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
</head>
<body>
	<h1>주소록</h1>
	<hr/>
	<div class="row">
		<div class="col-md-12">
			<h4>MENU GROUP</h4>
			<button type="button" class="btn btn-info" onclick="javascript:location.href='/test/addAddress.do'">등록</button>
		</div>
	</div>
	<hr/>
	<div class="row">
		<div class="col-md-8">
			<div class="row" style="height:80vh; overflow-y: scroll;" id="phoneBookArea">
				<c:forEach  var="phoenBook" items="${phoneBookList }" varStatus="status">
					<div class="col-md-4">
						<div class="card">
							<div class="card-header">
								<a href="/test/detail.do?index=${status.index }">${phoenBook.name }</a>
							</div>
							<div class="card-body">
								<table class="table table-bordered">
									<tr>
										<td>이름</td>
										<td>${phoenBook.name }</td>
									</tr>
									<tr>
										<td>성별</td>
										<td>${phoenBook.gender }</td>
									</tr>
									<tr>
										<td>전화번호</td>
										<td>${phoenBook.phone1 }-${phoenBook.phone2 }-${phoenBook.phone3 }</td>
									</tr>
									<tr>
										<td>직업</td>
										<td>${phoenBook.job }</td>
									</tr>
								</table>
							</div>
							<div class="card-footer">
								<button type="button" id="addBtn" name="addBtn" class="btn btn-primary" data-index="${status.index}">추가</button>
							</div>
						</div>
					</div>	
					
				</c:forEach>
					
			</div>
		</div>
		<div class="col-md-4" id="markedArea">
			<div class="card">
				<div class="card-header">즐겨찾기</div>
				<div class="card-body">
					<c:forEach  var="mark" items="${markList }" varStatus="status">
						[${mark.gender }]${mark.name } ${mark.phone1 }-${mark.phone2 }-${mark.phone3 } <button type="button" id="delBtn" name="delBtn" class="btn btn-sm btn-danger" data-index="${status.index}">삭제</button><br/> 
					</c:forEach>
				</div>
				<div class="card-footer">
					
				</div>
			</div> 
		</div>
	</div>
	
	<script>
		
	$(function(){
		
		
		$("#phoneBookArea").on("click", "button", function(){
			
			var phoneIndex = $(this).data("index");
			
			var data = {
					phoneIndex : phoneIndex
				}
			
			$.ajax({
				url : '/test/mark.do',
				type : 'post',
				data : JSON.stringify(data),
				contentType: 'application/json;charset=utf-8',
				
				success: function(res){
					updatePhoneBookArea(res.newPhoneBookList);
	                updateMarkedArea(res.newMarkList);
				}
			});
			
		});
		
		
		$("#markedArea").on("click", "button", function(){
					
					var phoneIndex = $(this).data("index");
					
					var data = {
							phoneIndex : phoneIndex
						}
					
					$.ajax({
						url : '/test/delete.do',
						type : 'post',
						data : JSON.stringify(data),
						contentType: 'application/json;charset=utf-8',
						
						success: function(res){
							updatePhoneBookArea(res.newPhoneBookList);
			                updateMarkedArea(res.newMarkList);
						}
					});
			 });
		
		
		function updatePhoneBookArea(phoneBookList) {
	        var html = '';
	        phoneBookList.forEach(function(phoneBook, index) {
	        	html += '<div class="col-md-4">';
	        	html += '<div class="card">';
	        	html += '<div class="card-header">' + phoneBook.name + '</div>' ;
	        	html += '<div class="card-body">';
	        	html += '<table class="table table-bordered">';
	        	html += '<tr><td>이름</td><td>' + phoneBook.name + '</td></tr>';
	        	html += '<tr><td>성별</td><td>' + phoneBook.gender + '</td></tr>';
	        	html += '<tr><td>전화번호</td><td>' + phoneBook.phone1 + '-' + phoneBook.phone2 + '-' + phoneBook.phone3 + '</td></tr>';
	        	html += '<tr><td>직업</td><td>' + phoneBook.job + '</td></tr>' ;
	        	html += '</table>';
	        	html += '</div>';
	        	html += '<div class="card-footer">';
	        	html +='<button type="button" id="addBtn" name="addBtn" class="btn btn-primary" data-index="' + index + '">추가</button>';
	        	html += '</div>' ;
	        	html += '</div>' ;
	        	html += '</div>';
	        });
	        
	        $("#phoneBookArea").html(html);
	    }

		
	    function updateMarkedArea(markList) {
	        var html = '';
	        markList.forEach(function(mark, index) {
	            html += '[' + mark.gender + '] ' + mark.name + ' ' + mark.phone1 + '-' + mark.phone2 + '-' + mark.phone3 +
	                '<button type="button" id="delBtn" name="delBtn" class="btn btn-sm btn-danger" data-index="' + index + '">삭제</button><br/>';
	        });
	        $("#markedArea .card-body").html(html);
	    }
		
		});
		
	</script>
</body>
</html>