package lecture.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import lecture.vo.LectureVO;
import util.MyBatisUtil;

public class heartDAOImpl implements IheartDAO {

	private static IheartDAO heartDao;
	
	private heartDAOImpl() {
		
	}
	
	public static IheartDAO getInstance() {
		if(heartDao == null)
			heartDao = new heartDAOImpl();
		
		return heartDao;
	}

	@Override
	public int updateHeart(LectureVO lv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.update("lecture.updateHeart", lv);
			if(cnt > 0) sqlSession.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

}
