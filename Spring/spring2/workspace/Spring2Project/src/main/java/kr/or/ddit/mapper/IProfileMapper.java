package kr.or.ddit.mapper;

import kr.or.ddit.vo.NoticeMemberVO;

public interface IProfileMapper {

	public NoticeMemberVO selectMember(String memId);

	public int profileUpdate(NoticeMemberVO memberVO);

}
