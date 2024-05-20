package kr.or.ddit.controller.intercept;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.crud.CrudMember;

@Controller
@RequestMapping("/intercept")
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginForm(CrudMember member, Model model) {
		member.setUserName("ㅋㅋㅋ");
		model.addAttribute("user", member);
		return "login/success";
	}
	
}
