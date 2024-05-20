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
			ppt = new Properties(); 

			FileInputStream fis = new FileInputStream("./res/db.properties"); 

			ppt.load(fis);

			Class.forName(ppt.getProperty("driver"));

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
