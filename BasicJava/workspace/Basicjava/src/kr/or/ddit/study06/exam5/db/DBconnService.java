package kr.or.ddit.study06.exam5.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnService {
	Connection conn = null;
	Statement  stmt = null;
	ResultSet  rs   = null;
	
	public static void main(String[] args) {
		DBconnService dbs = new DBconnService();
		dbs.selectAll();
	}
	
	public EmpVO selectAll() {
		EmpVO emp = new EmpVO();
		conn = DBconn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT EMPID, NAME, DEPT FROM EMP";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String empid = rs.getString("EMPID");
				String name = rs.getString("NAME");
				String dept = rs.getString("DEPT");
				emp.setDept(dept);
				emp.setEmpid(empid);
				emp.setName(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
