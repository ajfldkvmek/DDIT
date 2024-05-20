package kr.or.ddit.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private IBoardService service;
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String boardList(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model
			) {
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>();
		
		// 검색이 이뤄지면 아래가 실행됨
		// 검색이 이뤄졌다는걸 정확하게 확인하기 위해서 searchWord가 비어있지 않을때
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		// startRow, endRow, startPage, endPage를 설정
		pagingVO.setCurrentPage(currentPage);
		
		// totalRecord라는 총 게시글 수
		int totalRecord = service.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord); // totalPage 설정
		
		List<BoardVO> dataList = service.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "board/list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) {
		
		BoardVO board = service.selectBoard(boNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public String boardForm() {
		return "board/form";
	}
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String boardInsert(
			BoardVO boardVO, Model model, 
			RedirectAttributes ra, 
			HttpServletRequest req
			) throws Exception {
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		if(StringUtils.isBlank(boardVO.getBoTitle())) {
			errors.put("boTitle",  "제목을 입력해주세요.");
		}
		if(StringUtils.isBlank(boardVO.getBoContent())) {
			errors.put("boContent",  "내용을 입력해주세요.");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("boardVO", boardVO);
			goPage = "board/form";
		}else {
			HttpSession session = req.getSession();
			MemberVO memberVO = (MemberVO) session.getAttribute("SessionInfo");
			if(memberVO != null) { // 로그인을 정상적으로 진행 한 이후
				boardVO.setBoWriter(memberVO.getMemId());
				ServiceResult result = service.insertBoard(req, boardVO);
				if(result.equals(ServiceResult.OK)) {
					goPage = "redirect:/board/detail.do?boNo=" + boardVO.getBoNo();
				}else {
					model.addAttribute("message", "서버에러, 다시 시도해주세요.");
					goPage = "board/form";
				}
			}else { // 로그인을 처리하지 않은 상태
				ra.addFlashAttribute("message", "로그인 후에 사용 가능합니다!");
				goPage = "redirect:/signin.do";
			}
		}
		return goPage;
	}
	
	
	
	
	
	
	
}

