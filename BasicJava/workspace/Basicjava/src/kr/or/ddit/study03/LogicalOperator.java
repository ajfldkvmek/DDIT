package kr.or.ddit.study03;

import java.util.Scanner;

public class LogicalOperator {
	//논리연산자 or(|) and(&) nor(^) not(~)
	//45: 00101101
	//24: 00011001
	static int a = 45;
	static int b = 25;
	
	static int bit1 = 16;
	static int bit2 = 2;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		LogicalOperator obj = new LogicalOperator();
		
		obj.and(a,b);//0001001
		obj.or(a,b); //00111111
		obj.nor(a,b);//00110100
		obj.not(a);//11010010
		obj.not(b);//11100110
		obj.shift(bit1, bit2);
		
	}

	private void not(int a) {		
		System.out.println(~a);			
	}

	private void nor(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a^b);	
	}

	private void or(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a|b);	
	}

	private void and(int a, int b) {
		System.out.println(a&b);	
	}

	private void shift(int a, int b) {
		//<< >> >>>
		//숫자 >> 정수 정수 비트씩 오른쪽으로 이동 
		System.out.println(a >> b);
		System.out.println(a << b);
	}

}
