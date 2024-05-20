package kr.or.ddit.controller.intercept;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.vo.crud.CrudMember;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor{

	private static final String USER_INFO = "userInfo";
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		
		log.info("preHandler() 실행...");
		String requestURL = req.getRequestURL().toString(); // http://localhost/intercept/login
		String requestURI = req.getRequestURI().toString(); // intercept/login
		
		log.info("requestURL>>" + requestURL);
		log.info("requestURI>>" + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		
		Method methodObj = method.getMethod();
		
		//kr.or.ddit.controller.login.LoginController@~~~
		log.info("Bean: " + method.getBean());
		//public java.lang.String.kr.or.ddit.controller.login.LoginController.loginForm
		log.info("Method: " + methodObj);
		
		
		HttpSession session = req.getSession();
		if(session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
		}
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView mav) throws Exception {
		
		log.info("postHandle() 실행...");
		// http://localhost/intercept/login
		String requestURL = req.getRequestURL().toString(); 
		// intercept/login
		String requestURI = req.getRequestURI().toString(); 
		
		log.info("requestURL>>" + requestURL);
		log.info("requestURI>>" + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		
		Method methodObj = method.getMethod();
		
		//kr.or.ddit.controller.login.LoginController@~~~
		log.info("Bean: " + method.getBean());
		//public java.lang.String.kr.or.ddit.controller.login.LoginController.loginForm
		log.info("Method: " + methodObj);
		
		HttpSession session = req.getSession();
		
		// 컨트롤러 메서드를 거쳤다가 postHandle()로 넘어오면서 전달된 user라는 키에 value로 member가 담긴 model이 담겨저 있따
		// 그 중에 'user'로 넘긴 값이 로긍닣 ㅜ 인증된 회원 1명의 정보가 담긴 memberVO자바빈그 객체가 되고 
		// 객체가 null이 아닌 경우 메인 화면으로 리다이렉트 처리한다
		ModelMap modelMap = mav.getModelMap();
		Object member = modelMap.get("user");
		
		if(member != null && !((CrudMember) member).getUserId().equals("")) {
			log.info("member :" + member );
			log.info("member.getUserId() :" + ((CrudMember) member).getUserId());
			session.setAttribute(USER_INFO, member);
			resp.sendRedirect("/");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(req, resp);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex)
			throws Exception {
		
		log.info("afterCompletion() 실행...");
		
		// http://localhost/intercept/login
		String requestURL = req.getRequestURL().toString(); 
		// intercept/login
		String requestURI = req.getRequestURI().toString(); 
		
		log.info("requestURL>>" + requestURL);
		log.info("requestURI>>" + requestURI);
		
		HandlerMethod method = (HandlerMethod) handler;
		
		Method methodObj = method.getMethod();
		
		//kr.or.ddit.controller.login.LoginController@~~~
		log.info("Bean: " + method.getBean());
		//public java.lang.String.kr.or.ddit.controller.login.LoginController.loginForm
		log.info("Method: " + methodObj);
	}

	
}
