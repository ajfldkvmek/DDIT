package dao;

import java.util.List;

import util.JDBCUtil;

public class BookDAO {
	private static BookDAO singleTon = null;

	private BookDAO() {
	};

	public static BookDAO getInstance() {
		if (singleTon == null) {
			singleTon = new BookDAO();
		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
}
