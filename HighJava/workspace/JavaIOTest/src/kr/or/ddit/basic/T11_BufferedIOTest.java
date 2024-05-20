package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
	입출력성능 향상을 위한 보조스트림 예제
 */
public class T11_BufferedIOTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("D:/D_Other/bufferTest.txt");
			//버퍼크기 지정안하면 기본크기는 8KB
			//크기가 5KB인 보조 스트림 생성
			bos = new BufferedOutputStream(fos, 5);
			
			for(char ch = '1'; ch <='9'; ch++) {
				bos.write(ch);
			}
			System.out.println("작업 끝");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//close는 스트림을 닫는 것, flush는 버퍼를 비우는 기능
				//bos.flush();
				bos.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}