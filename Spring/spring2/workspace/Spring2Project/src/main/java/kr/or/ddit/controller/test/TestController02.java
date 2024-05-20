package kr.or.ddit.controller.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.PhoneBook;
import kr.or.ddit.vo.PhoneBookResponse;

@Controller
@RequestMapping("/test")
public class TestController02 {

	static List<PhoneBook> phoneBookList = new ArrayList<>();
	static List<PhoneBook> markList = new ArrayList<>();
	static boolean flag = false;
	
	public void init() {
		
		PhoneBook phoneBook1 = new PhoneBook("조현준", "남자", "010", "1234", "2345", "개발자");
		PhoneBook phoneBook2 = new PhoneBook("이세계김현태", "여자", "010", "1234", "2345", "황제" );
		PhoneBook phoneBook3 = new PhoneBook("김현태", "남자", "010", "1234", "2345", "백수" );
		phoneBookList.add(phoneBook1);
		phoneBookList.add(phoneBook2);
		phoneBookList.add(phoneBook3);
		
		PhoneBook phoneBook4 = new PhoneBook("이명문", "남자", "010", "1234", "2345", "명문에몽");
		markList.add(phoneBook4);
		
	}
	
	@RequestMapping(value="/addressBook.do")
	public String addressBook(Model model) {
		
		if(phoneBookList.size() == 0 && markList.size() == 0) init();
		
		model.addAttribute("phoneBookList", phoneBookList);
		model.addAttribute("markList", markList);
		flag = !flag;
		return "script/addressBook";
	}
	
	@RequestMapping(value="/addAddress.do")
	public String addAddress(){
		
		return "script/addAddress";
	}
	
	
	@RequestMapping(value="/addAddressMember.do", method = RequestMethod.POST)
	public String addAddressMember(PhoneBook phoneBook, Model model) {
		
		if(phoneBookList.size() == 0 && markList.size() == 0) init();
		
		String name = phoneBook.getName();
		String gender = phoneBook.getGender().equalsIgnoreCase("male") ? "남자" : "여자";
		String phone1 = phoneBook.getPhone1();
		String phone2 = phoneBook.getPhone2();
		String phone3 = phoneBook.getPhone3();
		String job = phoneBook.getJob();
		
		PhoneBook pb = new PhoneBook( name, gender, phone1, phone2, phone3, job  );
		
		phoneBookList.add(pb);
		
		return "redirect:/test/addressBook.do";
	}
	
	
	
	@RequestMapping(value="/mark.do", method = RequestMethod.POST)
	public ResponseEntity<PhoneBookResponse> mark(@RequestBody Map<String, Integer> map) {
		
		System.out.println("여기 오냐");
		
		int phoneIndex = map.get("phoneIndex");
		
		PhoneBookResponse phoneBookResponse = new PhoneBookResponse();
		
		PhoneBook pb = new PhoneBook();
		pb = phoneBookList.get(phoneIndex);
		phoneBookList.remove(phoneIndex);
		markList.add(pb);
		
		phoneBookResponse.setNewPhoneBookList(phoneBookList);
		phoneBookResponse.setNewMarkList(markList);
		
		return new ResponseEntity<PhoneBookResponse>(phoneBookResponse, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public ResponseEntity<PhoneBookResponse> delte(@RequestBody Map<String, Integer> map) {
		
		System.out.println("여기 오냐");
		
		int phoneIndex = map.get("phoneIndex");
		PhoneBookResponse phoneBookResponse = new PhoneBookResponse();
		
		PhoneBook pb = new PhoneBook();
		pb = markList.get(phoneIndex);
		markList.remove(phoneIndex);
		phoneBookList.add(pb);
		
		phoneBookResponse.setNewPhoneBookList(phoneBookList);
		phoneBookResponse.setNewMarkList(markList);
		
		return new ResponseEntity<PhoneBookResponse>(phoneBookResponse, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String detail(@RequestParam int index, Model model) {
	
		System.out.println("여기오냐");
		System.out.println(index);
		PhoneBook pb = phoneBookList.get(index);
		
		model.addAttribute(pb);
		
		return "script/adressDetail";
	}
}
