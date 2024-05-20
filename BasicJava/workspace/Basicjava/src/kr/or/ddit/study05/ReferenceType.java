package kr.or.ddit.study05;

import java.util.Scanner;

public class ReferenceType {

	Scanner sc = new Scanner(System.in);
	String a = "전역변수";
	
	public static void main(String[] args) {
		ReferenceType obj = new ReferenceType();
		obj.method1();
		obj.method2();
		obj.method3();
		obj.method4();
	}

	private void method4() {
		// TODO Auto-generated method stub
//		int[] arr1 = new int[] {1,2,3,4,5};
//		int[] arr2 = new int[] {1,2,3,4,5};
		
//		System.out.println(arr1);
//		System.out.println(arr2);
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		System.out.println("c1" + c1);
		System.out.println("c2" + c2);
		System.out.println(c1.name);
		System.out.println(c1.age);
	}

	private void method3() {
		// TODO Auto-generated method stub
//		String s1 = "가나다";
//		String s2 = "가나다";
//		String s3 = "라마바";
//		String s4 = new String("라마바");
//		String s5 = new String("라마바");
//		
//		System.out.println(s1==s2);
//		System.out.println(s1==s3);
//		System.out.println(s3==s4);
//		System.out.println(s3==s5);
//		System.out.println(s4==s5);
//		
//		System.out.println(s3.equals(s4));
//		System.out.println(s3.equals(s5));
//		System.out.println(s5.equals(s4));
//		
//		s1.toString();
	}

	private void method2() {
		// TODO Auto-generated method stub
//		String b = "method2 변수";
//		System.out.println(a);
//		System.out.println(b);
	}

	private void method1() {
		// TODO Auto-generated method stub
//		String b = "method1 변수";
//		System.out.println(a);
//		System.out.println(b);
	}
}


class Customer {
	
	String name;
	int age = 9999;
	public Customer() {
		this.name = "강감찬";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+", "+age;
	}
}
