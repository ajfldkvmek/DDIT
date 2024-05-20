package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	
	private String userId;
	private String password;
	private String userName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String date;
	
	private String gender;
	private String developer;
	private boolean foreigner;
	
	private String foreign;
	
	private String nationality;
	private String nation;
	
	private String[] cars;
	private String[] hobby;
	
	private Address address;
	
	private List<Card> cardList;
	
	private String introduction;
	
	private boolean ok;
	private String dong;
}
