package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {

	public static void main(String[] args) throws IOException {
	
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		outSrc = new byte[inSrc.length];
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int readBytes = 0; //읽어온 바이트 데이터 저장용
		
//		read()메서드-> byte단위로 데이터를 읽어와 int형으로 변환함 더 이상 읽을 데이터 없음 -1리턴
//		파라메터로 읽어올 범위 지정가능(temp), 실제 데이터가 저장되는 곳도 temp
//		temp, 0, readBytes
		while((readBytes = bais.read(temp)) != -1) {
			System.out.println("temp>> "  + Arrays.toString(temp));
			baos.write(temp, 0, readBytes);
			//temp, offset, 읽어들일 바이트수
		}		
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc>> "  + Arrays.toString(inSrc));
		System.out.println("outSrc>> "  + Arrays.toString(outSrc));
	}
}
