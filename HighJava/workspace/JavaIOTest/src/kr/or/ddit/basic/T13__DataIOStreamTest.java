package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
  	기본타입 데이터 입출력 보조스트림 예제
 	
 */

public class T13__DataIOStreamTest {

	public static void main(String[] args) {
		
		//파일 쓰기
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("D:/D_Other/test.dat"));
			
			dos.writeUTF("길동이"); 	//문자열 데이터 출력
			dos.writeInt(18);		//정수형으로 출력
			dos.writeFloat(3.14f);	//실수형(float)
			dos.writeDouble(3.14);	//실수형(double)
			dos.writeBoolean(true);
			System.out.println("출력완료");

		}catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//파일 읽기
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("D:/D_Other/test.dat"));
			
			//데이터 형식에 맞게 불러와야 저장할 당시 입력값대로 가져옴
			System.out.println("문자열 자료: \t" + dis.readUTF());
			System.out.println("정수형 자료: \t" + dis.readInt());
			System.out.println("실수형(float) 자료\t: " + dis.readFloat());
			System.out.println("실수형(double) 자료\t: " + dis.readDouble());
			System.out.println("논리형 자료\t: " + dis.readBoolean());
			
			System.out.println("읽기완료");
			
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
