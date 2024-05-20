package board.service;

import java.util.List;

import board.dao.IPostDao;
import board.dao.PostDaoImpl;
import board.vo.PostVO;

public class PostServiceImpl implements IPostService {

	private static IPostService postService;

	private IPostDao postDao;

	private PostServiceImpl() {
		postDao = PostDaoImpl.getInstance();
	}

	public static IPostService getInstance() {

		if (postService == null) {
			postService = new PostServiceImpl();
		}
		return postService;
	}

	public int registPost(PostVO pv) {
		int cnt = postDao.insertPost(pv);
		return cnt;
	}

	public int modifyPost(PostVO pv) {
		int cnt = postDao.updatePost(pv);
		return cnt;
	}

	public boolean checkPostNo(int postNo) {
		boolean Exists = postDao.checkPostNo(postNo);
		return Exists;
	}

	public int removePost(int postNo) {
		int cnt = postDao.deletePost(postNo);
		return cnt;
	}

	@Override
	public PostVO getPostNo(int postNo) {
		PostVO pv = postDao.getPost(postNo);
		return pv;
	}

	@Override
//	public void updateViewCnt(PostVO pv) {
	public void updateViewCnt(int postNo) {
		postDao.updateViewCnt(postNo);
	}
	
	@Override
	public List<PostVO> getPostListWithPaging(PostVO pv) {
		return postDao.getPostListWithPaging(pv);
	}

	@Override
	public int getTotalPostCount() {
        return postDao.getTotalPostCount();
	}
	
	@Override
	public List<PostVO> searchPostWithPaging(PostVO pv) {
		System.out.println("PostServiceImpl searchPostWithPaging: " + pv);
		return postDao.searchPostWithPaging(pv);
	}

	@Override
	public int getTotalSearchCount(PostVO pv) {
//		System.out.println("service getTotalSearchCount: " + searchField + " | " + searchText);
	    return postDao.getTotalSearchCount(pv);
//		int cnt = postDao.getTotalSearchCount(pv);
//		return cnt;
	}

	@Override
	public int updateCommentCount(int postNo) {
		return postDao.updateCommentCount(postNo);
	}

	@Override
	public List<PostVO> getPostsByCategory(PostVO pv) {
		System.out.println("[PostServiceImpl] getPostsByCategory pv: " + pv);
		return postDao.getPostsByCategory(pv);
	}

	@Override
	public int getPostsByCategoryCount(PostVO pv) {
		return postDao.getPostsByCategoryCount(pv);
	}

	public List<PostVO> getViewBNotice() {
		System.out.println("[PostServiceImpl] getViewBNotice 도착");
		return postDao.getViewBNotice();
	}
}
