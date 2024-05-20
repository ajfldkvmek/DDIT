package board.atch.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import board.atch.vo.AtchFileVO;

public interface IAtchFileService {

	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param parts 파트정보를 담고 있는 컬렉션 객체
	 * @return 
	 */
	public AtchFileVO saveAtchFileList(Collection<Part> parts);
	

	public List<AtchFileVO> getDeatilList(long l);
	
	
}
