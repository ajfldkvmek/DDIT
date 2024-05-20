package kr.or.ddit.controller.crud.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.crud.NoticeVO;
import kr.or.ddit.vo.crud.PaginationInfoVO;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {

	@Inject
	private INoticeService noticeService;
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
	@RequestMapping(value="/list.do")
	public String noticeList(
			@RequestParam(name="page", required = false, defaultValue="1") int currentPage,
			@RequestParam(required = false, defaultValue="title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model
			) {
		
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<>();
		
		//검색기능 추가시 활용
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			
			model.addAttribute("serchType",searchType );
			model.addAttribute("searchWord",searchWord );
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<NoticeVO> dataList = noticeService.selectNoticeList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "notice/list";
	}
	
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String noticeDetail(int boNo, Model model) {
		NoticeVO notice = noticeService.selectNotice(boNo);
		model.addAttribute("notice", notice);
		return "notice/detail";
	}
	
	
	
	
	
}
