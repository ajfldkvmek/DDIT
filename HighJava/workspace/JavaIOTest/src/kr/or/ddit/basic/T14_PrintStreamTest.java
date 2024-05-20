package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class T14_PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		FileOutputStream fos =
				new FileOutputStream("D:/D_Other/print.txt");
		
//		PrintStream은 모든 자료형 데이터를 출력하게 해주는 기능을 제공하는 클래스
		PrintStream out = new PrintStream(fos);
		
		out.print("안녕하세요 printStream입니다. \n");
		out.println("안녕하세요 printStream입니다2.");
		out.println("안녕하세요 printStream입니다3.");
		
		out.print(fos);
		out.println(3.14);
		
		out.close();
		/*
		 	printStream은 데이터를 문자로 출력하는 기능을 수행함(System.out)
		 	향상된 기능의 printWriter가 추가되었지만 계속 쓰이는 중
		 	
		 	printWriter가 printStream보다 다양한 문자를 처리하는데 적합
		 */
		
		FileOutputStream fos2 = 
				new FileOutputStream("D:/D_Other/print2.txt");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2, "CP949"));
		
		pw.print("ㅎㅇㅎㅇ PrintWriter 데스웅\n");
		pw.println("ㅎㅇㅎㅇ PrintWriter 데스웅2\n");
		pw.println("ㅎㅇㅎㅇ PrintWriter 데스웅3\n");
		
		pw.println(pw);
		pw.close();
	}
}
