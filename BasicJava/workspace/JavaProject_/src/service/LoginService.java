package service;

import java.util.List;

import controller.Controller;
import dao.LoginDAO;
import vo.Member;

public class LoginService {
	// 싱글톤 패턴을 만든다.
	private static LoginService instance = null;
	private LoginService() {}
	public static LoginService getInstance() {
		if(instance == null) 
			instance = new LoginService();
		return instance;
	}
	
	public static int loginCount = 0;
	
	// Dao를 부른다
	LoginDAO dao = LoginDAO.getInstance();
	
	public boolean login(String id, String pass){
		Member result = dao.login(id,pass);
		
		if(result != null&& result.getId().equals(id)){
			loginCount++;
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean signUp(List<Object> param)  {
		int result = dao.signUp(param);
		if(result ==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 *  영문이랑 , 숫자만 입력 가능 하도록.
	 *  id 10자 이내 입력  하도록 체크할것 .
	 */
	public boolean idPassChk(String id) {
		boolean pass = true;
		for(char ch : id.toCharArray()) {
			// 숫자 체크
			if('0'<= ch && ch <='9' ) {
				
			}
			else if('a'<= ch && ch<='z') {
				
			}else {
				return false;
			}
		}
		if(id.length() > 10) return false;
		return true;
	}
	
	public boolean idChk(String id) {
		return idPassChk(id);
	}
	
	public boolean passChk(String pw) {
		return idPassChk(pw);
	}
	
	public boolean nameChk(String name) {		
		if(2 <= name.length() && name.length() <=4) return true;
		return idPassChk(name);
	}
	
}
