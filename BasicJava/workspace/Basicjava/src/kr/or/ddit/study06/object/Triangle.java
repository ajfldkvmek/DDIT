package kr.or.ddit.study06.object;

public class Triangle {

	/*
	 * 좌표 x1y1 x2y2 x3y3
	 */
	
	int x1, y1; //좌표1
	int x2, y2; //좌표2
	int x3, y3; //좌표3
	double area;
	
	int a, b;
	// |(x1y2 + x2y3 + x3y1) - (x2y1 + x3y2 + x1y3)|/2
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		
		a = (x1*y2 + x2*y3 + x3*y1);
		b = (x2*y1 + x3*y2 + x1*y3);
		area =  (a-b)/2.0;	
//		area = Math.abs(area);
		if(area < 0) area = -area;
		
	}


	public Triangle(Point p1, Point p2, Point p3) {
		
		this(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);

	}


	@Override
	public String toString() {
		return "점 1의 좌표: (" + x1 + "," + y1 + ") 점 2의 좌표: (" + x2 + "," + y2 + ") 점 3의 좌표 : (" + x3 + "," +y3 +")" + " 넓이: " + area;
	}
		
}
