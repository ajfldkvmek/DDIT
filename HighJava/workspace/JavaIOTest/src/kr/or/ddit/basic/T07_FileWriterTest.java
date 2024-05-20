package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FileWriter(문자기반스트림) 테스트
 */

public class T07_FileWriterTest {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일에 저장하기
		// 콘솔과 연결된 입력용 문자 스트림 생성
		// inputStreamReader 스트림: 바이트기반 스트림을 문자기반 스트림으로
		// 변환해주는 보조 스트림

		InputStreamReader isr = new InputStreamReader(System.in);

		FileWriter fw = null;

		try {
			fw = new FileWriter("D:/D_Other/testChar.txt");
			System.out.println("아무거나 입력하세요(종료: Ctrl + z)");
			int data = 0;
			while( (data = isr.read()) != -1) {
				fw.write(data);
			}
			System.out.println("작업끝");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}
}
