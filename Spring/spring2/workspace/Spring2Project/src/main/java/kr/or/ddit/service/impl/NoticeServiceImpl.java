package kr.or.ddit.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.mapper.ILoginMapper;
import kr.or.ddit.mapper.INoticeMapper;
import kr.or.ddit.mapper.IProfileMapper;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeMemberVO;
import kr.or.ddit.vo.crud.NoticeFileVO;
import kr.or.ddit.vo.crud.NoticeVO;
import kr.or.ddit.vo.crud.PaginationInfoVO;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Inject
	private INoticeMapper noticeMapper;
	@Inject
	private ILoginMapper loginMapper;
	@Inject
	private IProfileMapper profileMapper;
	@Inject PasswordEncoder pe;
	
	
	@Override
	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeMapper.insertNotice(noticeVO);
		if(status>0) { //등록처리 완료 됐을 때
			
			//공지사항 게시글 등록시, 업로드한 파일 목록을 가져온다
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			
			//공지사항 파일 업로드 처리
			try {
				noticeFileUpload(noticeFileList, noticeVO.getBoNo(), req);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}


	@Override
	public NoticeVO selectNotice(int boNo) {
		noticeMapper.incrementHit(boNo); //조회수 증가
		return noticeMapper.selectNotice(boNo); //글번호에 해당하는 정보
	}

	@Override
	public ServiceResult updateNotice(HttpServletRequest req, NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeMapper.updateNotice(noticeVO);
		if(status > 0 ) {
			
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			
			try {
				//공시사항 파일 업로드
				noticeFileUpload(noticeFileList, noticeVO.getBoNo(), req);
				
				//기존에 등록되어 이쓴 파일 목록들 중 수정하기 위해서 x 버튼 눌러 삭제처리로 넘겨준 파일 번호들
				Integer[] delNoticeNo =  noticeVO.getDelNoticeNo();
				if(delNoticeNo!=null) {
					for(int i = 0; i < delNoticeNo.length; i++) {
						//삭제할 파일번호 목록들 중 파일번호에해당하는 공지사항 파일 정보 가져옴
						NoticeFileVO noticeFileVO = 
								noticeMapper.selectNoticeFile(delNoticeNo[i]);
						
						noticeMapper.deleteNoticeFile(delNoticeNo[i]);
						
						File file = new File(noticeFileVO.getFileSavepath());
						file.delete(); //기존파일 경로에서 파일 삭제
					}
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	
	@Override
	public ServiceResult deleteNotice(HttpServletRequest req, int boNo) {
		ServiceResult result = null;
		
		// 자식테이블에 해당하는 noticefile 먼저 삭제
		// 게시글 번호에 해당하는 게시글 정보 가져오기
		NoticeVO noticeVO = noticeMapper.selectNotice(boNo);
		//게시글 번호에 해당하는 파일 삭제
		noticeMapper.deleteNoticeFileByBoNo(boNo);
		
		
		// 파일 삭제 완료된 후 공지사항 게시글 삭제
		int status = noticeMapper.deleteNotice(boNo);
		if(status > 0 ) {
			
			List<NoticeFileVO> noticeFileList = noticeVO.getNoticeFileList();
			
			try {
				if(noticeFileList != null) {
					//D:\dir\dir\dir....\resources\notice\게시글번호/UUID_파일명
					//의 형태로 저장되어있으니까 '/'로 구분
					String[] filePath = noticeFileList.get(0).getFileSavepath().split("/");
					String path = filePath[0];
					deleteFolder(req, path);
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		// TODO Auto-generated method stub
		return noticeMapper.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		// TODO Auto-generated method stub
		return noticeMapper.selectNoticeList(pagingVO);
	}

	
	
	
	@Override
	public ServiceResult idCheck(String memId) {
		ServiceResult result = null;
		NoticeMemberVO member = loginMapper.idCheck(memId);
		if(member != null) {
			result = ServiceResult.EXIST;
		} else {
			result = ServiceResult.NOTEXIST;
		}
		return result;
	}

	@Override
	public ServiceResult signup(HttpServletRequest req, NoticeMemberVO memberVO) {
		
		ServiceResult result = null;
		
		//회원가입시 프로필 이미지로 파일을 업로드 하는데 필요한 서버 경로
		String uploadPath = req.getServletContext().getRealPath("/resources/profile");
		
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String profileImg = ""; //회원 정보에 추가할 이미지 경로
		
		MultipartFile profileImgFile = memberVO.getImgFile();
		
		if(profileImgFile != null && profileImgFile.getOriginalFilename() != null &&
				!profileImgFile.getOriginalFilename().equals("") ) {
			String fileName = UUID.randomUUID().toString();
			//UUID_원본파일명으로 파일 생성
			fileName += "_" + profileImgFile.getOriginalFilename();
			// resource/profile/uuid_원본파일명
			uploadPath += "/" + fileName;
			try {
				profileImgFile.transferTo(new File(uploadPath));
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
			profileImg = "/resources/profile/" + fileName;
		}
		
		memberVO.setMemProfileimg(profileImg);
		
		//스프링 시큐리티 적용시 비밀번호 암호화
		memberVO.setMemPw(pe.encode(memberVO.getMemPw()));
		
		int status = loginMapper.signup(memberVO);
		
		if(status > 0) {
			//한 명의 회원이 등록 될 때 최소 하나의 권한을 가질 수 있도록 권한 등록(스프링 시큐리티)
			loginMapper.signupAuth(memberVO.getMemNo());
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public NoticeMemberVO loginCheck(NoticeMemberVO memberVO) {
		
		return loginMapper.loginCheck(memberVO);
	}
	
	
	private void noticeFileUpload(List<NoticeFileVO> noticeFileList, 
			int boNo, HttpServletRequest req) throws Exception {
		
		//공지자항 게시판에서 등록된 파일은 기본 /resources/notice/ 경로로 설정
		String savePath = "/resources/notice/";
		
		if(noticeFileList != null) { // 넘겨받은 파일 데이터가 존재할 때
			if(noticeFileList.size() > 0) {
				for(NoticeFileVO noticeFileVO : noticeFileList) {
					String saveName = UUID.randomUUID().toString();
					// 파일명을 설정할 때 원본 파일명과 UUID_와 합쳐서 파일명을 만든다.
					saveName += "_"+noticeFileVO.getFileName();
					String saveLocate = req.getServletContext().getRealPath(savePath + boNo);
					File file = new File(saveLocate);
					if(!file.exists()) {
						file.mkdirs(); //파일구조 없으면 생성하기
					}
					
					saveLocate += "/" + saveName; //실제 업로드 할 경로(파일명 포함)
					
					noticeFileVO.setBoNo(boNo); //게시글 번호 설정
					noticeFileVO.setFileSavepath(saveLocate); //파일 업로드 경로 설정
					noticeMapper.insertNoticeFile(noticeFileVO); //게시글 파일 데이터 추가
					
					File saveFile = new File(saveLocate);
					noticeFileVO.getItem().transferTo(saveFile);
					
					
				}
			}
		}
	}

	
	@Override
	public NoticeFileVO noticeDownload(int fileNo) {
		//파일 번호에 해당하는 파일 정보 가져오기
		NoticeFileVO noticeFileVO = noticeMapper.noticeDownload(fileNo);
		if(noticeFileVO == null) {
			throw new RuntimeException();
		}
		noticeMapper.incrementDowncount(fileNo);
		return noticeFileVO;
	}

	private void deleteFolder(HttpServletRequest req, String path) {
		File folder = new File(path);
		
		try {
			
			if(folder.exists()) {
				File[] folderFileList = folder.listFiles();
				
				for(int i = 0; i < folderFileList.length; i++) {
					if(folderFileList[i].isFile()) {
						//폴더안의 파일이 파일일 때 차례대로 삭제
						folderFileList[i].delete();
					} else {
						//폴더라면 계속 타고 들어가로고 재귀
						deleteFolder(req, folderFileList[i].getPath());
					}
				}
				folder.delete();
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public NoticeMemberVO selectMember(String memId) {
		return profileMapper.selectMember(memId);
	}


	@Override
	public ServiceResult profileUpdate(HttpServletRequest req, NoticeMemberVO memberVO) {
		
		ServiceResult result = null;
		
		String uploadPath = req.getServletContext().getRealPath("/resources/profile");
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String profileImg ="";
		try {
			MultipartFile profileImgFile = memberVO.getImgFile();
			if(profileImgFile != null && profileImgFile.getOriginalFilename() != null &&
					!profileImgFile.getOriginalFilename().equals("")) {
				
				String fileName = UUID.randomUUID().toString();
				uploadPath += "/" + fileName;
				profileImgFile.transferTo(new File(uploadPath));
				profileImg = "/resources/profile/" + fileName;
			}
			memberVO.setMemProfileimg(profileImg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int status = profileMapper.profileUpdate(memberVO);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}


	@Override
	public String findId(NoticeMemberVO memberVO) {
		return loginMapper.findId(memberVO);
	}


	@Override
	public String findPw(NoticeMemberVO memberVO) {
		return loginMapper.findPw(memberVO);
	}
}
