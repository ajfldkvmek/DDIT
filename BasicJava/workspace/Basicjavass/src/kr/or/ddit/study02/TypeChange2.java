package kr.or.ddit.study02;

import java.util.Scanner;

public class TypeChange2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수를 입력하세요: ");
		int kor = sc.nextInt();		
				
		System.out.print("수학점수를 입력하세요: ");
		int math = sc.nextInt();		
		
		System.out.print("영어점수를 입력하세요: ");
		int eng = sc.nextInt();		

		System.out.println("국어점수는 "+kor+", 수학점수는 "+math+", 영어점수는 "+eng+"입니다.");

		int sum = kor+math+eng;
		System.out.println("총점: " + sum);
		
		double aver = (double)sum/3;
		System.out.println("평균: " + aver);
		
		sc.close();		
	}
}
