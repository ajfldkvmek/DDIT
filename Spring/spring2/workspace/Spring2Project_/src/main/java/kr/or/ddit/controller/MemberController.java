package kr.or.ddit.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import kr.or.ddit.vo.User;
import lombok.extern.slf4j.Slf4j;

/*
 	5장 컨트롤러 요청 처리
 	
 		1. 컨트롤러 메소드 매개변수
 			Model
 			- 이동 대상에 전달할 데이터를 가지고 있는 인터페이스 
 			
 			RedirectAttribute
 			- 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
 			
 			MultupartFile
 			- 멀티파트 요청을 사용해 업로드 된 파일 정보를 가지고 있느 인터페이스
 			
 			BindingResult
 			- 도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
 			
 			java.secutiry.Principal
 			- 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
 			
 		2. 
 */
/**
 * @author PC-06
 *
 */
@Controller
@Slf4j
public class MemberController {

	//URL 경로상의 쿼리 파라메터 정보로부터 요청 데이타를 취득
	@RequestMapping(value="/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm() 실행... ");
		return "member/registerForm";
	}
	
	//URL 경로상의 경로변수로 부터 요청 데이타를 취득
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		log.info("registerByParameter() 실행... ");
		log.info("userId: " + userId);
		log.info("password: " + password);
		return "success";
	}
	
	//@PathVariable 을 써줘야 경로에 있는 변수를 사용가능
	@RequestMapping(value="/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		log.info("registerByPath() 실행... ");
		log.info("userId: " + userId);
		return "success";
	}
	
	//HTML Form 필드명과 컨트롤러 매개변수 명이 일치하면 요청데이터를 취득
	//순서 상관 없이 name값만 일치시켜주면 원하는 데이터 가져올 수 있어
	@RequestMapping(value="/register01", method = RequestMethod.POST)
	public String register01(String password, String userId) {
		log.info("register01() 실행... ");
		log.info("userId: " + userId);
		log.info("password: " + password);
		
		return "success";
	}
	
	//HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 데이터를 취득
	// 넘겨받은 파라메터를 컨트롤러 메소드 내에서 사용하고 싶은 타입으로 사용할수 있다
	@RequestMapping(value="/register02", method = RequestMethod.POST)
	public String register02(String password, String userId, int coin) {
		log.info("register02() 실행... ");
		log.info("userId: " + userId);
		log.info("password: " + password);
		log.info("coin: " + coin);
		return "success";
	}
	
	/*
	 *  3. 요청 데이터 처리 어노테이션
	 *  
	 *  	@PathVariables
	 *  	- url 에서 경로 변수 값을 가져오기 위한 어노테이션
	 *  
	 *  	@RequestParam
	 *  	- 요청 파라메터 값을 가져오기 위한 어노테이션
	 *  
	 *  	@RequestHeader
	 *  	- 요청 헤더값을 가져오기 위하 어노테이션
	 *  
	 *  	@RequestBody
	 *  	- 요청 본문 가져오기 위한 어노테이션
	 *  
	 *  	@cookieValue
	 *  	- 쿠키값 가져오기 위한 어노테이션
	 */
	
	//URL 경로상의 경로변수로 부터 요청 데이타를 취득
	@RequestMapping(value="/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(
			@PathVariable String userId, @PathVariable int coin
			) {
		log.info("registerByPath() 실행... ");
		log.info("userId>>> " + userId);
		log.info("coin>>>" + coin);
		return "success";
	}
	
	//@RequestParam 어노테이션을 사용하여 특정한 html from의 필드명을 지정하여 요청
	/*
	 	클라이언트에서 선언된 필드명은 userId인데 서버 컨트롤러에서 메소드에서 받은 필드명이 username이면 파라메터 받을 수 없음
	 	데이터를 받는 필드명은 동일하게 userId로 하되 사용하는 변수명만 username으로 달리 설정 할 수 있음
	 	@RequestParam이 그 역할을 해줌
	 	
	 	Spring1 에서 페이징을 구현 할 때 page로 넘기는 방법을 이녀석을 채택하여 구현
	 */
	@RequestMapping(value="/register0202", method = RequestMethod.POST)
	public String register0202(
			@RequestParam("userId") String username, String password, int coin ) {
		
		log.info("register0202() 실행... ");
		log.info("username>>> " + username);
		log.info("password>>> " + password);
		log.info("coin>>>" + coin);
		return "success";
	}
	
	
	
	
	/*
	 *  4. 요청 처리 자바빈즈
	 * 
	 */
	
	// 1) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다
	@RequestMapping(value="/beans/register01", method = RequestMethod.POST)
	public String registerJavaBeans01(Member member) {
		
		log.info("registerJavaBeans01() 실행... ");
		log.info("member.getUserId()  " + member.getUserId());
		log.info("member.getPassWord()  " + member.getPassWord());
		log.info("member.getCoin()  " + member.getCoin());
		
		return "success";
	}
	
	//여러 개의 폼 텍스트 필드 요소값을 매개변수 수선에 상관없이 매개변수 명을 기준으로 처리한다
	@RequestMapping(value="/beans/register03", method = RequestMethod.POST)
	public String registerJavaBeans03(Member member, int coin) {
		
		log.info("registerJavaBeans03() 실행... ");
		log.info("member.getUserId()  " + member.getUserId());
		log.info("member.getPassWord()  " + member.getPassWord());
		log.info("member.getCoin()  " + member.getCoin());
		log.info("coin:  " + coin);
		
		return "success";
	}
	
	
	/* 
	 *  5. Date 타입 처리
	 *  - 스프링 MVC는 Date타입의 테이터를 처리하는 여러 방법 제공
	 *  - 따로 지정하지 않으면 변환에 적합한 날짜 문자열 형식이 어떤 것이 있는 지 알아보자
	 * 
	 */
	
	
	//1) 쿼리 파라메터(ex. dateOfbirth=12341234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date 타입으로 변환이 실패?
	@RequestMapping(value="/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth) {
		log.info("registerbyGet01() 실행... ");
		log.info("userId(): " + userId);
		log.info("dateOfBirth(): " + dateOfBirth);
		
		// 날짜 데이터 넘겨줄 때에는 '년/월/일"의 형태로 넘겨줘야 date타입을 받을 수 있음(나머진 ㄴㄴ)
		return "success";
	}
	
	@RequestMapping(value="/registerByGet02", method=RequestMethod.POST)
	public String registerByGet02(Member member) {
		
		log.info("registerByGet02() 실행 ...");
		log.info("userId:  " + member.getUserId());
		log.info("dateOfBirth:  " + member.getDateOfBitrh());
		
		return "success";
	}

	/*
	 *  6. @DateTimeFormat 어노테이션
	 *  
	 *  - @DateTimeFormat 어노테이션의 pattern속성값에 원하는 날짜 형식 지정 가능
	 * 
	 */
	
	
	
	
	/*
	 *  7. 폼 방식 요청 처리
	 */
	//1) 폼 텍스트 필드 요소 값을 기본데이터 타입인 문자열 타입 매개변수로 처리</p>
	@RequestMapping(value="/registerUserId", method = RequestMethod.POST)
	public String registerUserId(String userId) {
		log.info("registerUserId() 실행 ...");
		log.info("userId>>>"  +userId);
		return "success";
	}
	
	//2) 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리</p>
	@RequestMapping(value="/registerPassword", method = RequestMethod.POST)
	public String registerPassword(Member member) {
		log.info("registerPassword() 실행 ...");
		log.info("member.getPassword>>>"  +member.getPassWord());
		return "success";
	}
	
	//3) 폼 라디오 버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerRadio", method=RequestMethod.POST)
	public String registerRadio(String gender) {
		log.info("registerRadio() 실행... ");
		log.info("gender:  "  + gender);
		return "success";
	}
	
	//4) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerSelect01", method = RequestMethod.POST)
	public String registerSelect(String nationality) {
		log.info("registerSelect() 실행... ");
		log.info("nationality:  "  + nationality);
		return "success";
	}
	
	
	//5) 복수 선택 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerMultipleSelect01", method = RequestMethod.POST)
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01() 실행... ");
		log.info("cars:  "  + cars);
		return "success";
	}
	
	
	//6) 복수 선택 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 배열타입 매개변수로 처리
	@RequestMapping(value="/registerMultipleSelect02", method = RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02() 실행... ");
		log.info("carArray:  "  + carArray);
		
		if(carArray != null) {
			log.info("carArray.length : " + carArray.length);
			
			for(int i = 0; i < carArray.length; i++)
				log.info("carArray[" + i + "]: " + carArray[i]);
		} else {
			log.info("carArray is null");
		}
		return "success";
	}
	
	//7) 복수 선택 가능한 폼 셀렉트 박스 요소값을 리스트로 처리
	@RequestMapping(value="/registerMultipleSelect03", method = RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList) {
		log.info("registerMultipleSelect03() 실행... ");
		log.info("carArray:  "  + carList);
		
		//list 로는 selectbox 값을 가져 올 수 없다
		//배열을 이용하거나 객체를 이용하여 가져와야함
		if(carList != null) {
			log.info("carArray.length : " + carList.size());
			
			for(int i = 0; i < carList.size(); i++)
				log.info("carArray(" + i + "): " + carList.get(i));
		} else {
			log.info("carArray is null");
		}
		return "success";
	}
	
	
	
	//8) 폼 체크박스 요속밧을 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerCheckBox01", method=RequestMethod.POST)
	public String registerCheckBox01(String hobby) {
		log.info("registerCheckBox01() 실행... ");
		log.info("hobby>>>" + hobby);
		return "success";
	}
	
	
	//9) 폼 체크박스 요속박스를 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerCheckBox02", method=RequestMethod.POST)
	public String registerCheckBox02(String[] hobbyArray) {
		log.info("registerCheckBox02() 실행... ");
		log.info("hobbyArray>>>" + hobbyArray);
		
		if(hobbyArray != null) {
			log.info("carArray.length : " + hobbyArray.length);
			
			for(int i = 0; i < hobbyArray.length; i++)
				log.info("hobbyArray[" + i + "]: " + hobbyArray[i]);
		} else {
			log.info("hobbyArray is null");
		}
		return "success";
	}
	
	//10) 폼 체크박스 요속박스를  리스트 타입 매개변수로 처리
	@RequestMapping(value="/registerCheckBox03", method=RequestMethod.POST)
	public String registerCheckBox03(ArrayList<String> hobbyList) {
		
		//받는 타입을 list로 하게되면 no primary or default constructor found for interface
		//java.util.list] 에러 발생함
		//스프링에서는 list타입으로 데이터를 받는데 문제가 발생함(데이터 바인딩 불가)
		//대신 객체를 이용하여 데이터를 바인딩 하는 방법이 있음
		log.info("registerCheckBox03() 실행... ");
		log.info("hobbyList>>> " + hobbyList);
		
		if(hobbyList != null && hobbyList.size() > 0) {
			log.info("hobbyList.size()>>> "  + hobbyList.size());
			for(int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList.get(" + i + "):   " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList is null");
		}
		return "success";
	}

	
	
	//11) 폼 체크박스 요속밧을 기본 데이터 타입인 문자열 타입 매개변수로 처리
	@RequestMapping(value="/registerCheckBox04", method=RequestMethod.POST)
	public String registerCheckBox04(boolean foreigner) {
		log.info("registerCheckBox04() 실행... ");
		log.info("foreigner>>>" + foreigner);
		//개인정보 동의과같은 스위칭 기능을 만들 때 사용
		//체크된 값이 존재하면 value속성에 설정된 true가 넘어오고
		//체크된 값이 없으면 false가 넘어옴
		return "success";
	}	
	
	//12) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다</p>
	@RequestMapping(value="/registerUserAdress", method = RequestMethod.POST)
	public String registerUserAdress(Member member){
		
		log.info("registerUserAdress() 실행... ");
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address.getPostCode()	:	" + address.getPostCode());
			log.info("address.getLocation()	:	" + address.getLocation());
		} else {
			log.info("address is null");
		}
		return "success";
	}
	
	
	//13) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다
	@RequestMapping(value="/registerUserCardlist", method=RequestMethod.POST)
	public String registerUserCardlist(Member member) {
		log.info("registerUserCardlist() 실행... ");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null && cardList.size() > 0) {
			log.info("cardList.size()>> " + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo()>>> " + card.getNo());
				log.info("card.getVaildMonth()>>> " + card.getValidMonth());
			}
		} else {
			log.info("cardList is null");
		}
		return "success";
	}
	
	
	@RequestMapping(value="/registerAllForm", method = RequestMethod.GET)
	public String registerAllFrom() {
		return "member/registerAllForm";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registerUser(User user, Model model) {
		//넘겨받은 데이터를 log를 통해 문서에 작성되거 있는 대로 출력
		//데이터 전달자를 통해 넘겨받은 데이터를 result페이지로 전달
		//log를 통해 문제에 작성되어 있는 양식대로 화면을 출력
		//result 페이지에서는 jstl을 이용하여 el 표현문과 종합하여 출력
		
		User myUser = new User(); 
		Address address = user.getAddress();
		List<Card> list = user.getCardList();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM ");
		
		String[] hob = null;
		
		log.info("아이디: " + user.getUserId());
		myUser.setUserId(user.getUserId());
		
		log.info("비밀번호: " + user.getPassword());
		myUser.setPassword(user.getPassword());
		
		log.info("이름: " + user.getUserName());
		myUser.setUserName(user.getUserName());
		
		log.info("Email: " + user.getEmail());
		myUser.setEmail(user.getEmail());
		
		log.info("생년월일: " + user.getDateOfBirth());
		myUser.setDateOfBirth(user.getDateOfBirth());	
//		String s =  sdf.format(user.getDateOfBirth());
//		log.info("생년월일: " + s);
//		myUser.setDate(s);
		
		
		if(user.getGender().equals("male")) {
			myUser.setGender("남자");
			log.info("성별: " + "남자");
		} else if(user.getGender().equals("female")) {
			myUser.setGender("여자");
			log.info("성별: " + "여자");
		} else {
			myUser.setGender("뭐고");
			log.info("성별: " + "뭐고");
		}
		
		if(user.getDeveloper().equalsIgnoreCase("Y")) {
			log.info("개발자 여부: " + "개발자"); 
			myUser.setDeveloper("개발자");
		} else {
			log.info("개발자 여부: " + "일반"); 
			myUser.setDeveloper("일반");
		}
		
		if(user.isForeigner()) {
			log.info("외국인 여부: 외국인" ); 
			myUser.setForeign("외국인");
		} else {
			log.info("외국인 여부: 내국인" ); 
			myUser.setForeign("내국인");
		}
		
		//한국(KOREA) 독일(GERMANY) 호주(AUSTRAILIA) 캐나다(CANADA) 미국(USA)
		String nation = user.getNationality();
		if(nation.equalsIgnoreCase("korea")) {
			nation = "한국";
		} else if (nation.equalsIgnoreCase("GERMANY")) {
			nation = "독일";
		} else if (nation.equalsIgnoreCase("AUSTRAILIA")) {
			nation = "호주";
		} else if (nation.equalsIgnoreCase("CANADA")) {
			nation = "캐나다";
		} else {
			nation = "미국";
		}
		log.info("국적: " + nation); 
		myUser.setNation(nation);;
		
		if(user.getCars() != null && user.getCars().length > 0) {
			for(int i = 0; i < user.getCars().length; i++) {
				log.info("소유차량" + user.getCars()[i]);
			}
		} else {
			log.info("차가 없는디" );
		}
		myUser.setCars(user.getCars());
		
		
		if(user.getHobby() != null && user.getHobby().length > 0) {
			hob = new String[user.getHobby().length];
			for(int i = 0; i < user.getHobby().length; i++) {
				log.info("취미: " + user.getHobby()[i]);
				
				if(user.getHobby()[i].equalsIgnoreCase("sports")) {
					hob[i] = "운동";
				} else if(user.getHobby()[i].equalsIgnoreCase("music")) {
					hob[i] = "음악감상";
				} else if(user.getHobby()[i].equalsIgnoreCase("movie")) {
					hob[i] = "영화감상";
				} else if(user.getHobby()[i].equalsIgnoreCase("study")) {
					hob[i] = "공부";
				} else if(user.getHobby()[i].equalsIgnoreCase("book")) {
					hob[i] = "독서";
				} else {
					hob[i] = "개발";
				}
			}
		} else {
			log.info("취미가 없는디");
		}
		myUser.setHobby(hob);
		
		if(address != null) {
			log.info("우편번호: " + address.getPostCode());
			log.info("주소: " + address.getLocation());
		}
		myUser.setAddress(address);
		
		Card c = new Card();
		List<Card> cl = new ArrayList<Card>();
		if(list != null && list.size() != 0) {
			myUser.setCardList(list);
			for(int i = 0; i < list.size(); i++) {
				log.info("카드: " + list.get(i));
//				String no = list.get(i).getNo();
//				String date = sdf2.format( list.get(i).getDate());
//				c.setDate(date);
//				c.setNo(no);
//				cl.add(c);
			}
		}
		myUser.setCardList(list);
		
		log.info(user.getIntroduction());
		myUser.setIntroduction(user.getIntroduction());
		
		if(user.isOk()) {
			log.info("개인정보 동의 여부: 동의함");
			myUser.setDong("동의함");
		} else {
			log.info("개인정보 동의 여부: 동의안함");
			myUser.setDong("동의안함");
		}
		
		model.addAttribute("myUser", myUser);
		return "member/result";
	}
}

