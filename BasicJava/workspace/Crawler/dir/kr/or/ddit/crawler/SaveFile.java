package kr.or.ddit.crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class SaveFile {

	public static void createfile(String name, String contents) {

		String path = "D:/data/list/";
		File list = new File(path);
		
		// 폴더 생성
		if (!list.exists()) {
			try {
				list.mkdirs();
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
		}	
		
		// '/'는 디렉토리 이므로 파일명에 있으면 파일 생성 안됨 replaceAll
		String str = name.replaceAll("/", "@"); 
		
		//파일위치 + 파일명 + 확장자
		File file = new File(path +str+".html");
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter writer = new PrintWriter(fw);
			if (file.createNewFile()) {
				System.out.println("File created");
				writer.write(contents);
				writer.close();
			} else {
				//이미 파일 있으면 오류메세지 출력
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
