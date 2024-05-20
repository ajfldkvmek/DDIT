package kr.or.ddit.member.DAO;

import java.util.List;
import kr.or.ddit.member.VO.MemberVO;

/*
 	실제DB와 연결해서 SQL문을 수행하여 
 	결과를 받아와 서비스에 전달하는 DAO의 Interface
 */
public interface IMemberDAO {
	
	/*
	 	MemberVO에 담긴 데이터를 insert하기 위한 메서드
	 	return: 성공1, 실패2
	 */
	public int insertMember(MemberVO mv);
	//수정
	public int updateMember(MemberVO mv);
	
	//회원 있으면 true, 없으면 false
	public boolean checkMember(String memId);
	
	//회원정보삭제할 메서드
	public int deleteMember(String memId);
	
	//모든 회원정보 조회를 위한 메서드
	public List<MemberVO> selectAll();
	
	public List<MemberVO> searchMember(MemberVO mv);
	
}



