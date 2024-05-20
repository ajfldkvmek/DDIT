package lecture.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import lecture.vo.LectureVO;
import member.vo.MemberVO;
import util.MyBatisUtil;

public class LecDAOImpl implements ILecDAO {

	private static ILecDAO lecDAO;
	
	private LecDAOImpl() {
		
	}
	
	public static ILecDAO getInstance() {
		if(lecDAO == null) 
			lecDAO = new LecDAOImpl();
		
		return lecDAO;
	}

	
	
	@Override
	public LectureVO getLecture(String lecNo) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		LectureVO lv = null;
		try {
			
			lv = sqlSession.selectOne("lecture.getDetail",lecNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return lv;
	}

	@Override
	public int insertLecture(LectureVO lv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			
			cnt = sqlSession.insert("lecture.insertLecture", lv);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			if(cnt != 0) sqlSession.commit();
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public int updateLecture(LectureVO lv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.update("lecture.updateLecture", lv);
			if(cnt > 0) sqlSession.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return cnt;
	}

	@Override
	public int deleteLecture(String lecNo) {

		System.out.println(lecNo);
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.delete("lecture.deleteLecture", lecNo);
			
			if(cnt > 0) {
				sqlSession.commit();
			}
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return 0;
	}

	@Override
	public List<LectureVO> getLecList(String tutNo) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		List<LectureVO> list = null;
		
		try {
			list = sqlSession.selectList("lecture.getTutoLectureList", tutNo);
		
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
			
	}

	@Override
	public MemberVO getTutorInfo (String tutNo) {
		
		System.out.println("tutno dao>>>>>" + tutNo);
		SqlSession sqlSession = MyBatisUtil.getInstance();
		MemberVO mv = null;
		
		try {
			mv = sqlSession.selectOne("member.getTutorInfo", tutNo);
			
			System.out.println(" mv dao>>>>>" + mv);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return mv;
	}

	@Override
	public List<LectureVO> lectureSearch(LectureVO lv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		List<LectureVO> lv2 = null;
		try {
			lv2= sqlSession.selectList("lecture.search", lv);
			System.out.println("DAO>>>>>>>>" + lv2);
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
		}
		return lv2;
	}

	@Override
	public int getTotalLectureCount(LectureVO lv) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		LectureVO lv2 = null;
		try {
			lv2= sqlSession.selectOne("lecture.searchCount", lv);
			System.out.println("DAO>>>>>>>>" + lv2.getCnt());
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
		}
		return lv2.getCnt();
	}
}
