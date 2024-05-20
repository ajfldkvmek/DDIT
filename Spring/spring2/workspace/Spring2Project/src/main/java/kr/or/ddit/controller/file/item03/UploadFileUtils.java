package kr.or.ddit.controller.file.item03;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	public static String uploadFile(
			String uploadPath, String originalFileName, byte[] fileData) throws Exception {
		
		UUID uuid = UUID.randomUUID();
		
//		uuid_원본파일명 구성
		String savedName = uuid.toString()+"_"+originalFileName;
		
//		날짜에 해당하는 폴더 경로 만들고, 그 날짜를 리턴한다(/2024/03/06/ 처럼)
		String savedPath = calcPath(uploadPath);
		
		//배포된 서버 업로드 경로 /2024/03/06/ + UUID_원본파일명으로 File target하나 만듦
		File target = new File(uploadPath + savedPath, savedName);
		//위에서 만들엉진 경로와 파일명을 가지고 파일 복사
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);// 확장자 추출
		
		// \2024\03\06\ 경로를 /로 변경후 원본파일명의 경로까지 붙인다
		String uploadedFileName = savedPath.replace(File.separatorChar, '/') + "/" + savedName;
		
		//확장자가 이미지 파일이면 s_가 붙는 파일의 썸네일 이미지 파일을 생성한다
		if(MediaUtils.getMediaType(formatName) != null) {
			makeThumbnail(uploadPath, savedPath, savedName);
		}
		
		return uploadedFileName;
	}

	private static void makeThumbnail(String uploadPath, String savedPath, String savedName) throws Exception {
		
		//썸네일 이미지 만들기 위해 원본 이미지 읽기
		BufferedImage sourceImg = 
				ImageIO.read(new File(uploadPath + savedPath, savedName));
		
		//썸네일 이미지를 만들기 위한 설정
		// Method.AUTOMATIC		: 최소시간 내에 가장 잘 보이는 이미지를 얻기 위한 사용 방식
		// Mode.FIT_TO_HEIGHT	: 이미지 방향과 상관없이 주어진 높이 내에서 가장 잘 맞는 이미지로 계산
		// targetSize			: 값(100) >> 정방형으로 100x100
		BufferedImage destImg = 
				Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		String thumbnailName = 
				uploadPath + savedPath + File.separator + "s_" + savedName;
		String formatName = savedName.substring(savedName.lastIndexOf(".")+1);

		// s_가 붙은 썸네일 이미지 파일 (경로 + s_파일명)
		File newFile = new File(thumbnailName);
		//s_가 붙은 썸네일 이미지 생성
		ImageIO.write(destImg, formatName, newFile);
	}

	private static String calcPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR); //2024
		// DecimalFormat("00") 빈자리 0으로 채움 >> 3월의 경우 03으로출력
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);// /2024/03
		
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));// 2024/03/06
		
		//년 월 일 구조에 의한 폴더 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
	}

	///String...paths 가변인자
//	타입...변수명 형태로 사용
//	순서대로 들어오는 yearPath, monthPath, datePath가 배열 형태로 묶여서 들어옴
	private static void makeDir(String uploadPath, String...paths) {
	
		if(new File(paths[paths.length-1]).exists()) {
			return; //폴더 경로 존재하면 skip
		}
		
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			//각각의 폴더 경로가 없으면 만들어 준다
			if(!dirPath.exists()) {
				dirPath.mkdirs();
			}
		}
	}
	

	
	
	
	
	
	
	
	
	
}
