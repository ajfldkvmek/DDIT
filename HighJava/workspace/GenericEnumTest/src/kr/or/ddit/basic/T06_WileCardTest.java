package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06_WileCardTest {

	/*
	 * 와일드카드는 제너릭타입을 이용한 타입 안정한 코드를 위해 사용되는 특별한 종류의 인수로써 변수 선언, 객체생성 및 메서드정의 할 때
	 * 사용된다 (제네릭타입 선언시 사용할 수 없다)
	 * 
	 * <? extends T> => 와일드카드의 상한제한, T와 그 자손들만 가능 <? super T> => 와일드카드의 하한제한, T와 그
	 * 조상들만 가능 <?> => 모든 가능한 타입
	 */
	public static void main(String[] args) {

//		List<?> strList = new ArrayList<String>();

		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
//		FruitBox<String>strBox = new FruitBox<String>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple()); // << APPLE타입맞 받는 제네렉 클래스
//		appleBox.add(new Grape());

		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox); // << makejuice는 Fruit만 받는다
	}
}

class Juicer {
	//T type 인데 Fruit또는 그 하위만 입력 가능
	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	//static void makeJuice(FruitBox<Fruit> box) {
		String fruitListStr = ""; // 과일 목록

		int cnt = 0;
		// for(Fruit f: box.getFruitList()) {
		for (T f : box.getFruitList()) {
			if (cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + ">> 주스 완성!");
	}
	
	//일반메소드 + wildcard
	/*
	static void makeJuice(FruitBox<? extends Fruit> box) {
		String fruitListStr = ""; // 과일 목록

		int cnt = 0;
		// for(Fruit f: box.getFruitList()) {
		for (Object f : box.getFruitList()) {
			if (cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + ">> 주스 완성!");
	}*/
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "(" + name + ")";
	}
}

class Apple extends Fruit {
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {
	public Grape() {
		super("포도");
	}
}

//class FruitBox<T extends Fruit> {
class FruitBox<T> {
	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<T>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

//	public void setFruitList(List<T> fruitList) {
//		this.fruitList = fruitList;
//	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}
}
