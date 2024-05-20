package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {

	private String userName ="asd";
	private String passWord ="123";
	
	private String userId ="hongkd";
	private int coin = 100;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBitrh;
	
	private Address address;
	
	private List<Card> cardList;
	
	
	
	
}
