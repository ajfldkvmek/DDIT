package kr.or.ddit.HomeWork;

public class Student {

	String sNO = "";
	String dept = "";
	
	public static void main(String[] args) {
		
		Student std = new Student();
		std.setDept("컴퓨터");
		std.setsNO("231026");
		
		std.print();
	}

	public String getsNO() {
		return sNO;
	}

	public void setsNO(String sNO) {
		this.sNO = sNO;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "학생의  학번은 " + sNO + ", 소속은 " + dept + "입니다";
	}
	
	public void print() {
		System.out.println(toString());
	}	
}
