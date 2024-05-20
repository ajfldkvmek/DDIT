package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork4 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork4 obj = new HomeWork4();
		int n = (int)(Math.random()*100)+1;
		obj.dan1();
		obj.dan2();
		obj.dan3();	
		obj.dan4(n);
	}
	

	private void dan4(int num) {
		//n이 매개변수로 주어질 때 n이 홀수라면 n이하의 홀수인 모든 양이 정수합
		//n이 매개변수로 주어질 때 n이 짝수라면 n이하의 홀수인 모든 정수의 제곱의 합
		int sum = 0;
//		System.out.println(num);
		if(num % 2 == 1) {
			for(int a = 1; a <= num; a+=2) {
				sum+=a;
			}
		}
		else {
			for(int a = 0; a <= num; a+=2) {
				sum += a*a;
			}
		}
		System.out.println(sum);
	}	
	
	private void dan3() {
		System.out.println("Q3.입력받은 단 제외 구구단 출력");
		System.out.print("몇단을 뺄래? ");
		int num = sc.nextInt();
	
//		System.out.println("가로 출력ver.");
//		for (int a = 2; a < 10; a++) {
//			if(a != num) {
//				for (int b = 1; b < 10; b++) {
//					
//					System.out.printf("%d*%d=%d \t", a, b, a * b);
//				}
//				System.out.println();
//			}
//			
//		}
		System.out.println();
		
		System.out.println("세로 출력ver.");
		for(int b = 1; b < 10; b++) {
			for(int a = 2; a < 10; a++) {
				if(num != a) System.out.printf("%d*%d=%d \t", a, b, a * b);
			}
			System.out.println();
		}
		
	}
	
	private void dan2() {
		System.out.println("Q2.구구단 세로 출력");
		for(int b = 1; b < 10; b++) {
			for(int a = 2; a < 10; a++) {
				System.out.printf("%d*%d=%d \t", a, b, a * b);
			}
			System.out.println();
		}
		System.out.println();
	}	
	
	private void dan1() {
		System.out.println("Q1.선택한 단 출력");
		System.out.print("몇단을 출력할까 ");
		int num = sc.nextInt();
		for(int a = 1; a < 10; a++) System.out.printf("%d*%d=%d \n", num, a, num*a);
	}

}
