package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	//static블록은 클래스 로딩될 때 한 번만 호출됨
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc05", "java");
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try { rs.close();  } catch(SQLException ex) {} 
		if(stmt != null) try { stmt.close();  } catch(SQLException ex) {} 
		if(pstmt != null) try { pstmt.close();  } catch(SQLException ex) {} 
		if(conn != null) try { conn.close();  } catch(SQLException ex) {} 
	}
}
