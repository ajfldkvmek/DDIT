package kr.or.ddit.study09.exam1.db;

public class EmpVo {
	
	//대문자 -> 소문자 : ctrl shift y
	String empid, name, dept;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpVo [empid=" + empid + ", name=" + name + ", dept=" + dept + "]";
	}
	
	
	
}
