package kr.or.ddit.basic;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class T01ArrayListTest {

	public static void main(String[] args) {
		
		//default capacity = 10
		List<Object> list1 = new ArrayList<Object>();
		
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('c');
		list1.add(true);
		list1.add(12.22);
		
		System.out.println("size =>" + list1.size());
		System.out.println("list1 =>" + list1);
		
//		n번째 자료 꺼내오기 -> list.get(n-1);
		
//		데이터 끼워넣기도 add사용
		list1.add(0, "zzz");
		System.out.println("zzz끼워넣기 후: " + list1);
		
//		데이터 변경
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp-> "+ temp);
		System.out.println("데이터 변경후 list1-> "+ list1);
		
		//데이터 삭제
		list1.remove(0);
		System.out.println("첫번째 값 삭제 후>> " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb삭제후 >>" + list1);

		list1.remove(new Integer(111));
		System.out.println("111삭제후 >>" + list1);
/////////////////////////////////////////////////////////////////
		List<String> list2 = new ArrayList<String>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(String s : list2)
			System.out.println(s);

//		contains -- 비교객체 있으면 true 아니면 false
		System.out.println(list2.contains("AAA"));
		System.out.println(list2.contains("FFF"));
		
//		indexOf 값의 위치
		System.out.println(list2.indexOf("CCC"));

//		for(int i = 0; i <list2.size(); i++)
//			list2.remove(i);
//		System.out.println(list2.size());
		list2.clear();
		System.out.println(list2.size());
		
	} 
}
