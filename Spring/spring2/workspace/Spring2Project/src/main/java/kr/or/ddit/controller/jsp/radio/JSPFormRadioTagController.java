package kr.or.ddit.controller.jsp.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.CodeLabelValue;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/formtag/radio")
public class JSPFormRadioTagController {

	/*
	 * 9. 여러개의 라디오 버튼 요소
	 * 
	 * - HTML 라디오 버튼을 출력하려면 <form:radiobuttons> 요소 사용
	 */

	// 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달
	@RequestMapping(value = "/registerFormRadios01", method = RequestMethod.GET)
	public String registerFormRadios01(Model model) {

		log.info("registerFormRadios01() ㅎㅇㅎㅇ");

		Map<String, String> genderCodeMap = new HashMap<>();

		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");

		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("member", new Member());
		return "home/formtag/radio/registerFormRadios01";
	}

	// 모델에 List탕빙의 데이털르 생성하여 추가한 후에 화면에 전달
	@RequestMapping(value = "/registerFormRadios02", method = RequestMethod.GET)
	public String registerFormRadios02(Model model) {

		log.info("registerFormRadios02() ㅎㅇㅎㅇ");

		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));

		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		return "home/formtag/radio/registerFormRadios02";
	}

	
	/*
	 * 	10. 라디오 버튼 요소
	 * 	- HTML 라디오 버튼을 출력하려면 <form:radiobutton> 요소를 사용
	 * 
	 */
	
	// 1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadio01", method = RequestMethod.GET)
	public String registerFormRadio01(Model model) {

		log.info("registerFormRadio01() ㅎㅇㅎㅇ");

		model.addAttribute("member", new Member());
		
		return "home/formtag/radio/registerFormRadio01";
	}
	
	// 2) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadio02", method = RequestMethod.GET)
	public String registerFormRadio02(Model model) {
		
		log.info("registerFormRadio02() ㅎㅇㅎㅇ");
		Member member = new Member();
		
		member.setGender("female");
		model.addAttribute("member", member);
		
		return "home/formtag/radio/registerFormRadio01";
	}

}
