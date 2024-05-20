package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class T07_EqualsHashCodeTest {

	/*
	 * 해시함수는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수
	 * 해시함수에 의해 얻어지는 값을 해시값, 코드를 해시코드라함
	 * 
	 * Hashset, Hashmap, Hashtable과 같은 객체를 사용할 경우
	 * 객체가 서로 같은지 비교하기 위해 hashcode와 equals 메서드를 사용한다
	 * 이를 통해 객체가 서로 같은지 비교해서 중복값 제거
	 * >> 서로 같은지 확인 위해 두 메서드 재정의 필요
	 * 일치 여부는 데이터 입력시 확인
	 * 이로 인해 입력시 성능은 저하됨
	 * 그러나 데이터를 가져오는 속도는 매우 빨라짐
	 * 
	 *  해시의 규칙
	 *  두 객체가 같으면 반드시 같은 해시값을 가져야함
	 *  두 객체가 같으면 equals로 호출시 true를 반환해야함
	 *  >> a.equals(b) == b.equlas(a) >> 둘 다 true 여야함
	 *  두 객체가 서로 달라도 해시값은 같을 수 있음
	 *  
	 *  equals를 재정의 해야하면 hashcode도 재정의 해야함
	 *  hash코드는 기본적으로 힙메모리 주소를 기반으로 생성
	 *  그러므로 클래스에서 hashcode매소드 재정의 하지 않으면 
	 *  절대로 두 객체가 같은 해시값을 가질 수 없다
	 *  
	 *  hash 먼저 비교 후 equals가 성능 그나마 좋아 << equals override할거면 hashcode도 override해줘라
	 */
	public static void main(String[] args) {
		Person p1 = new Person(123, "가나다");
		Person p2 = new Person(123, "가나다");
		Person p3 = new Person(123, "다라마");
		
		System.out.println(p1.equals(p2));
		System.out.println("p1==p2>>" + (p1==p2));
		System.out.println(p2.equals(p3));
		System.out.println(p1.equals(p3));

		Set<Person> pSet = new HashSet<Person>();
		System.out.println("add(p1) 성공여부: " + pSet.add(p1));
		System.out.println("add(p2) 성공여부: " + pSet.add(p2));
	
		System.out.println("p1, p2 등록후 데이터>> ");
		for(Person p : pSet) {
			System.out.println(p);
		}
		
		System.out.println("add(p3) 성공여부: " + pSet.add(p3));
		System.out.println("p3 등록후 데이터>> ");
		for(Person p : pSet) {
			System.out.println(p);
		}
		
		System.out.println("remove(p2) 성공여부: " + pSet.remove(p2));
		System.out.println("p2 삭제후 데이터>> ");
		for(Person p : pSet) {
			System.out.println(p);
		}
		
	}
}

class Person {
	
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return (this.getId() == p.getId()) 
				&& (this.getName().equals(p.getName()));
	}
	
	//String 객체는 이미 hashcode가 override되어있음
	@Override
	public int hashCode() {
		return (name+id).hashCode();
	}
}
