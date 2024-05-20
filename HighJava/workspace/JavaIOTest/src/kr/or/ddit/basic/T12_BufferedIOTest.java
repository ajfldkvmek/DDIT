package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author PC-06
 *	성능향상을 위한 보조 스트림 예제
 *	(문자기반 스트림을 위한 보조스트림)
 */

public class T12_BufferedIOTest {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("src/kr/or/ddit/basic/T11_BufferedIOTest.java");
			br = new BufferedReader(fr);
			int cnt = 1;
			String temp = "";
			while( (temp = br.readLine()) != null) {
				System.out.println(cnt+"\t"+temp);
				cnt++;
			}
			
//			int data = 0;
//			while( (data = fr.read()) != -1 ) {
//				System.out.println((char) data);
//			}
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
