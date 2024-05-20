package member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;
import util.MyBatisUtil;

public class MemberDAOImpl implements IMemberDAO {

	// 싱글턴
	private static IMemberDAO memDAO;

	private MemberDAOImpl() {

	}

	public static IMemberDAO getInstance() {
		if (memDAO == null) {
			memDAO = new MemberDAOImpl();
		}

		return memDAO;
	}

	@Override
	public List<MemberVO> displayAllMember() {
		List<MemberVO> memList = new ArrayList<MemberVO>();

		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;

		try {
			memList = sqlSession.selectList("member.selectAll");
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		//System.out.println(memList);
		return memList;
	}

	@Override
	public List<MemberVO> searchMember(String str) {
		
		List<MemberVO> searchList = new ArrayList<MemberVO>();
		SqlSession sqlSession = MyBatisUtil.getInstance();
		int cnt = 0;
		
		try {
			searchList = sqlSession.selectList("member.searachMember", str);
			
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		System.out.println(searchList);
		return searchList;
		
	}

	@Override
	public MemberVO loginCheck(MemberVO mv) {
		
		MemberVO ret = null;
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		try {
			ret = sqlSession.selectOne("member.loginCheck", mv);
			System.out.println();
		} catch (PersistenceException ex) {
						
		} finally {
			sqlSession.close();
		}
		
		return ret;		
	}

	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		SqlSession sqlSession = MyBatisUtil.getInstance();
		try {
			cnt = sqlSession.update("member.insertMember",mv);
			if(cnt != 0) sqlSession.commit();
		} catch (PersistenceException ex) {
						
		} finally {
			sqlSession.close();
		}
		
		return cnt;
	}
}
