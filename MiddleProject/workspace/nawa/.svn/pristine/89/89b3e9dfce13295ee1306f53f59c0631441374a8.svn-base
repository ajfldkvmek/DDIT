package atch.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import atch.vo.BoardAtchFileVO;
import util.MyBatisUtil;


public class BoardAtchFileDaoImpl implements IBoardAtchFileDao {

	//(싱글톤 처리...)
	private static IBoardAtchFileDao fileDao;
	
	private BoardAtchFileDaoImpl() {
	}
	
	public static IBoardAtchFileDao getInstance() {
		if(fileDao == null) {
			fileDao = new BoardAtchFileDaoImpl();
		}
		return fileDao;
	}

	
	@Override
	public int insertBoardAtchFile(BoardAtchFileVO bfv) {
		SqlSession session = MyBatisUtil.getInstance();
		int cnt = 0;
		
		try {
			cnt = session.insert("boardFile.insertBoardAtchFile", bfv);
			if(cnt > 0) {
				session.commit();
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int insertBoardAtachFileDetail(BoardAtchFileVO bfv) {
		
		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("boardFile.insertBoardAtachFileDetail", bfv);

			if(cnt > 0) {
				session.commit();
			}
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BoardAtchFileVO> getBoardAtchFileList(BoardAtchFileVO bfv) {
		
		List<BoardAtchFileVO> boardAtchFileList = new ArrayList<BoardAtchFileVO>();
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			boardAtchFileList = session.selectList(
					"boardFile.getBoardAtchFileList", bfv);

		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return boardAtchFileList;
	}

	@Override
	public BoardAtchFileVO getBoardAtchFileDetail(BoardAtchFileVO bfv) {

		BoardAtchFileVO boardAtchFileDetail = null;
		//(상세정보 id 가져오기: 첨부파일 여러개면 id 하나로 여러개 가져올 수 있음 
		// -> atchfileid와 순번이 있어야 특정 하나(첨부파일 세부)만 가져올 수 있음)
		//(1건임이 확실하기 때문에 list가 아니라 VO로 쓴 것)
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			
			boardAtchFileDetail = session.selectOne(
					"boardFile.getBoardAtchFileDetail", bfv);
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return boardAtchFileDetail;
	}
	
	//dao 실행 테스트
	public static void main(String[] args) {
		
		IBoardAtchFileDao fileDao = BoardAtchFileDaoImpl.getInstance();
		
		BoardAtchFileVO bfv = new BoardAtchFileVO();
		int cnt = fileDao.insertBoardAtchFile(bfv);
		
		if(cnt > 0) {
			System.out.println("등록 성공 !!!");
			System.out.println(bfv.getBoardFIndex());
			
//			//////atchfiledetail작동테스트/////////
//			
//			atchFileVO.setFileStreCours("/aaa/bbb/ccc.jpg");
//			atchFileVO.setStreFileNm("aaaabbbbbb.jpg");
//			atchFileVO.setOrignlFileNm("ccc.jpg");
//			atchFileVO.setFileExtsn("jpg");
//			atchFileVO.setFileCn("");
//			atchFileVO.setFileSize(1024);
//			cnt = fileDao.insertAtachFileDetail(atchFileVO);
//		
//			if(cnt > 0) {
//				System.out.println("detail 등록 성공!!!");
//			}
			
		}
		
	}
}
