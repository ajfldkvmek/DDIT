package kr.or.ddit.study03;

import java.util.Scanner;

public class TestTemplate {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TestTemplate obj = new TestTemplate();
		obj.test1();
		obj.test2();
	}
	
	private void test2() {
		// TODO Auto-generated method stub
		System.out.println("test2 메소드 입니다");
		System.out.println("test2 메소드 입니다");
		System.out.println("test2 메소드 입니다");
		System.out.println("test2 메소드 입니다");
		System.out.println("test2 메소드 입니다");
	}

	private void test1() {
		System.out.println("test1 메소드 입니다");
		System.out.println("test1 메소드 입니다");
		System.out.println("test1 메소드 입니다");
		System.out.println("test1 메소드 입니다");
		System.out.println("test1 메소드 입니다");
	}
}
