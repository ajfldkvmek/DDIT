package service;

import java.math.BigDecimal;
import java.util.List;

import vo.BoardVO;

public interface BoardService {

	public int insertBoard(BoardVO bv);
	
	public void updateBoard(BoardVO bv);
	
	public int deleteBoard(BigDecimal no);
	
	public List<BoardVO> searchBoard(String title);
	
	public List<BoardVO> selectAll();

	public boolean chkNo(BigDecimal no);

}
