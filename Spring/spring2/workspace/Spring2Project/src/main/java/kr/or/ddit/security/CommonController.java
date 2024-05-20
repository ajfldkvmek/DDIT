package kr.or.ddit.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

@Controller
public class CommonController {

	Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value="/accessError", method = RequestMethod.GET)
	public String accssDenied(Authentication auth, Model model) {
		log.info("accessDenied() 실행");
		log.info("accessDenied>>  auth");
		//org.springframework.security.authentication.UsernamePaswordAuthenticationToken@~~~
		//Principal				: org.springframework/security.core.userdetails.User@ahfh784
		//Username 				: member;
		//Password 				: [protected]
		//Enabled				: true
		//AccountNonExpired		: true;
		//credentialsNonExpired	: true;
		//AccountNonLocked		: true;
		//Granted Authorities	: ROLE_MEMBER;
		//Credentials			: [protected];
		//Details				: org.springframwork.security.web.authentication
		//								/WebAuthenticationDetails@~~;
		//SessionId				: ~~;
		
		model.addAttribute("msg", "ACCESS DENIED");
		return "accessError";
	}
	
}
