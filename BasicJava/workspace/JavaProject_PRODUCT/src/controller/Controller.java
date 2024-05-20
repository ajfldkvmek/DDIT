
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.ProdService;
import util.ScanUtil;
import util.View;
import vo.Product;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	ProdService prodService = ProdService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home(); break;
			case ADMIN:
				view = adminMenu(); break;
			case MEMBER:
				view = memberMenu(); break;
			case ALL_LIST:
				view = allList(); break;
			case MANAGE:
				view = manage(); break;
			case REGIST:
				view = regist(); break;
			}
		}
	}

	private View memberMenu() {
		return null;
	}
	
	private View regist() {
		
		
		return null;
	}
	
	private View manage() {
		String name = ScanUtil.nextLine("상품명을 검색하세요");
		List<Object> param = new ArrayList<Object>();
		param.add(name);
//		prodService.prodSearchList(param);
		List<Product> list = prodService.prodSearchList(param);
		return View.ADMIN;
	}


	private View allList() {
		List<Object> param = new ArrayList<Object>();
		int pageNo =1;
		if(sessionStorage.containsKey("pageNo")) { //세션에서 pageno 받아오기
			pageNo = (int)sessionStorage.get("pageNo");
		} 
		
		int start_no = 1+10*(pageNo-1);
		int last_no = 10*pageNo;
		param.add(start_no);
		param.add(last_no);
		List<Product> list = prodService.prodList(param);
		printList(list);
		
		
		int select = ScanUtil.nextInt("홈으로 가려면 1번, 다음페이지는 2번 선택하세요.");
		switch(select) {
		case 1:
			return View.HOME;
		case 2:
			sessionStorage.put("pageNo", pageNo+1);
			return View.ALL_LIST;
		default:
			return View.ALL_LIST;
		}
	}


	private View adminMenu() {
		printAdmin();		
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.ALL_LIST;
		case 2:
			return View.MANAGE;
		case 3:
			return View.REGIST;
		default:
			return View.ADMIN;
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
		default :
			return View.HOME;
		}
	}
}
