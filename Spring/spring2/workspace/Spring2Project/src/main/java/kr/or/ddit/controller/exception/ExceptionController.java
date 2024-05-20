package kr.or.ddit.controller.exception;

public class ExceptionController {

	
	/*
	 * 
	 * 	16장. 예외처리
	 * 
	 * 		일반적으로 프로그램이 처리되는 동안 특정 문제가 일어났을때,  처리를 중단하고 다른 처리를 하는 것을 예외처리라고한다
	 * 
	 * 		웹 컨테이너는 기본적으로 예외처리 페이지를 에러 페이지로 표시
	 * 		하지만 페이지 애플리케이션 서버의 내부 정보가 노출되어 보안취약점 발생
	 * 		이 떄문에 에러 페이지를 따로 관리해주어야함
	 * 
	 * 		1-1) 예외 종류
	 * 		- 스프링 프레임워크 예외
	 * 		- 사용자 정의 예외
	 * 		- 의존 라이브러리에서 발생한 예외
	 * 		- 시스템 예외
	 * 
	 * 
	 * 		1-2) 우리는 가상의 예외를 발생시킬것
	 * 			a. 수정 화면 생성하고 뷰 파일에서 예외 발생
	 * 			b. 삭제할때, 매핑파일에서 예외 발생
	 * 			c. 존재하지 않는 게시물을 조회할때, 사용자 정의 예외 발생
	 * 			d. 존재하지 않는 페이지 요청시 예외발생
	 *
	 *
	 *		1-3) 예외처리 불가 기준
	 *			>>> 사용자가 정의한 예외 처리기를 거치지 않은 예외로 프레임워크에선 이러한 예외를 처리한 내용은 다음과 같음
	 *				 >> Http status400 bad request - 서버에 도착도 안함
	 *
	 *	
	 *
	 *
	 *
	 *	2. 예외 상황
	 *
	 *		2-1) 예외 발생 상황
	 *			
	 *			- 수정 화면 생성하고 뷰 파일에서 예외 발생
	 *				> Http status 500
	 *				[예외상황 발생 위치]
	 *				- views/crud/register.jsp < form:input path="title2"/>로 수정
	 *		
	 *		
	 *			- 삭제 할 때 매핑 파일에서 예외 발생
	 * 				> Http Status 500
	 * 				[예외 상황 만들 위치]
	 * 				- sqlmap/boardMapper_SQL.xml id가 delete인 삭제 기능을 가진 태그에서
	 * 					board_no를 board_no2로 수정
	 *
	 *
	 *			- 존재하지 않는 게시물을 조회할 때 사용자가 정의한 예외 발생
	 *
	 *				> Http Status 500
	 * 				[예외 상황 만들 위치]
	 * 				- kr.or.ddit.service.impl.BoardServieImpl read() 수정
	 * 				- new BoardRecordNotFoundException 예외 발생
	 * 
	 * 			- 존재하지 않는 URL요청시 예외 발생
	 * 				> Http Status 404
	 * 				[예외 상황 만들 위치]
	 * 				/crud/board/retry 와 같은 없는 url요청
	 * 
	 * 
	 *  3. 상태코드 사용한 에러 페이지 설정
	 *  - 웹 컨테이너 설정 파일 (web.xml)의 <error-code> 요소에 상태 코드를 설정하거 <location> 요소에 이동 대상 페이지를 지정한다
	 *  
	 *   예외처리방법
	 *   	- 웹 컨테이너 설정(web.xml)	
	 *   		> <error-page></error-page> 400 코드 설정
	 *   		> <error-page></error-page> 404 코드 설정
	 *   		> <error-page></error-page> 500 코드 설정
	 *   	
	 *   	- 처리할 수 있는 예외
	 *   		> 수정 화면 생성할 떄 뷰 파일에서 예외 발생
	 *  		> 삭제 할 떄 매핑 파일에서 예외 발생
	 *  		> 존재하지 않는 게시물 조회할 때 사용자가 정의한 예외 발생
	 *  		> 존재하지 않는 페이지 url요청시 예외발생
	 *  
	 *  
	 *  	- 처리할 수 없는 예외
	 *  
	 *  
	 *  4. 예외 타입 사용한 에러 페이지 설정
	 *  - 웹 컨테이너 설정 파일(web.xml)의 <exception-type>요소의 예외 타입을 설정하고 <locaton>요소에 이동 대상 페이지 지정
	 *  
	 *  	예외 처리 방법
	 *  	- 웹컨테이너 설정(web.xml) 
	 *  		> <error-page></error-page>
	 *  
	 *  	> 수정화면 생성할 때 뷰 파일에서 예외 발생
 	 *  	> 삭제할 때 매핑 파일에서 예외 발생
	 *  	> 존재하지 않는 게시물 조회할 때 사용자가 정의한 예외 발생
	 *  
	 *  
	 *  	- 처리하지 못하는 예외
	 *  	> 없는 페이지 요청
	 *  
	 *  
	 *  5. 기본 에러 페이지 설정
	 *  - 웹 컨테이너 설정파일(web.xml)의 <location>요서만 지정해 <error-page>요소를 정의
	 *  
	 *  	예외 처리 방법
	 *  	- 웹 컨테이너(web.xml)설정
	 *  		> <error-page>
	 *  		> 기본 이동 대상 설정
	 *  		> 에러 페이지를 jsp파일 절대경로로 설정
	 *  		> Controller에서 선언한 url매핑 정보로도 설정가능
	 *  		> 서블릿 3.1 이상에서 지원
	 *  
	 *   	- 처리할 수 있는 예외
	 *   		> 수정 화면 생성할 떄 뷰 파일에서 예외 발생
	 *  		> 삭제 할 떄 매핑 파일에서 예외 발생
	 *  		> 존재하지 않는 게시물 조회할 때 사용자가 정의한 예외 발생
	 *  		> 존재하지 않는 페이지 url요청시 예외발생
	 *  
	 *  
	 *  	- 처리할 수 없는 예외
	 *  	
	 *  
	 *  
	 *   6. 예외 처리 어노테이션
	 *   - @ExceptionHandler 와 @ControllerAdvice를 이용하여 처리한다
	 *   
	 *   	예외 처리 방법
	 *   	- @ControllerAdvice 어노테이션은 스프링 컨트롤러에서 발생하는 예외를 처리하는 핸들러 클래스임을 명시
	 *   
	 *   	- @ExceptionHandler 어노테이션은 괄호안에 설정한 예외 타입을 해당 메소드가 처리한다는 것을 의미
	 *   
	 *   
	 *   
	 *   	예외 처리 핸들러 생성
	 *   	- kr.or.ddit.controller.exception.CommonExcpetionHandler 클래스 생성
	 *   
	 *   
	 *   
	 *   	- 처리할 수 있는 예외
	 *  		> 삭제 할 떄 매핑 파일에서 예외 발생
	 *  			> SQLSyntaxException 발생
	 *  		> 존재하지 않는 게시물 조회할 때 사용자가 정의한 예외 발생
	 *  
	 *  	- 처리할 수 없는 예외
	 *   		> 수정 화면 생성할 떄 뷰 파일에서 예외 발생
	 *   			> ServletException을 상속받는 JasperException에러발생이므로 Exceptio 처리 안함
	 *  		> 존재하지 않는 페이지 url요청시 예외발생
	 *  	
	 *  
	 *   7. 예외 정보 출력
	 *   - 예외에 대한 내용을 Model객체를 이용해서 전달하여 뷰 화면에서 출력이 가능하다
	 *   
	 *   	예외처리 방법
	 *   	- CommonExceptionHanlder 클래스에서 에러 정보를 페이지로 던져준다
	 *   
	 *   8. 404에러 페이지 처리
	 *   - web.xml 설정을 통해 처리할 수 있다
	 *   	
	 *   	예외 처리 방법
	 *   	- 웹 컨테이너 설정
	 *   		> 404 에러를 처리할 수 있도록 Dispatcherservlet의 throwExceptionIfNoHandlerFound속성를 true로 설정
	 *   	
	 *   
	 *   	- 처리할 수 있는 예외
	 *   		> 존재하지 않는 페이지 url요청시 예외발생
	 *  		
	 *  
	 *  	- 처리할 수 없는 예외
	 *   		> 수정 화면 생성할 떄 뷰 파일에서 예외 발생
	 *  		> 삭제 할 떄 매핑 파일에서 예외 발생
	 *  		> 존재하지 않는 게시물 조회할 때 사용자가 정의한 예외 발생
	 *  
	 *  
	 *  
	 *   9. 입력값 검증 예외 처리
	 *   - @Validation 어노테이션ㅇ늘 사용한 Bean Validation의 유효성 검증 매커니즘을 이용할 수 있다
	 *   
	 *   
	 *   	예외처리 방법
	 *   	- 입력값 검증 기능의 활성화와 bindingResult정의
	 *   		> 입력값 검증 대상인 자바빈즈 메소드 매개변수에 @validation 어노테이션을 지정하고
	 *   		바로 다음값에 BindingResult를 정의한다
	 *   		BindingResult에는 요청 데이터으이 바인딩에러와 검사에러 정보가 저장된다
	 *  
	 *  
	 *   
	 */	
	
}	
