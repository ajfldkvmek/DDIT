package service;

import java.util.List;


public class MemberService {
	private static MemberService singleTon = null;

	private MemberService() {
	};

	public static MemberService getInstance() {
		if (singleTon == null) {
			singleTon = new MemberService();
		}
		return singleTon;
	}
	
}