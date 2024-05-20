package kr.or.ddit.study06.exam5.db;

public class EmpVO {
	String empid;
	String name;
	String dept;
	
	@Override
	public String toString() {
		return "EmpVO [empid=" + empid + ", name=" + name + ", dept=" + dept + "]";
	}
	String getEmpid() {
		return empid;
	}
	void setEmpid(String empid) {
		this.empid = empid;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getDept() {
		return dept;
	}
	void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
