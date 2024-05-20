package kr.or.ddit.mapper;

import kr.or.ddit.vo.NoticeMemberVO;

public interface ILoginMapper {

	public NoticeMemberVO idCheck(String memId);

	public int signup(NoticeMemberVO memberVO);

	public void signupAuth(int memNo);

	public NoticeMemberVO loginCheck(NoticeMemberVO memberVO);

	public String findId(NoticeMemberVO memberVO);

	public String findPw(NoticeMemberVO memberVO);

	public NoticeMemberVO readByUserId(String username);

	
}
