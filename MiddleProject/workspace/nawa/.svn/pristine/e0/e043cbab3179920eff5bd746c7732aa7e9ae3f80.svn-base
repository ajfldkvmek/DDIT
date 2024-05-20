package board.vo;

import java.time.LocalDate;


public class PostVO {
	// 게시판 기본 VO
	private int postNo;	// 게시물 번호
	private String postTitle;	// 게시물 제목
	private String postWriter;	// 게시물 작성자
	private LocalDate postDate;	// 게시물 날짜
	private String postContent;	// 게시물 내용
	private long viewCnt = 0;	// 게시물 조회수
	private int postCate;	// 게시물 카테고리(분류)
	private int commCnt;	// 게시물별 댓글수
	
//	private String rnum;
	//게시판 페이징 관련
	private int page;		// 요청 페이지
	private int start;	// 페이징 시작 페이지
	private int end;	// 페이징 끝 페이지
	private int countPerPage;	// 페이지당 게시물 수
	private int startIdx;	// xml에 적힌 값
	private int currentPage; // xml
	private int totalPages;	// 총 게시물 수
	
	// 댓글 관련
	private int commNo;	// 댓글 번호
	private String commContent;	// 댓글 내용
	private LocalDate commDate;	// 댓글 작성일
	private String commWriter;	// 댓글 글쓴이
	
	// 댓글 페이징 관련
	private int commStart;	// 댓글 페이징 시작
	private int commEnd;	// 댓글 페이징 끝 (범위)
	private int commPage;	// 현재 댓글 페이지
	
	private int commStartIdx;
//	private int commCountPerPage;	
	private int countCommPerPage;	// 페이지당 댓글 수
	private int currentCommPage;	// 현재 댓글 페이지 수
	private int totalCommPages;		// 총 댓글 수
	
	// 검색 관련
	private String searchField;	// 검색 범위 분류
	private String searchText;	// 검색어

	// 검색 페이징
	private int searchStartIdx;	// 페이징 시작 위치
	private int searchCountPerPage;	// 검색결과 페이지당 게시물 수
	private int searchCount;	// 검색 결과 수
	private int searchPage;	// 검색 현재페이지

	// 카테고리
	private int cateStartIdx;
	private int cateCountPerPage;
	private int cateNo;
	private int catePageNo;
	private int cateValue;
	private int catePostsCount;
	
	private long atchFileId = -1; //파일첨부 여부 확인
	
	
	
	
	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public PostVO(String postTitle, String postContent) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	public PostVO(int postNo, String postTitle, String postContent) {
		super();
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	public PostVO(String postTitle, String postWriter, String postContent) {
		this.postTitle = postTitle;
		this.postWriter = postWriter;
		this.postContent = postContent;
	}
	
	public PostVO(int postNo, String postTitle, String postWriter, String postContent) {
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postWriter = postWriter;
		this.postContent = postContent;
	}
	
	public PostVO(int postNo, String postTitle, String postWriter, LocalDate postDate, String postContent) {
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postWriter = postWriter;
		this.postDate = postDate;
		this.postContent = postContent;
	}
	
	public PostVO() {
		
	}
	
	//####################################
	public PostVO(String commContent) {
		super();
		this.commContent = commContent;
	}
	
	public PostVO(int commNo, String commContent) {
		super();
		this.commNo = commNo;
		this.commContent = commContent;
	}

	public PostVO(int postNo, int commNo, String commContent) {
		super();
		this.postNo = postNo;
		this.commNo = commNo;
		this.commContent = commContent;
	}
	
	public PostVO(String commContent, int postNo, String commWriter) {
		super();
		this.commContent = commContent;
		this.postNo = postNo;
		this.commWriter = commWriter;
	}

	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	public String getPostWriter() {
		return postWriter;
	}
	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}

	public long getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(long viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getCommNo() {
		return commNo;
	}

	public void setCommNo(int commNo) {
		this.commNo = commNo;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public LocalDate getCommDate() {
		return commDate;
	}

	public void setCommDate(LocalDate commDate) {
		this.commDate = commDate;
	}

	public String getCommWriter() {
		return commWriter;
	}

	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}

	public int getPostCate() {
		return postCate;
	}

	public void setPostCate(int postCate) {
		this.postCate = postCate;
	}

	public int getStartIdx() {
		return startIdx;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getCommStartIdx() {
		return commStartIdx;
	}

	public void setCommStartIdx(int commStartIdx) {
		this.commStartIdx = commStartIdx;
	}

	public int getSearchStartIdx() {
		return searchStartIdx;
	}

	public void setSearchStartIdx(int searchStartIdx) {
		this.searchStartIdx = searchStartIdx;
	}

	public int getSearchCountPerPage() {
		return searchCountPerPage;
	}

	public void setSearchCountPerPage(int searchCountPerPage) {
		this.searchCountPerPage = searchCountPerPage;
	}

	public int getCountCommPerPage() {
		return countCommPerPage;
	}

	public void setCountCommPerPage(int countCommPerPage) {
		this.countCommPerPage = countCommPerPage;
	}

	public int getCommStart() {
		return commStart;
	}

	public void setCommStart(int commStart) {
		this.commStart = commStart;
	}

	public int getCommEnd() {
		return commEnd;
	}

	public void setCommEnd(int commEnd) {
		this.commEnd = commEnd;
	}

	public int getCommPage() {
		return commPage;
	}

	public void setCommPage(int commPage) {
		this.commPage = commPage;
	}

	public int getSearchPage() {
		return searchPage;
	}

	public void setSearchPage(int searchPage) {
		this.searchPage = searchPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCommPage() {
		return currentCommPage;
	}

	public void setCurrentCommPage(int currentCommPage) {
		this.currentCommPage = currentCommPage;
	}

	public int getTotalCommPages() {
		return totalCommPages;
	}

	public void setTotalCommPages(int totalCommPages) {
		this.totalCommPages = totalCommPages;
	}

	public int getCommCnt() {
		return commCnt;
	}

	public void setCommCnt(int commCnt) {
		this.commCnt = commCnt;
	}

	public int getCateStartIdx() {
		return cateStartIdx;
	}

	public void setCateStartIdx(int cateStartIdx) {
		this.cateStartIdx = cateStartIdx;
	}

	public int getCateCountPerPage() {
		return cateCountPerPage;
	}

	public void setCateCountPerPage(int cateCountPerPage) {
		this.cateCountPerPage = cateCountPerPage;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public int getCatePageNo() {
		return catePageNo;
	}

	public void setCatePageNo(int catePageNo) {
		this.catePageNo = catePageNo;
	}

	public int getCateValue() {
		return cateValue;
	}

	public void setCateValue(int cateValue) {
		this.cateValue = cateValue;
	}

	public int getCatePostsCount() {
		return catePostsCount;
	}

	public void setCatePostsCount(int catePostsCount) {
		this.catePostsCount = catePostsCount;
	}

	
	
	
}
