package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Member;

public class AdminDAO {
	private static AdminDAO singleTon = null;

	private AdminDAO() {
	};

	public static AdminDAO getInstance() {
		if (singleTon == null) {
			singleTon = new AdminDAO();
		}
		return singleTon;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	
}
