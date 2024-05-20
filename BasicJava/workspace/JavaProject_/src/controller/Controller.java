package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			case MEMBER_SIGNUP:
				view = signUp();
				break;
			case MAIN:
				view = main();
				break;
			}
		}
	}

	private View signUp() {
		System.out.println("회원가입 정보를 입력해주세요.");
		/*
		 *  id 10자 이내 입력  하도록 체크할것 .
		 *  영문이랑 , 숫자만 입력 가능 하도록.
		 */
		String id;
		while(true) {
			id = ScanUtil.nextLine("아이디 >>");
			boolean idPass = loginService.idChk(id);
			if(idPass) break;
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 , 숫자만 입력");
		}
		/*
		 *  id 10자 이내 입력  하도록 체크할것 .
		 *  영문이랑 , 숫자만 입력 가능 하도록.
		 */
		String pass;
		while(true) {
			pass = ScanUtil.nextLine("비밀번호 >>");
			boolean pwPass = loginService.passChk(pass);
			if(pwPass) break;
			System.out.println("다시입력");
		}
		// 2~4글자 입력. 체크 
		String name;
		while(true) {
			name = ScanUtil.nextLine("이름 >>");
			boolean namePass = loginService.nameChk(name);
			if(namePass) break;
			System.out.println("2~4글자 입력");
		}
		// 11자 숫자 입력하도록 체크
		//010-1111-1111 받을 수 있게
		String phone ;
		while(true) {
			phone = ScanUtil.nextLine("번호 >>");
			phone = phone.replaceAll("-", "");
//			Long num = Long.parseLong(phone);
			try {
				if(phone.length()!= 11) {
					System.out.println("11자 숫자 입력");
					continue;
				}
				Long num = Long.parseLong(phone);
				
				break;
			} catch (Exception e) {
				
			}
			System.out.println("11자리 숫자만 입력하세요.");
		}
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(phone);
		
		boolean signPass = loginService.signUp(param);
		if(signPass) {
			System.out.println("회원가입이 성공 하였습니다.");
			return View.HOME;
		}else {
			System.out.println("회원가입이 실패 하였습니다. 다시 시도해주세요.");
			return View.MEMBER_SIGNUP;
		}
	}
	
	private View main() {
//		Member loginInfo = (Member) sessionStorage.get("loginInfo");
//		System.out.println(loginInfo.getName() + "님! 로그인 되었습니다");
		System.out.println("환영합니다.");
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
			pageNo = View.MEMBER_LOGIN;
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
