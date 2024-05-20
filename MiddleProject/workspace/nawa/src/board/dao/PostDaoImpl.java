package board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import board.vo.PostVO;
import member.vo.MemberVO;
import util.MyBatisUtil;

public class PostDaoImpl implements IPostDao {
	
	private static IPostDao postDao;
	
	private PostDaoImpl() {
		
	}
	
	public static IPostDao getInstance() {
		if(postDao == null) {
			postDao = new PostDaoImpl();
		}
		return postDao;
	}
	
	
	

	public int insertPost(PostVO pv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("board.insertPost", pv);
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

	
	
	public int updatePost(PostVO pv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.update("board.updatePost", pv);
			
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
	
	
	
	
	public int deletePost(int postNo) {

		SqlSession sqlSession = MyBatisUtil.getInstance();

		int cnt = 0;
		
		try {

//			cnt = sqlSession.delete("post.deletePost", postNo);
			cnt = sqlSession.update("board.deletePost", postNo);
			 
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
	
	public boolean checkPostNo(int postNo) {

		boolean Exists = false;
		int cnt = 0;
		SqlSession sqlSession = MyBatisUtil.getInstance(true);

		try {

			cnt = sqlSession.selectOne("board.checkPost", postNo);
		 	
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

	@Override
	public PostVO getPost(int postNo) {
		SqlSession sqlSession = MyBatisUtil.getInstance(true);
		PostVO pv = null;
	try {
		
		pv = sqlSession.selectOne("board.getPost", postNo);
		System.out.println("[PostDaoImpl] getPost의 postNo: " + postNo);
	}catch(PersistenceException ex) {
		ex.printStackTrace();
	}finally {
		sqlSession.close();
	}
	
	return pv;
	}

	@Override
	public void updateViewCnt(int postNo) {
	    SqlSession sqlSession = MyBatisUtil.getInstance();
	    try {
	        sqlSession.update("board.updateViewCnt", postNo);
	        sqlSession.commit();
	    } catch (PersistenceException ex) {
	        ex.printStackTrace();
	        sqlSession.rollback();
	    } finally {
	        sqlSession.close();
	    }
	}
	
	//게시물 목록 가져오기 ############################################################
//	public List<PostVO> getPostListWithPaging(int startIdx, int countPerPage) {
	public List<PostVO> getPostListWithPaging(PostVO pv) {
	    SqlSession sqlSession = MyBatisUtil.getInstance();
	    List<PostVO> postList = null;

	    try {
	        sqlSession = MyBatisUtil.getInstance();
	        postList = sqlSession.selectList("board.getPostListWithPaging", pv);
	    } finally {
	        if (sqlSession != null) {
	            sqlSession.close();
	        }
	    }
	    
	    return postList;
	}

	//총 게시물 수
	@Override
	public int getTotalPostCount() {
		SqlSession sqlSession = MyBatisUtil.getInstance();
        int totalCount = 0;

        try {
            totalCount = sqlSession.selectOne("board.getTotalPostCount");
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return totalCount;
	}
	
	//검색결과 목록 가져오기
	@Override
    public List<PostVO> searchPostWithPaging(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();

		List <PostVO> pagingSearchList = new ArrayList();

		try {
			pagingSearchList = sqlSession.selectList("board.searchPostWithPaging", pv);
			System.out.println("[PostDaoImpl] searchPostWithPaging searchList: " + pagingSearchList);
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			System.out.println("[PostDaoImpl] searchPostWithPaging searchList: 실패");
		}finally {
			sqlSession.close();
		}
		return pagingSearchList;

    }

	//검색결과 총 게시물 수
    @Override
    public int getTotalSearchCount(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		PostVO ppv = null;
		int cnt = 0;
		
		try {
//			cnt = sqlSession.selectOne("board.getTotalSearchCount", pv);
			 ppv = sqlSession.selectOne("board.getTotalSearchCount", pv);
	        if (ppv != null) {
	            cnt = ppv.getSearchCount();
	            System.out.println("[PostDaoImpl] getTotalSearchCount: cnt 받기 성공" + cnt);
	        	}
			} catch (PersistenceException ex) {
	            ex.printStackTrace();
	            System.out.println("[PostDaoImpl] getTotalSearchCount: cnt 받기 실패!");
	        } finally {
	        	sqlSession.close();
	        }
        return cnt;
    }
    
    // 제목 옆에 댓글수 표시
    public int updateCommentCount(int postNo) {
    	SqlSession sqlSession = MyBatisUtil.getInstance();
    	int commCnt = 0;
    	
    	try {
    		commCnt = sqlSession.selectOne("board.updateCommentCount", postNo);
            System.out.println("[PostDaoImpl] updateCommentCount: commCnt 받기 성공" + commCnt);

    	}catch (PersistenceException ex) {
    		ex.printStackTrace();
    		System.out.println("[PostDaoImpl] updateCommentCount: cnt 받기 실패!" );
    	}finally {
        	sqlSession.close();
        }
    	
    	return commCnt;
    }
    
    
	//카테고리별 목록 가져오기
	@Override
    public List<PostVO> getPostsByCategory(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List <PostVO> cateList = new ArrayList();
		System.out.println("[PostDaoImpl] getPostsByCategory시작: pv " + pv);
		try {
			cateList = sqlSession.selectList("board.getPostsByCategory", pv);
			System.out.println("[PostDaoImpl] getPostsByCategory cateList: " + cateList);
			
		} catch(PersistenceException ex) {
			ex.printStackTrace();
			System.out.println("[PostDaoImpl] getPostsByCategory 받기 실패!");
		} finally {
        	sqlSession.close();
        }
		return cateList;
    }

	//카테고리별 목록의 총 게시물 수
    @Override
    public int getPostsByCategoryCount(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		PostVO ppv = null;
		int cnt = 0;
		System.out.println("\"[PostDaoImpl] getPostsByCategoryCount pv: " + pv);
		try {
			 ppv = sqlSession.selectOne("board.getPostsByCategoryCount", pv);
	        if (ppv != null) {
	            cnt = ppv.getCatePostsCount();
	            System.out.println("[PostDaoImpl] getPostsByCategoryCount cnt 받기 성공: " + cnt);
	        	}
			} catch (PersistenceException ex) {
	            ex.printStackTrace();
	            System.out.println("[PostDaoImpl] getPostsByCategoryCount: cnt 받기 실패!");
	        } finally {
	        	sqlSession.close();
	        }
        return cnt;
    }
    
    //공지사항 조회용 뷰
    public List<PostVO> getViewBNotice() {
    	SqlSession sqlSession = MyBatisUtil.getInstance();
		List <PostVO> bNotiList = new ArrayList();
		System.out.println("[PostDaoImpl] getViewBNotice 시작");
		try {
			bNotiList = sqlSession.selectList("board.getViewBNotice");
			System.out.println("[PostDaoImpl] getViewBNotice bNotiList: " + bNotiList);
		} catch(PersistenceException ex) {
			ex.printStackTrace();
			System.out.println("[PostDaoImpl] getViewBNotice 받기 실패!");
		} finally {
        	sqlSession.close();
        }
    	return bNotiList;
    }

	@Override
	public List<PostVO> getTutorReqList(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List <PostVO> tutuorReqList = new ArrayList();
		System.out.println("[PostDaoImpl] getTutorReqList시작: pv " + pv);
		try {
			tutuorReqList = sqlSession.selectList("board.getTutorReqList", pv);
			System.out.println("[PostDaoImpl] getTutorReqList tutuorReqList: " + tutuorReqList);
			
		} catch(PersistenceException ex) {
			ex.printStackTrace();
			System.out.println("[PostDaoImpl] getTutorReqList 받기 실패!");
		} finally {
        	sqlSession.close();
        }
		return tutuorReqList;
	}

	@Override
	public int getTutorReqCount(PostVO pv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		PostVO ppv = null;
		int cnt = 0;
		System.out.println("[PostDaoImpl] getTutorReqCount pv: " + pv);
		try {
			 ppv = sqlSession.selectOne("board.getTutorReqCount", pv);
	        if (ppv != null) {
	            cnt = ppv.getTutorReqCount();
	            System.out.println("[PostDaoImpl] getTutorReqCount cnt 받기 성공: " + cnt);
	        	}
			} catch (PersistenceException ex) {
	            ex.printStackTrace();
	            System.out.println("[PostDaoImpl] getTutorReqCount: cnt 받기 실패!");
	        } finally {
	        	sqlSession.close();
	        }
		
        return cnt;
	}

	@Override
	public List<MemberVO> getTutorReqDetail(PostVO ppv) {
		SqlSession sqlSession = MyBatisUtil.getInstance();
		List <MemberVO> tutuorDetail = new ArrayList();
		System.out.println("[PostDaoImpl] getTutorReqList시작: ppv " + ppv);
		try {
			tutuorDetail = sqlSession.selectList("board.getTutorReqList", ppv);
			System.out.println("[PostDaoImpl] getTutorReqDetail tutuorDetail: " + tutuorDetail);
			
		} catch(PersistenceException ex) {
			ex.printStackTrace();
			System.out.println("[PostDaoImpl] getTutorReqDetail 받기 실패!");
		} finally {
        	sqlSession.close();
        }
		return tutuorDetail;
	}

	
	
	public int insertNotice(PostVO pv) {

		SqlSession sqlSession = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = sqlSession.insert("board.insertNotice", pv);
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
	
	
	//공지사항 목록 가져오기
		@Override
	    public List<PostVO> getNoticeList(PostVO pv) {
			SqlSession sqlSession = MyBatisUtil.getInstance();
			List <PostVO> noticeList = new ArrayList();
			System.out.println("[PostDaoImpl] getNoticeList시작: pv " + pv);
			try {
				noticeList = sqlSession.selectList("board.getNoticeList", pv);
				System.out.println("[PostDaoImpl] getNoticeList noticeList: " + noticeList);
				
			} catch(PersistenceException ex) {
				ex.printStackTrace();
				System.out.println("[PostDaoImpl] getNoticeList 받기 실패!");
			} finally {
	        	sqlSession.close();
	        }
			return noticeList;
	    }

		//공지사항 총 게시물 수
	    @Override
	    public int getNoticeCount() {
			SqlSession sqlSession = MyBatisUtil.getInstance();
			int cnt = 0;
			System.out.println("[PostDaoImpl] getNoticeCount 도착");
			try {
				 cnt = sqlSession.selectOne("board.getNoticeCount");
		            System.out.println("[PostDaoImpl] getNoticeCount cnt 받기 성공: " + cnt);
				} catch (PersistenceException ex) {
		            ex.printStackTrace();
		            System.out.println("[PostDaoImpl] getNoticeCount: cnt 받기 실패!");
		        } finally {
		        	sqlSession.close();
		        }
	        return cnt;
	    }

		@Override
		public MemberVO getMemInfo(MemberVO pvm) {
			SqlSession sqlSession = MyBatisUtil.getInstance();
			MemberVO memInfo = new MemberVO();
			System.out.println("[PostDaoImpl] getMemInfo시작: pvm " + pvm);
			try {
				memInfo = (MemberVO) sqlSession.selectOne("member.getMemberInfo", pvm);
				System.out.println("[PostDaoImpl] getMemInfo memInfo: " + memInfo);
				
			} catch(PersistenceException ex) {
				ex.printStackTrace();
				System.out.println("[PostDaoImpl] getMemInfo 받기 실패!");
			} finally {
	        	sqlSession.close();
	        }
			return memInfo;
		}
	    
	    
}
