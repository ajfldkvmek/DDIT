package kr.or.ddit.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.dao.IFreeDAO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class FreeServiceImpl implements IFreeService{

	@Inject
	private IFreeDAO freeDAO;

	@Override
	public ServiceResult insertFree(FreeVO freeVO) {
		ServiceResult result = null;
		int status = freeDAO.insertfree(freeVO);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return freeDAO.selectFreeCount(pagingVO);
	}

	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
//		List<FreeVO> l1 = freeDAO.selectFreeList(pagingVO);
//		System.out.println("service>>>>>>>>>>>>>" + l1);
		return freeDAO.selectFreeList(pagingVO);
	}

	@Override
	public FreeVO selectFree(int freeNo) {
		freeDAO.incrementHit(freeNo);
		return freeDAO.selectFree(freeNo);
	}

	@Override
	public ServiceResult updateFree(FreeVO freeVO) {
		ServiceResult result = null;
		int status = freeDAO.updatefree(freeVO);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteFree(int freeNo) {
		ServiceResult result = null;
		int status = freeDAO.deleteFree(freeNo);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
}
