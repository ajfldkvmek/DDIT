package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeWork {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("D:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("D:/D_Other/복사본_Tulips.jpg");

			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
