package dao;

import java.util.ArrayList;

import vo.Product;

public class ProductRepository {

	private static ProductRepository instance = new ProductRepository();

	public static ProductRepository getInstance() {
		return instance;
	}

	private ArrayList<Product> listOfProduct = new ArrayList<Product>();

	public ProductRepository() {
		Product phone = new Product("p1234", "iphone 6s", 800000);

		phone.setDescription("4.7인치 어쩌고 저쩌고 ");
		phone.setCategory("smart phone");
		phone.setManufacture("APPLE");
		phone.setUnitsInStcok(1000);
		phone.setCondition("NEW");
		phone.setFilename("P1234.png");

		Product noteBook = new Product("p1235", "LG 그램", 1800000);

		noteBook.setDescription("13.3 인치 어쩌고 저쩌고 ");
		noteBook.setCategory("Notebook");
		noteBook.setManufacture("LG");
		noteBook.setUnitsInStcok(1000);
		noteBook.setCondition("Refurbished");
		noteBook.setFilename("P1235.png");

		Product tablet = new Product("p1236", "Galaxy tab s", 900000);

		tablet.setDescription("9인치 어쩌고 저쩌고 ");
		tablet.setCategory("Tablet");
		tablet.setManufacture("Samsung");
		tablet.setUnitsInStcok(1000);
		tablet.setCondition("Old");
		tablet.setFilename("P1236.png");
		
		listOfProduct.add(phone);
		listOfProduct.add(noteBook);
		listOfProduct.add(tablet);
		
	}
	
	//상춤 전체 가져올 메서드
	
	public ArrayList<Product> getAllProduct(){
		return listOfProduct;
	}
	
	//상품 id에 해당하는 상품 가져오기
	public Product getProductById(String productId) {
		
		Product product = null;
		
		for(int i = 0; i < listOfProduct.size(); i++) {
			Product prod = listOfProduct.get(i);
			if(prod != null && prod.getProductId() != null && prod.getProductId().equals(productId)) {
				product = prod;
				break;
			}
		}
		return product;
	}
	
	
	public void addProduct(Product product) {
		listOfProduct.add(product);
	}
	
	
}
