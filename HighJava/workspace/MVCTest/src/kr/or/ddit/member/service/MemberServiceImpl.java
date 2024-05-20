package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.DAO.IMemberDAO;
import kr.or.ddit.member.DAO.MemberDAOImpleForJDBC;
import kr.or.ddit.member.VO.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDAO memDAO;	
	
	public MemberServiceImpl() {
		memDAO = new MemberDAOImpleForJDBC();
	}
	@Override
	public int registMember(MemberVO mv) {
		int cnt = memDAO.insertMember(mv);
		return cnt;
	}

	@Override
	public int modifyMember(MemberVO mv) {
		int cnt = memDAO.updateMember(mv);
		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {
		boolean isExist = memDAO.checkMember(memId);
		return isExist;
	}

	@Override
	public int removeMember(String memId) {
		int cnt = memDAO.deleteMember(memId);
		return cnt;
	}

	@Override
	public List<MemberVO> dispalyAllMember() {
		List<MemberVO> list = memDAO.selectAll();
		return list;
	}
	
	@Override
	public List<MemberVO> searchMember(MemberVO mv) {
		List<MemberVO> list = memDAO.searchMember(mv);
		return list;
	}

}
