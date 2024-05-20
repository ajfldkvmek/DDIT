package kr.or.ddit.main.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

@Repository
public class MainDAOImpl implements IMainDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<FreeVO> getFreeList() {
		return sqlSession.selectList("Main.getFreeList");
	}
	@Override
	public List<NoticeVO> getNoticeList() {
		return sqlSession.selectList("Main.getNoticeList");
	}
	@Override
	public List<BoardVO> getBoardList() {
		return sqlSession.selectList("Main.getBoardList");
	}
	
	
	@Override
	public int getFreeSize() {
		return sqlSession.selectOne("Main.getFreeSize");
	}

	@Override
	public int getBoardSize() {
		return sqlSession.selectOne("Main.getBoardSize");
	}

	@Override
	public int getNoticeSize() {
		return sqlSession.selectOne("Main.getNoticeSize");
	}

}