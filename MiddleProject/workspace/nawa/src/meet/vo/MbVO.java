package meet.vo;

import java.time.LocalDate;

public class MbVO {
	private int mb_no;
	private String mb_title;
	private String mb_cont;
	private String mb_ctno;
	private String mb_ctname;
	private LocalDate mb_bdate;

	private String mem_id;
	private String meet_no;

	private int cnt;

	private int mb_cnt;

	
	// 게시판 페이징 관련
	private int page; // 요청 페이지
	private int start; // 페이징 시작 페이지
	private int end; // 페이징 끝 페이지
	private int countPerPage; // 페이지당 게시물 수
	private int startIdx; // xml에 적힌 값
	private int currentPage; // xml
	private int totalPages; // 총 게시물 수
	
	private String mem_nick;
	
	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
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

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getStartIdx() {
		return startIdx;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getMb_cnt() {
		return mb_cnt;
	}

	public void setMb_cnt(int mb_cnt) {
		this.mb_cnt = mb_cnt;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMeet_no() {
		return meet_no;
	}

	public void setMeet_no(String meet_no) {
		this.meet_no = meet_no;
	}

	public String getMb_ctno() {
		return mb_ctno;
	}

	public void setMb_ctno(String mb_ctno) {
		this.mb_ctno = mb_ctno;
	}

	public String getMb_ctname() {
		return mb_ctname;
	}

	public void setMb_ctname(String mb_ctname) {
		this.mb_ctname = mb_ctname;
	}

	public int getMb_no() {
		return mb_no;
	}

	public void setMb_no(int mb_no) {
		this.mb_no = mb_no;
	}

	public String getMb_title() {
		return mb_title;
	}

	public void setMb_title(String mb_title) {
		this.mb_title = mb_title;
	}

	public LocalDate getMb_bdate() {
		return mb_bdate;
	}

	public void setMb_bdate(LocalDate mb_bdate) {
		this.mb_bdate = mb_bdate;
	}

	public String getMb_cont() {
		return mb_cont;
	}

	public void setMb_cont(String mb_cont) {
		this.mb_cont = mb_cont;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}