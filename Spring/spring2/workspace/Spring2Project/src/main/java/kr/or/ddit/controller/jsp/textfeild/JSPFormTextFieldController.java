package kr.or.ddit.controller.jsp.textfeild;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/textfield")
@Slf4j
public class JSPFormTextFieldController {

	/*
	 * 	4. 텍스트 필드 요소
	 * 
	 * 		- HTML 텍스트 필드를 출력하려면 <form:input> 요소를 사용한다
	 * 
	 */
	
	@RequestMapping(value="/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() ㅎㅇㅎㅇ");
		model.addAttribute("member", new Member());
		return "home/formtag/textfield/registerForm01";
	}
	
	
	@RequestMapping(value="/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02() ㅎㅇㅎㅇ");
		Member member = new Member();
		member.setUserId("hong123");
		member.setUserName("ㅁㅇㅁㄴㅇ");
		member.setEmail("zxc@zxc.zxc");
		model.addAttribute("member", member);
		return "home/formtag/textfield/registerForm01";
	}
	
	
	
}
