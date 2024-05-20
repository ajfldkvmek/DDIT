package service;

import java.math.BigDecimal;
import java.util.List;

import dao.BoardDAO;
import dao.BoardDAOImpleForJDBC;
import vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private static BoardService mService;
	
	private BoardDAO memDAO;	
	
	private BoardServiceImpl() {
		memDAO = BoardDAOImpleForJDBC.getInstance();
	}
	
	public static BoardService getInstance() {
		if(mService == null) {
			mService = new BoardServiceImpl();
		}
		return mService;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		memDAO.insertBoard(bv);
		return 0;
	}

	@Override
	public void updateBoard(BoardVO bv) {
		memDAO.updateBoard(bv);
	}

	@Override
	public int deleteBoard(BigDecimal no) {
		return memDAO.deleteBoard(no);
	}

	@Override
	public List<BoardVO> searchBoard(String title) {
		return memDAO.search(title);
	}

	@Override
	public List<BoardVO> selectAll() {
		return memDAO.selectAll();
	}

	@Override
	public boolean chkNo(BigDecimal no) {
		return memDAO.chkNo(no);
	}
	
}
