package board.dao;

import java.util.List;

import board.vo.PostVO;

public interface ICommentDao {

	/**
	 * PostVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param pv 등록할 게시물 정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0 반환
	 */
	public int insertComment(PostVO pv);
	
	/**
	 * PostVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param pv 등록할 회원정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0 반환
	 */
	public int updateComment(PostVO pv);
	
	/**
	 * 게시물이 존재하는지 확인하기 위한 메서드
	 * @param CommentNo 존재여부 체크할 게시물번호
	 * @return 게시물이 존재하면 true, 존재하지 않으면 false 리턴함
	 */
	public boolean checkComment(int commNo);
	
	/**
	 * 상세 게시물 정보를 가져오기 위한 메서드
	 * @param CommentNo 상세 게시물 정보를 가져오기 위한 게시물 번호
	 * @return 상세 게시물 정보를 담은 PostVO 객체
	 */
//	public PostVO getComment(int CommentNo);
	
	/**
	 * 게시물을 삭제하기 위한 메서드
	 * @param CommentNo 삭제할 게시물 번호
	 * @return DB작업 성공하면 1, 실패하면 0 반환
	 */
	public int deleteComment(int commNo);
	
	/**
	 * DB에 존재하는 (삭제처리되지 않은) 모든 게시물을 조회하기 위한 메서드
	 * (원랜 설계하고 인터페이스 만들고 코딩하는 것)
	 * @return
	 */
//	public List<PostVO> selectAll();
	
	/**
	 * 게시물을 검색하기 위한 메서드
	 * @param pv 검색조건을 담은 PostVO객체
	 * @return 검색된 게시물정보를 담은 List
	 */
//	public List<PostVO> searchComment(String searchField, String searchKeyword);

//	public void updateViewCnt(int CommentNo);

//	public List<PostVO> getCommentListWithPaging(int postNo, int start, int commCountPerPage);
	public List<PostVO> getCommentListWithPaging(PostVO pv);


	public int getTotalCommentCount(int postNo);

	public PostVO getComment(int commNo);
	
//	List<PostVO> searchCommentWithPaging(String searchField, String searchText, int start, int count);

//    int getTotalSearchCount(String searchField, String searchText);
}
