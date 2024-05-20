package kr.or.ddit.service.Impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.controller.util.FileUploadUtils;
import kr.or.ddit.controller.util.TelegramSendController;
import kr.or.ddit.mapper.IBoardMapper;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class BoardServiceImpl implements IBoardService {

	@Inject
	private IBoardMapper mapper;
	
	// 텔레그램 봇 API를 활용한 메세지 전송 위한 인스턴스 생성
	TelegramSendController tst = new TelegramSendController();
	
	
	
	@Override
	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO) {
		return mapper.selectBoardCount(pagingVO);
	}

	@Override
	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO) {
		return mapper.selectBoardList(pagingVO);
	}

	@Override
	public ServiceResult insertBoard(HttpServletRequest req, BoardVO boardVO) throws Exception {
		ServiceResult result = null;
		int status = mapper.insertBoard(boardVO);
		if(status > 0) {
			List<BoardFileVO> boardFileList = boardVO.getBoardFileList();
			FileUploadUtils.boardFileUpload(boardFileList, boardVO.getBoNo(), req, mapper);
			
			// 텔레그램 봇 API 실시간 알림
			try {
				tst.sendGet("안희재", boardVO.getBoTitle());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public BoardVO selectBoard(int boNo) {
		return mapper.selectBoard(boNo);
	}
	
	

}
