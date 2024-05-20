package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Cart;
import vo.Product;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class ProdDAO {
	// 싱글톤 패턴을 만든다. singleton
	private static ProdDAO instance = null;

	private ProdDAO() {
	}

	public static ProdDAO getInstance() {
		if (instance == null)
			instance = new ProdDAO();
		return instance;
	}

	// DAO에서 JDBC유틸 뷰르기
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public Product bookDetail(int bookNo) {

		String sql = "select * from book where no = " + bookNo;
		Map<String, Object> l = jdbc.selectOne(sql);
		return ConvertUtils.convertToVo(l, Product.class);
	}

	public void bookDelete(int delNo) {
		String sql = "delete book where no = ?";
	}

	public int prodAdd(List<Object> param) {
		String sql = "insert into prod(no, name, price, text, count)\r\n" + "    values(?,?,?,?,?)";
		return jdbc.update(sql, param);
	}

	public List<Product> printProdList() {
		String sql = "select no, name, price, text, count from prod";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, Product.class);
	}

	public int nameEdit(List<Object> param) {
		String sql = "update prod\r\n" + "set name = ?\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}

	public int priceEdit(List<Object> param) {
		String sql = "update prod\r\n" + "set price = ?\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}

	public int countEdit(List<Object> param) {
		String sql = "update prod\r\n" + "set count = ?\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}

	public int textEdit(List<Object> param) {
		String sql = "update prod\r\n" + "set text = ?\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}

	public int allEdit(List<Object> param) {
		String sql = "update prod\r\n" + "set name = ?,\r\n" + "    price = ?,\r\n" + "    count = ?,\r\n"
				+ "    text = ?\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}

	public int delete(List<Object> param) {
		String sql = "delete from prod where no = ?";
		return jdbc.update(sql, param);
	}

	public int buy(List<Object> param) {
		String sql = "insert into cart(no, id, prod_no, count)\r\n" + "values(to_char(sq.nextval), ?, ?, ?)";
		return jdbc.update(sql, param);
	}

	public List<Cart> printBuyList(List<Object> param) {
		String sql = "select c.no, c.id, c.count, p.price\r\n" + "from cart c, prod p\r\n"
				+ "where ? = p.no and c.buyno = 1";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, Cart.class);
	}

	public List<Cart> cartList(List<Object> param) {
		String sql = "select * from cart\r\n" + "where id = ? and buyno = 0";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, Cart.class);
	}

	public int buyCart(List<Object> param) {
		String sql = "update cart\r\n" + "set buyno = 1\r\n" + "where no = ?";
		return jdbc.update(sql, param);
	}
}
