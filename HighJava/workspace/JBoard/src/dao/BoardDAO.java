package dao;

import java.math.BigDecimal;
import java.util.List;

import vo.BoardVO;


public interface BoardDAO {
	//글작성
	public int insertBoard(BoardVO bv);
	//수정
	public int updateBoard(BoardVO bv);
	
	//글삭제
	public int deleteBoard(BigDecimal no);
	//전체보기
	public List<BoardVO> selectAll();
	
	public List<BoardVO> search(String str);
	
	public boolean chkNo(BigDecimal no);
}
