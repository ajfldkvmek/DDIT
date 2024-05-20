package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Book;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class BookDAO {
	// 싱글톤 패턴을 만든다. singleton
	private static BookDAO instance = null;
	private BookDAO() {}
	public static BookDAO getInstance() {
		if(instance == null) 
			instance = new BookDAO();
		return instance;
	}
	
	//DAO에서 JDBC유틸 뷰르기
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<Book> bookList() {
		String sql = "select no, name, pub, writer, content, sale_price from book";
		
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, Book.class);		
	}
	public Book bookDetail(int bookNo) {

		String sql = "select * from book where no = " + bookNo;
		Map<String, Object> l = jdbc.selectOne(sql);		
		return ConvertUtils.convertToVo(l, Book.class);		
	}
	public void bookDelete(int delNo) {
		String sql = "delete book where no = ?";
	}
}
