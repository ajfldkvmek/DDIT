package kr.or.ddit.study06.exam2;

public class TriangleTest {

	public static void main(String[] args) {

		Triangle t1 = new Triangle(17, 12, 34, 54, 7, 11);
		System.out.println(t1);
		
		// t2 point 객체를 이용하며 만들기
		Point p1 = new Point(17, 12);
		Point p2 = new Point(34, 54);
		Point p3 = new Point(7, 11);
		
		Triangle t2 = new Triangle(p1, p2, p3);
		System.out.println(t2);
	}
}
