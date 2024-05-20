package print;

import java.util.List;

import vo.Board;

public class Print {
	
	public void printUserBoard(List<Board> list) {
		System.out.println("----------------------------------");
		System.out.println("게시번호\t	제목\t내용\t작성일\t조회수\t작성자\t");
		for (Board board : list) {
			System.out.println(board.getNo()+"\t"+board.getTitle()+"\t"
								+board.getText()+"\t"+board.getTime()
								+"\t"+board.getCount() + "\t" + board.getMem_no() + "\t");
		}
	}
	
	public void printAdmin(){
		System.out.println("----------------------------------");
		System.out.println("0. 전체 게시판 조회");
		System.out.println("1. 정상 게시판 조회");
		System.out.println("2. 불량 게시글 조회");
		System.out.println("3. 불량 게시글 등록");
		System.out.println("4. 홈");
		System.out.println("----------------------------------");
	}
	
	
	public void printHome() {
		System.out.println("----------------------------------");
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 일반회원 로그인");
		System.out.println("----------------------------------");
	}
	
	public void printMember() {
		System.out.println("----------------------------------");
		System.out.println("1. 작성글 조회");
		System.out.println("2. 홈");
		System.out.println("----------------------------------");
	}
	

	public void printBadList(List<Board> l) {
		// 게시판 내용 출력
		System.out.println("----------------------------------");
		System.out.println("게시번호\t	제목\t내용\t작성일\t조회수\t작성자\t");
		for (Board board : l) {
			System.out.println(board.getNo()+"\t"+board.getTitle()+"\t"
								+board.getText()+"\t"+board.getTime()
								+"\t"+board.getCount() + "\t" + board.getMem_no());
		}
	}
	
	public void printList(List<Board> l) {
		// 게시판 내용 출력
		System.out.println("----------------------------------");
		System.out.println("게시번호\t제목\t\t내용\t작성자\t작성시간\t조회수");
		for (Board board : l) {
			System.out.println(board.getNo()+"\t"+board.getTitle()+"\t"
					+board.getText()+"\t"+board.getTime()
					+"\t"+board.getCount() + "\t" + board.getMem_no());
		}
		System.out.println("----------------------------------");

	}
	
	public void printView(Board view) {
		System.out.println("----------------------------------");
		System.out.println(view);
		System.out.println("----------------------------------");
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
	}
}
