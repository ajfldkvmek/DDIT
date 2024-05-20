package kr.or.ddit.study04;

//ctrl shift o
import java.util.Scanner;

public class VarTest {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VarTest obj = new VarTest();
		obj.quest5();
	}
	

	@SuppressWarnings("unused")
	private void method1() {
		
		char ch = 'A';
		byte bt = 10;
		short sh = 10;
		int i = 10;
		float fl = 10.1f;
		double d = 10.1;
		long l = 10l;		
		String str = "str";
		boolean b = true;
		
		System.out.println("ch: " + ch);
		System.out.println("byte: " + bt);
		System.out.println("short: " + sh);
		System.out.println("int: " + i);
		System.out.println("float: " + fl);
		System.out.println("double: " + d);
		System.out.println("long: " + l);
		System.out.println("boolean: " + b);
		System.out.println("String: " + str);
	}	


	@SuppressWarnings("unused")
	private void method2() {
		/*
		 *  각 데이터를 형변환하고 출력하시오
		 
		 	char -> int
		 	int -> char 
		 	int -> double
		 	int 값 변수 a,b를 나누기 연산 후 double로 저장
		 	char -> String (ch_1, ch_2값을 sting에 저장		 
		 */
		
		char ch = 'A';
		int i = 97;
		
		System.out.println("char to int ch: " + (int)ch);
		System.out.println("int to char i: " + (char)i);
		
		int a = 11;
		int b = 3;
		double d = (double)a/b;
		System.out.println("a= " + a + " b= " + b + " d= " + d);
		
		char ch1 = 'a';
		char ch2 = 'b';		
		String str = ""+ch1+ch2;
		
		System.out.println("ch1: " + ch1 + " "+ "ch2: "+ch2 + " str: " + str);
	}	

	@SuppressWarnings("unused")
	private void method3() {
		
		//Math.random() -> 랜덤 숫자 출력 0 ~ 1
		
		double rand = Math.random();
		System.out.println(rand);
		
		int irand = (int)(rand*10);
		
		System.out.println(irand);
	}
	
	@SuppressWarnings("unused")
	private void quest1() {
		/*
		 * 양꼬치 1인분 12000 음료수 2000
		 * 양꼬치 n개와 음료수 k 개를 먹었다면 지불할 금액 
		 */
		System.out.println("문제1");
		
		int n = (int)(Math.random()*10)+1;
		int k = (int)(Math.random() * 10)%3 + 1;
		int res = (12000*n)+(2000*k);
		
		System.out.println("양꼬치는 " + n +"개, " + "음료수는 " + k +"개 먹었습니다.");
		System.out.println("총 금액은 " + res + "원 입니다.\n");
		
	}
	@SuppressWarnings("unused")
	private void quest2() {
		//1~50
		System.out.println("문제2");
		int num1 = (int)(Math.random()*100) % 50+1;
		int num2 = (int)(Math.random()*100) % 50+1;
		
		System.out.println("num1: " + num1 + " num2: " + num2 );
		System.out.println(num1 + "을 " + num2+"로 나눈 몫은: " + num1/num2);
		System.out.println(num1 + "을 " + num2+ "로 나눈 나머지는: " + num1%num2 + "\n");
	}
	@SuppressWarnings("unused")
	private void quest3() {
		//1~50
		System.out.println("문제3");
		int num1 = (int)(Math.random()*100) % 50+1;
		int num2 = (int)(Math.random()*100) % 50+1;
		
		double div = (double)num1/num2 * 1000;
		
		System.out.println((int)div + "\n");
		
//		int div = num*1000/num2; 도 가능
//		double res = num1*1000/num2/1000.0;
//		System.out.println(res +"\n");
		
		
	}
	@SuppressWarnings("unused")
	private void quest4() {
		/*
		 * 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 출력 a:3 b:5일 때 35 53으로, 더 큰 값 출력
		 * 
		 */
		System.out.println("문제4");
		int num1 = (int)(Math.random()*100)+1;
		int num2 = (int)(Math.random()*100)+1;
		
		System.out.println("num1: " + num1 + ", num2: " + num2 );
		String str1 = ""+num1+num2;	
		String str2 = ""+num2+num1;	
		//str1 = String.valueOf(a) + String.valueOf(b)
		//str2 = String.valueOf(b) + String.valueOf(a)
				
		num1 = Integer.parseInt(str1);
		num2 = Integer.parseInt(str2);	
		
		int res = (num1 > num2) ? num1 : num2;
		System.out.println(res);
	}

	private void quest5() {
		// TODO Auto-generated method stub
		String str = sc.nextLine();
		System.out.println(str);
		
	}

}

