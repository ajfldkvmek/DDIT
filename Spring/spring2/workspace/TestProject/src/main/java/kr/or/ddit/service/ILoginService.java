package kr.or.ddit.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.MemberVO;

public interface ILoginService {

	public ServiceResult idCheck(String memId);

	public ServiceResult nickNameCheck(String nickname);

	public ServiceResult signup(MemberVO memberVO);

	public MemberVO loginCheck(MemberVO memberVO);

}
