<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<select class="form-control" id="selectImgType">
		<option value="all">전체</option>
		<option value="jpg">JPG</option>
		<option value="png">PNG</option>
		<option value="gif">GIF</option>
	</select>

	<hr />

	<div class="row" id="imageArea">
		<c:choose>
			<c:when test="${empty imageFileList }">
				<h1>이미지 파일이 존재하지 않습니다.</h1>
			</c:when>
			<c:otherwise>
				<c:forEach items="${imageFileList }" var="imageFile">
					<div class="col-md-3">
						<div class="card">
							<div class="card-header">${imageFile }</div>
							<div class="card-body">
								<img
									src="${pageContext.request.contextPath }/resources/image/${imageFile}"
									style="width: 200px;" />
							</div>
							<div class="card-footer">
								<a
									href="${pageContext.request.contextPath }/resources/image/${imageFile}"
									class="btn btn-primary" id="downloadFile">다운로드</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="modal fade" id="imageModal" tabindex="-1" aria-labelledby="imageModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-xl">
        <div class="modal-content">
            <div class="modal-body">
                <img src="<%=request.getContextPath() %>/resources/image/audio01.png" class="modal-thumbnail-img img-fluid" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    	</div>
	</div>

	<script>
   
	$(document).ready(function () {
        $("#selectImgType").on("change", function () {
            var ext = $(this).val();

            $.ajax({
                url: "/test_me/" + ext,
                type: "PUT",
                success: function (result) {
                	//alert(result)
                    displayImageCards(result);
                }
            });
        });

        function displayImageCards(imageFileList) {
            var imageArea = $("#imageArea");
            imageArea.empty();

            if (imageFileList.length === 0) {
                imageArea.append("<h1>이미지 파일이 존재하지 않습니다.</h1>");
                return;
            }
            
            $.each(imageFileList, function (index, imageFile) {
                var card = $("<div>").addClass("col-md-3")
                                     .append($("<div>").addClass("card")
                                                      .append($("<div>").addClass("card-header").text(imageFile))
                                                      .append($("<div>").addClass("card-body")
                                                                       .append($("<img>").attr("src", "${pageContext.request.contextPath }/resources/image/" + imageFile)
                                                                                         .attr("style", "width:200px;")))
                                                      .append($("<div>").addClass("card-footer")
                                                                       .append($("<a>").addClass("btn btn-primary")
                                                                                       .attr("href", "${pageContext.request.contextPath }/resources/image/" + imageFile)
                                                                                       .text("다운로드"))));
                imageArea.append(card);
                //
            });
        }
    });
	
	$(document).ready(function () {
		
		$(document).on("click", "#downloadFile", function (e) {
		    
			e.preventDefault();
			
			var realFile = $(this).attr('href').replace("/resources/image/", "");
		    
		    var fileObject = {
		    	realFile: realFile 
		    };

		    $.ajax({
		        url: "/test_me/downloadFile",
		        type: "GET",
		        data: fileObject,
		        //contentType: "application/json; charset=utf-8",
		        success: function (result) {
		        	var blob = new Blob([result], { type: "application/octet-stream" });
	                var url = window.URL.createObjectURL(blob); 
	                var a = document.createElement('a'); 
	                a.href = url; 
	                a.download = "downloaded_file.zip";
	                document.body.appendChild(a); 
	                a.click(); 
	                window.URL.revokeObjectURL(url); 
	                document.body.removeChild(a);  
		        },
		        error: function (xhr, status, error) {
	                console.error(xhr, status, error);
	            }
		    });
		});
		
	});
	
	function down(data){
		var blob = new Blob([data], { type: "application/octet-stream" });
        var url = window.URL.createObjectURL(blob); 
        var a = document.createElement('a'); 
        a.href = url; 
        a.download = "downloaded_file.zip";
        document.body.appendChild(a); 
        a.click(); 
        window.URL.revokeObjectURL(url); 
        document.body.removeChild(a); 
	}
	
</script>

</body>
</html>