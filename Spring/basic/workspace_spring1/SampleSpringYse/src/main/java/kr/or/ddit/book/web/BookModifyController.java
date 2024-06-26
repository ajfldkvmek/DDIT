package kr.or.ddit.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.BookService;

import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookModifyController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = bookService.selectBook(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", detailMap);
		mav.setViewName("book/update");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		
		//System.out.println("dasdsdds>>> " + map);
		ModelAndView mav = new ModelAndView();

		boolean isUpdateSuccess = bookService.updateBook(map);
		if(isUpdateSuccess) {
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		} else {
			mav = update(map);
		}
		return mav;
	}
	
	@RequestMapping(value= "/delete.do", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = bookService.deleteBook(map);
		
		if(isDeleteSuccess) {
			mav.setViewName("redirect:/book/list.do");
		} else {
			String boodId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId="+boodId);
		}
		return mav;
	}
}
