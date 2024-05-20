package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T08_HashMapTest {

	public static void main(String[] args) {
		/*
		 * Map<K, V> K는 중복 허용X, 순서X V는 중복 ㅇ
		 */
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-2222");

		System.out.println("map>>> " + map);
//		데이터 수정 -> 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장

		map.put("addr", "수정");
		System.out.println("map>>> " + map);

		map.remove("name");
		System.out.println("map>>>" + map);

		System.out.println("addr = " + map.get("addr"));

//		key값들을 읽어와 데이터를 출력하는 방법
//		방법1. keySet 이용하기
//			map의 key값으로 구성된 set데이터를 반환함
//		map -> keyset -> iterator
		Set<String> keySet = map.keySet();

		System.out.println("Iterator를 이용한 방법");
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + ":" + map.get(key));
		}

//		방법2. 향상된 for문
		System.out.println("향상된 for문 이용");
		for (String key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}

//		방법3. value값들만 읽어와 출력하기
		System.out.println("values 이용한 방법");
		for(String value : map.values())
			System.out.println(value);
	
//		방법4. Map관련 클래스 중 Entry사용하기Entry>> (key + value)
//		Map.Entry<K, V> 타입의 객체들을 Set타입으로 가져오기
//		Entry는 Map의 내부 인터페이스, key와 value를 동시에 가져올 수 있음
		System.out.println("EntrySet 이용한 방법");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
//		가져온 Entry객체들을 iterator를 이용하여 가져오기
		Iterator<Map.Entry<String, String>> st = entrySet.iterator();
		
		while(st.hasNext()) {
			Map.Entry<String, String> entry = st.next();
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}
}
