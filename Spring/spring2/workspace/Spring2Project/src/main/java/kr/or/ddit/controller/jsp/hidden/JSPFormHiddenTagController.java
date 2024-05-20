package kr.or.ddit.controller.jsp.hidden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/formtag/hidden")
public class JSPFormHiddenTagController {

	/*
	 *  12. 숨겨진 필드 요소
	 *  
	 *  - HTML 숨겨진 필드를 출력하려면 <form:hidden> 요소를 사용한다
	 *  
	 */
	
	@RequestMapping(value="/registerFormHidden01", method = RequestMethod.GET)
	public String registerFormHidden01(Model model) {
		
		log.info("registerFormHidden01() ㅎㅎㅎ");
		
		Member member = new Member();
		
		member.setUserId("qweewqwq");
		member.setUserName("이이이ㅡㄹㄹ므를믐");
		model.addAttribute("member", member);
		return "home/formtag/hidden/registerFormHidden01";
		
	}
}
