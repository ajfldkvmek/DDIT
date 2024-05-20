package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import print.Print;
import service.AdminService;
import service.BoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.Board;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	BoardService boardService = BoardService.getInstance();
	AdminService adminService = AdminService.getInstance();
	MemberService memberService = MemberService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
//			case BOARD_LIST: 
//				view = boardList();
//				break;
//			case BOARD_DETAIL:
//				view = boardView();
//				break;
//			case BOARD_INSERT:
//				view = boardInsert();
//				break;
//			case BOARD_DELETE:
//				view = boardDelete();
//				break;
//			case BOARD_UPDATE:
//				view = boardUpdate();
//				break;

			case LOGIN_ADMIN:
				view = loginAdmin();
				break;
			case ADMIN:
				view = admin();
				break;
			case BAD:
				view = badBoard();
				break;
			case MEMBER_LOGIN:
				view = loginMember();
				break;
			case MEMBER:
				view = member();
				break;
			}
		}
	}


	private View member() {
		printMember();
		int select = ScanUtil.nextInt("뭐할까? ");
		String id = (String) sessionStorage.get("id");
		switch(select) {
		case 1:
			List<Board> list = boardService.userBoard(id);
			printUserBoard(list);
			return View.MEMBER;
		default:
			return View.HOME;
		}
	}

	private View loginMember() {
		View v;
		String id = ScanUtil.nextLine("아이디>> ");
		String pw = ScanUtil.nextLine("비번>> ");
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);

		boolean loginChk = memberService.loginMember(param);
		System.out.println(loginChk);
		if (loginChk) {
			sessionStorage.put("id", id);
			return View.MEMBER;
		}
		else {
			System.out.println("로그인 실패 홈으로 돌아갑니다");
			return View.HOME;
		}
	}

	private View badBoard() {
		List<Board> list = boardService.goodList();
		printList(list);
		
		int select = ScanUtil.nextInt("어느놈 차단할래?>> ");
		List<Object> param = new ArrayList<Object>();
		param.add(select);
		boolean changeChk = boardService.badBoard(param);
		
		if(changeChk) System.out.println("수정완료");
		else System.out.println("게시글 번호를 확인하여 주세요");
		
		return View.ADMIN;
	}

	private View admin() {
		printAdmin();
		List<Board> list = boardService.boardList();
		List<Board> badlist = boardService.badboardList();		
		List<Board> goodlist = boardService.goodList();
		
		int select = ScanUtil.nextInt("뭐할까?>> ");
		switch (select) {
		case 0:
			printList(list);
			return View.ADMIN;
		case 1:
			printList(goodlist);
			return View.ADMIN;
		case 2: // 불량게시판 조회
			printBadList(badlist);
			return View.ADMIN;
		case 3: // 불량게시판 등록
			return View.BAD;
		default: // 홈
			return View.HOME;
		}
	}

	private View loginAdmin() {
		String id = ScanUtil.nextLine("아이디>> ");
		String pw = ScanUtil.nextLine("비번>> ");
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);

		boolean loginChk = adminService.loginAdmin(param);

		if (loginChk)
			return View.ADMIN;
		else {
			System.out.println("로그인 실패 홈으로 돌아갑니다");
			return View.HOME;
		}
	}

//	private View boardUpdate() {
//		int board_no = (int) sessionStorage.get("board_no");
//		
//		String name = ScanUtil.nextLine("이름");
//		String writer = ScanUtil.nextLine("작성자");
//		String content = ScanUtil.nextLine("내용");
//		
//		List<Object> param = new ArrayList();
//		
//		param.add(name);
//		param.add(writer);
//		param.add(content);
//		param.add(board_no);
//		
//		boardService.boardUpdate(param);
//		
//		
//		return null;
//	}
//
//	private View boardDelete() {
//		int board_no = (int) sessionStorage.get("board_no");
//		String del = ScanUtil.nextLine(board_no +"게시글을 정말 삭제하시겠습니까?(y/n)");
//		if(del.equals("y")) {
//			boardService.boardDelete(board_no);
//		}
//		return View.BOARD_LIST;
//	}
//
//	private View boardInsert() {
////		 *  게시번호	제목	작성자	작성시간	내용(10자만 출력)
////		 *  3	게시글3	테스트1	2023-11-01	오늘 날씨는 ....
////		 *  2	게시글2	테스트1	2023-11-01	오늘 날씨는 ....
////		 *  1	게시글1	테스트1	2023-10-31	오늘 날씨는 ....
//		String name = ScanUtil.nextLine("제목 작성");
//		String writer = ScanUtil.nextLine("작성자");
//		String content = ScanUtil.nextLine("내용");
//		
//		List<Object> param = new ArrayList();
//		param.add(name);
//		param.add(writer);
//		param.add(content);
//		
//		boardService.boardInsert(param);
//		return View.BOARD_LIST;
//	}
//
//	private View boardView() {
//		int board_no = ScanUtil.nextInt("게시판을 선택하세요.");
//		sessionStorage.put("board_no", board_no);
//		Board fb =  boardService.boardView(board_no);
//		printView(fb);
//		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
//		switch (select) {
//		case 1:
//			return View.BOARD_UPDATE;
//		case 2:
//			return View.BOARD_DELETE;
//		default:
//			return View.BOARD_DETAIL;
//		}
//	}
//
//	private View boardList() {
//		List<Board> list = boardService.boardList();
//		printList(list);
//		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
//		switch (select) {
//		case 1:
//			return View.BOARD_DETAIL;
//		case 2:
//			return View.HOME;
//		default:
//			return View.BOARD_LIST;
//		}
//	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.LOGIN_ADMIN;
		case 2:
			return View.MEMBER_LOGIN;
		default:
			return View.HOME;
		}
	}
}
