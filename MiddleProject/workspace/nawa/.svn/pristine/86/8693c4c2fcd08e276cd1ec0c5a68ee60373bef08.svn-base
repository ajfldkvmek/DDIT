package member.service;

import java.util.List;

import member.dao.IMemberDAO;
import member.dao.MemberDAOImpl;
import member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	
	private static IMemberService memService;
	
	private IMemberDAO memDAO;
	
	private MemberServiceImpl() {
		//memDao = MemberDaoImplForJDBC.getInstance();
		memDAO = MemberDAOImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		
		return memService;
		
	}
	
	
	@Override
	public List<MemberVO> displayAllMember() {
		List<MemberVO> list = memDAO.displayAllMember();
		return list;
	}

	@Override
	public List<MemberVO> searchMember(String str) {
//		System.out.println(str);
		return memDAO.searchMember(str);
	}

	@Override
	public MemberVO loginCheck(MemberVO mv) {
		
		return memDAO.loginCheck(mv);
		
	}

	@Override
	public int insertMember(MemberVO mv) {
		return memDAO.insertMember(mv);
	}
	
}
