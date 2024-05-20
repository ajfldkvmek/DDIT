package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import print.Print;
import service.memService;
import service.adminService;
import util.ScanUtil;
import util.View;
import vo.Admin;
import vo.Mem;

public class Controller extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	memService mService = memService.getInstance();
	adminService adService = adminService.getInstance();

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
			case ADMIN_HOME:
				view = adminHome();
				break;

			case ADMIN_MENU:
				view = adminMenu();
				break;

			case MEMBER_HOME:
				view = memberHome();
				break;

			case MEMBER_MENU:
				view = memberMenu();
				break;

			case SIGNUP:
				view = signUp();
				break;
			case MEMBER_UPDATE:
				view = upDate();
				break;
			case MEMBER_DELETE:
				view = delete();
				break;
			}
		}
	}
//	private View ticketCreate() {
//		Mem mem = (Mem) sessionStorage.get("bus");
//		adminService.ticketCreate(mem);
//		return null;
//	}
//
//	private View reserve() {
//		String st = ScanUtil.nextLine("출발지역 >> ");
//		String ed = ScanUtil.nextLine("도착지역 >> ");
//		
//		List<Mem> busList = memService.list(st, ed);
//		printBusList(busList);
//		printReserveMenu();
//		while(true) {
//			int select = ScanUtil.nextInt("메뉴를 선택하세요.");
//			
//			switch (select) {
//			case 1:
//				int busNo = ScanUtil.nextInt("예매 번호를 선택하세요.")-1;
//				Mem mem = busList.get(busNo);
//				sessionStorage.put("bus", mem);
//				return View.TICKET_CREATE;
//			case 2:
//				return View.RESERVE_LIST;
//			case 3:
//				return View.HOME;
//			default :
//				System.out.println("다시 입력하세요.");
//			}
//			
//		}
//	}

	private View delete() {
		int select = ScanUtil.nextInt("진짜 탈퇴? 1.ㅇㅇ 2.ㄴㄴ");
		switch (select) {
		case 1:
			List<Object> param = new ArrayList<Object>();
			param.add(select);
			param.add(sessionStorage.get("id"));
			boolean del = mService.delete(param);
			return View.HOME;
		case 2:
			return View.MEMBER_DELETE;
		default:
			return View.MEMBER_DELETE;
		}

	}

	private View upDate() {
//		if (sessionStorage == null) {
//			System.out.println("로그인을 먼저 해 주세요");
//			return View.MEMBER_HOME;
//		}
//		else {
//			return 
//		}
		printUpdateMenu();
		String id = (String) sessionStorage.get("id");
		String pw, name;
		int age;

		int select = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (select) {
		case 1: // 비밀번호
			pw = ScanUtil.nextLine("수정할 비밀번호 입력 >>");
			boolean pwc = mService.pwUpdate(id, pw);
			if (pwc)
				System.out.println("변경 완료");
			else
				System.out.println("실패");
			break;

		case 2: // 이름
			name = ScanUtil.nextLine("수정할 이름 입력 >>");
			boolean namec = mService.nameUpdate(id, name);
			if (namec)
				System.out.println("변경 완료");
			else
				System.out.println("실패");
			break;
		case 3: // 나이
			age = ScanUtil.nextInt("수정할 나이 입력 >>");
			boolean agec = mService.ageUpdate(id, age);
			if (agec)
				System.out.println("변경 완료");
			break;

		case 4: // 전체
			pw = ScanUtil.nextLine("수정할 비밀번호 입력 >>");
			name = ScanUtil.nextLine("수정할 이름 입력 >>");
			age = ScanUtil.nextInt("수정할 나이 입력 >>");
			List<Object> param = new ArrayList<Object>();
			param.add(pw);
			param.add(name);
			param.add(age);
			param.add(id);
			boolean allC = mService.allUpdate(param);
			break;
		default:
		}

		return View.MEMBER_MENU;
	}

	private View signUp() {

		System.out.println("회원가입 정보를 입력해주세요.");

		String id;
		while (true) {
			id = ScanUtil.nextLine("아이디 >>");
			boolean idPass = mService.idChk(id);
			if (idPass)
				break;
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 , 숫자만 입력");
		}

		String pw;
		while (true) {
			pw = ScanUtil.nextLine("비밀번호 >>");
			boolean passPass = mService.passChk(id);
			if (passPass)
				break;
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 , 숫자만 입력");
		}

		String name;
		while (true) {
			name = ScanUtil.nextLine("이름 >>");
			boolean namePass = mService.nameChk(name);
			if (namePass)
				break;
			System.out.println("2~4글자 입력");
		}

		int age = ScanUtil.nextInt("나이 >>");
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);
		param.add(name);
		param.add(age);

		mService.signUp(param);
		return View.MEMBER_HOME;
	}

	private View memberMenu() {
		printMemberHome();
		int select = ScanUtil.nextInt("메뉴 선택 >> ");

		switch (select) {
		case 1:
			return View.MEMBER_UPDATE;
		case 2:
			return View.MEMBER_DELETE;
		}
		return View.MEMBER_MENU;
	}

	private View memberHome() {
		printMemberMenu();
		int select = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (select) {
		case 1: {
			String id = ScanUtil.nextLine("id: ");
			String pw = ScanUtil.nextLine("pw: ");
			boolean chk = mService.memLogin(id, pw);
			if (chk) {
				sessionStorage.put("id", id);
				sessionStorage.put("pw", pw);
				return View.MEMBER_MENU;
			} else {
				loginFail();
				return View.MEMBER_HOME;
			}
		}

		case 2:
			return View.SIGNUP;
		case 3:
			return View.EDIT;
		case 4:
			return View.DELETE;
		default:
			return View.MEMBER_HOME;
		}

	}

	private View adminMenu() {

		printAdminMenu();

		int select = ScanUtil.nextInt("선택: ");

		switch (select) {
		case 1:
			List<Mem> list = adService.printMemberList();
			printMemberList(list);
			break;
		default:
			break;
		}
		return View.ADMIN_MENU;
	}

	private View adminHome() {
		View pageNo;

		String id = ScanUtil.nextLine("id: ");
		String pw = ScanUtil.nextLine("pw: ");
		boolean chk = adService.adminLogin(id, pw);
		if (chk)
			pageNo = View.ADMIN_MENU;
		else {
			loginFail();
			pageNo = View.ADMIN_HOME;
		}
		return pageNo;

	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.ADMIN_HOME;
		case 2:
			return View.MEMBER_HOME;
		default:
			return View.HOME;
		}
	}
}
