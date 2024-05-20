package meet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import board.vo.PostVO;
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
	public List<MeetVO> displayAllMeet(MeetVO mv) {
		System.out.println("다오임플시작");

		System.out.println("다다다다다다오오오오오" + mv);
		
		List<MeetVO> meetList = new ArrayList<MeetVO>();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		System.out.println("매퍼직전");
		try {
			meetList = sqlSession.selectList("meet.selectMeetAll", mv);
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
		MeetVO m = null;
		int chk = 0;
		try {
		m = sqlSession.selectOne("meet.mbcheck", mv);
		}catch(PersistenceException e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println("mbchk다오에서 리턴직전:"+ m);
		System.out.println("mbchk다오:"+m.getCnt());
		return m.getCnt();
	}

	@Override
	public int mbInsert(MbVO mv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt =0;
		try {
		cnt = sqlSession.insert("meet.mbInsert",mv);
		if(cnt>0) sqlSession.commit();
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

	@Override
	public List<MbVO> displayHugi(String meetNo) {
		System.out.println("후기뽑는 다오 진입");
		List<MbVO> hugiList = new ArrayList<MbVO>();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
		hugiList = sqlSession.selectList("meet.displayHugi",meetNo);
		System.out.println("후기뽑는 다오 hugiList:"+hugiList);
		}catch(PersistenceException e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return hugiList;
	}

	@Override
	public List<MbVO> getPostListWithPaging(MbVO mb) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List<MbVO> pageList = null;

	    try {
	        sqlSession = MyBatisUtil.getInstance();
	        pageList = sqlSession.selectList("meet.getPostListWithPaging", mb);
	    } finally {
	        if (sqlSession != null) {
	            sqlSession.close();
	        }
	    }
	    
	    return pageList;
	}

	@Override
	public int getTotalPostCount() {
		SqlSession sqlSession = MyBatisUtil.getInstance();
        int totalCount = 0;

        try {
            totalCount = sqlSession.selectOne("meet.getTotalPostCount");
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return totalCount;
	}
	
	@Override
	public int registerHeart(MeetVO mv) {
		System.out.println("하트다오");
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.update("meet.registerHeart", mv);
			System.out.println("하트다오:"+cnt);
			if(cnt > 0) sqlSession.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	@Override
	public int countAll() {
		
		System.out.println("페이지이이이이이잉 하기전 총 글 수 보기");
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		MeetVO mv = null;
		int cnt = 0;
		
		try {
			mv = sqlSession.selectOne("meet.countAll");
			cnt = mv.getTotalPage();
			System.out.println("총페이지:"+cnt);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public int searchCount(MeetVO mv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		MeetVO mv2 = null;
		try {
			mv2 = sqlSession.selectOne("meet.countSearch", mv);
			cnt = mv2.getTotalPage();
			System.out.println("검색총페이지:"+cnt);
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}

	@Override
	public int plusMeetMember(String meet_no) {
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		try {
			cnt = sqlSession.update("meet.plusMember", meet_no);
			System.out.println("멤버 추가:"+cnt);
			if(cnt > 0) sqlSession.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
	}

}
