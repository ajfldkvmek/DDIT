package kr.or.ddit.study11;

public class MathExample {
	
	public static void main(String[] args) {
		
		double ran = Math.random();
		System.out.println(ran);
		
		int abs = Math.abs(-10);
		System.out.println(abs);
		
		int a = 0;
		int b = 10;
		int max = Math.max(a, b);
		System.out.println(max);
		
//		pow(a,b) : a의 b 제곱
//		logN
//		sqrt: 제곱근
//		round : 반올림
		
		double pi = 3.141592;
		
		MathExample me = new MathExample();
		
		System.out.println(me.mr(pi, 3));;
	}
	
	public double mr(double b, int n) {
		
		double pow = Math.pow(10, n-1);
		
		double res = Math.round(b * pow) / pow;		
		return res;
	}

}
