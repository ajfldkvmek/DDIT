package kr.or.ddit.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/el")
public class JSPELController {

	/*
	 *  
	 *  8. EL 함수
	 *  
	 *  	- JSTL은 표현언어(EL)에서 사용할 수 있는 함수를 제공한다
	 *  
	 *  
	 *  	1) EL함수 목록
	 *  	fn:contains(str1, str2) 
	 *  		- 지정한 문자열의 포함 여부 판단
	 *  
	 *  	fn:containsIgnoreCase(str1, str2) 
	 *  		- 지정한 문자열의 포함 여부를 대소문자 구분 없이 판단
	 *  
	 *  	fn:startsWith(str1, str2)
	 *  		- 지정한 문자열로 시작하는지 판단
	 *  
	 *  	fn:endsWith(str1, str2)
	 *  		- 지정한 문자열로 끝나는지 판단
	 *  
	 *  	fn:length(obj)
	 *  		- 컬렉션 또는 배열의 요소 개수, 문자열의 길이을 구한다
	 *  
	 *  	fn:excapeXml(str)
	 *  		- 지정한 문자열을 xml 구문으로 해석되지 않도록 이스케이프 한다
	 *  
	 *  	fn:replace(str, src, dest) 
	 *  		- 문자열 치환
	 *  
	 *  	fn:toLowerCase
	 *  
	 *  	fn:toUppserCase
	 *  
	 *  	fn:trim(str)
	 *  		- 공백 제거
	 *  
	 *  	fn:substring(str, idx1, idx2) 
	 *  		- 지정한 범위에 해당하는 문자열 잘라내기
	 *  
	 *  	fn:substringAfter(str1, str2)
	 *  		- 지정한 문자열과 일치하는 이후의 문자열을 잘라내
	 *  		
	 *  	fn:substringBefore(str1, str2)
	 *  		- 지정한 문자열과 일치하는 이전의 문자열을 잘라내
	 *  		
	 *  	fn:join(array, str2)
	 *  		- 배열을 구분자로 분할해서 하느의 문자열로 만든다
	 *  
	 *  	fn:split(str1, str2)
	 *  		- 문자열 구분자로 분할해서 배열로 만든다
	 *  
	 */
	
	@RequestMapping(value="/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		String str = "<font>Hello World!</font>";
		model.addAttribute("str", str);
		return "home/el/home0101";
	}
	
	
	
}
