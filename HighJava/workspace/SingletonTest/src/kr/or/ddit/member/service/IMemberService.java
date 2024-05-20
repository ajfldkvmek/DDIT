package kr.or.ddit.member.service;

import java.util.List;
import kr.or.ddit.member.VO.MemberVO;

/**
 * 
 * @author PC-06
 *	회원정보 서비스를 위한 인터페이스
 */
public interface IMemberService {
	
	//등록
	public int registMember(MemberVO mv);
	//수정
	public int modifyMember(MemberVO mv);
	
	//회원 있으면 true, 없으면 false
	public boolean checkMember(String memId);
	
	//회원정보삭제할 메서드
	public int removeMember(String memId);
	
	//모든 회원정보 조회를 위한 메서드
	public List<MemberVO> dispalyAllMember();
	
	//회원정보검색
	public List<MemberVO> searchMember(MemberVO mv);
}



