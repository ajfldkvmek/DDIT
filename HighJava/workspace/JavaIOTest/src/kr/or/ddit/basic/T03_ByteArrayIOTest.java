package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T03_ByteArrayIOTest {

	public static void main(String[] args) {
	
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		outSrc = new byte[inSrc.length];
		
//		for(int i = 0; i < inSrc.length; i++) {
//			outSrc[i] = inSrc[i];
//		}
//		System.out.println("직접 복사후 출력>> " + Arrays.toString(outSrc));
		
		System.arraycopy(inSrc, 0, outSrc, 0, inSrc.length);
		System.out.println("직접 복사후 출력>> " + Arrays.toString(outSrc));
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0; //읽어온 바이트 데이터 저장용
		
//		read()메서드-> byte단위로 데이터를 읽어와 int형으로 변환함
//					>>더 이상 읽을 데이터 없음 -1리턴
		while((data = bais.read()) != -1) {
			baos.write(data);
		}		
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc>> "  + Arrays.toString(inSrc));
		System.out.println("outSrc>> "  + Arrays.toString(outSrc));
	}
}
