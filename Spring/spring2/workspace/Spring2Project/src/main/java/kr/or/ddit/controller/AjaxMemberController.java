package kr.or.ddit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ajax")
@Slf4j
public class AjaxMemberController {

	//ajax방식 요청 처리 페이지
	@RequestMapping(value="/registerForm", method = RequestMethod.GET)
	public String ajaxRegisterForm() {
		log.info("ajaxRegisgerForm() 실행...");
		return "member/ajaxRegisterForm";
	}
	
	//3) 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 자바빈즈 매개변수로 처리
	@RequestMapping(value="/register03", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister03(@RequestBody Member member){
		
		log.info("ajaxRegister03() 실행... ");
		log.info("member.getUSerId():" + member.getUserId());
		log.info("member.getPassword():" + member.getPassword());
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	//5) 요청 URL에 쿼리 파라메터를 붙여서 전달하면 문자열 매개변수로 처리한다 .
	// 이 경우 기본적으로 쿼리에 있는 데이터만 적용됨
	// @RequestBody 를 써 줘야 같이 가져옴
	// 이 떄 json데이터중 단일 파라메터만 받기 위해서 map과 key로 가져와야함
	// 비동기 방식이면서 단일 파라메터가 필요하면 웬만하면 map으로 꺼내자
	// 
	@RequestMapping(value="/register05", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister05(String userId, @RequestBody Map<String, String> map){
		
		//userId는 쿼리스트링에 담겨져 오는 데이터 이기 때문에 일반적인 방식으로도 데이터를 받을 수 있지만,
		//password는 요청 본문에서 데이터를 바인딩해 받아오지 못하므로 null이 출출력됨
		//비동기 통신이면서  요청본문에 설정되어 넘어오는 단일 파라메터같은 경우  @RequestBody 어노테이션을 설정하고
		//파라메터를 받기위한 테이터 타입 Map과같은 형태의 컬렉션으로 채택하여 사용
		//다만 좀 많이 받으면 VO로 받자
		log.info("ajaxRegister05() 실행... ");
		log.info("userId: " + userId);
		log.info("password: " + map.get("password"));
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	//7) 객체배열 타입의 JSON요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @RequestBody 지정하여 처리
	@RequestMapping(value="/register07", method=RequestMethod.POST)
	public ResponseEntity<String> regisger07(
			@RequestBody List<Member> memberList){
		
		//동기방식과 비동기방식의 처리함에 있어 List타입을 운용하는 것을 반드시 기억
		//비동기 처리시 List컬렉션으로 데이터를 받을 때 @RequestBody 라는 어노테이션을 이용하여 바인딩 할 수 있다.
		//동기 처리시에는 컨트롤러 메서드 내에서 List타입으로 값을 바인딩 할 수 없지만 객체내 존재하는 list타입으로는 바인딩 가능
		
		log.info("regisger07() 실행...");
		
		for(Member member: memberList) {
			log.info("member.getUserId()>>" + member.getUserId());
			log.info("member.getPassword()>>" + member.getPassword());
		}
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	
	//8) 중첩된 객체 타입의 JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리
	@RequestMapping(value="/register08", method=RequestMethod.POST)
	public ResponseEntity<String> register08(
			@RequestBody Member member){
		
		log.info("register08() 실행... ");
		log.info("member.getUserId()>> " + member.getUserId() );
		log.info("member.getPassword()>> " + member.getPassword() );
		
		Address address = member.getAddress();
		
		if(address != null) {
			log.info("address.getLocation()>> " + address.getLocation() );
			log.info("address.getPostCode()>> " + address.getPostCode() );
		} else {
			log.info("address is null");
		}
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	//9) 중첩된 객체 타입(컬렉션 List) JSON 요청 데이터를 @RequestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리
	@RequestMapping(value="/register09", method=RequestMethod.POST)
	public ResponseEntity<String> register09(
			@RequestBody Member member){
		
		log.info("register09() 실행... ");
		log.info("member.getUserId()>> " + member.getUserId());
		log.info("member.getPassword()>> " + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			log.info("cardList.size()>> " + cardList.size());
			
			for(Card card : cardList) {
				log.info("card.getNo() : " + card.getNo());
				log.info("card.getValidMonth() : " + card.getValidMonth());
			}
		} else {
			log.info("cardList in null");
		}
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
}
