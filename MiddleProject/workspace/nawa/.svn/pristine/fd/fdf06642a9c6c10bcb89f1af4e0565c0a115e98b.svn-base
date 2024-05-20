package board.atch.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import board.atch.dao.AtchFileDAOImpl;
import board.atch.dao.IAtchFileDAO;
import board.atch.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService {

	private static final String UPLOAD_DIR = "/image/board/";

	private IAtchFileDAO fileDAO;

	private static IAtchFileService fileService;

	private AtchFileServiceImpl() {
		// TODO Auto-generated method stub
		fileDAO = AtchFileDAOImpl.getInstance();
	}

	public static IAtchFileService getInstance() {
		if (fileService == null)
			fileService = new AtchFileServiceImpl();

		return fileService;
	}

	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {

		// 웹어플리케이션 루트 디렉토리를 기준으로 업로드 경로 설정하기
		String uploadPath = "D:/D_setting/A_TeachingMaterial/04_MiddelProject/workspace/nawa/WebContent" + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isFirstFile = true;

		AtchFileVO atchFileVO = null;

		for (Part part : parts) {
			String fileName = part.getSubmittedFileName();

			if (fileName != null && !fileName.equals("")) {// 파일 첨부가 됐으면

				if (isFirstFile) {
					isFirstFile = false;

					// 파일기본정보 저장하기
					atchFileVO = new AtchFileVO();
					fileDAO.insertAtchFile(atchFileVO);
				}

				// 파일세부정보 저장하기
				String orignFileName = fileName; // 원본파일 명
				long fileSize = part.getSize(); // 파일사이즈
				String saveFileName = ""; // 저장파일명
				String saveFilePath = ""; // 저장파일경로
				
				// uploadPath>> nawa/image/upload
				saveFileName = UUID.randomUUID().toString().replace("-", "");
				saveFilePath = uploadPath + "/" + saveFileName;

				try {
					part.write(saveFilePath);
				} catch (IOException ex) {
					throw new RuntimeException("업로드 중 오류발생", ex);
				}

				// 확장자 추출
				String fileExt = orignFileName.lastIndexOf(".") < 0 ? ""
						: orignFileName.substring(orignFileName.lastIndexOf(".") + 1);

				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileStreCours(saveFilePath);
				atchFileVO.setFileExtsn(fileExt);
				atchFileVO.setFileCn("");

				// 파일 세부정보 저장하기
				fileDAO.insertAtchFileDetail(atchFileVO);

				try {
					part.delete(); // 임시 업로드 파일 삭제하기
				} catch (IOException e) {
					throw new RuntimeException("업로드 파일 삭제중 예외발생", e);
				}
			}

		}
		return atchFileVO;
	}

	
	@Override
	public List<AtchFileVO> getDeatilList(long atchFileId) {
		
		IAtchFileDAO fileDAO = AtchFileDAOImpl.getInstance();
		List<AtchFileVO> atchList = null;
		if(fileDAO.checkAtchFile(atchFileId)) { //if true -> 리스트 가져오기
			System.out.println("service 첨부파일 있어>>>> ");
			//참이면 detail파일 목록 가져오기
			atchList = fileDAO.getDetailList(atchFileId);
			
		} 
		return atchList;
	}

}
