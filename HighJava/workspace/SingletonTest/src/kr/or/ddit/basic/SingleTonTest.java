package kr.or.ddit.basic;

public class SingleTonTest {

	public static void main(String[] args) {
		
		//getInstance() 이용하여 객체생성하기
//		MySingleTon test1 = new MySingleone() 처럼 만들면안됨
		
		MySingleton test1 = MySingleton.getInstance();
		test1.display();
		
		MySingleton test2 = MySingleton.getInstance();
		test2.display();
		
		//이름이 다른 두 객체의 주소가 다른것을 확인 가능
		System.out.println("test1>> " + test1);
		System.out.println("test2>> " + test2);
	}
}
