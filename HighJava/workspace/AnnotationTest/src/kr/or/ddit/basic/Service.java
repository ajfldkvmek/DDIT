package kr.or.ddit.basic;

//@PrintAnnotation<< 범위 지정가능
public class Service {
	
	public static void main(String[] args) {
		
		Service s = new Service();
		
		s.method1();
		s.method2();
		s.method3();
	}

	@PrintAnnotation
	//값 세팅 안하면 '-', 20이 기본값
	public void method1() {
		System.out.println("메서드1에서 출력");
	}
	@PrintAnnotation(value = "%")
	public void method2() {
		System.out.println("메서드2에서 출력");
	}
	@PrintAnnotation(value = "#", count = 30)
	public void method3() {
		System.out.println("메서드3에서 출력");
	}
}
