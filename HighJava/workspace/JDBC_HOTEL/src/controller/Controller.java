package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;
import util.ScanUtil;

public class Controller {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void printMenu() {
		System.out.println();
		System.out.println("-----Hotel-----");
		System.out.println("1. 체크인");
		System.out.println("2. 체크아웃");
		System.out.println("3. 체크인 리스트");
		System.out.println("4. 종료");
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		int select = 0;

		do {
			printMenu();
			select = ScanUtil.nextInt("메뉴>>");
			switch (select) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				checkList();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");

			}
		} while (select != 4);
	}

	private void exit() {
		System.out.println("-----Hotel-----");
		System.out.println("종료되었습니다.");
		System.out.println("---------------");
		System.exit(0);
	}

	private void checkList() {

		try {
			conn = JDBCUtil.getConnection();

			stmt = conn.createStatement();

			String sql = "select * from hotel";

			rs = stmt.executeQuery(sql);
			System.out.println("---------------");
			while (rs.next()) {
				int hotelNo = rs.getInt("h_no");
				String hotelName = rs.getString("h_name");
				System.out.println("방 번호 : " + hotelNo + ", 이름 : " + hotelName);
			}
			System.out.println("---------------");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	private void checkOut() {
		checkList();
		boolean pass = true;
		int hotelNo = 0;
		System.out.println("체크아웃 할 방번호를 적어주세요");
		while (pass) {

			hotelNo = ScanUtil.nextInt("방 번호>> ");

			boolean checkNo = checkNo(hotelNo);

			if (checkNo == false) {
				System.out.println("예약된 방이 아닙니다.");

			} else {
				pass = false;
			}

		}

		try {
			conn = JDBCUtil.getConnection();

			String sql = "delete from hotel where h_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelNo);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("방 번호 : " + hotelNo + " 가 체크아웃 되었습니다.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	private void checkIn() {
		boolean pass = true;

		int hotelNo = 0;

		while (pass) {
			hotelNo = ScanUtil.nextInt("방 번호>> ");

			boolean checkNo = checkNo(hotelNo);

			if (checkNo == true) {
				System.out.println("이미 예약된 방 입니다 다시 입력해주세요.");
			} else {
				pass = false;
			}
		}

		String hotelName = ScanUtil.nextLine("이름>> ");

		try {
			conn = JDBCUtil.getConnection(); // 커넥트 겟 커넥트로 먼저 불러온다.

			String sql = "insert into hotel\r\n" + "(h_no, h_name)\r\n" + "values(?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, hotelNo);
			pstmt.setString(2, hotelName);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println(hotelName + "님 예약 되셨습니다.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

	}

	private boolean checkNo(int hotelNo) {
		boolean pass = false;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "SELECT count(*) as cnt FROM hotel WHERE h_no = ?";

			pstmt = conn.prepareStatement(sql); //
			pstmt.setInt(1, hotelNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idCount = rs.getInt("CNT");

				if (idCount > 0) {
					pass = true;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, pstmt, rs);
		}

		return pass;
	}

}
