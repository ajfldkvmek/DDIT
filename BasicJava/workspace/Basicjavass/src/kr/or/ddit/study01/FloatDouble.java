package kr.or.ddit.study01;

public class FloatDouble {
	
	public static void main(String[] args) {
//		1. float: 4byte 부호1 지수8 기수 23 끝에 f추가 ex)float a = 3.14f
//		2. double: 8btye 부호1 지수11 기수 52
		
		//변환오차 발생 -> 두 개 쓰지말고 하나만 써
		double d1 = 3.14;
		float f1 = 3.14f;
		
		if(f1 == d1) System.out.println("같아");		
		else System.out.println("달라");
	}
}
