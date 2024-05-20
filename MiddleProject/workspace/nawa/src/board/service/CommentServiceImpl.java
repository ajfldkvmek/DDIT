package board.service;

import java.util.List;

import board.dao.CommentDaoImpl;
import board.dao.ICommentDao;
import board.vo.PostVO;

public class CommentServiceImpl implements ICommentService {

	private static ICommentService commService;

	private ICommentDao commDao;

	private CommentServiceImpl() {
		commDao = CommentDaoImpl.getInstance();
	}

	public static ICommentService getInstance() {

		if (commService == null) {
			commService = new CommentServiceImpl();
		}
		return commService;
	}
	
	
	
	@Override
	public int insertComment(PostVO pv) {
		int cnt = commDao.insertComment(pv);
		return cnt;
	}

	@Override
	public int updateComment(PostVO pv) {
		int cnt = commDao.updateComment(pv);
		return cnt;
	}

	@Override
	public boolean checkComment(int commNo) {
		boolean Exists = commDao.checkComment(commNo);
		return Exists;
	}

	@Override
	public int deleteComment(int commNo) {
		int cnt = commDao.deleteComment(commNo);
		return cnt;
	}
	
	public PostVO getCommNo(int commNo) {
		PostVO pv = commDao.getComment(commNo);
		return pv;
	}

	@Override
	public List<PostVO> getCommentListWithPaging(PostVO pv2) {
		System.out.println("comm Service end: " + pv2);
		return commDao.getCommentListWithPaging(pv2);
	}
//	public List<PostVO> getCommentListWithPaging(int postNo, int commPage, int commCountPerPage) {
	    // 페이징 시작 위치 계산
//		int start = (commPage - 1) * commCountPerPage;
//		if(start <= 0) start = 1;
//		System.out.println("service postNo: " + postNo + " | start: "  + start + " | commCountPerPage: "  + commCountPerPage);

	    // PostDao를 통해 검색 결과를 페이징하여 가져옴
//		return commDao.getCommentListWithPaging(postNo, start, commCountPerPage);

	@Override
	public int getTotalCommentCount(int postNo) {
		return commDao.getTotalCommentCount(postNo);
	}

}
