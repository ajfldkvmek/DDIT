package kr.or.ddit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
//@Slf4j << lombok에서 제공하는 로그출력 어노테이션
@Controller
@Slf4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	 * 장  4. 커트롤러 응답
	 * 
	 *  
	 *  1) void 타입
	 *  	- 호출하는 url과 동일한 뷰 이름을 나타내기 위해 사용
	 */
	
	//요청경로  (/goHome0101)과 동일한 뷰(/goHome0101.jsp)를 가르킨다
	@RequestMapping(value="/goHome0101", method = RequestMethod.GET)
	public void goHome0101() {
		log.info("goHome0101()실행");
	}
	
	//요청경로  (/goHome0102)과 동일한 뷰(/sub/goHome0102.jsp)를 가르킨다
	@RequestMapping(value="/sub/goHome0102", method = RequestMethod.GET)
	public void goHome0102() {
		log.info("goHome0102()실행");
	}
	
	
	/*
	 *  2. String 타입
	 *  
	 *   	- 뷰 파일의 경로와 파일 이름을 나타내기 위해  사용
	 */
	
	//반환값이 home0201 이므로 >> /home0201.jsp로 찾아갈 것임
	@RequestMapping(value="/home0201", method = RequestMethod.GET)
	public String goHome0201() {
		log.info("goHome0201()실행");
		return "home0201";
	}
	
	
	//반환값이 home0202 이므로 >> /home0202.jsp로 찾아갈 것임
	@RequestMapping(value="/home0202", method = RequestMethod.GET)
	public String goHome0202() {
		log.info("goHome0202()실행");
		return "home0202";
	}
	
	//반환값이 home0203 이므로 >> /home0203.jsp로 찾아갈 것임
	@RequestMapping(value="/sub/home0203", method = RequestMethod.GET)
	public String goHome0203() {
		log.info("goHome0203()실행");
		return "sub/home0203"; // >> 이놈은 기본적으로 forward 형태로 전달함 >>>>> "redircect:/subs/home0203" 처럼 명시해줘야 리다이렉트
	}
	
	@RequestMapping(value="/sub/home0204", method = RequestMethod.GET)
	public String goHome0204() {
		log.info("goHome0204()실행");
		return "redirect:/sub/home0203";
	}
	

	// '/'로 시작하면 웹 어플리케이션의 컨텍스트 경로에 영향을 받지 않은 절대 경로를 의미함
	// 해당경로: D:> workspace > .metadate > .pluging > ... > projectname > WEB-INF > views > sub > .jsp
	@RequestMapping(value="/sub/home0205", method = RequestMethod.GET)
	public String goHome0205() {
		log.info("goHome0205()실행");
		return "/sub/home0205";
	}
	
	
	/*
	 * 	3. 자바빈즈 클래스 타입(VO)
	 * 
	 * 		- json 객체 타입의 데이터를 만들어서 반환하는 용도로 사용
	 * 
	 * 	@RespoonseBody 를 이용한 방식
	 * 
	 *  @RestController 를 이용한 방식
	 *  
	 *  @ResponseBody 를 지정하지 않으면 404에러 발생
	 *  (jackson-databin 라이브러리가 설정되어 있지 않는 경우도 포함
	 *  
	 *  @ResponseBody가 객첼르 리턴하여 객체를 응답 데이터로 보내는 역할을 함
	 *  
	 *  @ResponseBody의 return default데이터 형식은 json이다
	 *  
	 *  @ResponseBody 대신에 @RestController(@Controller + @ResponseBody) 로 대체할 수 있따.
	 *  
	 */
	
	//기본적으로 return값이 제대로 잡혀있지 않으면 value를 기준으로 이동할 주소를 찾는다
	
	@ResponseBody
	@RequestMapping(value="/goHome0301", method = RequestMethod.GET)
	public Member goHome0301() {
		log.info("goHome0301() 실행... ");
		return new Member();
	}
	

	/*
	 *  4. Collection List 타입
	 *  
	 *   JSON 객체 배열타입의 데이터를 만들어서 변환하는 용도로 사용
	 * 
	 */
	
	//반환값이 컬렉션 List타입이면 json 객체 배열 타입으로 자동 변환된다 >> api가 보통 이 형태로 온다	
	@ResponseBody
	@RequestMapping(value="/goHome0401", method = RequestMethod.GET)
	public List<Member> goHome0401() {
		log.info("goHome0401() 실행... ");
		
		List<Member> list = new ArrayList<Member>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		list.add(member1);
		list.add(member2);
		
		return list;
	}
	
	
	/*
	 *  5. Collection Map 타입
	 *  
	 *   Map형태의 자료를 JSON 객체 배열타입의 데이터로 만들어서 변환하는 용도로 사용
	 * 
	 */
	
	//반환값이 컬렉션 map 타입이면 json 객체 타입으로 자동 변환된다
	@RequestMapping(value="/goHome0501", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Member> goHome0501() {
		log.info("goHome0501() 실행... ");
		
		Map<String, Member> map = new HashMap<>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		
		map.put("key1", member1);
		map.put("key2", member2);
		
		return map;
	}
	
	
	//200 OK 전송
	// void 타입은 아무런 형태가 아는데 제네릭 타입의 뭔가는 채워야겠어서 채우는 placeholder과 같은 느낌 같은 느낌
	@RequestMapping(value= "/goHome0601", method=RequestMethod.GET)
	public ResponseEntity<Void> goHome0601(){
		log.info("goHome0601() 실행... ");
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		//내가 요청한 url로 응답니 나가면서 응답데이터로 아무런 값도 전달되지 않는다.
		//해당 url 요청 후 브라우저에서 개발자 도구를 이용하여 네트워크 탭을 확인해보
		//응답으로 url 응답이 나간걸 확인할 수 있는데 이 때 상태코드 200으로 정상응답이 나간 걸 확인 가능
		//
		//그리고, 다른 기능으로 아무런 형태없이 응답으로 나가지만 응답에 대한 header 정보를 변경하고자 할 때 사용
	}
	
	
	/* 
	 *  7. repsonseEntity<String> 타입
	 *  
	 *  - response 할 때 http 헤더 정보와 문자열 데이터를 전달하는 용도로 사용한다.
	 * 
	 */
	//SUCCESS와 상태코드OK 전송
	@ResponseBody
	@RequestMapping(value="/goHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> goHome0701() {
		log.info("goHome0701() 실행... ");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	/*
	 *  8. ResponseEntity<자바빈즈클래스> 타입
	 *  
	 *   - response 할 대 Http 헤더 정보와 객체 데이터를 전달
	 * 
	 */
	//객체의 JSON 타입 데이터와 HTTP헤더 정보 전달
	@RequestMapping(value="/goHome0801", method=RequestMethod.GET)
	public ResponseEntity<Member> goHome0801(){
		log.info("goHome0801() 실행... ");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	
	/*
	 *  9. ResponseEntity<List> 타입
	 *  
	 *   - response 할 대 Http 헤더 정보와 객체배열 데이터를 전달하는 용도로 사용
	 * 
	 */
	@ResponseBody //페이지가 아니라 데이터임을 알이기 위함
	@RequestMapping(value="/goHome0901", method=RequestMethod.GET)
	public ResponseEntity<List<Member>> goHome0901(){
		log.info("goHome0901() 실행... ");
		List<Member> list = new ArrayList<Member>();
		Member member1 = new Member();
		Member member2 = new Member();
		list.add(member1);
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	
	/*
	 *  10. ResponseEntity<Map> 타입
	 *  
	 *   - response 할 대 Http 헤더 정보와 객체데이터를 Map형태로 전달
	 */
	
	@RequestMapping(value="/goHome1001", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> goHome1001(){
	
		log.info("goHome1001() 실행... ");
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		
		map.put("key1", member1);
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK); 
		//ResponseEntity가 있을 경우 @ResponseBody가 없어도 페이지가 아닌 응답으로 인식해서 크게 문제는 없지만 명시하는 것이 좋음
	}
	
	
	
	/*
	 *  11. ResponseEntity<byte[]> 타입
	 *
	 *   - response 할떄 HTTP 헤더 정보와 바이너리 파일 데이터를 전달하는 용도로 사용
	 * 
	 * 	무료/유료 이미지 다운로드 홈페이지를 사용해 보면 이미지 미리보기 후 다운로드를 할 수 있는 기능이 제공됨
	 *  이와 같은 리턴 타입의 형태를 설정해서 내보내는 것과 같음
	 *  
	 */
	//바이트 배열로 이미지 전송
	@ResponseBody
	@RequestMapping(value="/goHome1101", method=RequestMethod.GET)
	public ResponseEntity<byte[]> goHome1101(){
		log.info("goHome1101() 실행... ");
				
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			in = new FileInputStream("D:/img0.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				in.close();
			} catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return entity;
	}
	
	
	/*
	 *  12. ResponseEntity<bytep[]> 타입
	 *  	
	 *  	- file download
	 */
	
	@ResponseBody
	@RequestMapping(value="/goHome1202", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goHome1202() {
		
		log.info("goHome1202() 실행... ");
		
		String fileName = "ddit_download_file.zip";
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			in = new FileInputStream("D:/img0.jpg");
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" +
						new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				in.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		return entity;
	}
	
}
