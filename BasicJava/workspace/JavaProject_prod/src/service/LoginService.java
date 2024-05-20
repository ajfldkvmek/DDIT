package service;

import java.util.Map;

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
		
		if(result != null && result.getId().equals(id)){
			loginCount++;
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		}else{
			return false;
		}
	}
}
