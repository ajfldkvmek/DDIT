package service;

import java.util.List;

import dao.AdminDAO;
import dao.BoardDAO;
import vo.Board;

public class AdminService {
	
	private static AdminService instance = null;
	private AdminService() {}
	
	public static AdminService getInstance() {
		if(instance == null) 
			instance = new AdminService();
		return instance;
	}

	AdminDAO admindao = AdminDAO.getInstance();
	public boolean loginAdmin(List<Object> param) {
		// TODO Auto-generated method stub
		int result = admindao.loginAdmin(param);
		if(result == 0) return false;
		else return true;		
	}
	
	
}

