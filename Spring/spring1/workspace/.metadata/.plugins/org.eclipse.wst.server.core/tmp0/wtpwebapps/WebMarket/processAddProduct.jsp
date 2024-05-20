<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="vo.Product"%>
<%@page import="dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	//웹 앱 상의 절대경로
	String realFolder = request.getServletContext().getRealPath("/resources/images");	
	String encType = "UTF-8";
	int maxSize = 5*1024*1024;
	
	File file = new File(realFolder);

	if(!file.exists()) {
		file.mkdirs();
	}
	
	DiskFileUpload upload = new DiskFileUpload();
	upload.setSizeMax(1000000);
	upload.setSizeThreshold(maxSize);
	upload.setRepositoryPath(realFolder);
	List items = upload.parseRequest(request);
	Iterator params = items.iterator();
	
	/* 
	일반데이터 + 파일데이터 받을 때 방법
	*/
	String productId = "";
	String pname = "";
	String unitPrice = "";
	String description = "";
	String manufacture = "";
	String category = "";
	String unitsInStock = "";
	String condition = ""; 
	String fileName = "";
	
/* 	일반데이터 받을 때 방법
	String productId = request.getParameter("productId");
	String pname = request.getParameter("pname");
	String unitPrice = request.getParameter("unitPrice");
	String description = request.getParameter("description");
	String manufacture = request.getParameter("manufacture");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	String condition = request.getParameter("condition");
	*/
	
	
	while(params.hasNext()){
		FileItem item = (FileItem) params.next();
		
		if(item.isFormField()){
			String fieldName = item.getFieldName();
			if(fieldName.equals("productId")) productId = item.getString(encType);
			if(fieldName.equals("pname")) pname = item.getString(encType);
			if(fieldName.equals("unitPrice")) unitPrice = item.getString(encType);
			if(fieldName.equals("description")) description = item.getString(encType);
			if(fieldName.equals("manufacture")) manufacture = item.getString(encType);
			if(fieldName.equals("category")) category = item.getString(encType);
			if(fieldName.equals("unitsInStock")) unitsInStock = item.getString(encType);
			if(fieldName.equals("condition")) condition = item.getString(encType);
			
		} else { //파일일때
			String filefieldName = item.getFieldName();
			fileName = item.getName();
			String contentType = item.getContentType();
			long fileSize = item.getSize();
			File saveFile = new File(realFolder+"/"+fileName);
			item.write(saveFile);
		}
	}
	
	
	
	
	Integer price;
	if(unitPrice.isEmpty())
		price = 0;
	else 
		price = Integer.valueOf(unitPrice);
	
	long stock;
	if(unitsInStock.isEmpty())
		stock = 0;
	else 
		stock = Long.valueOf(unitsInStock);
	
	ProductRepository dao = ProductRepository.getInstance();
	
	//상품등록 페이지에 입력된 데이털르 가지고 등록할 상품을 만든다.
	Product newProduct = new Product();
	newProduct.setProductId(productId);
	newProduct.setPname(pname);
	newProduct.setUnitPrice(price);
	newProduct.setDescription(description);
	newProduct.setManufacture(manufacture);
	newProduct.setCategory(category);
	newProduct.setUnitsInStcok(stock);
	newProduct.setCondition(condition);
	newProduct.setFilename(fileName);
	
	dao.addProduct(newProduct);
	
	response.sendRedirect("products.jsp");
	
%>