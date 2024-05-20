package kr.or.ddit.study03;

public class Arithmatic {

	public static void main(String[] args) {
		// 산술 연산자: +, -, /, *, %
		// 사칙연산과 마찬가지로 +,- 보다 * / % 가 먼저 연산됨
		
		int a = 5;
		int b = 3;
		
		System.out.println("덧셈\t"+ (a+b));
		System.out.println("뺄셈\t"+ (a-b));
		System.out.println("곱셈\t"+ (a*b));
		System.out.println("나눗셈\t"+ ((double) a/b));
		System.out.println("나머지\t"+ (a%b));
	}
	
}
