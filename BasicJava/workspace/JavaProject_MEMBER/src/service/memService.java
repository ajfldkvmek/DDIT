package service;

import java.util.List;

import controller.Controller;
import dao.memDAO;
import vo.Admin;
import vo.Mem;

public class memService {
	private static memService singleTon = null;

	private memService() {
	};

	public static memService getInstance() {
		if (singleTon == null) {
			singleTon = new memService();
		}
		return singleTon;
	}
	
	public static int loginCount = 0;
	
	memDAO mDAO = memDAO.getInstance();	
	

	public boolean memLogin(String id, String pw) {
		Mem result = mDAO.memberLogin(id, pw);
		if (result != null && result.getId().equals(id)) {
			loginCount++;
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		}
		else return false;
		
	}
	
	public boolean delete(List<Object> param) {
		int result = mDAO.delete(param);
		if(result == 1) return true;
		else return false;
	}

	public boolean allUpdate(List<Object> param) {
		int result = mDAO.allUpdate(param);		
		if(result == 1) return true;
		else return false;
	}

	public boolean ageUpdate(String id, int age) {
		int result = mDAO.ageUpdate(id, age);	
		if(result == 1) return true;
		else return false;
	}
	
	public boolean nameUpdate(String id, String name) {
		int result = mDAO.nameUpdate(id, name);	
		if(result == 1) return true;
		else return false;
	}
	
	public boolean pwUpdate(String id, String pw) {
		int result = mDAO.pwUpdate(id, pw);	
		if(result == 1) return true;
		else return false;
	}

	public boolean signUp(List<Object> param) {
		int result = mDAO.signUp(param);		
		if(result == 1) return true;
		else return false;
	}

	public boolean idPassChk(String string) {
		boolean pass = true;
		for(char ch : string.toCharArray()) {
			// 숫자 체크
			if('0'<= ch && ch <='9' ) {
			}
			else if('a'<= ch && ch<='z') {
			}else if('A'<= ch && ch<='Z'){
			}else {
				return false;
			}
		}
		if(string.length()>10) return false;
		return true;
	}
	
	public boolean idChk(String id) {
		return idPassChk(id);
	}
	
	public boolean passChk(String pass) {
		return idPassChk(pass);
	}

	public boolean nameChk(String name) {
		if(2<=name.length() && name.length() <=4) return true;
		return false;
	}
}
