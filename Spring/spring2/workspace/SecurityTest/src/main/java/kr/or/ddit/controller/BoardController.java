package kr.or.ddit.controller;

import java.security.Principal;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import kr.or.ddit.vo.CustomUser;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger log =
			LoggerFactory.getLogger(BoardController.class);

	@Inject
	private PasswordEncoder pe;
	
	@PostConstruct
	public void init() {
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
		System.out.println("########################"+ pe.encode("1234"));
	}
	
	
	@RequestMapping(value="/list")
	public String list() {
		return "board/list";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@RequestMapping(value="/register")
	public String registerForm(Principal principal) {
		
		//사용자 정보 가져오기
		//방법 1. principal -> getName말고 딱히 업음
		log.info("principal.getName() : " + principal.getName());
		
		
		//방법 2. USer객체 정보 가져오기
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
		log.info("user.getUserName() : " + user.getUsername());
		log.info("user.getUserPassword() : " + user.getPassword());
		
		Iterator<GrantedAuthority> ite = user.getAuthorities().iterator();
		
		while(ite.hasNext()) {
			log.info("권한 : " + ite.next().getAuthority());
		}
		
		CustomUser customUser = 
				(CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		

		log.info("내가 조회한 내 정보(아이디) : " + customUser.getMember().getUserId());
		log.info("내가 조회한 내 정보(이름) : " + customUser.getMember().getUserName());
		
		return "board/register";
	}
	
}
