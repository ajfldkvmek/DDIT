package kr.or.ddit.study09.exam1;

/**
 * 
 * 디자인 패턴 중 하나인 싱글톤
 * 
 * 클래스를 여러개 만들지 못하게 함
 *
 */
public class SingleTon {

	private static SingleTon singleton = null;

	int a = 10;
	
	//기본 생성자를 private로 설정하여 외부의 사용을 막음
	private SingleTon() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}; 

	public static SingleTon getInstance() {
		System.out.println("객체 호출");
		if (singleton == null) {
//			System.out.println("싱글톤");
			singleton = new SingleTon();
		}
		System.out.println("객체로드가 완료되었습니다");
		return singleton;
	}
}
