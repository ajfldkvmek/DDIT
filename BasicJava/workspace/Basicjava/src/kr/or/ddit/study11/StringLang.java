package kr.or.ddit.study11;

import java.io.File;

public class StringLang {
	public static void main(String[] args) {
		StringLang sl = new StringLang();
//		sl.method1();
//		sl.method2();
//		sl.method3();
//		sl.method4();
//		sl.method5();
//		sl.method6();
//		sl.method7();
		sl.method8();
	}

	private void method8() {		
		//alt shift a
		// TODO Auto-generated method stub
		String test = "스플릿 테스트\n"
				    +"test1,"
				    +"test2,"
				    +"test3,"
				    +"test4,"
				    +"test5,";
//		System.out.println(test);
		String[] line = test.split(",");
		
		for(String s: line) {
			System.out.println(s);
		}
				
	}

	private void method7() {
		// TODO Auto-generated method stub
		String str= null;
		if(str.isEmpty()) {
			System.out.println("해당 문자열은 비어있습니다");
		}
		
		if(str != null|| str.isEmpty()) {
			
		}	
}

	private void method6() {
		String test ="가나다가나다가나다18";
		
		System.out.println(test);
		test = test.replace("18", "*");
		System.out.println(test);
		
//		test.replaceAll("정규식", replacement);
	}

	private void method5() {
		String test = " 공백 제거 \t   \n \r \r\n";
		System.out.println(test);
		System.out.println("----------");
		test = test.trim();
		System.out.println(test);
		System.out.println("----------");
	}

	private void method4() {
		String test = "소문자 abcd";
		System.out.println(test);
		test = test.toUpperCase();
		System.out.println(test);
		
		if(test.contains("aBcd")) {
			System.out.println("abcd값이 포함되어 있습니다.");
		}
		
		System.out.println("---------------------");
		String test1 = "대문자 ABCD";
		System.out.println(test1);
		
		test1 = test1.toLowerCase();
		System.out.println(test1);
		
	}

	private void method3() {
		String test = "문자열 test 입니다.";
		
		String start ="문자열";
		if(test.startsWith(start)) {
			System.out.println(start + "로 시작됩니다.");
		}
		
		String end = "입니다.";
		if(test.endsWith(end)) {
			System.out.println(end + "로 끝납니다.");
		}
		// 2023년으로 시작하는 엑셀 파일 개수를 구해보시오.
		
		int cnt = 0;
		
		File dir = new File("원하는 폴더 경로");
		for(String s : dir.list()) {
			if(s.startsWith("2023")) {
				
			}else continue;
			
			if(s.endsWith(".xls") || s.endsWith(".xlsx")) {
				cnt++;
			}
		}
		
		
		
	}

	public void method2() {
		String test ="문자열 test 입니다.";
		String search = "test1";
		
		if(test.contains(search)) {
			System.out.println(search + "값이 포함되어 있습니다.");
		}
		
		search =test;
		if(test.equals(search)) {
			System.out.println(search + "값이 동일합니다.");
		}
	}
	
	private void method1() {
		String test = "문자열 test 입니다.";
		
		for(int i=0; i<test.length(); i++) {
			System.out.println(test.charAt(i));
		}
		
		char ch[] = test.toCharArray();
		for(int i=0; i<ch.length; i++) {
			char c = ch[i];
			System.out.println(ch[i]);
		}
		
		/*
		 * 향상된 포문 
		 * 배열이나 리스트에서 사용됨.
		 * char c <- 하위 타입 
		 * : <- 세미콜론이 아님
		 * test.toCharArray() <- 배열 혹은 리스트 
		 * for(char c : test.toCharArray()) {
		 * 
		 */
		
		for(char c : test.toCharArray()) {
			System.out.println(c);
		}
		
	}
} 
