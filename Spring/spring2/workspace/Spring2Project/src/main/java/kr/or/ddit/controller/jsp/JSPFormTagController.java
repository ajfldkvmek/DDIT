package kr.or.ddit.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag")
@Slf4j
public class JSPFormTagController {

	/*
	 * 	8장: 스프링 폼 태그
	 * 
	 * 		- 스프링 폼은 HTML폼을 표시하기 위한 태그 라이브러리
	 * 		- 스프링 폼을 이용하면 HTML폼과 자바 객체를 쉽게 마인딩 할 수 있음
	 * 
	 * 		# 스프링 폼 커스텀 태그 목록
	 * 		<form:form>
	 * 		- 폼요소 생성
	 * 
	 * 		<form:input>
	 * 		- 텍스트 필드 요소 생성
	 * 
	 * 		<form:password>
	 * 		- 패스워드 필드 요소 생성
	 * 
	 * 		<form:textarea>
	 * 		- 텍스트 영역 요소 생성
	 * 
	 * 		<form:checkboxes>
	 * 		-여러개의 체크박스 요소 생성
	 * 
	 * 		<form:checkbox>
	 * 		- 체크박스 요소 생성
	 * 
	 * 		<form:radiobuttons>
	 * 		- 여러개의 라디오 버튼 요소 생성
	 * 
	 * 		<form:radiobutton>
	 * 		- 라디오 버튼 요소 생성
	 * 
	 * 		<form:select>
	 * 		- 셀렉트박스 요소생성
	 *
	 * 		<form:hidden>
	 * 		- 숨겨진 필드 요소생성
	 *
	 * 		<form:label>
	 * 		- 라벨 요소생성
	 *
	 * 		<form:button>
	 * 		- 버튼 요소생성
	 *
	 * 		<form:errorss>
	 * 		- 입력값 검증 오류 표시
	 *		
	 *		스프링 폼태그>>
	 *		<%@taglib uri="http://www.springframework.org/tags/form" %>
	 *
	 *
	 * 2. 폼 항목의 공통점
	 * 
	 * 		- HTML 폼 항목을 출력하기 위한 태그 라이브러리에는 몇 가지 공통속성이 있다
	 * 
	 * 		path		: 폼 항목에 바인딩 되는  폼 객체의 프로퍼티 지정
	 * 		disalbed	: 폼항목을 비활성화할지 여부 결정(default: false)
	 * 		readyonly	: 폼 항목을 읽기전용으로 만들이 여부결정(default: false)
	 * 		
	 * 
	 * 
	 */
	
	
	@RequestMapping(value="/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() 와따라ㅏ따라따라ㄸ따ㅏ따");
		model.addAttribute("member", new Member());
		return "home/formtag/registerForm01";
	}

	
}
