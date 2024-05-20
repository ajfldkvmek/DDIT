package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties ppt;

	static {
		try {
			ppt = new Properties(); // 객체 불러오기

			FileInputStream fis = new FileInputStream("./res/db.properties"); // 파일 읽기

			ppt.load(fis); // 파일을 읽었던것을을 Properties로 로드.

			Class.forName(ppt.getProperty("driver")); // Properties의 공구상자안에있는 getproperty도구를 이
														// 용해서 클래스 forname쓰기(드라이버)

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {

			return DriverManager.getConnection(ppt.getProperty("url"), ppt.getProperty("username"),
					ppt.getProperty("password"));
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}

}
