package kr.or.ddit.exam4;

public class Circle {

	double PI = Math.PI;
	
//	public static void main(String[] args) {
//		Circle c = new Circle();
//		double result = c.getArea(10);
//		System.out.println("넓이: " + result);
//	}
	
	public double getArea(int r) {
		return getArea((double)r);
	}
	/*
	 * 오버로딩: 변수타입, 개수를 다르게 하여 메소드를 호출 할 수 있다.
	 */
	public double getArea(double r) {
		return PI*r*r;
	}
	
	public double getArd(int r) {
		return PI*r*2;
	}
	
	public double getArd(double r) {
		return PI*r*2;
	}
	
	
}
