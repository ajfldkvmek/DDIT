package kr.or.ddit.study13;

import java.util.HashSet;

/**
 * 
 * @author PC-06
 * 
 * Hashset
 * 
 * Key로 이루어짐
 * Key 값은 중복을 허용하지 않고 순서가 보장되지 않음
 * 
 * set 타입의 대표 컬렉션
 * 
 * 주요메소드
 * .add(key)		 추가
 * .remove(key)		 삭제
 * .contains(key)    포함여부
 * .iterator(key)    전체출력
 */
public class SetExample {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		hs.add("가");
		hs.add("라");
		hs.add(1);
		hs.add(10.3);
		
		hs.add("가");
		System.out.println(hs);
		
		HashSet lotto = new HashSet();
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*45)+1);
		}
	
		System.out.println(lotto);
	}
}
