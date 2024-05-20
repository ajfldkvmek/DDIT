package kr.or.ddit.study09.exam1;

import java.util.Scanner;

public class PersonTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PersonVo p1 = new PersonVo("가나나", 20, "ROK");
		PersonVo p2 = new PersonVo("abc", 20, "USA");
		PersonVo p3 = new PersonVo("qwe", 20, "UK");
		PersonVo p4 = new PersonVo("zxc", 20, "JPN");
		PersonVo p5 = new PersonVo("123", 20, "GRM");

		System.out.print("p1의 나이 입력: ");
		int age1 = sc.nextInt();
//		if (age1 < 0) System.out.println("음수는 안되다");
//		else p1.age = age1;
		p1.setAge(age1);
		
		System.out.print("p2의 나이 입력: ");
		int age2 = sc.nextInt();
//		if (age2 < 0) System.out.println("음수는 안되다");
//		else p2.age = age2;		
		p2.setAge(age2);
		
		System.out.print("p3의 나이 입력: ");
		int age3 = sc.nextInt();
//		if (age1 < 0) System.out.println("음수는 안되다");
//		else p3.age = age3;
		p3.setAge(age3);
		
		System.out.print("p4의 나이 입력: ");
		int age4 = sc.nextInt();
//		if (age1 < 0) System.out.println("음수는 안되다");
//		else p4.age = age4;
		p4.setAge(age4);
		
		System.out.print("p5의 나이 입력: ");
		int age5 = sc.nextInt();
//		if (age1 < 0) System.out.println("음수는 안되다");
//		else p5.age = age5;
		p5.setAge(age5);
		
				
	}
}
