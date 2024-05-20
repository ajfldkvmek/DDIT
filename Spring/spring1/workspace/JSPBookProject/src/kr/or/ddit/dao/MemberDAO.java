package kr.or.ddit.dao;

import java.util.ArrayList;

import kr.or.ddit.vo.MemberVO;

public class MemberDAO{
	
	// 회원 정보가 담길 List
	private ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	
	// 싱글톤
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// 회원 정보 목록 조회
	public ArrayList<MemberVO> getMemberList() {
		return memberList;
	}

	// 회원 정보 등록
	public void insertMember(MemberVO member) {
		memberList.add(member);
	}

}
