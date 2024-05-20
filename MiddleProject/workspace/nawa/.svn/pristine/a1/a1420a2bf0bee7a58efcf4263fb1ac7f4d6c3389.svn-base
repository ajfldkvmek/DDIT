package meet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import meet.vo.MbVO;
import meet.vo.MeetVO;
import util.MyBatisUtil;

public class MeetDAOImpl implements IMeetDAO {

	private static IMeetDAO meetDAO;

	private MeetDAOImpl() {
	}

	public static IMeetDAO getInstance() {
		if (meetDAO == null)
			meetDAO = new MeetDAOImpl();

		return meetDAO;

	}

	@Override
	public List<MeetVO> displayAllMeet() {
		System.out.println("다오임플시작");
		List<MeetVO> meetList = new ArrayList<MeetVO>();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		System.out.println("매퍼직전");
		try {
			meetList = sqlSession.selectList("meet.selectMeetAll");
		} catch (PersistenceException e) {
			System.out.println("쿼리오류");
//			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		/*
		 * for (MeetVO meetVO : meetList) { System.out.println(meetVO.getMeet_no() + " "
		 * + meetVO.getMeet_name());
		 * 
		 * }
		 */
		System.out.println(meetList.size());
		
		return meetList;
	}

	@Override
	public MeetVO getDetail(String meetNo) {
		MeetVO mv = new MeetVO();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
			mv = sqlSession.selectOne("meet.getMeetDetail", meetNo);
		} catch (PersistenceException e) {
			System.out.println("다오오류");
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return mv;
	}

	@Override
	public int deleteMeet(String meetNo) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.update("meet.deleteMeet", meetNo);
			if(cnt>0) {
				sqlSession.commit();
			}

		} catch (PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public int insertMeet(MeetVO mv) {
		//System.out.println(mv);
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("meet.insertMeet", mv);
			if(cnt>0) {
				sqlSession.commit();
			}

		} catch (PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public int modifyMeet(MeetVO mv) {
		System.out.println("다오수정시작");
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt =0;
		try {
		cnt = sqlSession.update("meet.updateMeet", mv);
		System.out.println("다오cnt"+cnt);
			if(cnt>0) {
				sqlSession.commit();
			}
		}catch(PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public int meetJoin(MeetVO mv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt =0;
		try {
		cnt = sqlSession.insert("meet.joinMeet",mv);
		if(cnt>0) {
			sqlSession.commit();
		}
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public List<MeetVO> meetSearch(MeetVO mv) {
		System.out.println("다오 검색 시작");
		
		System.out.println("mv.getSearch:"+mv.getSearch());
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List<MeetVO> meetList = null;
		try {
			System.out.println("다오검색xml직전");
			meetList = sqlSession.selectList("meet.meetSearch",mv);
			System.out.println("meet서치 매퍼갔다옴"+meetList);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return meetList;
	}

	@Override
	public int mbcheck(MeetVO mv) {
		System.out.println("mbcheck다오");
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int chk = 0;
		try {
		sqlSession.selectOne("meet.mbcheck", mv);
			sqlSession.commit();
		}catch(PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println("mbchk다오에서 리턴직전:"+ chk);
		return chk;
	}

	@Override
	public int mbInsert(MbVO mv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt =0;
		try {
		cnt = sqlSession.insert("meet.mbInsert",mv);
		}catch(PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public List<MbVO> displayAllMeetBoard(String meetNo) {
		System.out.println("모임게시판 전체리스트 다오시작");
		List<MbVO> mbList = new ArrayList<MbVO>();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
			mbList = sqlSession.selectList("meet.selectAllMeetBoard",meetNo);
			System.out.println("다오임 리스트: "+mbList);
		}catch(PersistenceException e ) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return mbList;
	}

	@Override
	public MbVO getMbDetail(int mb_no) {
		MbVO mb = new MbVO();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
		mb = sqlSession.selectOne("meet.getMbDetail", mb_no);
		}catch(PersistenceException e) {
			e.printStackTrace();
		}finally {
		sqlSession.close();
		}
		return mb;
	}

	@Override
	public void updateMbViewCnt(int mb_no) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
		sqlSession.update("meet.updateMbViewCnt",mb_no);
		sqlSession.commit();
		}catch(PersistenceException e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		
	}

}
