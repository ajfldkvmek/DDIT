package kr.or.ddit.study06.object;

public class Point {

	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
