package kr.or.ddit.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class AOPLoggingController {

	
	@Around("execution(* kr.or.ddit.service.ILogService.*(..))")
	public void aroundLogging(ProceedingJoinPoint pjp) throws Throwable {
//		
		log.info("[@Around] getSignature : " + pjp.getSignature()); //클래스/메소드 정보(인터페이스)
		log.info("[@Around] target : " + pjp.getTarget());			//해당 서비스(구현체)
		
		log.info("[@Around] proceed : " + pjp.proceed());			//해당 메소드의 리턴값
		log.info("[@Around] : " + Arrays.toString(pjp.getArgs()));	//getargs >> 파라매터값 전부 가져옴
//		
		
				
	}
}
