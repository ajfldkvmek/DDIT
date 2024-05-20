package test01_StudentSort;

public class Student implements Comparable<Student> {

	private String name;
	private String stdNo;
	private int kor;
	private int math;
	private int eng;
	private int sum;

//	학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
	public Student(String stdNo, String name, int kor, int math, int eng) {
		this.stdNo = stdNo;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.sum = (kor + math + eng);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "학번: " +stdNo +"  이름: "+name + 
				"  국어: "+kor + "  수학: "+math + "  영어: " + eng + "  총점: " +sum;
	}

	@Override
	//학번 기준으로 오름차순 정렬
	public int compareTo(Student s) {
		return this.getStdNo().compareTo(s.getStdNo());
	}
	
}
