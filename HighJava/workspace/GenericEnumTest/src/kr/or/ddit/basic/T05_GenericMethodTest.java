package kr.or.ddit.basic;

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) {

		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}

public class T05_GenericMethodTest {

	public static void main(String[] args) {
		int result = Util2.compare(10, 20);
		System.out.println(result);

		int res2 = Util2.compare(3.14, 3);
		System.out.println(res2);
	}
}

interface Flyable {
	public void fly();
}

class MyPlane implements Flyable {
	@Override
	public void fly() {
		System.out.println("난다! 비행기!");
	}
	
}