package kr.or.ddit.controller.jsp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JSPHomeController {
	
	/*
	 * 	 7장. JSP
	 * 
	 * 		1. 지시자
	 * 				
	 * 			- 지시자(deirective)는 JSP 페이지에 대한 설정 정보를 저장할 때 사용
	 * 			- JSP가 제공하는 지시자에는 page, taglib, include 가 있음
	 * 
	 * 		
	 * 			1) page 지시자
	 * 
	 * 				- JSP페에지에 대한 정보를 지정
	 * 				contentType		: JSP가 생성할 문서의 MIME타입과 문자 코드 지정
	 * 				pageEncoding	: JSP 페이지 자제의 문자코드 지정
	 * 				session			: JSP 페이지가 세션을 사용할 지 여부 결정
	 * 				import			: JSP 페이지에서 사용할 자바 클래스 지정
	 * 
	 * 
	 * 			2) tablib 지시자
	 * 
	 * 				- JSP 내애서 사용할 태그 라이브러리 지정
	 * 		
	 * 				prefix		  	: 태그라리브러리를 호출할 떄 사용할 접두어
	 * 				uri			  	: TLD파일이 위치한 URI혹은 파일 경로 지정
	 * 
	 * 
	 * 			3) include 지시자
	 * 
	 * 				- JSP 페이지의 특정 영역에 다른 문서 포함
	 * 				
	 * 				file 			: 포함할 파일 경로 지정
	 * 
	 * 
	 * 
	 * 		2. 스크립틀릿
	 * 
	 * 			- 스크립틀릿(scriptlet)은 JSP페이지에서 자바 코드를 실행할 때 사용되는 코드의 블록
	 * 			- 스크립틀릿 블록은 "<%"와 "%>"사이 or "<%=" 와 "%>"사이에 자바 코드를 포함할 수 잇따.
	 * 			- 현재는 스크립틀릿 보단 jstl과 같은 커스텀 태그 라이브러리와 el을 조합하는 방식이 더 많음
	 * 
	 * 
	 * 
	 * 		3. 커스텀 태그 라이브러리
	 * 
	 * 			- 스크림트 요소가 많아지면 많아질수록 jsp코드는 복잡해짐
	 * 			- 위 문제를 해결하는 방법중 하나가 커스텀 태그를 사용하는 것
	 * 			    커스텀 태그를 사용하면 뷰를 표시가기 위한 로직을 공통화 하거나, 
	 * 			    표현하기 복잡한 로직을 캡슐화 할 수 있어서 JSP의	구현 코드를 간결하게 할 수 있음
	 * 			    이 커스텀 태그를 모아둔 것을 태그라이브러리 라고 함
	 * 
	 * 
	 * 
	 * 		4. 표현 연어(EL)
	 * 
	 * 			- JSP는 EL(expression language) 이라는 표현 언어를 사용해 값의 참조, 출력, 연산을 할 수 있따.
	 * 			- EL식은 ${...} 또는 #{...} 형식으로 작성한다.
	 * 
	 * 
	 * 			# EL을 사용하여 객체를 조회하는 방법은 다음과 같다.
	 * 			- 자바빈즈 프로퍼티를 조회하는 경우 "속성명.프로퍼티명"을 지정
	 * 			- List나 배열 요소를 조회하는 경우 "속성명[요소위치]" 지정
	 * 			- Map 요소를 조회하는 경우 "속성명[키명]" 지정
	 * 			
	 * 			# 사용 가능한 연산자
	 * 			- EL에서 사용하는 연산자는
	 * 			
	 * 			 - 산술 연산자		:  +, -, *, /, %
	 * 
	 * 			 - 비교 연산자		: ==(eq), !=(ne), <=(le), >=(ge), <(lt), >(gt)
	 * 
	 * 			 - empty 연선자	
	 * 				>> null이거나 공백(문자열의 경우 공백분자)인지 비교 
	 * 				>> true 조건: null값, 빈 문자, 길이가 0인 배열, 빈 collection
	 * 
	 * 
	 * 			 - 논리 연산자		: &&, ||, !, 
	 * 				
	 */
	
	
	@RequestMapping(value="/home0104", method=RequestMethod.GET)	
	public String home0104(Model model) {
		log.info("home0104() 실행...");
		
		Map<String, String> memberMap = new HashMap<String, String>();
		memberMap.put("userId", "hongkildong");
		memberMap.put("password", "1234");
		memberMap.put("email", "qwe@asd.zxc");
		memberMap.put("userName", "길동이");
		
		//Map 안에 들어있는 데이터를 출력하기 위해서는 속성명.키 or 속성명[키]
		model.addAttribute("memberMap", memberMap);
		
		return "home/home0104";
	}
	
	//산술 연산자 
	
	@RequestMapping(value="/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		log.info("home0201() 실행...");
		int coin = 100;
		model.addAttribute("coin", coin);
		return "home/home0201";
	}
	
	
	//비교 연산자
	@RequestMapping(value="/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		
		int coin = 1000;
		String userId = "hongkd";
		
		model.addAttribute("coin", coin);
		model.addAttribute("userId", userId);
		
		return "home/home0202";
	}
	
	//empty 연산자
	@RequestMapping(value="/home0301" , method=RequestMethod.GET)
	public String home0301(Model model) {
		return "home/home0301";
	}
	
	//empty 연산자
		@RequestMapping(value="/home0302" , method=RequestMethod.GET)
		public String home0302(Model model) {
			
			Member member = new Member();
			model.addAttribute("member", member);
			return "home/home0301";
	}
		
	//논리 연산자
	@RequestMapping(value="home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		
		int coin = 1000;
		String userId = "hongkd";
		
		Member member = new Member();
		model.addAttribute("coin", coin);
		model.addAttribute("member", member);
		model.addAttribute("userId", userId);
		
		return "home/home0401";
	}
}
