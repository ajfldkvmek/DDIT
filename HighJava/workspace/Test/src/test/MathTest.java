package test;

public class MathTest {

	public static void main(String[] args) {
		
//		System.out.println(sqrt(24));
		
	}
	
	static int root(int a) {
		int res = 0;
		int i = 1;
		while(true) {
			if( (i*i) >= a) {
				if(i*i == a) res = 1;
				break;
			}
			
			i++;
		}
		return res;
	}
	
	static int sqrt(int a) {
		int b = 1;
		while(true) {
			if(a < b*b) {
				b--;
				break;
			}
			b++;
		}
		return b;
	}
	
	
}
