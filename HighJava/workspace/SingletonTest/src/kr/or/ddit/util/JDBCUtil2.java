package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil2 {
	
	/*
	 	db.properties파일을 이용하여 DB설정정보를 관리하는 방법
	 	
	 	방법1) properties 객체 이용하기
	 	
	 */
	
	static Properties prop;
	
	//static블록은 클래스 로딩될 때 한 번만 호출됨
	static {
		//static 메서드 호출 될 때 초기화
		
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream("res/db.properties");
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), 
											prop.getProperty("username"), prop.getProperty("password"));
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
