package service;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import dao.adminDAO;
import dao.memDAO;
import vo.Admin;
import vo.Mem;

public class adminService {
	private static adminService singleTon = null;

	private adminService() {
	};

	public static adminService getInstance() {
		if (singleTon == null) {
			singleTon = new adminService();
		}
		return singleTon;
	}
	public static int loginCount = 0;
	
	adminDAO adDAO = adminDAO.getInstance();
	memDAO mDAO = memDAO.getInstance();

	public boolean adminLogin(String id, String pw) {
		Admin result = adDAO.adminLogin(id, pw);

		if (result != null && result.getId().equals(id)) {
			loginCount++;
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		}
		else return false;
	}

	public List<Mem> printMemberList() {
		List<Mem> mem = mDAO.memList();
		return mem;
	}
}
