package board.atch.dao;

import java.util.List;

import board.atch.vo.AtchFileVO;

public interface IAtchFileDAO {

	/**
	 * 첨부파일 기본정보 저장
	 * @param atchFileVO
	 * @return
	 */
	public int insertAtchFile(AtchFileVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 저장
	 * @return
	 */
	public int insertAtchFileDetail(AtchFileVO atchFileVO);
	
	public boolean checkAtchFile(long atchFileId);

	public List<AtchFileVO> getDetailList(long atchFileId);
	
	
}