package kr.or.ddit.basic;

/*
 * 	람다식 => 익명함수를 생성하기위한 식
 * 		자바에서는>>  매개변수를 가진 코드블럭 -> 런타임시 익명구현 객체로 생성된다
 *  
 * 	ex) 인터페이스명 객체변수명 = 람다식;
 * 		>> (매개변수들) -> { 처리할 코드들;}
 * 
 * 	-> 람다식으로 변환할 수 있는 인터페이스는 반드시 추상메서드가 1개여야함(함수형 인터페이스)
 * 	
 *  
 */
public class T01_LabmdaTest {

	public static void main(String[] args) {
		// 람다식을 사용하지 않을 경우
		Thread th1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i <= 10; i++) {
					System.out.println(i);
				}
			}
		});
		th1.start();

		// 람다식 사용 (익명함수식 >> 여기서는 Runnable()인터페이스의 run()을 사용)
		Thread th2 = new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				System.out.println("람다- " + i);
			}
		});
		th2.start();

	}
}
