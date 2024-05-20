package kr.or.ddit.main.dao;

import java.util.List;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;

public interface IMainDAO {

	List<FreeVO> getFreeList();
	int getFreeSize();
	
	List<BoardVO> getBoardList();
	int getBoardSize();
	
	List<NoticeVO> getNoticeList();
	int getNoticeSize();

}
