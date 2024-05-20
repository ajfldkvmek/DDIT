
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import print.Print;
import service.ProdServie;
import util.ScanUtil;
import util.View;
import vo.Cart;
import vo.Product;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	ProdServie prodServie = ProdServie.getInstance();

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
			case PROD_ADD:
				view = prodAdd();
			case PROD_EDIT:
				view = prodEdit();
				break;
			case PROD_SELECT:
				view = selectEdit();
				break;
			case PROD_DELETE:
				view = Delete();
				break;
			// MEMBER, BUY_LIST, CART,
			case MEMBER:
				view = member();
				break;
			case MEMBER_MENU:
				view = memberMenu();
				break;
			case BUY:
				view = buy();
				break;
			case BUY_LIST:
				view = buyList();
				break;
			case CART:
				view = cart();
				break;
			case BUY_CART:
				view = buyCart();
				break;
			}
		}
	}

	private View buyCart() {
		String select = ScanUtil.nextLine("구매하실 번호를 입력 >> ");
		List<Object> param = new ArrayList<Object>();
		param.add(select);
		boolean chk = prodServie.buyCart(param);
		if(chk) System.out.println("구매 완료");
		else System.out.println("구매실패");
		return View.MEMBER_MENU;
	}

	private View cart() {
		String id = (String) sessionStorage.get("id");
		System.out.println(id);
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Cart> list = prodServie.cartList(param);
		printBuyList(list);
		int select = ScanUtil.nextInt("장바구니의 상품 구매 허쉴? 1.ㅇㅇ 2.ㄴㄴ\n");
		if(select == 1) return View.BUY_CART;
		else return View.MEMBER_MENU;
	}

	private View buyList() {
		String id = (String) sessionStorage.get("id");
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		List<Cart> list = prodServie.printBuyList(param);
		printBuyList(list);
		return View.CART;
	}

	private View buy() {
		List<Product> list = prodServie.printProdList();
		printProdList(list);

		String no = ScanUtil.nextLine("뭐살래? ");
		int count = ScanUtil.nextInt("몇 개? ");
		String id = (String) sessionStorage.get("id");

		List<Object> param = new ArrayList<Object>();
		param.add(no);
		param.add(count);
		param.add(id);

		boolean chk = prodServie.buy(param);
		if (chk) {
			System.out.println("장바구니에 등록되었습니다");
			int mov = ScanUtil.nextInt("이동허쉴? 1.ㅇㅇ 2.ㄴㄴ");
			if (mov == 1)
				return View.CART;
			else
				return View.BUY;
		} else {
			System.out.println("잘못 누름 메인페이지로 돌아갑니다");
			return View.MEMBER;
		}
	}

	private View member() {
		System.out.println("로그인부터 하자");
		String id = ScanUtil.nextLine("id>> ");
		String pw = ScanUtil.nextLine("비번>> ");
		sessionStorage.put("id", id);
		sessionStorage.put("pw", pw);

		return View.MEMBER_MENU;
	}

	private View memberMenu() {
		printMemberMenu();
		
		int select = ScanUtil.nextInt("어디로갈까>> ");
		switch (select) {
		case 1:
			return View.BUY;
		case 2:
			return View.BUY_LIST;
		case 3:
			return View.CART;
		default:
			return View.MEMBER_MENU;
		}
	}

	private View Delete() {
		List<Product> list = prodServie.printProdList();
		printProdList(list);
		String select = ScanUtil.nextLine("삭제 상품 번호 입력>> ");
		List<Object> param = new ArrayList();
		param.add(select);
		boolean del = prodServie.delete(param);
		if (del) {
			System.out.println("삭제 완료");
			return View.ADMIN;
		}
		return View.PROD_DELETE;
	}

	private View selectEdit() {
		String name, text;
		int price, count;
		String no = (String) sessionStorage.get("no");
		List<Object> param = new ArrayList<Object>();
		printSelectMenu();
		int select = ScanUtil.nextInt("선택하시오 >> ");
		switch (select) {
		case 1:// 이름
			name = ScanUtil.nextLine("이름 입력>> ");
			param.add(name);
			param.add(no);
			if (prodServie.nameEdit(param)) {
				System.out.println("변경 완료");
				return View.ADMIN;
			} else {
				System.out.println("잘못누른듯 ㅇㅇ");
				return View.PROD_SELECT;
			}

		case 2:// 가격
			price = ScanUtil.nextInt("가격 수정>> ");
			param.add(price);
			param.add(no);
			if (prodServie.priceEdit(param)) {
				System.out.println("변경 완료");
				return View.ADMIN;
			} else {
				System.out.println("잘못누른듯 ㅇㅇ");
				return View.PROD_SELECT;
			}

		case 3:// 수량
			count = ScanUtil.nextInt("재고 수정>> ");
			param.add(count);
			param.add(no);
			if (prodServie.countEdit(param)) {
				System.out.println("변경 완료");
				return View.ADMIN;
			} else {
				System.out.println("잘못누른듯 ㅇㅇ");
				return View.PROD_SELECT;
			}

		case 4:// 설명
			text = ScanUtil.nextLine("설명 입력>> ");
			param.add(text);
			param.add(no);
			if (prodServie.textEdit(param)) {
				System.out.println("변경 완료");
				return View.ADMIN;
			} else {
				System.out.println("잘못누른듯 ㅇㅇ");
				return View.PROD_SELECT;
			}

		case 5:// 전체
			name = ScanUtil.nextLine("이름 입력>> ");
			price = ScanUtil.nextInt("가격 수정>> ");
			count = ScanUtil.nextInt("재고 수정>> ");
			text = ScanUtil.nextLine("설명 입력>> ");
			param.add(name);
			param.add(price);
			param.add(count);
			param.add(text);
			param.add(no);
			if (prodServie.allEdit(param)) {
				System.out.println("변경 완료");
				return View.ADMIN;
			} else {
				System.out.println("잘못누른듯 ㅇㅇ");
				return View.PROD_SELECT;
			}

		default:
			System.out.println("다시입력하세요");
			return View.PROD_SELECT;
		}
	}

	private View prodEdit() {
		List<Product> list = prodServie.printProdList();
		printProdList(list);
		String select = ScanUtil.nextLine("변경할 상품 번호 입력>> ");
		sessionStorage.put("no", select);
		return View.PROD_SELECT;
	}

	private View prodAdd() {
		String no = ScanUtil.nextLine("상품 번호>> ");
		String name = ScanUtil.nextLine("상품 이름>> ");
		int price = ScanUtil.nextInt("상품 가격>> ");
		String text = ScanUtil.nextLine("상품 설명>> ");
		int count = ScanUtil.nextInt("상품 수량>> ");

		List<Object> param = new ArrayList<Object>();
		param.add(no);
		param.add(name);
		param.add(price);
		param.add(text);
		param.add(count);

		boolean chk = prodServie.prodAdd(param);

		if (chk)
			System.out.println("등록완료");
		else
			System.out.println("잘못입력함");
		return View.ADMIN;
	}

	private View adminMenu() {
		printAdminMenu();
		int select = ScanUtil.nextInt("어디로 가야하오");
		// 1.등록 2.수정 3.삭제

		switch (select) {
		case 1:
			return View.PROD_ADD;
		case 2:
			return View.PROD_EDIT;
		case 3:
			return View.PROD_DELETE;
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

//private View bookDelete() {
//List<Product> list = prodServie.printBookList();
//printBookList(list);
//prindDelete();
//
//int select = ScanUtil.nextInt("어디로 가야하오");
//switch (select) {
//case 1:
//	int delNo = ScanUtil.nextInt("삭제할 번호를 선택하세요: ");
//	prodServie.bookDel(delNo);
//	return View.BOOK_DELETE;
//case 2:
//	int pageNo = (int) sessionStorage.get("no") + 1;
//	sessionStorage.put("no", pageNo);
//	return View.BOOK_DELETE;
//case 3:
//	pageNo = (int) sessionStorage.get("no") - 1;
//	sessionStorage.put("no", pageNo);
//	return View.BOOK_DELETE;
//case 4:
//	return View.HOME;
//default:
//	return View.BOOK_DELETE;
//}
//}
//
//private View bookDetail() {
//int bookNo = (int) sessionStorage.get("no");
//Product product = prodServie.bookDetail(bookNo);
//printDetail(product);
//int select = ScanUtil.nextInt("어디로 가야하오");
//switch (select) {
//case 1:
//	return View.BOOK_LIST;
//default:
//	return View.BOOK_DETAIL;
//}
//}
//
//private View bookList() {
//List<Product> list = prodServie.printBookList();
//printBookList(list);
//int select = ScanUtil.nextInt("어디가니?");
//printListMenu();
//switch (select) {
//case 1:
//	int bookNo = ScanUtil.nextInt("책번호 입력: ");
//	sessionStorage.put("no", bookNo);
//	return View.BOOK_DETAIL;
//
//default:
//	return View.HOME;
//}
//}

//private View memberMenu() {
//	printMember();
//	int select = ScanUtil.nextInt("어디로 가야하오");
//	switch (select) {
//	case 1:
//		return View.BUY_LIST;
//
//	default:
//		return View.MEMBER;
//	}
//
//}