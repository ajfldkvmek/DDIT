//MemberService
package service;

import java.util.List;

import dao.BoardDAO;
import dao.MemberDAO;
import vo.Board;

public class MemberService {
	// 싱글톤 패턴을 만든다.
	private static MemberService instance = null;
	private MemberService() {}
	
	public static MemberService getInstance() {
		if(instance == null) 
			instance = new MemberService();
		return instance;
	}
	
	// Dao를 부른다
	BoardDAO boarddao = BoardDAO.getInstance();
	MemberDAO memberdao = MemberDAO.getInstance();
	


	public boolean loginMember(List<Object> param) {
		int result = memberdao.loginMember(param);
		if(result == 0) return false;
		else return true;
	}
	
}
