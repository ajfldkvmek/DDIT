package kr.or.ddit.study05;

import java.util.Scanner;

public class SwitchExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		SwitchExample obj = new SwitchExample();
		
		obj.switchtest1();
		obj.switchtest2();
		obj.switchtest3();
		obj.switchtest4();
	}

	private void switchtest1() {
		System.out.println("회원 등급을 입력하세요(1~3)");
		int grade = sc.nextInt();
		
		switch(grade) {
		case 1: System.out.println("VIP");
			System.out.println();
			break;
		case 2:
			System.out.println("우수");
			break;
		case 3:
			System.out.println("일반");
			break;
		default:
			System.out.println("잘못 누름");
			break;
		}
	}

	private void switchtest2() {
		// 끝자리 31일인 달 
		// 끝자리 30일 달
		// 끝자리 28 29인 달
		
		System.out.print("몇 월? ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31일 까지 있어");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일 까지 있어");
			break;
		case 2: System.out.println("28or29일 까지 있어"); break;
		
		default: System.out.println("잘못 눌렀어"); break;
		
		}
	}
	
	private void switchtest3() {
		System.out.print("국가명 입력: ");
		String nation = sc.nextLine();
		
		switch (nation) {
		case "korea":
			System.out.println("한국");
			break;
		case "japan":
			System.out.println("일본");
			break;
		case "china":
			System.out.println("중국");
			break;		
		default: System.out.println("다른나라");
			break;
		}
	}

	private void switchtest4() {
		System.out.print("점수를 입력해: ");
		int score = sc.nextInt();
		
		switch(score/10) {
		case 10: 
			switch(score%10) {
			case 0: System.out.println("A+"); break;
			default: System.out.println("잘못 입력"); break;
			}
			break;
		case 9:
			switch(score%10) {
			case 0: case 1: case 2:
				System.out.println("A-"); break;
			case 3: case 4: case 5:
				System.out.println("A"); break;
			case 7: case 8: case 9:
				System.out.println("A+"); break;
			}
			break;
		
		case 8:
			switch(score%10) {
			case 0: case 1: case 2:
				System.out.println("B-"); break;
			case 3: case 4: case 5:
				System.out.println("B"); break;
			case 7: case 8: case 9:
				System.out.println("B+"); break;
			}
			break;
		
		case 7:
			switch(score%10) {
			case 0: case 1: case 2:
				System.out.println("C-"); break;
			case 3: case 4: case 5:
				System.out.println("C"); break;
			case 7: case 8: case 9:
				System.out.println("C+"); break;
			}
			break;	
			
		case 6:
			switch(score%10) {
			case 0: case 1: case 2:
				System.out.println("D-"); break;
			case 3: case 4: case 5:
				System.out.println("D"); break;
			case 7: case 8: case 9:
				System.out.println("D+"); break;
			}
			break;
		
		case 5: case 4: case 3: case 2: case 1:
			System.out.println("F"); 
			break;
			
		default: System.out.println("그거 점수 아니야");
		break;
		
		}
	
	}	

	
}
