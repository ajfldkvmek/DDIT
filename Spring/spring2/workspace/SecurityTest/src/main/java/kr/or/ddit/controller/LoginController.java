package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping(value="/login")
	public String loginForm(String error, String logout, Model model) {
		
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		
		if(error != null) {
			model.addAttribute("error", "Login Error");
		}
		if(logout != null) {
			model.addAttribute("logout", "logout");
		}
		
		return "loginForm";
	}
	
	@GetMapping(value="/logout")
	public String logoutForm() {
		return "logoutForm";
	}
	
	
}
