package kr.or.ddit.study06.exam5;

public class SingleTonTest {

	public static void main(String[] args) {
		
		//싱글톤은 객체를 하나만 생성하기 떄문에 이름 다르게 해도 다 같은 변수로 취급됨
		SingleTon singleTon = SingleTon.getInstance();
//		SingleTon singleTon2 = SingleTon.getInstance();
		
		singleTon.a = 100;
		System.out.println(singleTon.a);
		SingleTon singleTon2 = SingleTon.getInstance();
		
		System.out.println(singleTon2.a);	
	}
}
