package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01_FileTest {

	public static void main(String[] args) throws IOException {
//		1. new File(String 파일 or 경로명) 경로사이에 '/' or '\' 사용
		File file = new File("D:/D_Other/test.txt");
		System.out.println("파일명: " + file.getName());
		System.out.println("파일여부: " + file.isFile());
		System.out.println("디렉토리(폴더)여부: " + file.isDirectory());

		File file2 = new File("D:/D_Other");
		if (file2.isFile()) {
			System.out.println("파일");
		} else if (file2.isDirectory()) {
			System.out.println("디렉토리 폴더");
		}
		System.out.println("-------------------------------");

		// 2.new File(File parnet, String child)
		// => parent디렉토리 안에 있는 child파일 또는 디렉토리를 갖는다
		File file3 = new File(file2, "test.txt");

		// 파일크기 보는 length는 매우 자주 씀
		System.out.println(file3.getName() + "의 용량크기:	" + file.length() + "bytes");
		System.out.println("-------------------------------");
		
		// 3. new File(String parent, String child)
		File file4 = new File(".\\D_Other\\test../");
		System.out.println("절대경로: " + file4.getAbsolutePath());
		System.out.println("경로: " + file4.getPath());
		System.out.println("표준경로: " + file4.getCanonicalPath());
		System.out.println();
		

		/*
		 *  디렉토리(폴더)만들기	1.mkdir 중간경로 반드시 사전생성  필요
		 *  			  	2.중간경로도 같이 생성
		 *  
		 *  둘다 만들기 성공하면 return true, 아니면 false
		 */
		File file5 = new File("D:/D_Other/연습용");
		if(file5.mkdir()) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		System.out.println();		
	
		File file6 = new File("D:/D_Other/test/java/src");
		if(file6.mkdir()) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		System.out.println();		
	}
}
