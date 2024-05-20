package controller;

import java.util.HashMap;
import java.util.Map;

import print.Print;
import service.LoginService;
import util.ScanUtil;
import util.View;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	LoginService loginService = LoginService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("login", false); // false: 로그인 안됨
		sessionStorage.put("loginInfo", null);
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case MEMBER_LOGIN:
				view = login();
				break;
			case MAIN:
				view = main();
				break;
			}
		}
	}

	private View main() {
		Map<String, Object> loginInfo = (Map<String, Object>) sessionStorage.get("loginInfo");
		System.out.println(loginInfo.get("NAME") + "님! 로그인 되었습니다");
		return null;
	}

	private View login() {
		View pageNo;
		String id   = ScanUtil.nextLine("아이디 입력>>> ");
		String pass = ScanUtil.nextLine("비밀번호 입력>>> ");

		boolean loginChk = loginService.login(id, pass);
		if (loginChk) {
			pageNo = View.MAIN;
		} else {
			System.out.println("다시 로그인해주세요!");
			pageNo = View.HOME;
		}
		return pageNo;
	}

	private View home() {
		printHome();
		switch (ScanUtil.nextInt("번호 입력 >> ")) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.MEMBER_SIGNUP;
		default:
			return View.HOME;
		}
	}

}
