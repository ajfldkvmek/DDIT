package service;

import java.util.List;

import dao.BusDAO;
import dao.BusDao;
import vo.Bus;

public class BusServie {
	
	// 싱글톤 패턴을 만든다.
	private static BusServie instance = null;
	private BusServie() {}
	public static BusServie getInstance() {
		if(instance == null) 
			instance = new BusServie();
		return instance;
	}
	
	// Dao를 부른다 - 테이블 하나당 다오하나
	BusDao busdao = BusDao.getInstance();
	public List<Bus> printBusList() {
		return busdao.busList();
	}
//	public Bus bookDetail(int bookNo) {
//		return bookdao.bookDetail(bookNo);
//	}
	public List<Bus> list(String st, String dest) {
		return busdao.list(st, dest);
	}
	public Bus reserve(int select) {
		return busdao.reserve(select);
	}
	
}
