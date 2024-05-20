<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid px-2 px-md-4">
	<div class="page-header min-height-300 border-radius-xl mt-4"
		style="background-image: url('https://images.unsplash.com/photo-1531512073830-ba890ca4eba2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1920&q=80');">
		<span class="mask  bg-gradient-secondary opacity-6"></span>
	</div>
	<form class="card card-body mx-3 mx-md-4 mt-n6" id="boardForm" method="post" 
		action="/board/insert.do" enctype="multipart/form-data">
		<div class="row gx-4 mb-2">
			<div class="col-md-12">
				<div class="input-group input-group-outline mb-4">
					<input type="text" class="form-control" id="boTitle" name="boTitle" value="" placeholder="제목을 입력해주세요.">
				</div>
			</div>
			<div class="col-md-12">
				<div class="input-group input-group-outline mb-4">
					<textarea class="form-control" cols="50" rows="20" id="boContent" name="boContent"></textarea>
				</div>
			</div>
			<div class="col-md-12">
				<div class="input-group input-group-outline mb-4">
					<input type="file" class="form-control" id="boFile" name="boFile" multiple="multiple" />
				</div>
			</div>
			<div class="col-md-12"><br/></div>
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2">
						<div class="card">
							<div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
								<a class="d-block blur-shadow-image text-center">
									<img src="https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-1-min.jpg" alt="img-blur-shadow" class="img-fluid shadow border-radius-lg">
								</a>
								<div class="colored-shadow" style="background-image: url(&quot;https://demos.creative-tim.com/test/material-dashboard-pro/assets/img/products/product-1-min.jpg&quot;);"></div>
							</div>
							<div class="card-body text-center bg-white border-radius-lg p-3 pt-0">
								<h6 class="mt-3 mb-1 d-md-block d-none">
									파일명 (파일크기)
								</h6>
								<p class="mb-0 text-xs font-weight-bolder text-info text-uppercase">
									<button type="button" class="btn btn-primary btn-sm" title="삭제">
										delete
									</button>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<button type="button" class="btn btn-primary" id="insertBtn">등록</button>
				<button type="button" class="btn btn-danger" onclick="javascript:location.href='/board/detail.do?boNo=${board.boNo}'">취소</button>
				<button type="button" class="btn btn-info" onclick="javascript:location.href='/board/list.do'">목록</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("boContent", {
		filebrowserUploadUrl : "/imageUpload.do"
	});
	CKEDITOR.config.width = "100%";
	CKEDITOR.config.height = "400px";
	
	var insertBtn = $("#insertBtn");
	var boardForm = $("#boardForm");
	
	insertBtn.on("click", function(){
		var title = $("#boTitle").val();
		var content = CKEDITOR.instances.boContent.getData();
		
		if(title == null || title == ""){
			alert("제목을 입력해주세요!");
			return false;
		}
		
		if(content == null || content == ""){
			alert("내용을 입력해주세요!");
			return false;
		}
		
		boardForm.submit();
		
	});
	
	
	
	
});

</script>

