package service;

import java.util.List;

import dao.ProdDAO;
import vo.Product;

public class ProdService {
	// 싱글톤 패턴을 만든다.
	private static ProdService instance = null;
	private ProdService() {}
	public static ProdService getInstance() {
		if(instance == null) 
			instance = new ProdService();
		return instance;
	}
	
	// Dao를 부른다 - 테이블 하나당 다오하나
	ProdDAO dao = ProdDAO.getInstance();
	
	public List<Product> prodList(List<Object> param) {
		return dao.prodList(param);
	}
	public List<Product> prodSearchList(List<Object> param) {
		return dao.prodSearchList(param);
	}
	
	
}
