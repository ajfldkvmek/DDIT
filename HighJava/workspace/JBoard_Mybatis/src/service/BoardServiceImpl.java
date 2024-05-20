package service;

import java.math.BigDecimal;
import java.util.List;

import dao.BoardDAO;
import dao.BoardDAOImple;
//import dao.BoardDAOImpleForJDBC;
import vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private static BoardService mService;
	
	private BoardDAO memDAO;	
	
	private BoardServiceImpl() {
		memDAO = BoardDAOImple.getInstance();
	}
	
	public static BoardService getInstance() {
		if(mService == null) {
			mService = new BoardServiceImpl();
		}
		return mService;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return memDAO.insertBoard(bv);
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
	public List<BoardVO> searchBoard(BoardVO vo) {
		return memDAO.search(vo);
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
