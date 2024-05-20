package kr.or.ddit.basic;

//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class T10_PropertiesTest {

	public static void main(String[] args) throws IOException {
		/*
		 * properties는 Map보다 축소된 기능의 객체라 할 수 있다
		 * Map은 모든 타입의 객체데이터를 key와 value값으로 사용할 수 있지만
		 * P가놈은 key와 value값으로 string만 사용가능
		 */
		
		Properties prop = new Properties();
		
		prop.setProperty("name", "길동");
		prop.setProperty("tel", "010-3333-3333");
		prop.setProperty("addr", "대전");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + tel);
		System.out.println("주소: " + addr);

		//.store :: properties의 객체로 파일 저장용
		prop.store(new FileOutputStream("./src/kr/or/ddit/test.properties"), 
				"코멘트");
		
		//
		prop.load(new FileReader("./src/kr/or/ddit/test.properties"));
		
		System.out.println("일거온 정보>> ");
		System.out.println(prop.getProperty("name"));
		
		
//		try {
//			prop.store(new FileOutputStream("./src/kr/or/ddit/test.properties"), 
//					"코멘트");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
