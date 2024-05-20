package lecture.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import lecture.vo.LectureVO;
import util.MyBatisUtil;

public class involveDAOImpl implements IinvolveDAO {

	private static IinvolveDAO involveDao;
	
	private involveDAOImpl() {
		
	}
	
	public static IinvolveDAO getInstance() {
		if(involveDao == null)
			involveDao = new involveDAOImpl();
		
		return involveDao;
	}

	@Override
	public int involveLecture(LectureVO lv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("lecture.involveLecture", lv);
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	
	}


}
