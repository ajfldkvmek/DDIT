package kr.or.ddit.basic;

/*
 *  열거형(enum) -> 상수값들을 선언하는 방법
 *  static final int ~~
 *  static final int ~~
 *  static final int ~~
 *  static final int ~~
 *
 *  ==>>>>>> enum Data{A, B, C, D};
 *  -> enum (Name) {상수1, 상수2,...,상수n}
 *  
 */


public class T02_EnumTest {

	public static void main(String[] args) {
		

//		int a = Animal.LION;
//		if(a == Flower.ROSE) {
//			System.out.println("장미다");
//		
	/*
	 *  열거형에서 사용되는 메소드
	 *  name() = 열거혀의 상수를 문자로 받환한다
	 *  ordinal() 열거형 상수가 정의된 순서값을 반환한다(기본적으로 0부터 시작)
	 *  valueOf("열거형 상수이름") 지정된 열거형에서 "열거형 상수이름"과 일치하는 열거형 상수를 반환한다.
	 */
		
		City myCity1 = City.서울;
		City myCity2 = City.valueOf("서울");
		
		System.out.println(myCity1.name());
		System.out.println(myCity1.ordinal());
		System.out.println();
		System.out.println(myCity2.name());
		System.out.println(myCity2.ordinal());
		System.out.println("===========================");
		
		Season ss = Season.valueOf("여름");
		System.out.println(ss.name());
		System.out.println(ss.ordinal());
		System.out.println(ss.getData());
		System.out.println("-----------------------------");
		
		//.values() ->> 열거형상수 배열을 반환
		Season[] enumArr= Season.values();
		for(Season s : enumArr) {
			System.out.println(s.name() + ": " + s.getData());
		}
		System.out.println();
		
		for(City city : City.values()) {
			System.out.println(city.name()+" "+city.ordinal());
		}
		
		
		City city = City.대구;
		System.out.println(city == City.대구);
		System.out.println(city == City.대전);
		
		System.out.println("대구>> " + city.compareTo(City.대구));
		System.out.println("서울>> " + city.compareTo(City.서울));
		System.out.println("대전>> " + city.compareTo(City.대전));

//		System.out.println("대전>> " + city.compareTo(HomeTown.공주));
//		System.out.println(City.대전 == HomeTown.대전));
	}
	

	// City 열거형 객체 선언(기본값을 이용하는 열거형
	public enum City {
		서울(), 붓산(), 대구(), 광주(), 대전()
	}
	
	public enum HomeTown {평양, 남원, 공주, 대구, 대전, 진주}
	// 데이터값을 임의로 지정한 열거형 객체 선언
	// 데이터값을 정해 줄 경우에는 셍성자를 만들어서 괄호속의 값을 가져올 수 있어
	public enum Season {
		봄("3부터 5"), 여름("6부터 8"), 가을("9부터 11"), 겨울("12부터 2");
		//괄호속값이 저장될 변수 선언
		private String data;
		private Season(String data) {
			this.data = data;
		}
		public String getData() {
			return this.data;
		}
	}
}

//class Animal {
//	static final int LION = 1;
//	static final int TIGER = 2;
//}
//
//class Flower {
//	static final int ROSE = 1;
//	static final int SUNFLOWER = 7;
//}