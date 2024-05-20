package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class PhoneBookResponse {

	List<PhoneBook> newPhoneBookList;
	List<PhoneBook> newMarkList;
}
