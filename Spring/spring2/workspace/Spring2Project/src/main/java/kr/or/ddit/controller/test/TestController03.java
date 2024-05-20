package kr.or.ddit.controller.test;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.controller.test.dao.Test03Repository;
import kr.or.ddit.controller.test.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test03")
@Slf4j
public class TestController03 {

	
	
	@Inject
	Test03Repository tr = new Test03Repository();
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginPage() {
		return "script/test03/login";
	}
	
	@RequestMapping(value="/findInfo.do", method = RequestMethod.GET)
	public String findInfo() {
		return "script/test03/findInfo";
	}
	
	
	@RequestMapping(value="/info.do", method = RequestMethod.GET)
	public String info(StudentVO studentVO, Model model, RedirectAttributes ra) {
		log.info("일단 여기 오냐");
		
		String memId = studentVO.getMemId();
		String memPw = studentVO.getMemPw();
		
		if(tr.login(memId, memPw)) {
			int idx = tr.idx(memId);
			System.out.println(idx);
			studentVO = tr.loginInfo(memId);
			model.addAttribute("studentVO", studentVO);
			ra.addFlashAttribute("msg", studentVO.getMemName()+"님 환영합니다!");
			
			return "redirect:/test03/infoPage.do?idx="+idx;
		} else {
			return "script/test03/login";
		}
	}
	
	@RequestMapping(value="/infoPage.do", method = RequestMethod.GET)
	public String infoPage(Model model, @RequestParam int idx) {
		log.info("infoPage... goto info.jsp");
		StudentVO sv = tr.getVO(idx);
		System.out.println(sv);
		model.addAttribute("sv", sv);
		
		return "script/test03/info";
	}

	
	
	
	
	
	@RequestMapping(value="/finId.do", method=RequestMethod.POST)
	public ResponseEntity<String> findId(@RequestBody StudentVO studentVO) {
		log.info("여기는 오기는 하는구나오니...");
		System.out.println(studentVO.getMemName() + studentVO.getMemEmail());
		String id = tr.findId(studentVO.getMemName(), studentVO.getMemEmail());
		
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findPw.do", method=RequestMethod.POST)
	public ResponseEntity<String> findPw(@RequestBody StudentVO studentVO) {
		
		log.info("여기는 오니...");
		System.out.println(studentVO.getMemName() + studentVO.getMemEmail() + studentVO.getMemId());
		String pw = tr.findPw(studentVO);
		
		return new ResponseEntity<String>(pw, HttpStatus.OK);
	}
	
}
