package kr.or.ddit.basic;

class Util {
	//메서드는 return타입 앞에 제네릭
	//클래스는 클래스명뒤에 제네릭
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
//		boolean keyCompare = p1.getKey().equals(p2.getKey());
//		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return false;
	}
}

//multi type generic class
class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public void displayAll(K key, V value) {
		System.out.println(key + " : " + value);
	}
}

public class T04_GenericMethodTest {
	
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		boolean result = Util.<Integer, String>compare(p1, p2);
		
		if(result) {
			System.out.println("(논리적 의미로) 동일한 객체");
		} else {
			System.out.println("(논리적 의미로) 동일한 객체 아님");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("001", "홍길동");
		
		result = Util.<String, String>compare(p3, p4);
		
		if(result) {
			System.out.println("(논리적 의미로) 동일한 객체");
		} else {
			System.out.println("(논리적 의미로) 동일한 객체 아님");
		}
		
		p1.displayAll(180, "키");
		
	}
	
}