<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>AjaxRegisterFileForm</title>
</head>
<body>

	<h1>10. 파일 업로드 ajax 방식 요청 처리</h1> <hr/>
	
	<p>Ajax방식으로 전달한 하필 요소값을 스프링MVC가 지원하는 MultipartFile 매개변수로 처리
	
	<div>
		<input type="file" id="inputfile"/><hr/>
		<img id="preview"/>
		
	</div>
	
</body>

<script>
	
		$(function(){
			var inputFile = $("#inputfile");
			inputFile.on("change", function(event){
				
				console.log("change event...");
		 		var files = event.target.files;
				var file = files[0];
				
				console.log(file);
				
				if(isImageFile(file)){
					//비동기 처리시 파일데이터 전송할 때 formData()를 이용하여 데이터를 전송한다(매우 중요)
					var formData = new FormData();
					 formData.append("file", file);
					 
					 
					 // formData 	: key/value 형식으로 데이터 저장됨
					 // dataType	: 응답(response)에 대한 mime타입
					 // processData : 데이터 파라메터를 data라는 속성으로 넣는데 제어쿼리 내부적으로 쿼리스트링을 구성합니다
					 //					파일 전송의 경우 쿼리스트릥을 사용하지 않으므로 해당 설정을 false로 비활성화 합니다
					 // contentType	: content-Type을 설정시 사용하는데 해당 설정의 기본 값은 'application/x-www-form-urlencoded; charset=utf-8;
					 //					때문에 기본작으로 나가지 않고 multipart/form-data로 나갈 수 있도록 false로 설정
					 // request 요청에서 content-Type을 확인해보면 
					 //					multipart/form-data; boundary===WebkitFormBoundary[HashKey~~~~~]와 같이 전송된 것을 볼 수 있음
					 
					 $.ajax({
						 
						 type : "post",
						 url : "/ajax/uploadAjax",
						 data : formData,
						 dataType : "text",
						 processData : false,
						 contentType : false,
						 success : function(data){
							 alert(data);
							 
							 if(data === "UPLOAD SUCCESS"){
								 var file = event.target.files[0];
								 var reader = new FileReader();
								 reader.onload = function(e) {
									 $("#preview").attr("src", e.target.result);
								 }
								 reader.readAsDataURL(file);
							 }
						 }
					});
					 
				} else {
					alert("이미지 파일을 넣어주세요")
				}
				
			});
				
		});
			
		function isImageFile(file){
			var ext = file.name.split(".").pop().toLowerCase(); //파일명에서 확장자를 가져와서 소문자로 변경
			//확장자가 이미지 파일이 아닐경우 false리턴
			return ($.inArray(ext,["jpg","jpeg","png","gif"]) === -1 ) ? false : true;
		} 
		
	</script>
</html>