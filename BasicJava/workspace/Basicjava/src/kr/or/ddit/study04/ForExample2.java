package kr.or.ddit.study04;

import java.util.Scanner;

public class ForExample2 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample2 obj = new ForExample2();
		obj.method1();
		obj.method2();
		obj.method99();
	}

	private void method2() {
		for (int a = 2; a < 10; a++) {
			System.out.println(a + "단");
			for (int b = 1; b < 10; b++) {
				// System.out.println(a + "x" + b + " = " + a*b);
				System.out.printf("%d*%d=%d ", a, b, a * b);
			}
			System.out.println();
		}
	}

	private void method1() {
		// 영어에 포함된 모음의 수 구하기

		String str = sc.nextLine();

		int count = 0;
		// a e i o u
		for (int i = 0; i < str.length(); i++) {
//			System.out.print(str.charAt(i));
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'u'
					|| str.charAt(i) == 'i')
				count++;
		}
		System.out.printf("모음의 갯수는 %d개 입니다", count);
	}

	private void method99()	{
		
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0) continue;
			System.out.println("홀수만 출력 " + i);
		}
	}
}
