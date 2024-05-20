package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Board;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class BoardDAO {
	// 싱글톤 패턴을 만든다.
	private static BoardDAO instance = null;
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		if(instance == null) 
			instance = new BoardDAO();
		return instance;
	}
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Board> boardList() {
		String sql = "select no, title, substr(text, 1, 10) text, \r\n" + 
				"        to_char(time, 'yyyy.mm.dd') time, count, mem_no from board";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		
		return ConvertUtils.convertToList(l, Board.class);
	}
	
	
	public List<Board> badboardList() {
		String sql = "select no, title, substr(text, 1, 10) text, \r\n" + 
				"        to_char(time, 'yyyy.mm.dd') time, count, mem_no from board\r\n" + 
				"        where delyn = 1";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		
		return ConvertUtils.convertToList(list, Board.class);
	}
	
	public List<Board> goodList() {
		String sql = "select no, title, substr(text, 1, 10) text, \r\n" + 
				"        to_char(time, 'yyyy.mm.dd') time, count, mem_no from board\r\n" + 
				"        where delyn = 0";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		
		return ConvertUtils.convertToList(list, Board.class);
	}
	
	public List<Board> userBoard(String id) {
		String sql = "select no, title, substr(text, 1, 10) text,\r\n" + 
				"            to_char(time, 'yyyy.mm.dd') time, count, mem_no from board\r\n" + 
				"            where delyn = 0 and mem_no = \r\n" + 
				"            (select no from member where id = ?)";
		
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(list, Board.class);
	}
	
	public int badBoard(List<Object> param) {
		String sql = "update board\r\n" + 
						"set delyn = 1\r\n" + 
						"where no = ?";
		return jdbc.update(sql, param);
	}
	
}







/*
 * 
 * 	public Board boardView(int board_no) {
		String sql = " SELECT board_no, board_name, board_writer,  "
				+ "           TO_CHAR(board_date, 'YYYY-MM-DD') board_date,"
				+ "           board_content, board_delyn   "  
				+ "    FROM FREE_BOARD\r\n"	
				+ "    where board_no = ? ";
		List<Object> l = new ArrayList<>();
		l.add(board_no);
		Map<String, Object> map = jdbc.selectOne(sql, l);
		return ConvertUtils.convertToVo(map, Board.class);
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
	*/
