
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import print.Print;
import service.BookServie;
import util.ScanUtil;
import util.View;
import vo.Book;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	BookServie bookServie = BookServie.getInstance();

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
			case ADMIN:
				view = adminMenu();
				break;
			case MEMBER:
				view = memberMenu();
				break;
			case BOOK_LIST:
				view = bookList();
				break;
			case BOOK_DETAIL:
				view = bookDetail();
				break;
			case BOOK_DELETE:
				view = bookDelete();
				break;
			}
		}
	}

	private View bookDelete() {
		List<Book> list = bookServie.printBookList();
		printBookList(list);
		prindDelete();

		int select = ScanUtil.nextInt("어디로 가야하오");
		switch (select) {
		case 1:
			int delNo = ScanUtil.nextInt("삭제할 번호를 선택하세요: ");
			bookServie.bookDel(delNo);
			return View.BOOK_DELETE;
		case 2:
			int pageNo = (int) sessionStorage.get("no") + 1;
			sessionStorage.put("no", pageNo);
			return View.BOOK_DELETE;
		case 3:
			pageNo = (int) sessionStorage.get("no") - 1;
			sessionStorage.put("no", pageNo);
			return View.BOOK_DELETE;
		case 4:
			return View.HOME;
		default:
			return View.BOOK_DELETE;
		}
	}

	
	private View bookDetail() {
		int bookNo = (int) sessionStorage.get("no");
		Book book = bookServie.bookDetail(bookNo);
		printDetail(book);
		int select = ScanUtil.nextInt("어디로 가야하오");
		switch (select) {
		case 1:
			return View.BOOK_LIST;
		default:
			return View.BOOK_DETAIL;
		}
	}

	private View bookList() {
		List<Book> list = bookServie.printBookList();
		printBookList(list);
		int select = ScanUtil.nextInt("어디가니?");
		printListMenu();
		switch (select) {
		case 1:
			int bookNo = ScanUtil.nextInt("책번호 입력: ");
			sessionStorage.put("no", bookNo);
			return View.BOOK_DETAIL;

		default:
			return View.HOME;
		}
	}

	private View memberMenu() {
		printMember();
		int select = ScanUtil.nextInt("어디로 가야하오");
		switch (select) {
		case 1:
			return View.BOOK_LIST;

		default:
			return View.MEMBER;
		}

	}

	private View adminMenu() {
		printAdmin();
		int select = ScanUtil.nextInt("어디로 가야하오");
		switch (select) {
		case 1:
			return View.BOOK_ADD;
		case 2:
			return View.BOOK_UPDATE;
		case 3:
			return View.BOOK_DELETE;
		default:
			return View.HOME;
		}

	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.MEMBER;
		default:
			return View.HOME;
		}
	}
}
