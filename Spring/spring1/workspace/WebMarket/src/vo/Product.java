package vo;

public class Product {

	private String productId;	//상품 아이디
	private String pname;		//상품명
	private int unitPrice;		//가격
	private String description;	//설명
	private String manufacture;	//제조사
	private String category;	//분류
	private long unitsInStcok;	//재고
	private String condition;	//신상/중고/재생
	private String filename;	//이미지파일명
	private int quantity;		//장바구니 담은 갯수
	
	
	public Product() {
		super();
	}


	public Product(String productId, String pname, int unitPrice) {
		this.productId = productId;
		this.pname = pname;
		this.unitPrice = unitPrice;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getManufacture() {
		return manufacture;
	}


	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public long getUnitsInStcok() {
		return unitsInStcok;
	}


	public void setUnitsInStcok(long unitsInStcok) {
		this.unitsInStcok = unitsInStcok;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
