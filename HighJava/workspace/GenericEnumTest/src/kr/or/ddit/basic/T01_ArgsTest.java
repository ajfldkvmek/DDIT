package kr.or.ddit.basic;

public class T01_ArgsTest {
/*
 *	가변형 인수-> 메서드의 맥개변소의 개수가 실행될 때 마다 다를 떄 사용한다
 *	가변형 인수는 메서드안에서는 배열로 처리된다
 *	가변형 인수는 한가지 자료형만 사용할 수 있다
 *	
 */
	public static void main(String[] args) {
		
		T01_ArgsTest t1 = new T01_ArgsTest();
		
		int[] data = {100, 200, 300};
		String name = "moomyung";
		System.out.println(t1.sumArr(data));
		System.out.println(t1.sumArr(new int[] {1,2,3,4,5}));
		
		System.out.println(t1.sumArg(100, 200, 300));
		System.out.println(t1.sumArg(1,2,3,4,5));
		
		System.out.println(t1.sumArg2(name, data));
		System.out.println(t1.sumArg2(name, new int[] {1,2,3,4,5}));
	}
	
	/**
	 * 	가변형 인수를 사용한 메서드 sumArg
	 */
	public int sumArg(int...data) {
		int num = 0;
		for(int i = 0; i < data.length; i++) {
			num += data[i];
		}
		return num;
	}
	/**
	 *  가변형 인수와 일반 인수를 같이 사용할 경우에는
	 *  가변형 인수를 가장 뒤에 배치해야한다
	 */
	public String sumArg2(String name, int...data) {
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name+ "씨의 점수는 " + sum;
	}
	
	public int sumArr(int[] data) {
		int num = 0;
		for(int i = 0; i < data.length; i++) {
			num += data[i];
		}
		return num;
	} 
	
}
