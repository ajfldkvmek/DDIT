package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {

	static String fileName = "D:/D_Other/";

	public static void main(String[] args) {
		File f1 = new File(fileName + "sample.txt");
		File f2 = new File(fileName + "test.txt");

		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재");
		} else {
			System.out.println(f1.getAbsolutePath() + "은 없음");

			try {
				if (f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "을 생성");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (f2.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재");
		} else {
			System.out.println(f1.getAbsolutePath() + "은 없음");

			try {
				if (f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath() + "을 생성");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File f3 = new File(fileName);
		File[] files = f3.listFiles(); //file명 + a
		
		for(File f : files) {
			System.out.print(f.getName() + "=>");
			if(f.isFile()) {
				System.out.println("파일");
			} else {
				System.out.println("디렉토리");
			}
		}
		
		System.out.println("==============================");
		String[] strfiles = f3.list(); //file명 출력
		for(String strfile : strfiles) 
			System.out.println(strfile);
		System.out.println("==============================");
		System.out.println();
		
		displayFileList(new File(fileName));
	
	}

	private static void displayFileList(File dir) {
		
		System.out.println("[" + dir.getAbsolutePath() +"] 디렉터리 내용");
		int fileSize = 0;
		//파일목록가져오기
		File[] files = dir.listFiles();
		
		List<Integer> subDirlist = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for(int i = 0; i < files.length; i++) {
			String attr = ""; //파일 속성 정보
			String size = ""; //파일 크기

			if(files[i].isDirectory()) {
				attr = "<DIR>";
				subDirlist.add(i);
			} else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";
				fileSize += Integer.parseInt(size);
			}
//			System.out.printf("%s %-5s %12s %s\n",  << 앞에 -붙여서 음수표시해수면 우측정렬에서 좌측정렬로됨
			System.out.printf("%s %5s %12s %s\n", 
								sdf.format(new Date(files[i].lastModified())),
								attr, size, files[i].getName());
			
		}
		
		int dirCount = subDirlist.size();
		int fileCount = files.length - dirCount;
		
		System.out.println("\t\t"+fileCount +"개의 파일 \t\t\t" + fileSize+" 바이트" + "\n" +
				"\t\t"+dirCount + "개의 디렉터리");		
		
		
		//하위 디렉터리로 들어가서 파일목록 보기
		for(Integer idx : subDirlist)
			displayFileList(files[idx]);
	}
}



















