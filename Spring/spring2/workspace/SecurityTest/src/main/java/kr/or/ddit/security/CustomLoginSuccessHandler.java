package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	private static final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		log.info("#################### Login Success");
		
		//security.core.userdetails
		User customUser = (User) authentication.getPrincipal();
		
		//인증이 완료된 사용자의 아이디 비밀번호 꺼내기
		log.info("#################### username : " + customUser.getUsername());
		log.info("#################### password : " + customUser.getPassword());
		
		//세션에 등록되어있는 정보삭제
		clearAuthenticationAttribute(request);
		
		SavedRequest svaedRequest =  requestCache.getRequest(request, response);
		String targetURL = "/";
		
		if(svaedRequest != null) {// 타겟정보 존재
			targetURL = svaedRequest.getRedirectUrl();
		} 
		
		log.info("Login Success targetURL: " + targetURL);
		response.sendRedirect(targetURL);
		
	}

	private void clearAuthenticationAttribute(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session == null) {
			return;
		}
		
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
	}

	
}
