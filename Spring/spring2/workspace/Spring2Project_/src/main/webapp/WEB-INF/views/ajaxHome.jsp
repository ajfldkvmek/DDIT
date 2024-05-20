<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h3>Ajax Home</h3>
	
	<hr/>
	<br/>
	
	<form>
		 boardNo: <input type="text" name="boardNo" id="boardNo"/><br/>
		 title: <input type="text" name="title" id="title"/><br/>
		 content: <input type="text" name="content" id="content"/><br/>
		 writer: <input type="text" name="writer" id="writer"/><br/>
		 <input type="button" id="btn" value="전송"/>
	</form>
	
	<div>
		<h4>Headers 매핑</h4>
		<button id="putBtn">Modify(PUT)</button>
		<button id="putHeaderBtn">Modify(PUT With Header)</button>
		
		
		<br/><hr/>
		
		<h4>Content Type 매핑</h4>
		<button id="postBtn">postBtn(POST)</button>
		<button id="putJsonBtn">putJsonBtn(PUT JSON)</button>
		<button id="putXmlBtn">putXmlBtn(PUT XML)</button>
		
		
		<br/><hr/>
		
		<h4>Content Type 매핑</h4>
		<button id="getBtn">getBtn(POST)</button>
		<button id="getJsonBtn">getJsonBtn(PUT JSON)</button>
		<button id="getXmlBtn">getXmlBtn(PUT XML)</button>
		
		
	</div>
	
	
<script type="text/javascript">

$(function() {
	
	var putBtn = $("#putBtn");
	var putHeaderBtn = $("#putHeaderBtn");
	
	//contentTYpe 매핑 명역
	var postBtn = $("#postBtn");
	var putJsonBtn = $("#putJsonBtn");
	var putXmlBtn = $("#putXmlBtn");
	
	var getBtn = $("#getBtn");
	var getJsonBtn = $("#getJsonBtn");
	var getXmlBtn = $("#getXmlBtn");
	
	
	putBtn.on("click" ,function(){
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				
				boardNo: boardNo,
				title: title,
				content: content,
				writer: writer
		}
		
		$.ajax({ //비동기 처리 준비
			type: "put",
			url: "/board/" + boardNo,
			data: JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success: function(result){
				console.log("result: " + result);
				
				// == : equals operator , === : strict equal operator (값을 더 엄격하게 비교할 때 사용)
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		})
	});
	
	putHeaderBtn.on("click", function() {

		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();

		var boardObject = {
			boardNo : boardNo,
			title : title,
			content : content,
			writer : writer
		}
		
		
		$.ajax({
			url : "/board/"+boardNo,
			type: "put",
			data: JSON.stringify(boardObject),
			headers: {
				"X-HTTP-Method-Override" : "PUT"
			},
			contentType: "application/json; charset=utf-8",
			success: function(result){
				console.log("result:  " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
		
	});
	
	
	postBtn.on("click", function(){
		
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		 
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
			}
		
		$.ajax({
			type: "post",
			url : "/board/"+boardNo,
			data: JSON.stringify(boardObject),
			contentType: "application/json; charset=utf-8",
			success: function(result){
				console.log("result:  " + result);
				if(result === "SUCCESS"){
					alert(result);
				}
			}
		});
	});
	
	putJsonBtn.on("click", function(){
		
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNo,
				title : title,
				content : content,
				writer : writer
			}
		
		$.ajax({
		
			url: "/board/"+boardNo,
			type: "put",
			data: JSON.stringify(boardObject),
			contentType: "application/json; charset=utf-8",
			
			success: function(result){
				console.log("구아아아ㅏㄱ");
				if(reuslt==="SUCCESS") {
					alert(result);
				}
			}
		});
		
	});
	
	putXmlBtn.on("click", function(){
		
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var xmlData = "";
		xmlData += "<Board>";
		xmlData += "<boardNo>" + boardNo + "</boardNo>";
		xmlData += "<title>" + title + "</title>";
		xmlData += "<content>" + content + "</content>";
		xmlData += "<writer>" + writer + "</writer>";
		xmlData += "</Board>";
		
		$.ajax({
		
			url: "/board/"+boardNo,
			type: "put",
			data: xmlData,
			contentType: "application/xml; charset=utf-8",	
			success: function(result){
				console.log("구아아아ㅏㄱ");
				if(result==="SUCCESS") {
					alert(result);
				}
			}
		});
	});
	
	getBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		//GET 방식 비동기 HTTP 요청 수행
		$.get("/board/"+boardNo, function(data){
			console.log("data>>> " + data);
			alert(JSON.stringify(data));
		})
	})
	
	getJsonBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type: "get",
			url: "/board/"+boardNo,
			headers: {
				"Accpet" : "application/json"
			},
			success: function(result){
				console.log("result>>>>" + result)
				alert(JSON.stringify(result));
			}
		})
	})
	
	getXmlBtn.on("click", function(){
		var boardNo = $("#boardNo").val();
		
		$.ajax({
			type: "get",
			url: "/board/"+boardNo,
			headers: {
				"Accpet" :"application/xml"
			},
			success: function(result){
				console.log("result>>> " +  result);
				//alert(result);
				alert(xmlToString(result));
			}
		});
	});
});

function xmlToString(xmlData) {
	
	var xmlString;
	
	//window.ActiveXObject는 activeX 를 지원하는 브라우저인지 확인하고 지원할 경우 Object를 리턴하고
	//그렇지 않으면 null 리턴
	if(window.ActiveXObject) {
		xmlString = xmlData.xml;
	} else {
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}

</script>
</body>
</html>