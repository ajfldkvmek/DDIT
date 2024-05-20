package member.dao;

import java.util.List;

import member.vo.MemberVO;

public interface IMemberDAO {

	public List<MemberVO> displayAllMember();

	public List<MemberVO> searchMember(String str);

	public MemberVO loginCheck(MemberVO mv);

	public int insertMember(MemberVO mv);

	public int tempBlock(MemberVO mv);

	public int updateMember(MemberVO mv);
	
	
}
