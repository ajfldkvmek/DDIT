package kr.or.ddit.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType;

import lombok.extern.slf4j.Slf4j;

//AOP 설정시 필수 어노테이션
//@Component
//@Aspect

@Slf4j
@Component
@Aspect
public class AOPController {

	/*
	 * 14장. AOP
	 * 
	 * AOP란?
	 * 
	 * 403호 현명이가 신읍이르 프로젝트를 진행하고 있습니다 그러던 어느 날, 팀장님을 통해 지금 개발중인 서비스 처리 속도좀 로그로 남겨주세요
	 * 라는 부탁을 받았습니다 현명이는 부탁받은 요구사항을 이행하기 위해 본인이 만들고 있는 서비스 로직에서 처리 속도를 찍어볼 메소드를 개발해
	 * 처리속도가 잘 나오는 걸 확인합니다 그리고 팀장님께 보고하고 컨펌받습니다
	 * 
	 * 긍정적인 검토안을 전달받은 현명이는 새로운 미션을 받습니다 2천만 건에 달하는 우리 서비스 전체에 처리 속도를 찍으라네요?
	 * 
	 * 30만개 정도 하다보니 현명이는 의문을 가집니다.
	 * 
	 * 이거 ㄹㅇ 계속해야함? 퇴사마렵네...
	 * 
	 * 여기서 시간을 측정하고 권한을 체크하는 것은 부가기능으로 일종의 인프라 로직이라 하는데, 이 인프라 로직은 애플리케이션 전 영역에 나타날
	 * 수도 있고, 중복코드를 만들어 효율성을 떨어트리고, 유지보수성도 저하시킴
	 * 
	 * 이런 인프라 로직은 하나의 관심사를 가질 수 있는데 이런 관심사들의 중복 횡단으로 나타나는데 이를 "횡단 관심사" 라고 함
	 * 
	 * 이걸 모아서 프로그래밍 하는 걸 AOP라고 한다
	 * 
	 * 
	 * 
	 * 
	 * Aspect : AOP의 단위가 되는 횡단 관심사 - 공통 기능 - 어드바이스 + 포인트컷을 모듈화한 애플리케이션의 횡단 기능
	 * 
	 * 
	 * 횡단 관심사: 애플리케이션 전체를 관통하는 부가 기능 로직(로깅, 보안, 트랜젝션 등) => 주기능x - 횡단 관심사분리: 해당 기능을
	 * 분리해서 한 곳으로 모아놓음
	 * 
	 * @Component >> @Aspect와 짝궁 component 스캔시 여기봐라 하는 의미
	 * 
	 * 
	 * Join Point : 애플리케이션 실행 흐름에서의 특정 포인트(어드바이스 적용 위치)
	 * 
	 * Advice : 어떤 부가기능을 언제 사용할 지
	 * 
	 * - Before : 조인포인트 실행 이전에 실행, 일반적으로 리턴타입 void
	 * 
	 * - After returning : 조인포인트 완료후 실행 (ex. 메서드가 예외없이 실행될 때)
	 * 
	 * - After Throwing : 메서드가 예외를 던지는 경우 실행
	 * 
	 * - After (finally) : 조인포인트의 동작과 관계없이 실행
	 * 
	 * - Around : 메서드 호출 전후에 수행 (조인포인트 실행 여부 선택, 반환 값 변환, 예외 변환, try~catch~finally
	 * 구문 처리 가능 등), 가장 강력한 어드바이스이다.
	 * 
	 * 
	 * -----------------------------------------------------------------------------
	 * ---------------------------
	 * 
	 * 
	 * # AOP(관점 지향 프로그래밍) - Aspect Oriented Programming
	 * 
	 * 1-1) 관점 지향 프로그래밍
	 * 
	 * 소스 여기저기에 흩어져 있는 횡단 관심사를 중심으로 설계와 구현을 하는 프로그래밍 기법 >> AOP는 횡단 관심사의 분리를 실현하는 방법
	 * 
	 * 횡단 관심사 핵심 비지니스와 거리가 있지만 여러 모듈에서 공통적이고 반복적으로 처리를 요구하는 내용
	 * 
	 * 횡단 관심사의 분리 애플리케이션 개발 시 횡단 관심사에 해당하는 부분을 분리하여 한 곳으로 모으는 것
	 * 
	 * 
	 * 1-2) AOP개발 순서 (1) 핵심 비지니스 로직에만 근거해서 코드 작성 (2) 주변로직에 해당하는 관심사들을 분리하여 작성 (3) 핵심
	 * 비지니스에 어떤 로직을 결합할 것인지 정하기
	 *
	 *
	 * 1-3) AOP사용 예 로깅, 보안관리, 트랜잭션, 예외처리
	 *
	 *
	 * 1-4) AOP관련 용어 - Aspect : AOP의 단위가 되는 횡단 관심사에 해당한다 - 조인포인트(JoinPoint) : 횡단
	 * 관심사가 실행될 지점이나 시점(메소드 실행이나 예외 발생 등)을 말한다 : 어디에 적용할 것인지 결정, 메소드/객체생성시/필드접근시 등등
	 * - 어드바이스(Advice) : 특정 조인 포인트에서 실행되는 코드로, 횡단 관심사를 실제로 구현해서 처리하는 부분이다. : 어떤
	 * 부가기능을 구현할 것인지 결정 -Before, After, AfterReturning, AfterThrowing, Around -
	 * 포인트컷(PointCut) : 수 많은 조인 포인트 중에서 실제로 어드바이스를 적용할 곳을 선별하기 위한 표현식을 말함 : 어드바이스가
	 * 적용될 시점(표현식으로 작성) - 위빙(Weaving) : 애플리케이션 코드의 적절한 시점에 Aspect를 적용하는 것을 말한다. -
	 * 타겟(Target) : AOP 처리에 의해 처리 흐름에 변화가 생긴 객체를 말합니다. : 어떤 대상에 대해서 부가 기능을 설정할 것인지
	 * 결정
	 *
	 *
	 * 1-5) 스프링 지원 어드바이스 요형(부가기능) - Before > 조인 포인트 전에 실행된다. > 예외가 발생하는 경우를 제외하고 항상
	 * 실행된다 - After Returning > 조인 포인트가 정상적으로 종료된 후에 실행된다. > 예외가 발생하면 실행되지 않는다. -
	 * After Trowing > 조인 포인트에서 예외가 발생했을 때 실행된다. > 예외가 발생하지 않고 정상적으로 종료되면 실행되지 않는다.
	 * - After > 조인 포인트에서 처리가 완료된 후 실행된다. > 예외 발생이나 정상 종료 여부와 상관없이 항상 실행된다. - Around
	 * > 조인 포인트 전후에 실행된다.
	 *
	 *
	 * 1-6) AOP의 기능을 활용하기 위한 설정
	 * 
	 * - 의존관계등록(pom.xml) > aspectjrt(이미 등록되어 있음) > aspectjweaver
	 * 
	 * - 스프링 AOP 설정 > root-context.xml 설정 : AOP를 활성화 하기 위한 태그를 작성
	 * 
	 * 
	 * ### 스프링 AOP 스프링 AOP는 동작 시점이 여러가지가 있지만 그 중 런타임 시점에 프록시 객체를 생성후 기능을 삽입 >>> 메소드
	 * 실행 시점 시 동작
	 * 
	 * 
	 * 
	 * 2. 포인트 컷 표현식 - execution 지시자에 대하 araboja
	 * 
	 * 
	 * # 포인트 컷(pointcut) - Advice가 실행될 지점을 표현하는 표현식
	 * 
	 * 2-1) execution 지시자의 표현 방식
	 * 
	 * - excution 지시자를 활용해 포인트 컷을 표현한 것
	 * 
	 * - 포인트 컷 표현요소 ex) execution(Board kr.or.ddit.service.I~~.Service*.read*(..))
	 * 
	 * 표현요소 				│ 설명 
	 * ──────────────────────────────────────── 
	 * execution 			│ 지시자 
	 * Board 				│ 반환값 
	 * kr.or.ddit.service 	│ 패키지 
	 * BoardService*		│ 클래스(타입) 
	 * read* 				│ 메소드 
	 * (..) 				│ 인수,  파라미터
	 * ────────────────────────────────────────
	 * 
	 *
	 * 2-2) 포인트컷 표현식에 사용되는 와일드 카드
	 *
	 * 와일드카드 		│ 설명
	 * ─────────────────────────────────────────────────────────────────────────────
	 *  * 			│ 임의의 패키지 1개 계층을 의미하거나 임의의 인수 1개를 의미한다. 
	 *  .. 			│ 임의의 패키지 0개 이상 계층을 의미하거나  임의의 인수 0개 이상을 의미한다. 
	 *  + 			│ 클래스명 뒤에 붙여 쓰며, 해당 클래스와 해당 클래스의 서브 클래스, 
	 *  			│ 혹은 구현 클래스 모두를 의미한다.
	 * ─────────────────────────────────────────────────────────────────────────────
	 * 
	 * 2-3) 포인트컷 표현식을 적용한 모습
	 * 
	 * @Before("execution(* kr.or.ddit.servie.IBoardService.BoardService.*.*(..))")
	 * public void startLog(JoinPoint jp){ log.info("startLog : " +
	 * jsp.getSignature()); }
	 * 
	 * 
	 * 
	 * 
	 * 	### AOP 적용시 주의점
	 * 
	 *		root-context.xml, servlet-context.xml 에서 basepackage로 설정한 설정값에 따라
	 * 		객체로 설정된 패키지 하위 자원들이 빈으로 등록되는데, @Component, @Aspect가 선언되어 있는 
	 *  	AOPController와 조인포인트로 설정한 Service부분들이 basePackage로 설정된 하위 자원들의 중복으로
	 *  	빈 등록이 되지 않아 AOP가 활성화 되지 않는 문제가 발생할 수 있음
	 *  
	 *  	AOP를 적용시키는데 있어서 패키지 구조 설계에 따른 중복으로 인해 빈 등록이 되지 않는 오류를 최소화하기 위해서는
	 *  	퍼스펙티브를 스프링으로 변경한 후 Project Exproloer를 활용해 Spring bean으로 등록되어 있는 내역들 중
	 * 		@Aspect가 적용되어 있는 AOPController가 빈으로 등록되어 있는지  체크하고
	 *  	중복되어 등록되어있지는 않는지 확인하여야함
	 * 		각각의 빈들이 중복되어 만들어지지 않고 정상적으로 만들어지는거라면 위빙 포인트가 생성되어 타겟이 실행되기 전 AopProxy가 활성화 되어
	 *		인터페이스 기반의 프록시로서 역할을 할 수 있도록 true인지를 체크한다.
	 *
	 *
	 * ### AOP 프록시
	 *		클라이언트가 요청한 요청을 타겟이 받기 전 실제 타겟인것처럼 위장해서 클라이언트의 요청을 받는다.
	 *		여기서 등장하는 개념이 프록시인데, 프록시는 쉽게 말하면 대리자라고 생각하면 되는데 타겟으로 향하는
	 *		요청을 중간에서 대리자인 프록시가 받아 선 처리 후 타겟으로 요청을 던져준다.
	 *		그리고 응답으로 나가는 부분을 잡아야하는 처리가 필요 시, 응답을 잡아서 처리 후 최종 응답을 내보낸다.
	 *
	 *			[클라이언트]	>>>		[프록시]		>>>		[타겟]
	 *
	 */

	
	/*
	 *  3. Before 어드바이스
	 *  	- 조인포인트 전에 실행(예외발생하는 경우만 제외하고 항상 실행)
	 */
	@Before("execution(* kr.or.ddit.service.IBoardService.*(..))")
	public void startLog(JoinPoint jp) {

		log.info("[@Before] startLog");

		// getSignature() : 어떤 클래스의 어떤 메소드가 실행되었는지 보여줌
		// 파라메터 타입의 뭔지 보여줌
		log.info("[@Before] startLog " + jp.getSignature());
		// getArgs() : 전달된 파라메터 정보를 보여줌
		log.info("[@Before] startLog " + Arrays.toString(jp.getArgs()));
		
		/*
		 *  8. 메소드 정보 획득
		 *  - @Before 어노테이션이 붙은 메서드는 JoinPoint라는 매개변수를 통해 실행중인 메소드의 정보를 획득할 수 있다.
		 * 
		 */
		// 프록시가 입혀지기 전의 원본 대상 객체를 가져온다
		Object targetObj = jp.getTarget();
		log.info("[@Before] targetObj" + targetObj);
			
		Object thisObject = jp.getThis();
		log.info("[@Before] thisObject : " + thisObject);
			
		Object[] args = jp.getArgs();
//		for(int i = 0; i < args.length; i++) {
//			log.info("[@Before] args" + args[i]);
//		}
		for(Object obj : args)
			log.info("[@Before] args" + obj);
	}

	/*
	 *  4. After Returning
	 *  - 조인 포인트가 정상적으로 종료 후 실행된다. 예외가 발생하면 실행되지 않는다
	 * 
	 */
	@AfterReturning("execution(* kr.or.ddit.service.IBoardService.*(..))")
	public void logReturning(JoinPoint jp) {
		log.info("[@AfterReturnin] logReturning");
		log.info("[@AfterReturnin] logReturning" + jp.getSignature());
	}
	
	
	/*
	 *  5. After Throwing
	 *  - 조인 포인트내에서 예외가 발생하였을 때 실행된다. 예외가 발생하지 않고 정상적으로 종료하면 실행되지 않는다
	 * 
	 */
	@AfterThrowing(pointcut = "execution(* kr.or.ddit.service.IBoardService.*(..))",
					throwing = "e")
	public void logException(JoinPoint jp, Exception e) {
		log.info("[@AfterThrowing] logException");
		log.info("[@AfterThrowing] logException : " + jp.getSignature());
		log.info("[@AfterThrowing] logException" + e);
	}
	
	
	/*
	 *  6. After 어드바이스
	 *  - 조인 포인트에서 처리가 완료된 후 실행된다
	 */
	@After("execution(* kr.or.ddit.service.IBoardService.*(..))")
	public void endLog(JoinPoint jp) {
		log.info("[@After] logException");
		log.info("[@After] logException : " + jp.getSignature());
		log.info("[@After] logException : " + Arrays.toString(jp.getArgs()));
	}
	
	/*
	 *  Around 어드바이스( 제일 많이 사용됨 )
	 *  - 조인 포인트 전 후로 실행됨
	 *  
	 *  	- ProceedingJoingPoint
	 *  	: around 어드바이스에서 사용함
	 *  
	 *  	스프링프레임워크가 컨트롤하고 있는 비즈니스로직 호출을 가로챔
	 *  	책임이 around 어드바이스로 전가됨
	 *  	그 정보를 스프링 컨테이너가 around 어드바이스 메소드로 넘겨주면
	 *  	ProceedingJointPoint 객체로 받아서 around 어드바이스가 컨트롤 시 사용할 수 있도록 해줌
	 */
	@Around("execution(* kr.or.ddit.service.IBoardService.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		log.info("[@Around] : " + Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		
		long endTime =  System.currentTimeMillis();
		log.info("[@Around] : " + Arrays.toString(pjp.getArgs()));
		
		//직후 시간 - 직전시간 : 메소드 실행시간
		log.info("[@Around] timeLog: " + pjp.getSignature());
		log.info("[@Around] 메소드 실행시간: " + (endTime - startTime));
		return result;
		
	}
	
}
