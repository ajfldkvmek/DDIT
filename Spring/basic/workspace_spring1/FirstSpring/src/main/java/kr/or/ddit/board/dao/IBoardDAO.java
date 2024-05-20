package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDAO {

	public List<BoardVO> selectBoardList();

	public int insertboard(BoardVO boardVO);

	public BoardVO selectBoard(int boNo);

	public void incrementHit(int boNo);

	public int updateboard(BoardVO boardVO);

	public int deleteboard(int boNo);

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

}
