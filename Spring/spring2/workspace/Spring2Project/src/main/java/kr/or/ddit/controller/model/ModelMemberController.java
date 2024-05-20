package kr.or.ddit.controller.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ModelMemberController {

	/*
	 *  6장. 데이터 전달자 모델
	 *  
	 *  	- Model 객체 이용
	 *  
	 *  
	 *   1) 매개변수에 선언된 Mode객체의 addAttribute() 메서드를 호출하여 데이터를 뷰(view)에 전달한다.
	 *   
	 */
	
	@RequestMapping(value="/read01", method=RequestMethod.GET)
	public String read01(Model model) {
		log.info("read01()실행... ");
		
		model.addAttribute("userId", "hongkd");
		model.addAttribute("password", "password");
		model.addAttribute("email", "qwe@asd.zxc");
		model.addAttribute("userName", "홍길동");
		model.addAttribute("birthday", "1212-12-12");
		return "member/read01";
	}
	
	//2) Model 객체에 자바빈즈 클래스 객체를 값으롬나 전달할 때는 뷰에서 참조할 이름을 클래스 명의 앞글자를 소문자로 변환하여 처리
	@RequestMapping(value="/read02", method=RequestMethod.GET)
	public String read02(Model model) {
		log.info("read02()실행... ");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setUserName("홍길동");
		member.setEmail("qwe@asd.zxc");
		member.setBirthDay("1212-12-12");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member);
		return "member/read02";
	}
	
	@RequestMapping(value="/read03", method=RequestMethod.GET)
	public String read03(Model model) {
		
		Member member = new Member();
		log.info("read03()  실행...");
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("qwe@asd.zxc");
		member.setUserName("asdasd");
		member.setBirthDay("2345-12-12");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		
		member.setDateOfBirth(cal.getTime());
		model.addAttribute("user", member);
		
		return "member/read03";
		
	}
	
	
	// 4) Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다
	@RequestMapping(value="/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		log.info("read04()  실행...");
		
		String[] carArray = {"bmw", "audi", "jeep"};
		List<String> carList = new ArrayList<>();
		carList.add("bmw");
		carList.add("audi");
		carList.add("jeep");
		
		
		String[] hobbyArray = {"Muisc", "Movie"};
		List<String> hobbyList = new ArrayList<>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		
		return "member/read04";
	}
	
	
	@RequestMapping(value="/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		log.info("read06()  실행...");
		
		Member member = new Member();
		member.setUserId("길동아!!!!!!!!!!!!!!");
		member.setPassword("123123");
		member.setEmail("ㅂㅈㄷ@ㅁㄴㅇ.ㅋㅌㅊ");
		member.setUserName("이르르르ㅡ륾");
		member.setBirthDay("1234-12-21");
		member.setGender("남자");
		member.setDeveloper("Y");
		member.setForeigner(false);
		member.setNationality("NORTH KOREA");
		member.setCar("jeep");
		
		String[] carArray = {"bmw", "audi"};
		member.setCarArray(carArray);
		
		List<String> carList = new ArrayList<String>();
		carList.add("bmw");
		carList.add("audi");
		member.setCarList(carList);
		
		member.setHobby("Music, Movie");
		
		String[] hobbyArray = {"Music", "Movie"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobList = new ArrayList<String>();
		hobList.add("Music");
		hobList.add("Sprots");
		member.setHobbyList(hobList);
		
		Address address = new Address();
		address.setPostCode("123123");
		address.setLocation("dddddd");
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<>();
		Card c1 = new Card();
		Card c2 = new Card();

		
		Calendar cal =  Calendar.getInstance();
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		c1.setNo("12345");
		c1.setValidMonth(cal.getTime());
		
		
		
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 11);
		c2.setNo("99999");
		c2.setValidMonth(cal.getTime());
		
		cardList.add(c1);
		cardList.add(c2);

		member.setCardList(cardList);
		
		member.setDateOfBirth(cal.getTime());
		member.setIntroduction("ㅎㅇㅎㅇㅎㅎㅇㅎㅇㅇ");
		
		model.addAttribute("user", member);
		
		return "member/read06";
	}
	
	
	
	
}
