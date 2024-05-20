package kr.or.ddit.study04.homework;

import java.util.Scanner;

public class Homework3 {
	
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework3 obj = new Homework3();
		
		obj.method();
	}

	private void method() {
		// TODO Auto-generated method stub
		//1.가위 2.바위 3.보
		//스캐너로 입력받고 결과 출력
		
		int res = 0;
		System.out.println("가위 바위 보 게임 숫자를 입력하세요\n 1:가위 2:바위 3:보");	
		
		int your = sc.nextInt();
		int com = (int)(Math.random()*3)+1;		
				
		if(your > 3 || your < 1) res = 1;
		
		if(res == 0) {
			
			if(your == 1) System.out.println("당신의 입력: 가위");
			else if(your == 2) System.out.println("당신의 입력: 바위");
			else if(your == 3) System.out.println("당신의 입력: 보");
			
			if(com == 1) System.out.println("컴퓨터 입력: 가위");
			if(com == 2) System.out.println("컴퓨터 입력: 바위");
			if(com == 3) System.out.println("컴퓨터 입력: 보");
			
			boolean ls1 = (your == 1)&&(com == 2);
			boolean ls2 = (your == 2)&&(com == 3);
			boolean ls3 = (your == 3)&&(com == 1);
			if(your == com) System.out.println("비김");
			else if(ls1 || ls2 || ls3) System.out.println("짐");
			else System.out.println("이김");
		}
		
		else System.out.println("숫자를 잘못 입력함");
	}
		
	
}
