package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import kr.or.ddit.vo.MemberAuth;



public class MemberVO {

	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date regDate;
	private Date updDate;
	
	private List<MemberAuth> authList;
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public List<MemberAuth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<MemberAuth> authList) {
		this.authList = authList;
	}

	
}
