package lecture.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import lecture.vo.LectureVO;
import util.MyBatisUtil;

public class pageDAOImpl implements IPageDAO{

	private static IPageDAO pageDAO;
	
	private pageDAOImpl() {
		
	}
	
	public static IPageDAO getInstance() {
		if(pageDAO == null) {
			pageDAO = new pageDAOImpl();
		}
		
		return pageDAO;
	}

	@Override
	public List<LectureVO> getPostListWithPaging(LectureVO lv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List<LectureVO> pageList = null;
		
		try {
			sqlSession = MyBatisUtil.getInstance();
			pageList = sqlSession.selectList("lecture.getPostListWithPaging", lv);
			
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return pageList;
	}

	//전체글 수 조회
	@Override
	public int getTotalPostCount() {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int totalCount = 0;
		
		try {
			totalCount = sqlSession.selectOne("lecture.getTotalPostCount");
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return totalCount;
	}

//	검색글 수 조회
	@Override
	public int getSearchCount() {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int searchCount = 0;
		
		try {
			searchCount = sqlSession.selectOne("lecutre.getSearchPostCount");
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return searchCount;
	}

}
