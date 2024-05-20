package lecture.comm.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.http.Part;

import lecture.comm.dao.AtchFileDaoImpl;
import lecture.comm.dao.IAtchFileDao;
import lecture.comm.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService {

	private static final String UPLOAD_DIR = "upload_files";

	private IAtchFileDao fileDao;

	private static IAtchFileService fileService;

	public AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}

	public static IAtchFileService getInstance() {
		if (fileService == null) {
			fileService = new AtchFileServiceImpl();
		}

		return fileService;
	}

	@Override
	public AtchFileVO saveAtchFileList(Collection<Part> parts) {

		String uploadPath = "d:/D_Other/ " + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isFirstFile = true;
		AtchFileVO atchFileVO = null;

		for (Part part : parts) {

			String fileName = part.getSubmittedFileName();

			if (fileName != null && !fileName.equals("")) {

				if (isFirstFile) {
					isFirstFile = false;
					atchFileVO = new AtchFileVO();
					fileDao.insertAtchFile(atchFileVO);
				}

				// 파일 세부 정보 저장하기

				String orignFileName = fileName; // 원본파일명
				long fileSize = part.getSize(); // 파일 사이즈
				String saveFileName = ""; // 저장파일명
				String saveFilePath = ""; // 저장파일경로

				saveFileName = UUID.randomUUID().toString().replace("-", "");
				saveFilePath = uploadPath + "/" + saveFileName; // 최종경로

				try {
					// 업로드 파일 저장하기
					part.write(saveFilePath);
				} catch (IOException ex) { // RuntimeException 예외처리를 가능하게?
					throw new RuntimeException("업로드 파일 저장중에 예외 발생!!", ex);
				}

				// 확장자 추출 // ↓삼항 연산자
				String fileExt = orignFileName.lastIndexOf(".") < 0 ? ""
						: orignFileName.substring(orignFileName.lastIndexOf(".") + 1);

				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileStreCours(saveFilePath);
				atchFileVO.setFileExtsn(fileExt);
				atchFileVO.setFileCn("");

				// 파일 세부정보 저장하기
				fileDao.insertAtchFileDetail(atchFileVO);

				try {
					part.delete(); // 임시 업로드 파일 삭제하기
				} catch (IOException e) {
					throw new RuntimeException("업로드 파일 삭제중 예외 발생", e);
				}

			}
		}

		return atchFileVO;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileDetail(atchFileVO);
	}

}
