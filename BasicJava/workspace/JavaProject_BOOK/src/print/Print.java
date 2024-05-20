package print;

import java.util.List;

import javax.sound.midi.Soundbank;

import vo.Book;

public class Print {

	public void printVar() {
		System.out.println("----------------------------------");
	}

	public void println(int num) {
		for (int i = 0; i < num; i++)
			System.out.println();
	}

	
	public void prindDelete() {
		
	}
	
	public void printDetail(Book book) {
		System.out.println(book.getName());
//		System.out.println(book.getName());
//		System.out.println(book.getName()); ...
		
		
		System.out.println("1. ㅎ");
	}
	
	
	public void printListMenu() {
		printVar();
		System.out.println("1. 상세페이지");
		System.out.println("2. 홈");
		println(3);
		printVar();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 관리자"); // 신규등록, 업데이트, 삭제
		System.out.println("2. 일반 회원");
		println(5);
		printVar();
	}

	public void printBookList(List<Book> l) {
		// 게시판 내용 출력"\t"
		printVar();
		System.out.println("번호\t이름\t출판사\t작가 \t설명\t가격");
		for (Book book : l) 
			System.out.println(
					book.getNo()+"\t"+book.getName()+"\t"+book.getPub()+"\t"+book.getWriter()+"\t"
					+book.getContent()+"\t"+book.getSale_price()+"\t");
		for (Book book : l) 
			System.out.println(book.getNo());
		println(1);
		printVar();
	}

	public void printAdmin() {
		printVar();
		System.out.println("1. 등록");
		System.out.println("2. 업데이트");
		System.out.println("3. 삭제");
		System.out.println("4. 로그아웃");
		println(4);
		printVar();
	}

	public void printMember() {
		printVar();
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 홈");
		println(5);
		printVar();
	}

}
