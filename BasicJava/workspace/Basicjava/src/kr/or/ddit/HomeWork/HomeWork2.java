package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork2 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		question1();
		question2();
	}
	
	public static void question1() {
		
		//정수 하나를 설정하고 키보드로 임의의 수를 입력 받아
		// 입력받은 수가 크면 "더 작은 수를 입력하세요"를 출력하고
		// 다시 수를 입력 받는다. 입력 받은 수가 더 작으면
		// "더 큰 수를 입력하세요"를 출력하고 다시 수를 입력 받는다.
		// 설정된 값과 같은 값을 몇번만에 맞추는지를 출력하는
		// 프로그램을 작성하시오.
		
		int question = 120; //정답
		int cnt = 0; //시도횟수
		
		while(true) {
			System.out.print("정수 하나를 입력 하세요 : ");
			
			int ans=Integer.parseInt(sc.nextLine());
			cnt++;
			if(ans > question) System.out.println("더 작은 수를 입력하여주세요.");
			else if(ans < question) System.out.println("더 큰 수를 입력하세요.");
			else {System.out.println("정답!"+cnt+"번 만에 맞췄어"); break;}
		}
	}
	
	public static void question2(){
		//논리연산자 : &&,||,!
		// 년도를 입력 받아 윤년과 평년을 판별
		//  윤년 : 4의 배수이면서 100의 배수가 아니면서 400의의 배수해가 되는 해
		System.out.print("년도 입력 : ");
		int year=sc.nextInt();
		if((year%4==0)&&(year%100!=0)||(year%400==0)){
			System.out.println(year+"년은 윤년입니다.");
		}else{
			System.out.println(year+"년은 평년입니다.");
		}
	}
}
