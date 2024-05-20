package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil3;
import vo.BoardVO;

public class BoardDAOImpleForJDBC implements BoardDAO{
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BoardDAO memDAO;
	private BoardDAOImpleForJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getInstance() {
		
		if(memDAO == null) {
			memDAO = new BoardDAOImpleForJDBC();
		}
		return memDAO;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " insert into jdbc_board(board_no, board_title, board_writer, board_content)\r\n" + 
					"    values(board_seq.nextVal, ?, ?, ?)  ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_writer());
			pstmt.setString(3, bv.getBoard_content());
			
			cnt = pstmt.executeUpdate(); // 몇건이 처리됐는지 return

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		try {
			conn = JDBCUtil3.getConnection();

			String sql = "update jdbc_board set board_title = ? , board_write = ? , " + " board_content = ?  where board_no = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_writer());
			pstmt.setString(3, bv.getBoard_content());
			pstmt.setBigDecimal(4, bv.getBoard_no());

			int cnt = pstmt.executeUpdate(); // 몇건이 처리됐는지 return
			if (cnt > 0) {
				System.out.println(bv.getBoard_no() + "인 회원정보 수정 성공");
			} else {
				System.out.println(bv.getBoard_no() + "인 회원정보 수정 실패");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return 0;
	}

	@Override
	public int deleteBoard(BigDecimal no) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " delete from jdbc_board where board_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, no);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<BoardVO>();
//		BoardVO bv = new BoardVO();
		try {
			conn = JDBCUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = " select * from jdbc_board ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				BigDecimal board_no = rs.getBigDecimal("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String content = rs.getString("board_content");
				//TimeStamp를 LocalDate타입으로 변환하여 출력
				LocalDateTime regDate = rs.getTimestamp("board_date").toLocalDateTime();
				
				bv.setBoard_content(content);
				bv.setBoard_title(title);
				bv.setBoard_writer(writer);
				bv.setBoard_no(board_no);
				bv.setRegDt(regDate);
				
				list.add(bv);
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public List<BoardVO> search(String str) {
		List<BoardVO> list = new ArrayList<BoardVO>();
//		BoardVO bv = new BoardVO();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " select * \r\n" + 
					"from jdbc_board\r\n" + 
					"where board_title like '%'|| ? ||'%' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				BigDecimal board_no = rs.getBigDecimal("board_no");
				String title = rs.getString("board_title");
				String writer = rs.getString("board_writer");
				String content = rs.getString("board_content");
				//TimeStamp를 LocalDate타입으로 변환하여 출력
				LocalDateTime regDate = rs.getTimestamp("board_date").toLocalDateTime();
				
				bv.setBoard_content(content);
				bv.setBoard_title(title);
				bv.setBoard_writer(writer);
				bv.setBoard_no(board_no);
				bv.setRegDt(regDate);
				
				list.add(bv);
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return list;
	}

	@Override
	public boolean chkNo(BigDecimal no) {
		
		boolean isExist = false;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = " select count(*) as cnt \r\n" + " from jdbc_board\r\n " + " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					isExist = true;
				}
			}

		} catch (SQLException ex) {

		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return isExist;
	}
}
