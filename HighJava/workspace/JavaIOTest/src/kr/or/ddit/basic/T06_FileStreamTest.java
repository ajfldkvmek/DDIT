package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일 입출력 예제
 */
public class T06_FileStreamTest {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// FileOutputStream은 파일 업으면 생성해줌ㄴ
			fos = new FileOutputStream("D:/D_Other/out.txt");
			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			System.out.println("파일에 쓰기 완료");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		try {
			fis = new FileInputStream("D:/D_Other/out.txt");
//			fis = new FileInputStream(new File("D:/D_Other/out.txt"));
			int data = 0;
			while( (data = fis.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
