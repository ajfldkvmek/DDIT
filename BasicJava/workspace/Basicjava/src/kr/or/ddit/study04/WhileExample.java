package kr.or.ddit.study04;

import java.util.Scanner;

public class WhileExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample obj = new WhileExample();
		obj.method1();
		obj.method2();
		obj.method3();
	}

	private void method1() {
		// TODO Auto-generated method stub
		//while(조건) { 실행할 문장 }
		
		int num = 0;
		while(num < 10) {
			System.out.println(num+1 + "번 실행되었습니다");
			num++;
		}
		
	}
	
	private void method2() {
		String menu = "***커피***\n"
				 + "1.아메리카노"
				 + "2.카페라테"
				 + "3.자바칩"
				 + "4.카라멜마키아토"
				 + "5.프로그램 종료";
		
		int sum = 0;
		String bill = "";
		
		while(true) {
			System.out.println(menu);
			int exit = 0;
			int select = sc.nextInt();
			//int ame = 0, latte = 0, java = 0, caramel = 0;

			
			switch(select) {
			case 1: System.out.println("아메리카노 선택\t1000"); sum+=1000; bill += "아메\n";
				break;
			case 2: System.out.println("카페라테 선택\t1500"); sum+=1500; bill += "카페라테\n";
				break;
			case 3: System.out.println("자바칩 선택\t2000"); sum+=2000; bill += "자바칩\n";
				break;
			case 4: System.out.println("카라멜마키아토 선택\t2000"); sum+=2500; bill += "카마\n";
				break;
			case 5: {System.out.println("종료\n");  exit = -1;}
				break;
			default: System.out.println("잘못 선택\n");
				break;
			}
			if(exit == -1) break;
		}
		

		System.out.println("총 금액은: " +sum);
		System.out.println(bill);
		
	}
	
	private void method3() {
		int overflow = 2147483640;
		
		while(true ) {
			overflow++;
			System.out.println(overflow);
			if(overflow <0) {
				System.out.println(overflow);
				System.out.println("오버 플로우 발생!");
				break;
			}

		}
	}
}
