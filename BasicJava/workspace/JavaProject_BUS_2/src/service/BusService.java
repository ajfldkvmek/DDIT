package service;

import java.util.List;

import dao.BusDao;
import vo.Bus;

public class BusService {
	private static BusService singleTon = null;

	private BusService() {
	};

	public static BusService getInstance() {
		if (singleTon == null) {
			singleTon = new BusService();
		}
		return singleTon;
	}
	
	BusDao busdao = BusDao.getInstance();

	public List<Bus> list(String st, String ed) {
		return busdao.list(st, ed);
	}
	
}
