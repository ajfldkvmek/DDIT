package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09_FileEncodingTest {

	/*
	 * 문자인코딩 방시에 대하여
	 * 
	 * 한글 인코딩 방식은 크게 UTF-8과 EUC-KR 두 가지 가 있다 원래 한글 윈도우는 CP949방식을 사용했는데 MS사에서
	 * EUC-KR방식 코드표에서 확장했기때문에 MS949라고도함
	 * 
	 * 한글 윈도우의 메모장에서 말하는 ANSI인코딩일아 CP949(Code Page 949)를 말한다 - MS949 -> 한글윈도우의 기본 한글
	 * 인코딩 방식(ANSI계열) - US-ASCII -> 영문전영인코딩
	 * 
	 * 참고) ASCII => extended ASCII(ISO 8859-1) => 완성형(KSC 5601) => 윈도우 계열: CP949 =>
	 * 유닉스 계열: EUC-KR(확장유닉스 코드)
	 * 
	 * => ANSI계열 => EUC-KR ---------------------------------- => 유니코드(UTF-8)
	 */

	public static void main(String[] args) {

		FileInputStream fis = null;
		InputStreamReader isr = null;

		try {
			fis = new FileInputStream("D:/D_Other/test_ansi.txt");
			isr = new InputStreamReader(fis, "cp949");

			int data = 0;

			while ((data = isr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			System.out.println("출력끝");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				보조스트림만 닫아도 됨
//				fis.close();
				isr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
