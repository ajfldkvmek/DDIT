package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Product;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class ProdDAO {
	// 싱글톤 패턴을 만든다.
	private static ProdDAO instance = null;
	private ProdDAO() {}
	public static ProdDAO getInstance() {
		if(instance == null) 
			instance = new ProdDAO();
		return instance;
	}
	
	//DAO에서 JDBC유틸 뷰르기
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<Product> prodList(List<Object> param) {
		String sql = "select *\r\n" + 
				"from (select ROWNUM rnum, A.*\r\n" + 
				"        from(select no, name, price, substr(text,0,5) text,\r\n" + 
				"            count, to_char(reg, 'YYYY.MM.DD') reg\r\n" + 
				"            from prod) A\r\n" + 
				"    )\r\n" + 
				"where rnum >= ? and rnum <= ?";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		
		return ConvertUtils.convertToList(l, Product.class);
	}
	
	public List<Product> prodSearchList(List<Object> param) {
		String sql = "select no, name, price, substr(text,0,5),\r\n" + 
				"            count, to_char(reg, 'YYYY.MM.DD') reg\r\n" + 
				"            from prod\r\n" + 
				"            where name like '%'||?||'%'";
		
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, Product.class);
	}
}
