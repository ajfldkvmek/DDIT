package kr.or.ddit.controller.crud.notice;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.NoticeMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeLoginController {
	
	@Inject
	private INoticeService noticeService;

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String noticeLogin(Model model) {
		model.addAttribute("bodyText", "login-page");
		return "conn/login";
	}
	
	
	
	@RequestMapping(value="/signup.do", method = RequestMethod.GET)
	public String noticeSignUpForm(Model model) {
		model.addAttribute("bodyText", "register-page");
		return "conn/register";
	}
	
	
	@RequestMapping(value="/signup.do", method = RequestMethod.POST)
	public String noticeSignUp(NoticeMemberVO memberVO, Model model,
			HttpServletRequest req, RedirectAttributes ra
			) {
		String goPage = "";
		
		Map<String ,String> errors = new HashMap<>();
		
		if(StringUtils.isBlank(memberVO.getMemId())) {
			errors.put("memId", "아이디 입력 ㄱㄱ");
		}
		if(StringUtils.isBlank(memberVO.getMemPw())) {
			errors.put("memPw", "비번 입력 ㄱㄱ");
		}
		if(StringUtils.isBlank(memberVO.getMemName())) {
			errors.put("memName", "이름 입력 ㄱㄱ");
		}
		if(errors.size() > 0) {
			model.addAttribute("bodyText", "register-page");
			model.addAttribute("errors", errors);
			model.addAttribute("member", memberVO);
			goPage = "conn/register";
		} else {
			ServiceResult result = noticeService.signup(req, memberVO);
			if(result.equals(ServiceResult.OK)) {
				//가입 성공, 1회성 메세지 처리
				ra.addFlashAttribute("message", "회원가입 성공");
				goPage = "redirect:/notice/login.do";
			} else {
				//가입실패
				model.addAttribute("bodyText", "register-page");
				model.addAttribute("message", "서버에러 다시 시도");
				model.addAttribute("member", memberVO);
				goPage = "conn/register";
			}
		}
		
		return goPage;
	}
	
	//아이디 중복 확인 
	@ResponseBody
	@PostMapping(value="/idCheck.do")
	public ResponseEntity<ServiceResult> idCheck(@RequestBody Map<String, String> map){
		log.info("넘겨받은 아이디: " + map.get("memId"));
		ServiceResult result = noticeService.idCheck(map.get("memId"));
		
		return new ResponseEntity<ServiceResult>(result, HttpStatus.OK);
	}
	
	@PostMapping(value="/loginCheck.do")
	public String longinCheck(NoticeMemberVO memberVO, Model model,
			HttpSession session) {
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		if(StringUtils.isBlank(memberVO.getMemId())) {
			errors.put("memId", "아이디 입력해라아ㅏ라라");
		}
		if(StringUtils.isBlank(memberVO.getMemPw())) {
			errors.put("memPw", "비번 입력해라아ㅏ라라");
		}
		
		if(errors.size() > 0 ) {
			model.addAttribute("bodyText", "login-page");
			model.addAttribute("errors", errors	);
			model.addAttribute("member", memberVO);
			goPage = "conn/login";
		} else {
			NoticeMemberVO member = noticeService.loginCheck(memberVO);
			if(member!=null) {
				session.setAttribute("SessionInfo", member);
				goPage = "redirect:/notice/list.do";
			} else {
				model.addAttribute("message", "로그인 실패 정보 확인 바람");
				model.addAttribute("bodyText", "login-page");
				model.addAttribute("member", memberVO);
				goPage = "conn/login";
			}
		}
		return goPage;
	}
	
	@RequestMapping(value="/forget.do", method = RequestMethod.GET)
	public String loginForgetIdAndPw(Model model) {
		model.addAttribute("bodyText", "login-page");
		return "conn/forget";
	}
	
//	// 아이디 찾기 기능 요청(비동기)
	@RequestMapping(value="/idForget.do", method = RequestMethod.POST)
	public ResponseEntity<String> idForgetProcess(@RequestBody NoticeMemberVO memberVO, Model model) {
	
		String id = noticeService.findId(memberVO);
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
//
	// 비밀번호 찾기 기능 요청(비동기)
	@RequestMapping(value="/pwForget.do", method = RequestMethod.POST)
	public ResponseEntity<String> pwForgetProcess(@RequestBody NoticeMemberVO memberVO, Model model) {
	
		String pw = noticeService.findPw(memberVO);
		
		return new ResponseEntity<String>(pw, HttpStatus.OK);
	}
//	
}
