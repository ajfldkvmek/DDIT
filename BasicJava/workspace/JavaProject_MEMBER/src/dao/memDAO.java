package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Admin;
import vo.Mem;

public class memDAO {
	private static memDAO singleTon = null;

	private memDAO() {
	};

	public static memDAO getInstance() {
		if (singleTon == null) {
			singleTon = new memDAO();
		}
		return singleTon;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

//	public List<Mem> list(String st, String ed) {
//		String sql =
//				"select * from bus\r\n" + 
//				"where st_bus = ? and ed_bus = ? \r\n" + 
//				"and de_time between sysdate and trunc(sysdate)+1\r\n" + 
//				"and not sit_no =0";
//		List<Object> param = new ArrayList();
//		param.add(st);
//		param.add(ed);
//		List<Map<String, Object>> list = jdbc.selectList(sql, param);
//		return ConvertUtils.convertToList(list, Mem.class);
//	}

	public List<Mem> memList() {
		String sql = "select * from mem where del = 0";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		return  ConvertUtils.convertToList(list, Mem.class);
	}
	
	
	public Mem memberLogin(String id, String pw) {
		String sql = "SELECT ID, PW FROM MEM WHERE ID = ? AND PW = ?";
		List<Object> param = new ArrayList<Object>();		
		param.add(id);
		param.add(pw);
		String mid = "";
		String mpw = "";
		Map result = jdbc.selectOne(sql, param);
		//해당 로그인 id pw로 불러온 정보가 null이 아니면 데이터 입력
		if(result != null) {
			mid = (String) result.get("ID");
			mpw = (String) result.get("PW");
		}
		
		Mem mem = new Mem();
		mem.setId(mid);
		mem.setPw(mpw);
		
		return mem;
	}

	public int signUp(List<Object> param) {
		
		String sql = "INSERT INTO MEM (no, id, pw, name, age)\r\n" + 
				"VALUES (SQ.nextval, ?, ?, ?, ?)";
		
//		List<Object> param = new ArrayList<Object>();
//		param.add(id); param.add(pw); param.add(name); param.add(age);
		
		return jdbc.update(sql, param);
	}

	public int pwUpdate(String id, String pw) {
		String sql = "UPDATE MEM\r\n" + 
				"SET pw = ?\r\n" + 
				"WHERE id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(pw);
		param.add(id);
		return jdbc.update(sql, param);
	}

	public int nameUpdate(String id, String name) {
		String sql = "UPDATE MEM\r\n" + 
				"SET name = ?\r\n" + 
				"WHERE id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(name);
		param.add(id);
		return jdbc.update(sql, param);
	}

	public int ageUpdate(String id, int age) {
		String sql = "UPDATE MEM\r\n" + 
				"SET age = ?\r\n" + 
				"WHERE id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(age);
		param.add(id);
		return jdbc.update(sql, param);
	}

	public int allUpdate(List<Object> param) {
		String sql = "UPDATE MEM\r\n" + 
				"SET pw = ?,\r\n" + 
				"    name = ?,\r\n" + 
				"    age = ?    \r\n" + 
				"WHERE id = ?";
			
		return jdbc.update(sql, param);
	}

	public int delete(List<Object> param) {
		String sql = "UPDATE MEM\r\n" + 
				"SET del = ?  \r\n" + 
				"WHERE id = ?";
		
		return jdbc.update(sql, param);
	}
}
