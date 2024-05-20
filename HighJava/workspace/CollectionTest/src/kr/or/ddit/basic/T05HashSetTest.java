package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class T05HashSetTest {

	public static void main(String[] args) {
		
		Set<Object> hs1 = new HashSet<Object>();
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		//set은 순서개념이 없고 데이터 중복 허용하지않음
		
		//set 의 데이터를 수정하려면 수정하는 메서드가 없기떄문에 
		//해당데이터를 삭제후 새로운 데이터를 추가해야함
		
		//삭제메서드
		//clear(), remove(삭제할데이터)
		
		//ex) AA를 FF로 변경시
		hs1.remove("AA");
		hs1.add("FF");
		
		//전체삭제
//		hs1.clear();
		
		/*
		 * set은 인덱스 개념이 없기때문에 list처럼 인덱스 이용한 접근 불가능
		 * Map과 동일하게 Iterator 객체 필요
		 */
		
		Iterator<Object> it = hs1.iterator();
		
		while(it.hasNext()) { //다음값 있으면 return true아니면 return false
			System.out.println(it.next());
		}
		
		Set<Integer> intRnd = new HashSet<Integer>();
		while(intRnd.size() < 5) {
			int num = (int) (Math.random() * 100 + 1);
			intRnd.add(num);
		}
		System.out.println("난수>>" + intRnd);
		List<Integer> intRndList = new ArrayList<Integer>(intRnd); //set<->list는 같은 collection이라 서로 변환 가능;
		System.out.println("list데이터출력>> ");
		for(Integer i : intRndList) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
}
