package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Board;



@Controller
@RequestMapping("/board")
public class BoardController {

	/*
	 	1. 요청 경로 매핑
	 		 @RequestMapping의 value 속성에 요청 경로를 설정한다
	 		 
	 		 - 요청 경로는 반드시 설정해야 하는 필수 정보이다
	 		 - 속성이 하나 일 때는 속성명 생략할 수 있다
	 		 - 컨트롤러의 클래스 레벨과 메서드 레벨로 지정할 수 있다
	 		 - 클래스 레벨로 요청 경로를 지정하면 메소드 레벨레엇 지정한 경로의 기본 경로로 취급된다.
	 		 - 클레스 레벨의 경로에 메소드레벨의 요청 경로를 덧붙인 형태가 최종 경로가 된다.
	 */
	
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/register")
	public void registerForm() {
		logger.info("registerForm() 실행...");
	}
	
	@RequestMapping(value="/modify")
	public void modifyForm() {
		logger.info("modifyForm() 실행...");
	}
	
	@RequestMapping(value="/list")
	public void list() {
		logger.info("list() 실행...");
	}
	
	/*
	 * 	2. 경로 패턴 매핑
	 * 
	 * 		@RequestMapping(value="/board/read/123")
	 * 
	 * 		- URL 경로상의 변하는 값을 경로 변수로 취급한다.
	 * 		- 경로 변수에 해당하는 값을 파라메터 변수에 설정할 수 있다.
	 * 			>> @PathVariable를 이용해야함
	 */
	
	@RequestMapping(value="/read/{boardNo}")
	public String read(@PathVariable int boardNo) {
		logger.info("read() 실행...");
		logger.info("boardNo>> "+ boardNo);
		return "board/read";
	}
	
	/* 
	 *  3. HTTP 메서드 매핑
	 * 	
	 * 	 	method 속성을 사용하여 http 메서드를 매핑 조건으로 지정할 수 있따.
	 * 		화면으로 응답하는 경우에는 http 메소드로 get 방식과 post방식 두 가지를 사용할 수 있따.
	 * 
	 */
//	@RequestMapping(value="/formHome", method=RequestMethod.GET)
//	public String formHome() {
//		logger.info("formHome 실행...");
//		return "formHome";
//	}
//	
//	
//	@RequestMapping(value="/register", method=RequestMethod.GET)
//	public String registerForm1() {
//		logger.info("registerForm1 실행...");
//		return "success";
//	}
//	
//	@RequestMapping(value="/register", method=RequestMethod.POST)
//	public String registerForm2() {
//		logger.info("registerForm2 실행...");
//		return "success";
//	}
//	
//	
//	@RequestMapping(value="/modify", method=RequestMethod.GET)
//	public String modifyForm1() {
//		logger.info("modifyForm1 실행...");
//		return "success";
//	}
//	
//	@RequestMapping(value="/modify", method=RequestMethod.POST)
//	public String modifyForm2() {
//		logger.info("modifyForm2 실행...");
//		return "success";
//	}
//	
//	@RequestMapping(value="/remove", method=RequestMethod.POST)
//	public String removeForm() {
//		logger.info("removeForm 실행...");
//		return "success";
//	}
//	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public String listForm() {
//		logger.info("listForm 실행...");
//		return "success";
//	}
	
	/*
	 *  4. param mapping
	 *   
	 *   	@RequestMapping(value="board/get", method=RequestMethod.GET, params="register")
	 *   		- 요청 파라메터 를 매핑 조건으로 지정하는 경우에는 params 속성을 사용한다	
	 *   
	 *   			버튼이나 링크에 따라 호출할 메서드를 바꿔야 할 때 사용
	 *   
	 */
	
	//board/get경로 ,get방식, reigster 요청 파라메터에 대한 처리
	@RequestMapping(value="/get", method=RequestMethod.GET, params="register")
	public String registerFormParamsGet() {
		logger.info("registerFormParamsGet() 실행...");
		return "board/register";
	}	
	
	//board/post경로 ,post방식, reigster 요청 파라메터에 대한 처리
	@RequestMapping(value="/post", method=RequestMethod.POST, params="register")
	public String registerFormParamsPost() {
		logger.info("registerFormParamsPost() 실행...");
		return "board/list";
	}
	
	//board/get경로 ,get방식, modify 요청 파라메터에 대한 처리
	@RequestMapping(value="/get", method=RequestMethod.GET, params="modify")
	public String modifyFormParamsGet() {
		logger.info("modifyFormParamsGet() 실행...");
		return "board/modify";		
	}
	
	//board/post경로 ,post방식, modify 요청 파라메터에 대한 처리
	@RequestMapping(value="/post", method=RequestMethod.POST, params="modify")
	public String modifyFormParamsPost() {
		logger.info("modifyFormParamsPost() 실행...");
		return "board/list";		
	}
	
	//board/get경로 ,get방식, remove 요청 파라메터에 대한 처리
	@RequestMapping(value="/get", method=RequestMethod.GET, params="remove")
	public String removeFormParamsGet() {
		logger.info("removeFormParamsGet() 실행...");
		return "board/remove";
	}
	
	//board/post경로 ,post방식, remove 요청 파라메터에 대한 처리
	@RequestMapping(value="/post", method=RequestMethod.POST, params="remove")
	public String removeFormParamsPost() {
		logger.info("removeFormParamsPost() 실행...");
		return "board/list";
	}
	
	//board/get경로 ,get방식, list 요청 파라메터에 대한 처리
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "list")
	public String listParamsGet() {
		logger.info("listParamsGet() 실행...");
		return "board/list";
	}
	
	//board/get경로 ,get방식, read 요청 파라메터에 대한 처리
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "read")
	public String readParamsGet() {
		logger.info("readParamsGet() 실행...");
		return "board/read";
	}
	
	/*
	 * 	headers 매핑
	 * 
	 * 		요청 헤더를 매핑 조건으로 지정하는 경우네는 headers 속성을 사용한다.
	 * 
	 */
	
	//headers 매핑 테스트
	@RequestMapping(value="/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		logger.info("ajaxHome() 실행...");
		return "ajaxHome";
	}
	
	//headers 매핑이지만 headers 설정을 하지 않고 요청함
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyPut(@PathVariable int boardNo){
		logger.info("ResponseEntity() 실행...");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT,
					headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(
			@PathVariable int boardNo, 
			@RequestBody Board board //@RequestBody로 지정해줘야함
			){
		logger.info("modifyByHeader()... 실행");
		logger.info("boardNo>> " + boardNo );
		logger.info("board.getTitle()>> "  + board.getTitle());
		logger.info("board.getContent()>> "  + board.getContent());
		logger.info("board.getWriters()>> "  + board.getWriter());
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
	}
	
	
	/*
	 *  6. Content Type 매핑
	 *  
	 *   	- 요청의 contentType 헤더 값을 매핑 조건으로 지정하는 경우에는 consume 속성을 사용함
	 */
	
	//consume 속성값 지정하지 않으면 기본적으로 application/json 미디어 타입으로 기본ㅇ로 설정됨
	@RequestMapping(value="/{boardNo}", method=RequestMethod.POST)
	public ResponseEntity<String> modifyContentType(
			@PathVariable int boardNo, @RequestBody Board board){
		
		logger.info("modifycontentType() 실행...");
		logger.info("boardNo>> " + board.getBoardNo());
		logger.info("boardTitlte>> " + board.getTitle());
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<String> modifyByJson(
			@PathVariable int boardNo, @RequestBody Board boad
			){
		logger.info("modifyByJSon()실행... ");
		logger.info("boarNo>> " + boardNo);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, consumes="application/xml")
	public ResponseEntity<String> modifyByXml(
			@PathVariable int boardNo, @RequestBody Board board
			){
		logger.info("modifyByXml()실행... ");
		logger.info("boardNo>> " + boardNo);
		logger.info("board.getTitle()>> " + board.getTitle());
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	/*
	 *  7. Accpet 매핑 
	 *  
	 *  	- produces 속성값을 지정해서 요청하는 미디어 타입을 처리
	 * 
	 */
	
	//produces 속성값을 지정하지 않으면 기본적으로 json타입
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> readAccept(@PathVariable int boardNo){
		
		logger.info("readAccept()실행... ");
		Board board = new Board();
		board.setTitle("제먹");
		board.setContent("내영");
		board.setWriter("작성자");
		
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//produces 속성값에 applicaton/json미디어 타입 지정
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<Board> readToJson(@PathVariable int boardNo){
		
		logger.info("readToJson()실행... ");
		
		String addStr = "_json";
		Board board = new Board();
		board.setTitle("제먹" + addStr);
		board.setContent("내영" + addStr);
		board.setWriter("작성자" + addStr);
		
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//produces 속성값을 applicaton/xml로 지정
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET, produces="application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable int boardNo){
		
		logger.info("readToXml()실행... ");
		
		String addStr = "_xml";
		Board board = new Board();
		board.setTitle("제먹" + addStr);
		board.setContent("내영" + addStr);
		board.setWriter("작성자" + addStr);
		
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
}





























