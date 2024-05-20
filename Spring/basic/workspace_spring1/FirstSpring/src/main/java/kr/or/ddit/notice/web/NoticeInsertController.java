package kr.or.ddit.notice.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;

import kr.or.ddit.notice.service.INoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String noticeForm() {
		return "notice/form";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, Model model) {
		
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		
		if(StringUtils.isBlank(noticeVO.getNoticeTitle())) {
			errors.put("noticeTitle", "제목을 입력해 주세요");
		}
		
		if(StringUtils.isBlank(noticeVO.getNoticeContent())) {
			errors.put("noticeContent", "내용을 입력해 주세요");
		}
		
		if(errors.size() > 0) { //내가 넘긴 데이터가 정상이 아님
			model.addAttribute("errors", errors);
			model.addAttribute("notice", noticeVO);
			goPage = "notice/form";
		} else { //정상적인 데이터
			noticeVO.setNoticeWriter("a001"); //작성자 임시로 하드 코딩
			ServiceResult result = noticeService.insertNotice(noticeVO);
			
			if(result.equals(ServiceResult.OK)) { //등록성공
				goPage = "redirect:/notice/detail.do?noticeNo="+noticeVO.getNoticeNo();
			} else { //등록실패
				model.addAttribute("notice", noticeVO);
				goPage = "notice/form";
			}
		}
		
		return goPage;
	}
}
