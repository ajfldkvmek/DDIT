package kr.or.ddit.controller.crud.notice;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.CustomUser;
import kr.or.ddit.vo.NoticeMemberVO;
import kr.or.ddit.vo.crud.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {
	
	@Inject
	private INoticeService noticeService;
	
	
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public String noticeForm() {
		return "notice/form";
	}

	
	@RequestMapping(value="/insert.do", method = RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, Model model,
			RedirectAttributes ra,
			HttpServletRequest req
			) {
		
		String goPage="";
		
		Map<String, String> errors = new HashMap<String, String>();
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해줘");
		}
		
		if(StringUtils.isBlank(noticeVO.getBoContent())) {
			errors.put("boTitle", "제목을 입력해줘");
		}
		
		if(errors.size() > 0 ) {//에러 발생했을 경우
			model.addAttribute("errors", errors);
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		} else {
			//HTTPsERvletRequest 방법으로 로그인 처리 후 세션 정보에서얻어온 회원 정보를 추가하기위한 준비
//			HttpSession session =  req.getSession();
//			NoticeMemberVO memberVO = (NoticeMemberVO) session.getAttribute("SessionInfo");
//			
			// 스프링 시큐리티 Userdeatils 에서 정보 가져오기
			CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			NoticeMemberVO memberVO = user.getMember();
			
			if(memberVO != null) {
				
				noticeVO.setBoWriter(memberVO.getMemId()); 
				ServiceResult result = noticeService.insertNotice(req, noticeVO);
				if(result.equals(ServiceResult.OK)) {
					//등록 성ㅅ공
					ra.addFlashAttribute("message", "게시글 등록이 성공했습니다");
					goPage = "redirect:/notice/detail.do?boNo="+noticeVO.getBoNo();
				} else {
					//실패
					model.addAttribute("message", "서버에러, 다시시도 ㄱ");
					goPage="notice/form";
				}
				
			} else {
				ra.addFlashAttribute("message", "로그인 후에 사용 가능");
				goPage = "redirect:/notice/login.do";
			}
			
		}
		
		return goPage;
	}
	
	
}
