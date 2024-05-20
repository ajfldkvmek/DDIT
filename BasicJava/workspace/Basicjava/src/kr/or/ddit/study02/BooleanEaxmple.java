package kr.or.ddit.study02;

public class BooleanEaxmple {
	
	public static void main(String[] args) {
		//true false 논리 연산
		
		//boolean false;
		boolean flag = false;
		
		int age = 95;
		flag = (age>17);
		if(flag) {
			System.out.println("성년");
		}
		else System.out.println("미성년");
		
		while(flag) System.out.println("flag가 참이면 반복");
		
	}

}
