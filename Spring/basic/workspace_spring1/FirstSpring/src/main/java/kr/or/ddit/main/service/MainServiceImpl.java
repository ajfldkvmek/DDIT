package kr.or.ddit.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.main.dao.IMainDAO;
import kr.or.ddit.vo.MainVO;

@Service
public class MainServiceImpl implements IMainService{

	@Inject
	private IMainDAO mainDAO;

	@Override
	public MainVO getMain() {
		
		MainVO mv = new MainVO();
		
		mv.setBoardList(mainDAO.getBoardList());
		mv.setFreeList(mainDAO.getFreeList());
		mv.setNoticeList(mainDAO.getNoticeList());
		
		mv.setFreeSize(mainDAO.getFreeSize());
		mv.setBoardSize(mainDAO.getBoardSize());
		mv.setNoticeSize(mainDAO.getNoticeSize());
		
//		mainDAO.getBoardList();
//		mainDAO.getNoticeList();
//		mainDAO.getFreeList();
//		mainDAO.getFreeSize();
//		mainDAO.getBoardSize();
//		mainDAO.getNoticeSize();
		
		return mv;
	}
	
}
