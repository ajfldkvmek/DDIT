package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import util.ScanUtil;
import util.JDBCUtil;

public class Controller {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		new Controller().start();
	}

	public void start() {
		int choice = 0;
		do {
			displayMenu(); // 메뉴 출력
			choice = ScanUtil.nextInt("메뉴번호 입력>>"); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				selectAll();
				break;
			case 5: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 5);
	}

	private void selectAll() {
		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from mymember";

			rs = stmt.executeQuery(sql);

			System.out.println("\t\t\t\t");
			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");

				LocalDate regDate = rs.getTimestamp("reg_dt").toLocalDateTime().toLocalDate();

				System.out.println(memId +"\t"+ memName +"\t"+ memTel +"\t"+ memAddr +"\t"+ regDate);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

		}
	}

	private void deleteMember() {
		System.out.println("삭제할 회원 정보를 입력해 주세요.");

		try {
			conn = JDBCUtil.getConnection();

			String sql = "delete from mymember where mem_id = ?";

			boolean pass = true;

			while (pass) {
				String memId = ScanUtil.nextLine("회원ID>>");

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				int cnt = pstmt.executeUpdate();

				if (cnt > 0) {
					System.out.println(memId + " 인 회원정보가 삭제되었습니다.");
					pass = false;
				} else {
					System.out.println(memId + " 인 회원정보가 없습니다.");
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}
	}

	private void updateMember() {

		boolean isExist = false;
		String memId = "";
		do {
			System.out.println();
			System.out.println("수정 할 회원 정보를 입력해 주세요.");
			System.out.println();

			memId = ScanUtil.nextLine("회원ID>> ");
			isExist = checkMember(memId);

			if (!isExist) {
				System.out.println("회원ID가" + memId + "인 회원이 없습니다." + "\n 다시 입력해 주세요.");
			}

		} while (!isExist);

		String memName = ScanUtil.nextLine("회원 이름 >>");
		String memTel = ScanUtil.nextLine("회원 번호 >>");
		String memAddr = ScanUtil.nextLine("회원 주소 >>");

		try {
			conn = JDBCUtil.getConnection();

			String sql = "UPDATE MYMEMBER\r\n" + "set mem_name = ?, mem_tel = ? , mem_addr =?\r\n" + "where mem_id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "인 회원 정보 변경 성공!");
			} else {
				System.out.println(memId + "인 회원 정보 변경 실패!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	private void insertMember() {

		boolean isExist = false;
		String memId = "";
		do {
			System.out.println();
			System.out.println("추가 할 회원 정보를 입력해 주세요.");
			System.out.println();

			memId = ScanUtil.nextLine("회원ID>> ");
			isExist = checkMember(memId);

			if (isExist) {
				System.out.println("회원ID가" + memId + "인 회원이 이미 존재합니다." + "\n 다시 입력해 주세요.");
			}

		} while (isExist);

		String memName = ScanUtil.nextLine("회원 이름 >>");
		String memTel = ScanUtil.nextLine("회원 번호 >>");
		String memAddr = ScanUtil.nextLine("회원 주소 >>");

		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into mymember\r\n" + "(mem_id, mem_name, mem_tel, mem_addr)\r\n" + "values(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(memId + "인 회원 정보 추가 성공!");
			} else {
				System.out.println(memId + "인 회원 정보 추가 실패!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	private boolean checkMember(String memId) {
		boolean isExist = false;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "select count(*) as cnt from mymember\r\n" + "where mem_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cnt = rs.getInt("CNT");

				if (cnt > 0) {
					isExist = true;
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return isExist;
	}

}
