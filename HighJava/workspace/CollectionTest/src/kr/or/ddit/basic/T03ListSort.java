package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03ListSort {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("가");
		list.add("다");
		list.add("마");
		list.add("나");
		list.add("라");

		System.out.println("정렬전>> " + list);
		System.out.println();

		// 오름차순
		Collections.sort(list);
		System.out.println("정렬후>> " + list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list, new Desc());
	}

}

//정렬방식 결정하는 클래스(외부정렬자)는 comparator를 구현해야한다
class Desc implements Comparator<String> {
	@Override

	/*
	 * compare()메서드의 반환값을 결정하는 방법 >>이 메서드가 양수값 반환하면 두 값의 순서가 바뀐다(기본: 오름차순)
	 * 
	 * 오름차순 정렬일 경우 앞이 갑이 크면 양수, 같으면 0, 작으면 음수반환
	 */

	public int compare(String str1, String str2) {
		return str1.compareTo(str2)*-1;
	}
	


}