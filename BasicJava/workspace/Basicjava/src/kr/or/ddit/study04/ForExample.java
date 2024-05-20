package kr.or.ddit.study04;

import java.util.Scanner;

public class ForExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample obj = new ForExample();
		obj.sum();
		obj.alpha();
		obj.alpha2();
	}

	private void sum() {
		int odd = 0;
		int even = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				even += i;
			else
				odd += i;
		}
		System.out.println("짝수 들의 합: " + even);
		System.out.println("홀수 들의 합: " + odd);
	}

	private void alpha() {

		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print((char) i + " ");
		}
	}

	private void alpha2() {
		String str = sc.nextLine();
		char ch = str.charAt(0);

		for (int i = ch; i <= 'z'; i++) {
			System.out.print((char) i + " ");
		}
	}
		
}
