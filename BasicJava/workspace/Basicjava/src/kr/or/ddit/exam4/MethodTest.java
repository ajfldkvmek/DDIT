package kr.or.ddit.exam4;

public class MethodTest {

	public static void main(String[] args) {
		System.out.println("메인 메소드");
		
		MethodTest mt = new MethodTest();
		int m2 = mt.method2();
		double m3 = mt.method3();
		
		System.out.println("int method2: " + m2);
		System.out.println("doule method3: " + m3);
	}
	
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("void method");
		System.out.println("리턴값 없음");
	}
	
	public int method2() {
		System.out.println("int method");
		System.out.println("리턴값 int");
		return 10;
	}
	
	public double method3() {
		System.out.println("double method");
		System.out.println("리턴값 double");
		return method2()/3;
	}
	
	
}
