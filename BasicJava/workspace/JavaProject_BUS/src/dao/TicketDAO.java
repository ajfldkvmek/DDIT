package dao;

import util.JDBCUtil;

public class TicketDao {
	private static TicketDao singleTon = null;

	private TicketDao() {
	};

	public static TicketDao getInstance() {
		if (singleTon == null) {
			singleTon = new TicketDao();
		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
}
