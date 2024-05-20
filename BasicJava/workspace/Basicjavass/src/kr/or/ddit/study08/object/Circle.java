package kr.or.ddit.study08.object;

public class Circle {

	int x;
	int y;
	double r;
	double area;
	double around;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		
		area = r*r*3.14;
		around = r*2*3.14;
	}

	@Override
	public String toString() {
		return "Circle [x좌표= " + x + ", y자표= " + y + ", 반지름= " + r + ", 넓이= " + area + "둘레=: " + around + "]";
	}
	
}
