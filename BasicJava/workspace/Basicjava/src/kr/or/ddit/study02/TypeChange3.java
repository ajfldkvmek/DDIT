package kr.or.ddit.study02;

import java.util.Scanner;

public class TypeChange3 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력(숫자만): ");
		String str = sc.nextLine();
	
		System.out.println("입력받은 문자: "+str);
				
//		String to int, long, double	
//		int -> Integer.
		int num = Integer.parseInt(str);
		
//		long -> Long.
//		long lg = Long.parseLong(str);
//		
//		double -> Double.
//		double db = Double.parseDouble(str);
		
		System.out.println("string에서 변형된 숫자 num: " + num);
		
		System.out.println("num+3= "+ (num+3));
		sc.close();
	}
	
}
