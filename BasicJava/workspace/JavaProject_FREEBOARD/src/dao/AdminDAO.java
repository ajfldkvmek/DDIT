package dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Board;

public class AdminDAO {

	private static AdminDAO instance = null;
	private AdminDAO() {}
	public static AdminDAO getInstance() {
		if(instance == null) 
			instance = new AdminDAO();
		return instance;
	}
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int loginAdmin(List<Object> param) {
		String sql = "select id, pw from admin where id = ? and pw = ?";		
		return jdbc.update(sql, param);
	}
}
