package kr.or.ddit.controller.crud.notice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.CustomUser;
import kr.or.ddit.vo.NoticeMemberVO;

@Controller
@RequestMapping("/notice")
public class NoticeProfileController {

	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value="/profile.do", method = RequestMethod.GET)
	public String noticeProfile(
			HttpSession session,
			RedirectAttributes ra,
			Model model
			) {
		
		//String goPage = "";
//		NoticeMemberVO sessionMember = (NoticeMemberVO) session.getAttribute("SessionInfo");
//		
//		if(sessionMember == null) {
//			ra.addFlashAttribute("message", "로ㅓ그인 후 이용 가느능으으응");
//			return "redirect:/notice/login.do";
//		} 
//		//
		
		CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		NoticeMemberVO member = noticeService.selectMember(user.getMember().getMemId());
		
//		NoticeMemberVO member = noticeService.selectMember(sessionMember.getMemId());
		
		if(member != null) {
			model.addAttribute("member", member);
			return "notice/profile";
		} else {
			ra.addFlashAttribute("message", "로ㅓ그인 후 이용 가느능으으응");
			return "redirect:/notice/login.do";
		}
		
		
	}
	
	@PostMapping(value="/profileUpdate.do")
	public String noticeProfileUpdate(NoticeMemberVO memberVO,
						RedirectAttributes ra, Model model,
						HttpServletRequest req) {
		
		String goPage = "";
		ServiceResult result = noticeService.profileUpdate(req, memberVO);
		
		if(result.equals(ServiceResult.OK)) {
			ra.addFlashAttribute("message", "수정와료료료로");
			goPage = "redirect:/notice/profile.do";
		} else {
			model.addAttribute("member", memberVO);
			model.addAttribute("message", "서버에러 다시 시도 ㄱㄱ");
			goPage = "notice/profile";
		}
		return goPage;
	}
	
	
	
}
