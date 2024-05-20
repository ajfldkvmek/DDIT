package atch.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

import atch.dao.BoardAtchFileDaoImpl;
import atch.dao.IBoardAtchFileDao;
import atch.vo.BoardAtchFileVO;


public class BoardAtchFileServiceImpl implements IBoardAtchFileService {

	private static final String UPLOAD_DIR = "upload_files";

	private IBoardAtchFileDao fileDao;
	
	private static IBoardAtchFileService fileService;
	
	private BoardAtchFileServiceImpl() {
		fileDao = BoardAtchFileDaoImpl.getInstance();
	}

	public static IBoardAtchFileService getInstance() {
		if(fileService == null) {
			fileService = new BoardAtchFileServiceImpl();
		}
		return fileService;
	}

	@Override
	public BoardAtchFileVO saveBoardAtchFileList(Collection<Part> parts) {

		// 웹애플리케이션 루트 디렉토리를 기준으로 업로드 경로 설정하기
		String uploadPath = "d:/D_Other/" + UPLOAD_DIR;
			//(ㄴgetServletContext() 대신에 절대경로 사용)
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		
		boolean isFirstFile = true; // 첫번째 파일 여부
		BoardAtchFileVO bfv = null;
		
		for(Part part : parts) {
			
			String boardFName = part.getSubmittedFileName();
			
			if(boardFName != null && !boardFName.equals("")) {
				
				if(isFirstFile) {
					isFirstFile = false;
					
					// 파일기본정보 저장하기
//					AtchFileVO atchFileVO = new AtchFileVO();
						//(밑에서 활용하기 위해 전역변수 느낌으로 뺌)
					bfv = new BoardAtchFileVO();
					fileDao.insertBoardAtchFile(bfv);
					
				}
				
				String boardOriName = boardFName;	// 원본파일명
//				long fileSize = part.getSize();	// 파일사이즈
				String saveFileName = "";	// 저장파일명
//				String saveFilePath = "";	// 저장파일경로
				
				saveFileName = UUID.randomUUID().toString().replace("-", "");
//				saveFilePath = uploadPath + "/" + saveFileName;
				
				// 업로드 파일 저장하기
				try {
//					part.write(saveFilePath);
					part.write(saveFileName);
				} catch (IOException ex) {
					throw new RuntimeException("파일 업로드 중 예외가 발생했습니다.", ex);
					//(runtimeexception으로 예외처리 강제화)
				}
				
				// 확장자 추출
//				String fileExt = orignFileName.lastIndexOf(".") < 0 ? "" :
//					orignFileName.substring(orignFileName.lastIndexOf(".") + 1);
//						//(ㄴ 0보다 작으면 없다는 뜻)\
				
//				boardAtchFileVO.setBoardFName(boardFName);
				bfv.setBoardFName(boardFName);
//				atchFileVO.setFileSize(fileSize);
//				boardAtchFileVO.setBoardOriName(boardOriName);
				bfv.setBoardOriName(boardOriName);
//				atchFileVO.setFileStreCours(saveFilePath);
//				atchFileVO.setFileExtsn(fileExt);
//				atchFileVO.setFileCn("");
				
				// 파일 세부정보 저장하기
				fileDao.insertBoardAtachFileDetail(bfv);
				
				try {
					part.delete(); // 임시 업로드 파일 삭제하기
				} catch (IOException e) {
					throw new RuntimeException("업로드 파일 삭제 중 예외 발생", e);
					//(ㄴ런타임익셉션: 발생할수도 안할수도있음. 굳이 처리할 필요 X.
					// nullpointer, 나눗셈에서 분모에 0 사용 등... try&catch할 필요X)
				}
				
			}
			
		}
		
		return bfv;
		//(return 이유: 가장중요한 atchfileid 있어서! -> 회원정보테이블에 정보 넣을거)
		//(null: 첨부파일 없음. 중요한 구분임.)
	}

	@Override
	public List<BoardAtchFileVO> getBoardAtchFileList(BoardAtchFileVO bfv) {
		List<BoardAtchFileVO> boardAtchFileList = fileDao.getBoardAtchFileList(bfv);
		return boardAtchFileList;
	}

	@Override
	public BoardAtchFileVO getBoardAtchFileDetail(BoardAtchFileVO bfv) {
		return fileDao.getBoardAtchFileDetail(bfv);
	}

	
	/*
	 * public static void main(String[] args) {
	 * System.out.println(UUID.randomUUID().toString().replace("-", ""));
	 * //(ㄴ"웬만하면 중복이 거의 안 됨") //(4988bc84-7a7e-4a59-a22a-a36af3ac2499) }
	 */
}


