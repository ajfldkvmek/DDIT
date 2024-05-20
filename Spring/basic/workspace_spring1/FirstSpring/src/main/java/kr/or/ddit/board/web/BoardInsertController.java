package kr.or.ddit.board.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardInsertController {
	
	@Inject
	private IBoardService boardService;

	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String boardForm() {
		return "board/form";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String boardInsert(BoardVO boardVO, Model model) {
		String goPage = ""; //데이터를 가용하는 부분에서 로직상 페이지 정보를 담을 공간
		
		Map<String, String> errors = new HashMap<>();
		
		if(StringUtils.isBlank(boardVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해 주세요");
		}
		
		if(StringUtils.isBlank(boardVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해 주세요");
		}
		
		if(errors.size() > 0) { //내가 넘긴 데이터가 정상이 아님
			model.addAttribute("errors", errors);
			model.addAttribute("board", boardVO);
			goPage = "board/form";
		} else { //정상적인 데이터
			boardVO.setBoWriter("a001"); //작성자 임시로 하드 코딩
			ServiceResult result = boardService.insertBoard(boardVO);
			
			if(result.equals(ServiceResult.OK)) { //등록성공
				goPage = "redirect:/board/detail.do?boNo="+boardVO.getBoNo();
			} else { //등록실패
				model.addAttribute("board", boardVO);
				goPage = "board/form";
			}
		}
		return goPage;
	}
}
