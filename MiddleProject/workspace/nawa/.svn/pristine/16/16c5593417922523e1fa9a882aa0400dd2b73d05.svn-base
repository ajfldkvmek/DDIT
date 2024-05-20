package board.service;

import java.util.List;

import board.vo.PostVO;

public interface ICommentService {
	/**
	 * 게시물 등록을 위한 메서드
	 * @param pv 등록할 게시물 정보를 담은 VO 객체
	 * @return 등록 성공하면 1, 실패하면 0 반환
	 */
	public int insertComment(PostVO pv);
	
	/**
	 * 게시물 수정을 위한 메서드
	 * @param pv 수정할 게시물 정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0 반환
	 */
	public int updateComment(PostVO pv);
	
	/**
	 * 게시물이 존재하는지 확인하기 위한 메서드
	 * @param PostNo 존재여부 확인할 게시물 번호
	 * @return 게시물이 존재하면 true, 존재하지 않으면 false 리턴함.
	 */
	public boolean checkComment(int commNo);
	
	/**
	 * 게시물 상세정보를 가져오기 위한 메서드
	 * @param PostNo 게시물 상세정보를 가져오기 위한 게시물 번호
	 * @return 게시물정보를 담은 PostVO객체 리턴함
	 */
//	public PostVO getPostNo(int postNo);
	
	/**
	 * 게시물을 삭제하기 위한 메서드
	 * @param postNo 삭제할 게시물 번호
	 * @return 작업 성공하면 1, 실패하면 0 반환
	 */
	public int deleteComment(int commNo);
	
	/**
	 * 모든 게시물을 조회하기 위한 메서드
	 * @param postNo 
	 * @return 모든 등록된 게시물 (삭제처리된 게시물 제외)
	 */
//	public List<PostVO> displayAllPost();
	
	public PostVO getCommNo(int commNo);
	
	/**
	 * 게시물을 검색하기 위한 메서드
	 * @param pv 검색정보를 담은 PostVO 객체
	 * @return 검색된 게시물정보를 담은 List
	 */
//	public List<PostVO> searchPost(String searchField, String searchKeyword);
	
//	public void updateViewCnt(int postNo);

//	List<PostVO> getCommentListWithPaging(int postNo, int commPage, int commCountPerPage);
	List<PostVO> getCommentListWithPaging(PostVO pv);

	public int getTotalCommentCount(int postNo);
	
//	List<PostVO> searchPostWithPaging(String searchField, String searchText, int start, int count);

//    int getTotalSearchCount(String searchField, String searchText);
	
}
