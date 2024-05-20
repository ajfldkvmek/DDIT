package kr.or.ddit.controller.validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/validation")
@Slf4j
public class ValidationController {
	

	/*
	 * 	9. 입력 유효성 검증
	 * 
	 * 		1. 입력값 검증
	 * 
	 * 			- 스프링 MVC bean validation 기능을 이용해 요청 파라메터 값이 바인딩된 
	 * 				도메인 클래스(또는 커맨드 클래스)의 입력값을 검증한다.
	 * 
	 * 			[환경설정]
	 * 			# 의존과계 정의
	 * 			- 입력값 검증을 위한 의존 라이브러리를 추가한다
	 * 			- pom.xml에서 hibernate-validation 추가
	 * 
	 * 			# 입력값 검증 활성화
	 * 			- Member 클래스로 넘어가서 임시 테스트로 userId, userName에 규칙을 활성화한다
	 * 			- 이 떄 규칙을 활성화 하기 위해서 사용할 어노테이션이 있음
	 * 				> @validation를 지정
	 * 				> 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다
	 * 
	 * 			# 입력값 검증 환경설정 순서
	 * 			1. 입력값 검증을 위한 의존 라이브러리 추가
	 * 			2. 입력값 검증을 활성화
	 * 				> 활성화 할 도메인 클래스 안에 @validation 어노테이션 지정
	 * 			3. 도메인 클래스 내 필드에다가 검증을 위한 어노테이션 데이터 검증을 설정한다(@Notblank, @Size 등)
	 * 			4. 에러를 받을 BindingResult를 설정한다(컨트롤러 메소드 내에 설정)
	 * 			
	 * 
	 */
	
	
	@RequestMapping(value="/registerValidationForm01", method = RequestMethod.GET)
	public String registerValidationForm01(Model model) {
			model.addAttribute("member",new Member());
			return "validation/registerValidationForm01";
	}
	
	//입력값 검증을 위해선 @Validated 써줘야함
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String registerValidationFormReuslt(@Validated Member member, BindingResult result) {
		log.info("registerValidationFormReuslt() zzzzz");
		log.info("mebmer.getUserId():  " + member.getUserId());
		log.info("mebmer.getUserName():  " + member.getUserName());
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm01";
		}
		
		return "validation/success";
	}
	
	
	
	/*
	 * 	2. 입력값 검증 결과
	 * 	- 입력값 검증 대상의 도메인 클래스 직후에 BindingReuslt를 정의한다
	 * 		
	 * 		# BindingResult에는 요청 데이터의 바인딩에러와 입력ㄱ밧 검증 에러 정보가 저장된다
	 * 		1) 에러 정보 확인을 위한 BindingResult메서드
	 * 
	 * 		hasError()
	 * 		- 에러가 발생한 경우 true 반환
	 * 
	 * 		hasGlobalError()
	 * 		- 객체 레벨의 에러가 발생한 경우 true 반환
	 * 
	 * 		hasFiledError()
	 * 		- 필드 레벨의 에러가 발생한 경우 true 반환
	 * 
	 * 		hasFiledError(String)
	 * 		- 인수에 저장한 필드 레벨의 에러가 발생한 경우 true 반환
	 * 
	 */
	
	
	@RequestMapping(value="/registerValidation02", method = RequestMethod.GET)
	public String registerValidation02(Model model) {
		model.addAttribute("member", new Member());
		return "/validation/registerValidationForm02";
	}
	
	@RequestMapping(value="/result2", method = RequestMethod.POST)
	public String registerValidatonForm02Result(@Validated Member member, BindingResult result) {
		
		log.info("registerValidatonForm02Result() ㅎㅎㅎ");
		log.info("result.hasError(): " + result.hasErrors());
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> filedErrors = result.getFieldErrors();
			
			log.info("allErrors.size(): " + allErrors.size());
			log.info("globalErrors.size(): " + globalErrors.size());
			log.info("filedErrors.size(): " + filedErrors.size());
			
			for(int i = 0; i < allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				log.info("allErrors>> " + objectError + "\n");
			}
			
			for(int i = 0; i < globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				log.info("globalErrors>> " + objectError + "\n");
			}
			
			for(int i = 0; i < filedErrors.size(); i++) {
				FieldError filedError = filedErrors.get(i);
				log.info("filedError>> " + filedError + "\n");
				log.info("### filedError.getDefaultMessage()>>> "  +filedError.getDefaultMessage());
			}
			
			return "validation/registerValidationForm02";
		}
		
		log.info("userId : " + member.getUserId());
		log.info("userName : " + member.getUserName());
		log.info("email : " + member.getEmail());
		log.info("gender : " + member.getGender());
		return "validation/success";
	}
	
	/*
	 * 	3. 입력값 검증 규칙
	 * 
	 * 	- 입력값 검증 규칙은 Bean Validaiton이 제공하는 제약 어노테이션으로 설정한다
	 * 
	 *		검사 규칙은 크게 세가지로 구분
	 *			- Bean Validaiton 표준 제약 어노테이션
	 *			- 서드파티에서 구현한 제약 어노테이션
	 *			- 직접 구현한 제약 어노테이션
	 *
	 *		1) Member 클래스에서 테스트를 위한 어노테이션 설정
	 *
	 *		@NotNull				: 빈 값인지 아닌지 검사
	 *		@Null					: null인지 검사
	 *		@NotBlank				: 문자열이 null이 아니고 trim한 값이 0보다 큰지 검사
	 *		@NotEmpty				: 문자열이 null이거나 비어있는지 검사
	 *		@size					: 글자수나 컬렉션 요소 개수 검사 >> Size(min = ? , max = ?)
	 *		@Max(value=	)			: value보다 작거나 같은 걸 검사
	 *		@Min(value=	)			: value보다 크거나 같은 걸 검사
	 *		@Email					: 이메일 형식 검사
	 *		@Past					: 과거 날짜인지 검사
	 *		@Future					: 미래 날짜인지 검사
	 *		@Pattern(regexp=)		: CharSequence는 지정된 정규식과 일치해야하고, 정규식 java규칙을 따름
	 *		@Positive				: 양수여야함(0은 에러)
	 *		@PoritiveOrZero			: 양수 or 0
	 *		@Length(min=?, max=?)	: 문자열의 길이가 min max 사이
	 * 
	 * 		[시나리오 테스트]
	 * 		- Member 크래스의 검증 활성화 추가
	 * 		>> userId, password, userName email, dateOfBirth
	 */
	
	/*
	 * 	4. 중첩된 자바빈즈 입력값 검증
	 * 	- 중첩된 자바빈즈와 자바빈즈의 컬렉션에서 정의한 프로퍼티에 대해 입력값 검증을 할 때는 @Valid를 지정한다
	 * 
	 * 		1) 중첩된 자바빈즈 클래스를 정의하고 @Valid를 지정
	 * 		 - Member 클래스 내 Address address 필드에 @Valid 어노테이션을 지정
	 * 		 - Member 클래스 내 List<Card> cardList 필드에 @Valid 어노테이션을 지정
	 * 
	 * 		2) Address 클래스 내애도 validation 설정
	 * 		
	 * 		3) Card 클래스 내애도 validation 설정
	 * 
	 */
	
	
	@RequestMapping(value="/registerValidation03", method = RequestMethod.GET)
	public String registerValidationForm03(Model model) {
		log.info("registerValidationForm03() adasds");
		model.addAttribute("member", new Member());
		return "validation/registerValidationForm03";
	}
	
	
	@RequestMapping(value="/result3", method = RequestMethod.POST)
	public String registerValidationResult03(@Validated Member member, BindingResult result) {
		log.info("registerValidationResult03() adasds");
		
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm03";
		}
		
		log.info("userId: " + member.getUserId());
		log.info("dateOfBirth: " + member.getDateOfBirth());
		
		Address address = member.getAddress();
		if(address != null) {
			log.info("postCode: " + address.getPostCode());
			log.info("location: " + address.getLocation());
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("cardNo: " + card.getNo());
				log.info("ValidMonth: " + card.getValidMonth());
			}
		}
		
		return "validation/success";
	}
	
}
