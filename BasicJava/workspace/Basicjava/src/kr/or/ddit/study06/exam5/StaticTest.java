package kr.or.ddit.study06.exam5;

public class StaticTest {

	static int a = 10;
	int b = 10;
	
	public static void main(String[] args) {

//		System.out.println(a);
//		System.out.println(b);
//		
//		StaticTest st1 = new StaticTest();
//		StaticTest st2 = new StaticTest();
//		StaticTest st3 = new StaticTest();
//		
//		a = 20;
//		st1.b = 15;
//		
//		System.out.println("st1 static a: "+ a);
//		System.out.println("st1 int b: "+ st1.b);
//	
//		
//		System.out.println("st2 staic a: "+ a);
//		System.out.println("st2 int b: "+ st2.b);
//		
//		System.out.println("st2 staic a: "+ a);
//		System.out.println("st2 int b: "+ st3.b);
		
		StaticTest st = new StaticTest();
		st.b = 20;
		st.method1();
		

		
		
		StaticTest st2 = new StaticTest();
		st2.method1();
	}
	
	public void method1() {
		System.out.print("method1, ");
		System.out.println("static int a: " + a);
		System.out.println("int b: " + b);
	}
	
	public static void method2() {
		System.out.print("static method2, ");
		System.out.println("static int a: " + a);
	}
	
	
}
