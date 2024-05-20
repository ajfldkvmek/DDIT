package kr.or.ddit.controller.crud.notice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.crud.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeModifyController {
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String noticeUpdateForm(int boNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
	}
	
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String noticeUpdaet(NoticeVO noticeVO, Model model,
			RedirectAttributes ra,
			HttpServletRequest req) {
		
		String goPage="";
		ServiceResult result = noticeService.updateNotice(req, noticeVO);
		if(result.equals(ServiceResult.OK)) {
			ra.addFlashAttribute("message", "게시글 수정 완료");
			goPage = "redirect:/notice/detail.do?boNo="+noticeVO.getBoNo();
		} else {
			model.addAttribute("notice", noticeVO);
			model.addAttribute("message", "서버에러, 다시 시도 ㄱㄱ");
			model.addAttribute("status", "u");
			goPage = "notice/form";
		}
		return goPage;
	}
	
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String noticeDeleteForm(int boNo, Model model, 
			RedirectAttributes ra,
			HttpServletRequest req) {
		
		String goPage = "";
		ServiceResult result = noticeService.deleteNotice(req, boNo);
		
		if(result.equals(ServiceResult.OK)) {
			ra.addFlashAttribute("message", "삭제완룔로로ㅗ로");
			goPage = "redirect:/notice/list.do";
		} else {
			ra.addAttribute("message", "서버오류류류류류류");
			goPage = "redirect:/notice/detail.do?boNo="+boNo;
		}
		return goPage;
	}

}
