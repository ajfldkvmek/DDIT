package kr.or.ddit.book.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.BookService;

/*
	@Controller 어노테이션이 있는 클래스는 스프링이 브라우저의 요청을 받아들이는 컨트롤러라고 인지해서
	자바빈(java bean)으로 등록해서 관리한다
 */
@Controller
@RequestMapping("/book")
public class BookInsertController {
	
	/*
	 	서비스를 호출하기 위해 @Autowired 어노테이션 사용
	*/
	@Autowired
	private BookService bookService;
	
	/*
		@RequestMapping
		요청 URL을 어떤 메소드가 처리할 지 여부를 결정
		
		method 속성은 http요청 메소드를 의미한다
		일반적인 웹페이지 개발에서 get 메소드는 데이터를 변경하지 않은 경우에만 사용된다
		
		ModelAndView는 컨트롤러가 반환할 데이터를 담당하는 모델(model)과 화면을 담당하는 뷰(view)의 경로를 합쳐놓은 객체이다
		
		ModelAndVie의 생성가제 문자열 타입 파라메터가 입력되면 뷰의 경로라고 간주한다
		
		뷰의 경로를 'book/form'과 같은 형태로 전달하는 이유는 요청에 해당하는 url의 mapping되는 화면의 경로 값을
		ViewResolver라는 녀석이 제일 먼저 받음
		
		받아서 prefix, suffix 속성에 의해서 앞에는 'WEB-INF/views/'를 붙이고 뒤에는 .jsp를 붙여 최종 위치에 해당하는 jsp파일을 찾아줌
		
	 */
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public ModelAndView bookForm() {
		return new ModelAndView("/book/form");
	}
	
	/*
	 	데이터의 변경이 일어나므로 http메소드는 post방식으로 처리ㄷ
	 	@RequestMapping의 각 속성은 2개이상 사용해야 할 때 무조건 명시해줘야함
	 	
	 	Map 타입의 경우 @RequestParam을 붙여야만 http파라메터 값을 map 안에 바인딩 할 수 있음 <<<<< 진자 개 중요
	 */
	@RequestMapping(value="/form.do", method=RequestMethod.POST)
	public ModelAndView insertBook(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String bookId = bookService.insertBook(map);	
		
		if(bookId == null) {
			//데이터 입력이 실패할 경우 다시 데이터 입력을 받아야 하므로 redirect한다
			//ModelAndView 객체는 .setViewName() 메소드를 통해 뷰의 경로를 지정할 수 있다
			mav.setViewName("redirect:/book/form.do");
		} else {
			//데이터 입력이 성공하면 상세페이지로 이동
			mav.setViewName("redirect:/book/detail.do?bookId="+bookId);
		}
		
		return mav;
	}
}
