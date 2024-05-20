package main;

import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import print.PrintBoard;
import service.BoardService;
import service.BoardServiceImpl;
//import util.JDBCUtil3;
import vo.BoardVO;

public class BoardMain extends PrintBoard {
	
//	private Connection conn;
//	private Statement stmt;
//	private PreparedStatement pstmt;
//	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);
	
	private BoardService mService;

	public BoardMain() {
		scan = new Scanner(System.in);
		mService = BoardServiceImpl.getInstance();
	}
	BoardVO bv = new BoardVO();
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 글 작성");
		System.out.println("  2. 글 삭제");
		System.out.println("  3. 글 수정");
		System.out.println("  4. 글 검색");
		System.out.println("  5. 전체글 출력");
		System.out.println("  6. 종료.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 * @throws SQLException 
	 */
	public void start()  {
		int choice = 0;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertBoard();
				break;
			case 2: // 자료 삭제
				deleteBoard();
				break;
			case 3: // 자료 수정
				updateBoard();
				break;
			case 4: //글 검색
				searchBoard();
				break;
			case 5:
				selectAll();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	private void searchBoard() {
		// 제목검색만해보면
//		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = new BoardVO();
		System.out.print("검색할 글 번호을 입력하세요>> ");
		vo.setBoard_no(scan.nextBigDecimal());
		System.out.print("검색할 글 제목을 입력하세요>> ");
		vo.setBoard_title(scan.next());
		System.out.print("검색할 글 작성자 입력하세요>> ");
		vo.setBoard_writer(scan.next());
		System.out.print("검색할 글 내용 입력하세요>> ");
		vo.setBoard_content(scan.next());
		if(mService.searchBoard(vo) != null) {
			printSearchBoard(mService.searchBoard(vo));
		} else {
			System.out.println("그런거 없다");
		}
		
	}

	//글 전체조회
	private void selectAll() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = mService.selectAll();
		printSelectAll(list);
	}

	// 회원정보 삭제 메소드
	private void deleteBoard() {
		
		boolean chk = false;
		BigDecimal no;
		do {
			System.out.println();
			System.out.println("수정할 글번호");
			System.out.print("회원ID>> ");
			no = scan.nextBigDecimal();

			chk = chkNo(no);
			
			if (!chk) {
				System.out.println("없는 글번호, 다시 입력 바람");
			}
		} while (!chk);

		int result= mService.deleteBoard(no);
		if(result == 0) System.out.println("삭제실패");
		else System.out.println("삭제완료");
	}

	// 글 수정 메소드
	private void updateBoard() {

		boolean chk = false;
		BigDecimal no;
		do {
			System.out.println();
			System.out.println("수정할 글번호");
			System.out.print("회원ID>> ");
			no = scan.nextBigDecimal();

			chk = chkNo(no);
			
			if (!chk) {
				System.out.println("없는 글번호, 다시 입력 바람");
			}
		} while (!chk);

		System.out.print("제목>> ");
		String title = scan.next();

		System.out.print("작성자>> ");
		String writer = scan.next();

		System.out.println();// 입력버퍼 비우기

		System.out.print("내용>> ");
		String content = scan.next();
		
		bv.setBoard_title(title);
		bv.setBoard_writer(writer);
		bv.setBoard_content(content);
		
		mService.updateBoard(bv);

	}

	// 회원정보 등록 메소드
	private void insertBoard() {

		System.out.print("제목>>" );
		String title = scan.next();
		
		System.out.print("작성자>> ");
		String writer = scan.next();

		System.out.print("내용>> ");
		String content = scan.next();
		
		bv.setBoard_title(title);
		bv.setBoard_writer(writer);
		bv.setBoard_content(content);
		
		int res = mService.insertBoard(bv);
		
		printInsert(res);
	}
	

	private boolean chkNo(BigDecimal no) {
		return mService.chkNo(no);
	}
	
	public static void main(String[] args) throws SQLException {
		BoardMain boardObj = new BoardMain();
		boardObj.start();
	}

}
