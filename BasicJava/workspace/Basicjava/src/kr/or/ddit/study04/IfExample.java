package kr.or.ddit.study04;

import java.util.Scanner;

public class IfExample {
	
	
	Scanner sc = new Scanner(System.in);
	
	String c = "전역변수";

	public static void main(String[] args) {
		IfExample obj = new IfExample();
		//obj.methon1();
		//System.out.println(obj.c);
		//obj.method2();
		obj.method4();
		obj.ifexam();
	}

	private void ifexam() {
		// TODO Auto-generated method stub
//		if(1==1)System.out.println("실행1");
		System.out.println("실행2");
	}

	@SuppressWarnings("unused")
	private void methon1() {
		if(true) {
			System.out.println("if문 시작");
			String str2 = "Asdasd";
			
			if(true) {
				String str3 = "adasdasd";
				System.out.println(str2);
				System.out.println(str3);
			}
			System.out.println("if문 끝");
		}
	}
	
	
	
	@SuppressWarnings("unused")
	private void method2() {
		//키와 체충을 입력하여 bmi지수를 구하고 그에 따른 정상 과체중 비만 고도비만의 정보를 출력하시오
		// ~ 18.4: 저체중  18.5~22.9 정상 23~24.9 비만, 25~ 고도비만
		
		System.out.print("키를 입력하세요: ");
		double height = sc.nextDouble();
		System.out.print("몸무게를 입력하세요: ");
		double weight = sc.nextDouble();
		//1.3 × {체중 (kg)} / {키 (m)2.5} 
		double bmi = weight/(height*height) * 10000;
//		bmi = Math.round(bmi*100.0)/100.0;
		bmi = Math.round(bmi);
		System.out.println(bmi);
		if(bmi < 18.5) System.out.println("저체중");
		else if(bmi < 23) System.out.println("정상");
		else if(bmi < 25) System.out.println("과체중");
		else if(bmi < 30) System.out.println("비만");
		else System.out.println("고도비만");		
		
	}

	@SuppressWarnings("unused")
	private void method3() {
				
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		
		if(score >= 100) {
			System.out.println("A+");
		} else if(score >= 90) {
			if(score % 10 > 5) System.out.println("A+");
			else System.out.println("A-");
			
		} else if(score >= 80) {
			if(score % 10 > 5) System.out.println("B+");
			else System.out.println("B-");		
			
		} else if(score >= 70) {
			if(score % 10 > 5) System.out.println("C+");
			else System.out.println("C-");			
			
		} else if(score >= 60) {
			if(score % 10 > 5) System.out.println("D+");
			else System.out.println("D-");			
			
		} else System.out.println("F");
		
	}

	private void method4() {
		
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		String grade = "";
		int toggle = 0;
		
		if(score >= 100) {
			grade = "A+";
			toggle = 1;
		} else if(score >= 90) {
			grade = "A";			
		} else if(score >= 80) {
			grade = "B";	
		} else if(score >= 70) {
			grade = "C";				
		} else if(score >= 60) {
			grade = "D";	
		} else grade = "F";
		
		if((toggle == 0) && grade != "F") {
			if(score % 10 > 5) grade=grade+"+";
			else grade=grade+"-";
		}
		
		System.out.println(grade);
	}	
}
