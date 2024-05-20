package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vo.BoardVO;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;

public class BoardDAOImple implements BoardDAO {

	
	private static BoardDAO memDAO;
	private BoardDAOImple() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getInstance() {
		
		if(memDAO == null) {
			memDAO = new BoardDAOImple();
		}
		
		return memDAO;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.insertBoard", bv);
			if(cnt > 0) {
				sqlSession.commit();
			}
		} catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.updateBoard", bv);
			if(cnt > 0) {
				sqlSession.commit();
			}
		} catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(BigDecimal no) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.delete("board.deleteBoard", no);
			
			if(cnt > 0) {
				sqlSession.commit();
			}
		}catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = new ArrayList<>();
		
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		try {
			list = sqlSession.selectList("board.selectAll");
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public List<BoardVO> search(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		try {
			list = sqlSession.selectList("board.searchBoard", vo);
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public boolean chkNo(BigDecimal no) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		boolean chk = false;
		try {
			int cnt = sqlSession.delete("board.deleteBoard", no);
			if(cnt > 0) {
				sqlSession.commit();
				chk = true;
			}
		}catch(PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return chk;
	}

}
