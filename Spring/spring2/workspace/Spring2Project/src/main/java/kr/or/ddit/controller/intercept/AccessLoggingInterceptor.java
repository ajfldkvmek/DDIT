package kr.or.ddit.controller.intercept;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessLoggingInterceptor implements HandlerInterceptor {

	PrintWriter writer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("preHandle() 실행...");
		
		File file = new File("C:/logs/ddit_logging.log");
		writer = new PrintWriter(new FileWriter(file, true), true);
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		String requestURI = request.getRequestURI().toString();
		String requestURL = request.getRequestURL().toString();
		
		log.info("requestURI : " + requestURI );
		log.info("requestURL : " + requestURL );
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		// class kr.or.ddit.controller.~~~Controller
		Class clazz = method.getDeclaringClass();
		// class kr.or.ddit.controller.~~~Controller
		String className =  clazz.getName();
		// ~~~Controller
		String classSimpleName = clazz.getSimpleName();
		
		String methodName = method.getName();
		
		writer.printf("현재일시 : %s %n", getCurrentTime());
		writer.printf("Access Controller : %s $n", className + "." + methodName);
		writer.println("-----------------------------------------------------------");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//super.afterCompletion(request, response, handler, ex);
		log.info("afterCompletion() 메소드 최종 타겟 마무리");
	}

	
	public String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(cal.getTime());
	}
	
}
