package kr.or.ddit.study01;

public class IntegerExample {

	public static void main(String[] args) {

//		정수형
//		1.byte : 1byte
//		2.short : 2byte
//		3.int : 4byte
//		4.long : 8byte

		byte b1 = 127;
		System.out.println("b1 = " + b1);

		short s1 = 128;
		System.out.println("s1 = " + s1);

//		short s2 = s1 + 10;
//		자바에서 기본적으로 상수는 int 로 인식
		short s2 = (short)(s1 + 10);
		System.out.println(s2);
		
		int var1 = 200; // 10진수
		int var2 = 0201; //8진수
		int var3 = 0x74a; //16진수
		int var4 = 0b11-11; //2진수
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		//long l1 = 10;
		long l2 = 100000000000L;
		
		System.out.println("l2 = " + l2);
	}

}
