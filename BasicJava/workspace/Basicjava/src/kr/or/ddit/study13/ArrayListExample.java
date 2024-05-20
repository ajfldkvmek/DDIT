package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author PC-06
 * 
 * ArrayList 1차원배열 구조
 * 중복을 허락하고 순서화 제공
 * List 타입의 컬렉션
 * 
 * 주요메소드
 * .add 	 : 삽입
 * .clear 	 : 초기화
 * .contains : 포함여부
 * .get 	 : idx 반환
 * .remove 	 : idx값 반환하고 삭제
 *
 */

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayTest at = new ArrayTest();
		
		for(int i = 0; i < 20; i++) {
			at.add("str" + i);
		}
		String[] arr = at.arr;
//		System.out.println(at.contains("str1"));
//		System.out.println(arr.length);
//		System.out.println(Arrays.toString(at.arr));
	
		/*
		 * 배열중에 str6이 있는지 검사해보기
		 * 
		 **/
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i].equals("str6")) {
//				System.out.println(i + "번째에있어");
//				break;
//			}
//		}
		
		ArrayList l = new ArrayList();
		l.add("데이터");
		l.add(10.3);		
		
		for(int i = 0; i <l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}
