package kr.or.ddit.study06.exam1;

public class StudentTest {

	int a=10;
	static int b = 17; //객체 생성 없이 불러오기 가능
	
	public static void main(String[] args) {

		Student2 std1 = new Student2();
		std1.major = "컴퓨터 공학";
		std1.name = "홍길동";
		std1.age = 20;
		
//		System.out.println(std1.toString());
		
		Student2[] std = new Student2[10];
		
		for(int a = 0; a < std.length; a++) std[a] = new Student2();
		
		std[0].major = "기계";
		System.out.println(std[0]);
		StudentTest obj = new StudentTest(); 
		System.out.println(obj.a);
		System.out.println(b);
		
	}
}
