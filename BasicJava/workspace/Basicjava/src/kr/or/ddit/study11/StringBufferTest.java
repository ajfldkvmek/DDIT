package kr.or.ddit.study11;

import java.util.Date;

public class StringBufferTest {

	public static void main(String[] args) {
		
		Date d1 = new Date();
//		stringTest();
		stringBufferTest();
		Date d2 = new Date();
		
		long time = (d2.getTime()-d1.getTime());

		System.out.println(time);
	}
	
	public static void stringTest() {
		String str = "";
		for(int i = 0; i < 1000000; i++) {
			str +='a';
		}
	}
	//갯수가늘어나면 stringbuffer사용하자
	public static void stringBufferTest() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 1000000; i++) {
			sb.append("a\n");
		}
		String str = sb.toString();
		System.out.println(str);
	}
	
}
