package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10_FileEncodingtest {

	public static void main(String[] args) throws IOException {
		/*
		 * OutputStreamWriter 객체 >>바이트 기반 객체를 문자기반 객체로 변환해주는 보조 스트림 
		 * 							이 객체도 인코딩방식을 지정하여  출력할 수 있다
		 * 
		 * 
		 * 키보드로 입력한 내용을 파일로 저장하는데 out_utf8, out_ansi로 지정가능
		 */

		// 입력용 스트림 객체
		InputStreamReader isr = new InputStreamReader(System.in);

		// 출력용 스트림
		FileOutputStream fos1 = new FileOutputStream("D:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = new FileOutputStream("D:/D_Other/out_ansi.txt");

		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "utf-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "ms949");

		System.out.println("아무거나 입력 ㄱ(종료: ctrl+z)");

		int data = 0;
		
		while((data = isr.read()) != -1) {
			osw1.write(data);
			osw2.write(data);
		}
		System.out.println("작업완료...");
		
		isr.close();
		osw1.close();
		osw2.close();
	}
}
