package board.dao;

import java.util.List;

import board.vo.PostVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 받아와 
 * 서비스에 전달하는 DAO의 인터페이스
 * 
 *  @AUTHOR PC-24
 *  
 */
public interface IPostDao {
	
	// 추상메소드의 정의
	// (e.g.public int insertMember(String memId, String memName
			// , String memTel, String memAddr);)
	// 괄호에 일일이 항목 넣는건 효율적인 파라미터 전달방법이 아님 -> VO사용
	// DTO 하나 정의해서 DTO의 파라미터로 VO 정의하고... 등등 활용가능
	// DTO는 전달하는 기능에 초점을 맞춘 것. VO는 보관하는 기능에 포커스
	// DTO는 객체 담아 전달만. VO는 재정의도 가능.
	// => PostVO 패키지&클래스 생성
	
	/**
	 * PostVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param pv 등록할 게시물 정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0 반환
	 */
	public int insertPost(PostVO pv);
	
	/**
	 * PostVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param pv 등록할 회원정보를 담은 VO
	 * @return DB작업이 성공하면 1, 실패하면 0 반환
	 */
	public int updatePost(PostVO pv);
	
	/**
	 * 게시물이 존재하는지 확인하기 위한 메서드
	 * @param PostNo 존재여부 체크할 게시물번호
	 * @return 게시물이 존재하면 true, 존재하지 않으면 false 리턴함
	 */
	public boolean checkPostNo(int postNo);
	
	/**
	 * 상세 게시물 정보를 가져오기 위한 메서드
	 * @param PostNo 상세 게시물 정보를 가져오기 위한 게시물 번호
	 * @return 상세 게시물 정보를 담은 PostVO 객체
	 */
	public PostVO getPost(int postNo);
	
	/**
	 * 게시물을 삭제하기 위한 메서드
	 * @param postNo 삭제할 게시물 번호
	 * @return DB작업 성공하면 1, 실패하면 0 반환
	 */
	public int deletePost(int postNo);
	
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
//	public List<PostVO> searchPost(String searchField, String searchKeyword);
//	public List<PostVO> searchPost(PostVO pv);

	
//	public void updateViewCnt(PostVO pv);
	public void updateViewCnt(int postNo);

//	public List<PostVO> getPostListWithPaging(int startIdx, int countPerPage);
	public List<PostVO> getPostListWithPaging(PostVO pv);

	public int getTotalPostCount();
	
//	List<PostVO> searchPostWithPaging(String searchField, String searchText, int start, int count);
	List<PostVO> searchPostWithPaging(PostVO pv);

//    int getTotalSearchCount(String searchField, String searchText);
    int getTotalSearchCount(PostVO pv);
	
    public int updateCommentCount(int postNo);
    
    public List<PostVO> getPostsByCategory(PostVO pv); 
    
    public int getPostsByCategoryCount(PostVO pv);

	public List<PostVO> getViewBNotice();
    
}
