 package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.Admin;

public class adminDAO {
	private static adminDAO singleTon = null;

	private adminDAO() {
	};

	public static adminDAO getInstance() {
		if (singleTon == null) {
			singleTon = new adminDAO();
		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	
	public Admin adminLogin(String id, String pw) {
		String sql = "SELECT ID, PW FROM ADMIN WHERE ID = ? AND PW = ?";
		List<Object> param = new ArrayList<Object>();		
		param.add(id);
		param.add(pw);
		String aid = "";
		String apw = "";
		Map result = jdbc.selectOne(sql, param);
		//해당 로그인 id pw로 불러온 정보가 null이 아니면 데이터 입력
		if(result != null) {
			aid = (String) result.get("ID");
			apw = (String) result.get("PW");
		}
		
		Admin admin = new Admin();
		admin.setId(aid);
		admin.setPw(apw);;
		
		return admin;
	}
	
}
