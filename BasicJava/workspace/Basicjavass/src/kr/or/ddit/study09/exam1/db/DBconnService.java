package kr.or.ddit.study09.exam1.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnService {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		DBconnService dbs = new DBconnService();
		dbs.selectAll();		
	}
	
	public EmpVo selectAll()	{
		
		EmpVo emp = new EmpVo();
		
		conn = DBconn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "select EMPID, NAME, DEPT from emp";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String empid = rs.getString("EMPID");
				String name = rs.getString("NAME");
				String dept = rs.getString("DEPT");
//				System.out.printf("%s\t%s\t%s\n", empid, name, dept);
				emp.setEmpid(empid);
				emp.setName(name);
				emp.setDept(dept);				
//				System.out.println(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
