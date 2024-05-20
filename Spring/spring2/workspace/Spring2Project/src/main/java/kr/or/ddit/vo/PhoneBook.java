package kr.or.ddit.vo;

import lombok.Data;

@Data
public class PhoneBook {
	
    private String name;
	private String gender;
	private String phone1;
	private String phone2;
	private String phone3;
	private String job = "개발자";
	private String email = "*****@******.com";
	private String address = "대전 ***구 ***동";
	private String zipCode = "******";
	private String nickName = "John Doe";
	private String nation = "대한민국";
	private String hobby = "그런거 없다";
	
	
	public PhoneBook(String name, String gender, String phone1, String phone2, String phone3, String job) {
		this.name = name;
		this.gender = gender;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.job = job;
	}

	public PhoneBook() {

	}
	
}
