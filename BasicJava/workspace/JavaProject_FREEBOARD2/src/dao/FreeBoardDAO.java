package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.FreeBoard;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class FreeBoardDAO {
	// 싱글톤 패턴을 만든다.
	private static FreeBoardDAO instance = null;
	private FreeBoardDAO() {}
	public static FreeBoardDAO getInstance() {
		if(instance == null) 
			instance = new FreeBoardDAO();
		return instance;
	}
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public List<FreeBoard> boardList() {
		String sql = " SELECT board_no, board_name, board_writer,"
				+ "           board_date,"
				+ "           board_content, board_delyn  \r\n"
				+ "	   FROM FREE_BOARD\r\n"
			    + "    WHERE BOARD_DELYN IS NULL "
			    + "    ORDER BY board_no DESC";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		
		return ConvertUtils.convertToList(l, FreeBoard.class);
	}
	public FreeBoard boardView(int board_no) {
		String sql = " SELECT board_no, board_name, board_writer,  "
				+ "           TO_CHAR(board_date, 'YYYY-MM-DD') board_date,"
				+ "           board_content, board_delyn   "  
				+ "    FROM FREE_BOARD\r\n"	
				+ "    where board_no = ? ";
		List<Object> l = new ArrayList<>();
		l.add(board_no);
		Map<String, Object> map = jdbc.selectOne(sql, l);
		return ConvertUtils.convertToVo(map, FreeBoard.class);
	}
	public void boardInsert(List<Object> param) {
		String sql = "INSERT INTO FREE_BOARD \r\n" + 
				"	  (BOARD_NO  , BOARD_NAME, board_writer, board_content)\r\n" + 
				"	  VALUES\r\n" + 
				"	  ((SELECT\r\n" + 
				" 	  MAX(BOARD_NO) \r\n" + 
				"  	  FROM FREE_BOARD)+1, ?, ?, ?) ";
		jdbc.update(sql, param);
	}
	public void boardDelete(int board_no) {
		String sql = "  UPDATE  FREE_BOARD\r\n" + 
					 "  SET board_delyn ='Y'\r\n" + 
				"       WHERE BOARD_NO =?";
		List<Object> param = new ArrayList();
		param.add(board_no);
		jdbc.update(sql, param);
	}
	//parameter name writer text no
	public void boardUpdate(List<Object> param) {
		String sql = "";
		jdbc.update(sql, param);
	}
}
