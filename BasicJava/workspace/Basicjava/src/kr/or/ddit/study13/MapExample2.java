package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MapExample2 {

	public static void main(String[] args) {
		
		//해시맵에 각각
		//key: eno, ename, dept, tel
		//value: 100, 장승수, 영업부, 01084228117
		//       101, 홍성범, 기획부, 01075623127           
		
		HashMap map = new HashMap();
		HashMap map2 = new HashMap();
		ArrayList al = new ArrayList();
		
		map.put("eno", "100");
		map.put("ename", "장승수");
		map.put("dept", "영업부");
		map.put("telno", "01084228117");
		
		map2.put("eno", "101");
		map2.put("ename", "홍성범");
		map2.put("dept", "기획부");
		map2.put("telno", "01075623127");
		
		
		System.out.println("eno: " + map.get("eno"));
		System.out.println("telno: " + map.get("telno"));
		
		System.out.println("map2's eno: " + map2.get("eno"));
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			String value = (String) map.get(key);
			System.out.println(key + ": " + value);
		}
		
		Iterator it2 = map2.keySet().iterator();
		while(it2.hasNext()) {
			String key = (String) it2.next();
			String value = (String) map2.get(key);
			System.out.println(key + ": " + value);
			
		}
		
		al.add(map);
		al.add(map2);
		
		
	}
}
