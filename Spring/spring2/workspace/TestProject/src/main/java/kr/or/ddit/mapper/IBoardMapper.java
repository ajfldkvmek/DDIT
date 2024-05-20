package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardMapper {

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

	public int insertBoard(BoardVO boardVO);

	public void insertBoardFile(BoardFileVO boardFileVO);

	public BoardVO selectBoard(int boNo);

}
