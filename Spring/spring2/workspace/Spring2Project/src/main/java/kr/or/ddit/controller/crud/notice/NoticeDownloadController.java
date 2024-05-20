package kr.or.ddit.controller.crud.notice;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import kr.or.ddit.service.INoticeService;
import kr.or.ddit.vo.crud.NoticeFileVO;

@Controller
public class NoticeDownloadController {

	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value="/notice/download.do" , method = RequestMethod.GET)
	public View noticeDownload(int fileNo, ModelMap model) {
		//선택한 파일을 다운하기 위한 정보를 파일 번호에 해당하는 파일정보 가져옴
		NoticeFileVO noticeFileVO = noticeService.noticeDownload(fileNo);
		
		Map<String, Object> noticeFileMap = new HashMap<>();
		noticeFileMap.put("fileName", noticeFileVO.getFileName());
		noticeFileMap.put("fileSize", noticeFileVO.getFileSize());
		noticeFileMap.put("fileSavepath", noticeFileVO.getFileSavepath());
		
		model.addAttribute("noticeFileMap", noticeFileMap);
		
		// 리턴되는 NoticeDownloadView는 JSP페이지로 존재하는 페이지 Name을 요청하는게 아니라
		// 클래스를 요청하는 것인데 해당 클래스가 스프링에서 제공하는 AbstractView 클래스를 상속받는 클래스이다
		// 그 클래스느 AbstractView를 상속받아 renderMergedOoutputModel함수를 재정의할 때 View로 취급될 수 있게 해줌
		return new NoticeDownloadView();
		
	}
	
	
}
