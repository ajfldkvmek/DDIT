package kr.or.ddit.study06.object;

public class Rectangle {

	/*
	 * int x, y;
	 * 높이 넓이 선언
	 * 
	 * 생성자 구현
	 */	
	int x;
	int y;
	int width;
	int height;
	int area;
	
	public Rectangle() {
		height = 10;
		width = 10;
	}
	
//	public Rectangle(int height, int width) {
//		this.height = height;
//		this.width = width;
//		System.out.println("사각형의 밑변: " + width);
//		System.out.println("사각형의 높이: " + height);
//		
//		System.out.println("사각형의 넓이: " + height*width);
//	}	
	public Rectangle(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		area = height*width;
//		System.out.println("사각형의 밑변: " + this.width);
//		System.out.println("사각형의 높이: " + this.height);
//		System.out.println("사각형의 넓이: " + this.height*this.width);
	}

	@Override
	public String toString() {
		return "Rectangle [x좌표= " + x + ", y좌표= " + y + ", 높이= " + height + ", 너비= " + width + ", 넓이= " + area + "]";
	}
	
	
}
