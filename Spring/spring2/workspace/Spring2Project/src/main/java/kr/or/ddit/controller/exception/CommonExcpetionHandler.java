package kr.or.ddit.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

//@ControllerAdvice 어노테이션은 스프링에서 발생하는 예외를 처리하는 핸들러 클래스임을 명시

@ControllerAdvice
@Slf4j
public class CommonExcpetionHandler {

	// @ExceptionHanlder 어노테이션은 괄호 안에 설정한 예외 타입을 해당 메소드가 처리하는 것을 의미
//	@ExceptionHandler(Exception.class)
//	public String handle(Exception e, Model model) {
//		
//		log.info("e: " + e.toString());
//		model.addAttribute("exception", e);
//		return "error/errorCommon";
//	}
//	
//	
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(value=HttpStatus.NOT_FOUND)
//	public String handle404(Exception e) {
//		log.info("e : " + e.toString());
//		return "error/custom404";
//	}
//	
	
}
