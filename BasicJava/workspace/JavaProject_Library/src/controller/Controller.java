package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import util.ScanUtil;
import util.View;
import vo.Member;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
		
	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			
			
			}
		}
	}
	
	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.BUS_RESERVE;
		case 2:
			return View.RESERVE_LIST;
		case 3:
			return View.RESERVE_CANCLE;
		default :
			return View.HOME;
		}
	}
}
