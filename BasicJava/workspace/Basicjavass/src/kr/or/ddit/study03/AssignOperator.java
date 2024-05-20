package kr.or.ddit.study03;

public class AssignOperator {

	public static void main(String[] args) {
		// =: 대입연산자 
		// -=, +=, /=, *= , &=, %=
		
		int a = 7;
		int b = 3;
		
		System.out.println("a: "+a+ ", b: "+b);
		
		a += b;
		System.out.println("a+b: "+a);		
		
		a = 7;
		b = 3;
		a -= b;		
		System.out.println("a-b: "+a);
		
		a = 7;
		b = 3;
		a *= b;
		System.out.println("a*b: "+a);
		
		a = 7;
		b = 3;
		a /= b;
		System.out.println("a/b: "+a);
		
		a = 7;
		b = 3;
		a %= b;
		System.out.println("a%b: "+a);
		
		a = 7;
		b = 3;
		a &= b;
		System.out.println("a&b: "+a);
		
	}	
}
