package service;

import java.util.List;

import dao.BoardDAO;
import vo.Board;

public class BoardService {
	// 싱글톤 패턴을 만든다.
	private static BoardService instance = null;
	private BoardService() {}
	
	public static BoardService getInstance() {
		if(instance == null) 
			instance = new BoardService();
		return instance;
	}
	
	// Dao를 부른다
	BoardDAO dao = BoardDAO.getInstance();
	
	
	public List<Board> boardList() {
		return dao.boardList();
	}
	
	public List<Board> goodList() {
		return dao.goodList();
	}
	
	public List<Board> badboardList() {
		return dao.badboardList();
	}
	
	public List<Board> userBoard(String id) {
		return dao.userBoard(id);
	}

	public boolean badBoard(List<Object> param) {
		int result = dao.badBoard(param);
		if(result == 0)return false;
		else return true;
	}
	


}



/*
	public Board boardView(int board_no) {
		return dao.boardView(board_no);
	}
	public void boardInsert(List<Object> param) {
		dao.boardInsert(param);
	}
	public void boardDelete(int board_no) {
		dao.boardDelete(board_no);
	}
	public void boardUpdate(List<Object> param) {
		dao.boardUpdate(param);
	}
*/