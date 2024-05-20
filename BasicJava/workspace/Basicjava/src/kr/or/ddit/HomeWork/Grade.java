package kr.or.ddit.HomeWork;

//세 과목의 성적을 입력 받고 총점과 합을 출력할 수 있는 Grade class를 설계하시오.
public class Grade {

	double kor;
	double math;
	double eng;
	double sum;
	
	public static void main(String[] args) {
		
		Grade g = new Grade();
//		g.setEng(78);
//		g.setKor(87);
//		g.setMath(99);
//		g.setsum();
		g.sum(99,87,97);
	}
	
	public void sum(int a, int b, int c) {
		kor = a;
		math = b;
		eng = c;
		sum = a+b+c;
		System.out.println(toString());
	}
	
//	public double getKor() {
//		return kor;
//	}
//
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
//
//	public double getMath() {
//		return math;
//	}
//
//	public void setMath(int math) {
//		this.math = math;
//	}
//
//	public double getEng() {
//		return eng;
//	}
//
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//	
//	public void setsum() {
//		this.sum = eng+math+kor;
//	}
	
	@Override
	public String toString() {
		return "점수: 국어= " + kor + ", 수학= " + math + ", 영어= " + eng + "\n총점 : " + sum;
	}


}
