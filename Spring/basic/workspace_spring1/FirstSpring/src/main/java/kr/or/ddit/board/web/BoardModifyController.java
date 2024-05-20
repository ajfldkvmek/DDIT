package kr.or.ddit.board.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardModifyController {

	@Inject
	private IBoardService boardService;
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String boardUpdateView(int boNo, Model model) {
		//System.out.println("update.do 와따다다다다ㅏㄷ");
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		model.addAttribute("status", "u"); //update의 u를 의미함 - 시스템에 이 기능이 게시글 등록이 아니라 수정임을 알리기 위함
		return "board/form";
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO, Model model) {
		String goPage= "";
		ServiceResult result = boardService.updateBoard(boardVO);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/board/detail.do?boNo="+boardVO.getBoNo();
		} else {
			model.addAttribute("board", boardVO);
			model.addAttribute("status", "u");
			goPage = "board/form";
		}
		return goPage;
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String boardDelete(int boNo) {
		String goPage = "";
		ServiceResult result = boardService.deleteBoard(boNo);
		if(result.equals(ServiceResult.OK)) {
			goPage="redirect:/board/list.do";
		} else { // 삭제 실패
			goPage = "redirect:/board/detail.do?boNo="+boNo;
		}
		return goPage;
	}
	
}
