package kr.or.ddit.study13;

import java.util.ArrayList;

public class ArrayListExample2 {
	
	public static void main(String[] args) {
		
			
		Student s1 = new Student("홍길동", 91, 83, 97, 0, 0, 1);
		Student s2 = new Student("강감찬", 99, 99, 97, 0, 0, 1);
		Student s3 = new Student("이성계", 89, 87, 83, 0, 0, 1);
		Student s4 = new Student("이순신", 99, 99, 99, 0, 0, 1);
		Student s5 = new Student("정몽주", 97, 79, 97, 0, 0, 1);
		Student s6 = new Student("정몽헌", 97, 79, 97, 0, 0, 1);
		
		ArrayList al = new ArrayList();
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		
//		System.out.println(al.size());
//		System.out.println(al);
//		for(Object s : al) {
//			System.out.println(s);
//		}
		
		al.add(s6);
//		System.out.println(al.size());
		
		al.remove(s4);
//		System.out.println(al.size());
		for(Object s : al) {
			System.out.println(s);
		}
		
		al.remove(1);
		al.remove(2);
		System.out.println("---------remove---------");
		for(Object s : al) {
			System.out.println(s);
		}
		
		System.out.println("----------------------contains-----------------");
		if(al.contains(s3)) {
			System.out.println(s3+ "s3 여기 있어");
		}
	}
}
