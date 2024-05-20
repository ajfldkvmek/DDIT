package kr.or.ddit.free.dao;

import java.util.List;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeDAO {

	int insertfree(FreeVO freeVO);

	int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	void incrementHit(int freeNo);

	FreeVO selectFree(int freeNo);

	int updatefree(FreeVO freeVO);

	int deleteFree(int freeNo);
	
}
