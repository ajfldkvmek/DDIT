package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Board;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class MemberDAO {
	// 싱글톤 패턴을 만든다.
	private static MemberDAO instance = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) 
			instance = new MemberDAO();
		return instance;
	}
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public int loginMember(List<Object> param) {
		String sql = "select id, pw from member where id = ? and pw = ?";		
		return jdbc.update(sql, param);
	}
	
	
}
