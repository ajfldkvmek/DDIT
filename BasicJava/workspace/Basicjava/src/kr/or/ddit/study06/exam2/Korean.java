package kr.or.ddit.study06.exam2;

public class Korean {

	String nation = "대한민국";
	String name;
	String ssn;
	
	//기본생성자
	public Korean() {
		
	}

	//1번 생성자
	public Korean(String nation, String name, String ssn) {
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
	}
 
	//2번 생성자
	public Korean(String nation) {
		this.nation = nation;
	}

	//3번 생성자
	public Korean(String name, String ssn) {
		this("한국");
		this.name = name;
		this.ssn = ssn;
//		this("대한민국", name, ssn);
	}

	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
}
