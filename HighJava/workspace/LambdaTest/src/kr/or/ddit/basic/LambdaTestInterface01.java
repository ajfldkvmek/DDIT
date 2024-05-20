package kr.or.ddit.basic;

//함수적 인터페이스 -> 추상메서드가 한 개임 인터페이스
@FunctionalInterface
public interface LambdaTestInterface01 {
	//반환값이 없고 매개변수도 없는 추상 메소드 선언
	
	public void test();
}

@FunctionalInterface
interface LambdaTestInterface02 {
	//반환값 없고 매개변수 있는 추상메서드
	public void test(int a);
}

@FunctionalInterface
interface LambdaTestInterface03 {
	//반환값 없고 매개변수 있는 추상메서드
	public int test(int a, int b);
}