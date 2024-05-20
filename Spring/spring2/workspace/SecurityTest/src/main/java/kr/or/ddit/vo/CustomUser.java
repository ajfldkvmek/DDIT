package kr.or.ddit.vo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	private MemberVO member;
	
	public CustomUser(String userName, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		
		super(userName, password, authorities); //부모 클래스에 파라매터 뻐꾸기
		
	}

	public CustomUser(MemberVO member) {
		
		// java 스트림을 사용한 경우(람다식 표현) 단점: 디버깅 어려움
		// 자바 버전 8부터 추가됨
		
		//map: 컬렉션(set,map,list 등) 배열 등에 설정되어 있는 각 타입의 값들을 하나씩 참조하여
		// 							람다식으로 반복처리할 수 있게 해줌
		// collect: stream을 돌려 발생되는 데이터를 가공 처리하고 원하는 형태의 자료형으로 변환을 돕는다.
		// 회원 정보안에 들어있는 역할명들을 걸렉션형태의 스트림으로 만들어서 보내준다.
		super(member.getUserId(), member.getUserPw(),
				member.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		this.member = member;
	}
	
	public MemberVO getMember() {
		return member;
	}
	
	public void setMember(MemberVO member) {
		this.member = member;
	}
	
}
