package board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import board.vo.PostVO;
import util.MyBatisUtil;

public class CommentDaoImpl implements ICommentDao {

	private static ICommentDao commDao;
	
	private CommentDaoImpl() {
		
	}
	
	public static ICommentDao getInstance() {
		if(commDao == null) {
			commDao = new CommentDaoImpl();
		}
		return commDao;
	}
	
	
	
	@Override
	public int insertComment(PostVO pv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		System.out.println("commDao pv: " + pv);
		try {

			cnt = sqlSession.insert("board.insertComment", pv);

			if( cnt > 0 ) {
				sqlSession.commit();
			}
		} catch (PersistenceException ex) {
//			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	@Override
	public int updateComment(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.update("board.updateComment", pv);
			
			if( cnt > 0 ) {
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
	public int deleteComment(int commNo) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;
		
		try {

//			cnt = sqlSession.delete("post.deletePost", postNo);
			cnt = sqlSession.update("board.deleteComment", commNo);
			 
		 	if( cnt > 0 ) {
				sqlSession.commit();
			}

		} catch (PersistenceException ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	@Override
	public boolean checkComment(int commNo) {
		boolean Exists = false;
		int cnt = 0;
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		
		try {
			
			cnt = sqlSession.selectOne("board.checkComment", commNo);
			
			if(cnt > 0) {
				Exists = true;
			}
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		} finally {
			sqlSession.close(); 
		}
		
		return Exists;
	}
	
	public PostVO getComment(int commNo) {
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		PostVO pv = null;
	try {
		
//		pv = sqlSession.selectOne("board.getComment", commNo);
		pv = sqlSession.selectOne("board.getComment", commNo);
		
	}catch(PersistenceException ex) {
		ex.printStackTrace();
	}finally {
		sqlSession.close();
	}
	
	return pv;
	}

	@Override
//	public List<PostVO> getCommentListWithPaging(int postNo, int start, int commCountPerPage) {
	public List<PostVO> getCommentListWithPaging(PostVO pv2) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List<PostVO> commList = null;
//		Map<String, Object> params = new HashMap<String, Object>();
		try {
			//(현재댓글페이지 - 1)*페이지당댓글수 ~  (현재댓글페이지*페이지당댓글수) - 1
		
//			commList = sqlSession.selectList("board.commentList", params);
			commList = sqlSession.selectList("board.getCommentListWithPaging", pv2);
			System.out.println("commList 가져왔니?" + commList);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("comm dao에서 pv2 못 가져옴");
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return commList;
	}

	@Override
	public int getTotalCommentCount(int postNo) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
        int totalCommCount = 0;

        try {
        	totalCommCount = sqlSession.selectOne("board.getTotalCommentCount", postNo);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return totalCommCount;
	}

}
