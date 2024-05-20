package atch.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import atch.vo.BoardAtchFileVO;


public interface IBoardAtchFileService {
// 어느 게시판이든 첨부파일 관리 일원화 가능
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param parts 파트정보를 담고 있는 컬렉션 객체
	 * @return
	 */
	public BoardAtchFileVO saveBoardAtchFileList(Collection<Part> parts);

	/**
	 * 첨부파일 목록 조회하기
	 * @param atchFileVO
	 * @return
	 */
	public List<BoardAtchFileVO> getBoardAtchFileList(BoardAtchFileVO boardAtchFileVO);
	
	/**
	 * 첨부파일 세부정보 조회 메서드
	 * @param atchFileVO
	 * @return
	 */
	public BoardAtchFileVO getBoardAtchFileDetail(BoardAtchFileVO boardAtchFileVO);
	


}
