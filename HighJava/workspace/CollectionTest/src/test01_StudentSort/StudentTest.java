package test01_StudentSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
//		   총점 정렬기준은 외부클래스에서 제공하도록 한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력>> ");
		int num = sc.nextInt();
		List<Student> list1 = new ArrayList<>();

		for(int n = 0; n < num; n++) {
//			System.out.print("학번>> ");
			String stdNo = sc.next();
//			System.out.print("이름>> ");
			String name = sc.next();
//			System.out.print("국어>> ");
			int kor = sc.nextInt();
//			System.out.print("수학>> ");
			int math = sc.nextInt();
//			System.out.print("영어>> ");
			int eng = sc.nextInt();
			Student s = new Student(stdNo, name, kor, math, eng);
			
			list1.add(s);
		}
		sc.close();
		
		System.out.println("학번순 정렬");
		Collections.sort(list1);
		for(Student s : list1)
			System.out.println(s);
		
		System.out.println("성적순 정렬");
		Collections.sort(list1, new Desc());
		for(Student s : list1)
			System.out.println(s);
		
	}
}

class Desc implements Comparator<Student> {
	/*
	 * compare()메서드의 반환값을 결정하는 방법 >>이 메서드가 양수값 반환하면 두 값의 순서가 바뀐다(기본: 오름차순)
	 * 
	 * 오름차순 정렬일 경우 앞이 갑이 크면 양수, 같으면 0, 작으면 음수반환
	 *  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
	 */
	public int compare(Student s1, Student s2) {
		
		//Integer.compare(o1, o2) 도 가능
		if(s1.getSum() > s2.getSum()) {
			return -11;
		} else if(s1.getSum() < s2.getSum()) {
			return 1;
		} else {
			return s1.getStdNo().compareTo(s2.getStdNo())*-1;
		}
	}
}
