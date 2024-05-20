package kr.or.ddit.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.dao.INoticeDAO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class NoticeServiceImpl implements INoticeService{

	@Inject
	private INoticeDAO noticeDAO;

	@Override
	public ServiceResult insertNotice(NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeDAO.insertNotice(noticeVO);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeDAO.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		List<NoticeVO> l1 = noticeDAO.selectNoticeList(pagingVO);
		System.out.println("service>>>>>>>>>>>>>" + l1);
		return noticeDAO.selectNoticeList(pagingVO);
	}
	
	@Override
	public NoticeVO selectNotice(int noticeNo) {
		noticeDAO.incrementHit(noticeNo);
		return noticeDAO.selectNotice(noticeNo);
	}

	@Override
	public ServiceResult updateNotice(NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeDAO.updatenotice(noticeVO);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteNotice(int noticeNo) {
		ServiceResult result = null;
		int status = noticeDAO.deleteNotice(noticeNo);
		if(status > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	
}
