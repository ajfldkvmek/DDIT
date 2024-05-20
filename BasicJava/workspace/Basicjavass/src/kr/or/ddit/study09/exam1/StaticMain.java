package kr.or.ddit.study09.exam1;

public class StaticMain {

	public static void main(String[] args) {

		

		int a = StaticTest.a;
//		int b = StaticTest.b;
		StaticTest.method2();
		
		StaticTest st = new StaticTest();
		int b = st.b;
		st.method1();
		System.out.println(b);
	}
}
