package kr.or.ddit.study08;

import java.util.Scanner;

public class BoardTest implements IBoard{

	@Override
	public void writeBoard(String title, String contents, String id) {
		// TODO Auto-generated method stub
		//1. db에서 이름 가져오기
		//id 값이 null이면 로그인 시키기
		
//		Scanner sc = new Scanner(System.in);
//		
//		if(id == null) {
//			id = sc.next();
//			String pass = sc.next();
//		}
			
		boolean phoneChk = false;	
		ILogin login = new LoginTest();
		
		if(phoneChk) {
			login = new MobileLoginTest();			
		}
		else {
			login = new LoginTest();
		}

	}
	
}
