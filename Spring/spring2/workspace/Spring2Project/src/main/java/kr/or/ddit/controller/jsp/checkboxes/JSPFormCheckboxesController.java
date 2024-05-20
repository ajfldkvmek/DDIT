package kr.or.ddit.controller.jsp.checkboxes;

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
@RequestMapping("/formtag/checkboxes")
@Slf4j
public class JSPFormCheckboxesController {

	/*
	 * 	7. 여거래그이 체크박스 요소
	 * 	- HTL 여러개의 체크박스를 출력하려면 <form:checkboxes> 사용
	 */
	
	@RequestMapping(value="registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() ㅎㅎㅇㅎㅇ");
		Map<String, String> hobbyMap = new HashMap<>();
		
		hobbyMap.put("01", "Sprots");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Movie");
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("member", new Member());
		return "home/formtag/checkboxes/registerForm01";
	}
	
	
	// 2) 모델에 List 타입의 데이터를 생성하여 추가한 후 화면에 전달
	@RequestMapping(value="registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02() ㅎㅎㅇㅎㅇ");
		
		List<CodeLabelValue> hobbyCodeList = new ArrayList<>();
		hobbyCodeList.add(new CodeLabelValue("01", "Sports"));
		hobbyCodeList.add(new CodeLabelValue("02", "Music"));
		hobbyCodeList.add(new CodeLabelValue("03", "Movie"));
		
		model.addAttribute("hobbyCodeList", hobbyCodeList);
		model.addAttribute("member", new Member());
		
		return "home/formtag/checkboxes/registerForm02";
	}
	
	
	
	
}
