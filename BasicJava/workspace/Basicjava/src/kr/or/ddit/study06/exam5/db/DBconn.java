package kr.or.ddit.study06.exam5.db;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class DBconn {
	static Connection conn = null;
	
	public static Connection getConnection() {
		String  url  = "jdbc:oracle:thin:@localhost:1521:xe";
		String  user = "pc05";
		String  pwd  = "java";
		
		if(conn == null) {
			System.out.println();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
