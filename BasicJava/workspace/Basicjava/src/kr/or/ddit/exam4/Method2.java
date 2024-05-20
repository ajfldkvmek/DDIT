package kr.or.ddit.exam4;

public class Method2 {

	public static void main(String[] args) {
//		Circle c = new Circle();
//		int r = 10;
//		double r2 = 10.5;
//		
//		double area = c.getArea(r);
//		double round = c.getArd(r);
//		System.out.println("원의 넓이는 " + area);
//		System.out.println("원의 둘레는 " + round);		
//	
//		double darea = c.getArea(r2);
//		double dround = c.getArd(r2);		
//		System.out.println("원의 넓이는 " + darea);
//		System.out.println("원의 둘레는 " + dround);
		
		Method2 m2 = new Method2();
		m2.recursive(10);
	}
	
	public void recursive(int i) {
		if(i == 0) {
			System.out.println("종료");
			return;
		}
		System.out.println(i);
		recursive(--i);
	}
}
