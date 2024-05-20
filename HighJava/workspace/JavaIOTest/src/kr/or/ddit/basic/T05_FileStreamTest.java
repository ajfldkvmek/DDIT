package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;

public class T05_FileStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("D:/D_Other/test2.txt");
			
			int data = 0;
			
			while( (data = fis.read()) != -1) {
				System.out.print((char) data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		} 
	}
}
