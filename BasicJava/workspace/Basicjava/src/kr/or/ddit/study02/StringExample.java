package kr.or.ddit.study02;

public class StringExample {

	public static void main(String[] args) {
		//문자열: 데이터타입은 아님
		
		//String str1 = "this is String";
		
		String name1 = "길동이";
		String name2 = new String("길동삼");
		String sname = name1+", "+name2;
		
		
		System.out.println(sname);
		String nameEnter = name1 + "\n" + name2;
		System.out.println(nameEnter);
		
		String nameTab = name1 + "\t" + name2;
		System.out.println(nameTab);
		
		String nameComma = "\""+name1 + ","+name2+"\"";
		System.out.println(nameComma);
		
		
		String year = "20"+23;
		System.out.println(year);
		
		char c = 'k';
		String str = "20"+c;
		System.out.println(str);
	}
}
