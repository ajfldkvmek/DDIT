package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class MainVO {

	private List<FreeVO> freeList;
	private List<NoticeVO> noticeList;
	private List<BoardVO> boardList;
	
	int freeSize;
	int noticeSize;
	int boardSize;
	
}
