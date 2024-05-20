package kr.or.ddit.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.BookService;

import java.util.List;
import java.util.Map;
// Book 목록과 상세보기를 가용할 페이지

@Controller
@RequestMapping("/book")
public class BookRetrieveController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list.do")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> list = bookService.selectBookList(map);
		//System.out.println("Asdasasads" + list);
		mav.addObject("booklist", list);
		mav.setViewName("/book/list");
		return mav;
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		
		Map<String, Object> detailMap = bookService.selectBook(map);
		ModelAndView mav = new ModelAndView();
		
		//ModelAndView 객체 mav에 뷰로 전달할 데이터 다믄다
		//book이라는 키의 이름으로 쿼리 결과를 담았다(bookId에 해당하는 book정보)
		mav.addObject("book", detailMap);
		String bookId = map.get("bookId").toString();		
		mav.addObject("bookId", bookId);
		mav.setViewName("book/detail");
		
		return mav;
	}
}
