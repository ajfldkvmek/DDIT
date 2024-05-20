package service;

import java.util.List;

import dao.ProdDAO;
import vo.Cart;
import vo.Product;

public class ProdServie {
	
	// 싱글톤 패턴을 만든다.
	private static ProdServie instance = null;
	private ProdServie() {}
	public static ProdServie getInstance() {
		if(instance == null) 
			instance = new ProdServie();
		return instance;
	}
	
	// Dao를 부른다 - 테이블 하나당 다오하나
	ProdDAO prodDAO = ProdDAO.getInstance();
//	CartDAO cartDAO = CartDAO.getInstance();
	
	public boolean prodAdd(List<Object> param) {
		int result = prodDAO.prodAdd(param);
		
		if(result == 0) return false;
		else return true;
	}	
	public List<Product> printProdList() {
		return prodDAO.printProdList();
	}
//	public Product bookDetail(int bookNo) {
//		return bookdao.bookDetail(bookNo);
//	}
//	public void bookDel(int delNo) {
//		bookdao.bookDelete(delNo);
//	}

	public boolean nameEdit(List<Object> param) {
		int result = prodDAO.nameEdit(param);
		if(result == 0) return false;
		else return true;
	}
	public boolean priceEdit(List<Object> param) {
		int result = prodDAO.priceEdit(param);
		if(result == 0) return false;
		else return true;
	}
	public boolean countEdit(List<Object> param) {
		int result = prodDAO.countEdit(param);
		if(result == 0) return false;
		else return true;
	}
	public boolean textEdit(List<Object> param) {
		int result = prodDAO.textEdit(param);
		if(result == 0) return false;
		else return true;
	}
	public boolean allEdit(List<Object> param) {
		int result = prodDAO.allEdit(param);
		if(result == 0) return false;
		else return true;
	}
	
	public boolean delete(List<Object> param) {
		int result = prodDAO.delete(param);
		if(result == 0) return false;
		else return true;
	}
	public boolean buy(List<Object> param) {
		int result = prodDAO.buy(param);
		
		if(result == 0) return false;
		else return true;
	}
	
	public List<Cart> printBuyList(List<Object> param) {
		return prodDAO.printBuyList(param);
	}
	public List<Cart> cartList(List<Object> param) {
		return prodDAO.cartList(param);
	}
	public boolean buyCart(List<Object> param) {
		int chk = prodDAO.buyCart(param);
		if(chk == 0) return false;
		else return true;
	}

}
