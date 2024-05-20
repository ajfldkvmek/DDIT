package kr.or.ddit.study13;

import java.util.HashMap;
import java.util.Iterator;

import oracle.net.aso.e;


/**
 * 
 * @author PC-06
 *
 * MapExample
 * 
 * put(key, value)
 * get(key) value를 key를 통해 가져옴
 * 
 * 
 */
public class MapExample {

	public static void main(String[] args) {
		/*
		 * 제네릭 정보
		 * HashMap<key, value>
		 */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 95);
		map.put("강감찬", 99);
		map.put("정몽주", 85);
		map.put("이순신", 75);
		map.put("이성계", 87);
		
//		int score = (int) map.get("홍길동");
//		double d = (double) map.get("강감찬");
//		System.out.println(score);
//		System.out.println(d);
//		
		//기존값 새로 입력하면 덮어씌워짐
//		map.put("홍길동", 65);
//		score = (int) map.get("홍길동");
//		System.out.println(score);
		
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = map.get(key);
			System.out.println(key + ", " + value);
		}		
	}
}
