package kr.or.ddit.study13;

class Student{
	//5명의 3과목(국영수) 성적과 이름을 서언 저장하고 총점 평균과 등수를 출력
	
	String name;
	int kor;
	int math;
	int eng;
	int sum;
	double aver;
	int rank;
	
	public Student(String name, int kor, int math, int eng, int sum, double aver, int rank) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.sum = sum;
		this.aver = aver;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + ", sum=" + sum + ", aver="
				+ aver + ", rank=" + rank + "]";
	}
			
}