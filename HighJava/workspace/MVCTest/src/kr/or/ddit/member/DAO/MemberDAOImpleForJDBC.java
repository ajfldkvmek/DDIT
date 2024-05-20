package kr.or.ddit.member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.VO.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDAOImpleForJDBC implements IMemberDAO {

	private Connection conn;
	private Statement stmt;
	// stmt보다 pstmt를 권장함(sql injection 공격때문에 이게 더 안전)
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {

		int cnt = 0;
		try {

			conn = JDBCUtil3.getConnection();
			String sql = " insert into mymember ( mem_id, mem_name, mem_tel, mem_addr )\r\n" + " values( ?, ?, ?, ? ) ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate(); // 몇건이 처리됐는지 return

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "update mymember set mem_name = ? , mem_tel = ? , " + "" + " mem_addr = ?  where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate(); // 몇건이 처리됐는지 return

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean isExist = false;
		try {
			conn = JDBCUtil3.getConnection();

			String sql = " select count(*) as cnt \r\n" + " from mymember\r\n " + " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
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

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " delete from mymember where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<MemberVO> selectAll() {

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {

			conn = JDBCUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from mymember";

			rs = stmt.executeQuery(sql);
//			System.out.println("아이디\t이름\t전화번호\t\t주소\t\t가입일");
//			System.out.println(memId+"\t"+memName+"\t"+memTel+"\t"+memArr+"\t\t"+regDate);
			while (rs.next()) {
				MemberVO mv = new MemberVO();
//				String memId = rs.getString("mem_id");
//				String memName = rs.getString("mem_name");
//				String memTel = rs.getString("mem_tel");
//				String memArr= rs.getString("mem_addr");
//				TimeStamp를 LocalDate타입으로 변환하여 출력
				LocalDate regDate = rs.getTimestamp("reg_dt").toLocalDateTime().toLocalDate();
				mv.setMemId(rs.getString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));
				mv.setRegDt(regDate);
				list.add(mv);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil3.close(conn, stmt, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil3.getConnection();
			String sql = " select * from mymember where 1 = 1";
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				sql += " and mem_id = ? ";
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				sql += " and mem_name = ? ";
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				sql += " and mem_addr like '%'||?||'%' ";
			}

			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if (mv.getMemId() != null && !mv.getMemId().equals("")) {
				pstmt.setString(index++, mv.getMemId());
			}
			if (mv.getMemName() != null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());
			}
			if (mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());
			}
			if (mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO mv2 = new MemberVO();
//				String memId = rs.getString("mem_id");
//				String memName = rs.getString("mem_name");
//				String memTel = rs.getString("mem_tel");
//				String memArr= rs.getString("mem_addr");
//				TimeStamp를 LocalDate타입으로 변환하여 출력
				LocalDate regDate = rs.getTimestamp("reg_dt").toLocalDateTime().toLocalDate();
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));
				mv2.setRegDt(regDate);
				list.add(mv2);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

		}
		return list;
	}
}
