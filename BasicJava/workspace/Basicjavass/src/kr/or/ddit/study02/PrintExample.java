package kr.or.ddit.study02;

public class PrintExample {
	
	public static void main(String[] args) {
		
		System.out.print("길동아");
		System.out.print(" 123123");
		System.out.print(" 대전 중구 계룡로\n");
		System.out.println();
		
		System.out.println("길동아아");
		System.out.println(" 123123");
		System.out.println(" 대전 중구 계룡로");
		
//		형식 지정 문자열, 변수리스트
//		System.out.printf();
//		
//		System.out.printf("형식지정문자열", 변수 리스트);
//		%[[-|0]n]d --> %d: 10진 정수 %f: 실수  %s: 문자열
		//		-: 왼쪽 정렬
//		0: 남은 공간 0으로 채움
		
		System.out.printf("숫자: %d\n",1000);
		System.out.printf("%8d\n", 1000);
		System.out.printf("%-8d\n", 1000);
		System.out.printf("%08d\n", 1000);
		System.out.println();
		
		System.out.printf("이름: %s, 나이: %d, 응애에요: %f", "자아바", 25, 123.123);
		
	}

}
