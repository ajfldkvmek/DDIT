package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	//@NotBlank
	//입력값 검증 규칙 지정
	//문자열이 null이 아니고 trim길이가 0보다 크다는 것을 검사함
	@NotBlank(message="아이디는 필수값이다")
	private String userId = "a001";
	
	@NotBlank(message="이름은 필수값이다")
	@Size(max = 3, message="이름이 너무 길다")
	private String userName = "hongkd";
	
	@NotBlank(message="비빌번호는 필수값이다")
	private String password = "1234";
	
	private int coin = 100;
	
	//날짜 형식 검사, 과거인지 검사
	@Past(message="미래는 안된다")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	//이메일 주소 형식인지 검사
	@Email(message="메일이 이상하다")
	private String email;
	
	private String gender;

	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	
	private boolean foreigner;
	private String developer;
	private String nationality;
	
	//@Valid
	//중첩된 자바빈즈의 입력값 검증을 하겠다 
	//라는 뜻
	@Valid
	private Address address;
	@Valid
	private List<Card> cardList;
	
	private String car;
	private String[] carArray;
	private List<String>carList;
	
	private String introduction;
	private String birthDay;
	
	
}
