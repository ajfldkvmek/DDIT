package kr.or.ddit.controller.jsp.textarea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/textarea")
@Slf4j
public class JSPFormTextareaTagController {

	/*
	 * 	6. 텍스트 영역 요소
	 * 
	 * 		- HTML 텍스트 영역을 출력하려면 <form:textarea> 요소를 사용한다
	 * 
	 */
	
	@RequestMapping(value="/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		model.addAttribute("member", new Member());
		return "home/formtag/textarea/registerForm01";
				   //formtag/textarea/registerForm01
								   ///regisTerForm01
	}
	
	@RequestMapping(value="/registerForm02", method = RequestMethod.GET)
	public String regiserForm02(Model model) {
		Member member = new Member();
		member.setIntroduction("하이하이 나는 \n나다 이새끼야 \n병철이형은 나가있어");
		model.addAttribute("member", member);
		return "home/formtag/textarea/registerForm01";
	}
}
