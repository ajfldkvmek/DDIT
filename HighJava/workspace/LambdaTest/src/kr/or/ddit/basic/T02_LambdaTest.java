package kr.or.ddit.basic;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class T02_LambdaTest {

	public static void main(String[] args) {

		// 람다식을 사용하지 않았을 경우
		LambdaTestInterface01 lam1 = new LambdaTestInterface01() {
			@Override
			public void test() {
				System.out.println("ㅇㅎㅇㅎㅎ");
				System.out.println("익명 구현 객체 방식입니다");
			}
		};
		lam1.test();

		// 람다식 사용
		LambdaTestInterface01 lam2 = () -> {
			System.out.println("람다식 처리");
		};
		lam2.test();
		System.out.println("-----------------------------");

		/*
		 * 람다식 작성법
		 * 
		 * 기본형식: (자료형이름 매개변수형) -> {실행문들;...} 1.매개변수의 자료형이름은 생략x ex) (int a)
		 * {System.out.println(a);} (a) -> {System.out.println(a);}
		 *
		 * 2)매개변수가 1개일 경우 괄호( '()' ) 생략할 수 있다 ex) a -> {실행문;}
		 * 
		 * 3) '실행문'이 1개일경우 '{}' 생략할 수 있따(문장끝을 나타내는 ';'도 생략가능 ex) a -> sysout(a)
		 * 
		 * 4) 매개변수가 하나도 없으면 괄호 '()'를 생략할 수 없다
		 * 
		 * 5) 반환값이 있을 경우 return 명령을 사용한다 ex) (a,b) -> {return a+b;} (a,b) -> retrun a+b;
		 * 
		 * 6) 실행문에 return문만 있을 경우 return명령과 '{}'를 생략할 수 있다 ex) (a,b) -> a+b
		 * 
		 */
		//Consumer>> 파라메터1개, return값 없을 때 사용할 수 있는 내장 람다
		Consumer<Integer> lam3 = (Integer z) -> {
			Integer result = z + 100;
			System.out.println("result = " + result);
		};
		lam3.accept(30);

		Consumer<Integer> lam4 = z -> {
			Integer result = z + 300;
			System.out.println("result = " + result);
		};
		lam4.accept(60);

		Consumer<Integer> lam5 = 
				z -> System.out.println("result = " + (z + 500));
		lam5.accept(90);
		System.out.println("----------------------");
		/////////////////////////////////////////////
		//Bifunction>> 파라메터2개, return값 있을 때 사용하는 내장 람다
//		LambdaTestInterface03 lam6 = (int x, int y) -> {
//			int r = x + y;
//			return r;
//		};
//		int k = lam6.test(20, 50);
//		System.out.println("k = " + k);
		BiFunction<Integer, Integer, Integer> lam6 =
				(Integer x, Integer y) -> {
					int r = x+y;
					return r;
				};
		int k = lam6.apply(20, 50);
		System.out.println();
		System.out.println("k = " + k);
		
		BiFunction<Integer, Integer, Integer> lam7 = 
				(Integer x, Integer y) -> {
			return x + y;
		};
		k = lam7.apply(80, 50);
		System.out.println("k = " + k);

		
		BiFunction<Integer, Integer, Integer> lam8 = 
				(Integer x, Integer y) -> x + y;
		k = lam8.apply(100, 200);
		System.out.println("k = " + k);
		
		BiFunction<Integer, Integer, Integer> lam9 = 
				(Integer x, Integer y) -> x > y ? x : y;
		k = lam9.apply(100, 200);
		System.out.println("k = " + k);
	}
}
