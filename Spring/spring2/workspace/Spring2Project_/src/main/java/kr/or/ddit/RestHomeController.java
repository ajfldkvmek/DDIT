package kr.or.ddit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestHomeController {
	
	@RequestMapping(value="goRestHome0301", method = RequestMethod.GET)
	public Member restHome0301(){
		log.info("restHome0301 실행.. ");
		return new Member();
	}
	
	@ResponseBody
	@RequestMapping(value="/goRestHome0401", method = RequestMethod.GET)
	public List<Member> goRestHome0401() {
		log.info("goRestHome0401() 실행... ");
		
		List<Member> list = new ArrayList<Member>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		list.add(member1);
		list.add(member2);
		
		return list;
	}
	
	@RequestMapping(value="/goRestHome0501", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Member> goRestHome0501() {
		log.info("goRestHome0501() 실행... ");
		
		Map<String, Member> map = new HashMap<>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		
		map.put("key1", member1);
		map.put("key2", member2);
		
		return map;
	}
	
	
	/* 
	 * 
	 *  6. responseEntityType<Void> 타입
	 *  
	 *  	- response 할 때, HTTP 헤더 정보와 내용을 가공하는 용도로 사용된다.
	 *  
	 */
	
	//200 OK 전손
	// void 타입은 아무런 형태가 아는데 제네릭 타입의 뭔가는 채워야겠어서 채우는 placeholder과 같은 느낌 같은 느낌
	@RequestMapping(value= "/goRestHome0601", method=RequestMethod.GET)
	public ResponseEntity<Void> goRestHome0601(){
		log.info("goRestHome0601() 실행... ");
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		//내가 요청한 url로 응답니 나가면서 응답데이터로 아무런 값도 전달되지 않는다.
		//해당 url 요청 후 브라우저에서 개발자 도구를 이용하여 네트워크 탭을 확인해보
		//응답으로 url 응답이 나간걸 확인할 수 있는데 이 때 상태코드 200으로 정상응답이 나간 걸 확인 가능
		//
		//그리고, 다른 기능으로 아무런 형태없이 응답으로 나가지만 응답에 대한 header 정보를 변경하고자 할 때 사용
	}
	
	@ResponseBody
	@RequestMapping(value="/goRestHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> goRestHome0701() {
		log.info("goRestHome0701() 실행... ");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/goRestHome0801", method=RequestMethod.GET)
	public ResponseEntity<Member> goRestHome0801(){
		log.info("goRestHome0801() 실행... ");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@ResponseBody //페이지가 아니라 데이터임을 알이기 위함
	@RequestMapping(value="/goRestHome0901", method=RequestMethod.GET)
	public ResponseEntity<List<Member>> goRestHome0901(){
		log.info("goRestHome0901() 실행... ");
		List<Member> list = new ArrayList<Member>();
		Member member1 = new Member();
		Member member2 = new Member();
		list.add(member1);
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}

	
	@RequestMapping(value="/goRestHome1001", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> goRestHome1001(){
		log.info("goRestHome1001() 실행... ");
		Map<String, Member> map = new HashMap<String, Member>();
		
		Member member1 = new Member();
		Member member2 = new Member();
		
		map.put("key1", member1);
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK); 
		//ResponseEntity가 있을 경우 @ResponseBody가 없어도 페이지가 아닌 응답으로 인식해서 크게 문제는 없지만 명시하는 것이 좋음
	}
	
	@ResponseBody
	@RequestMapping(value="/goRestHome1101", method=RequestMethod.GET)
	public ResponseEntity<byte[]> goRestHome1101(){
		log.info("goRestHome1101() 실행... ");
				
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
	
	
	@RequestMapping(value="/goRestHome1202", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goRestHome1202() {
		
		log.info("goRestHome1202() 실행... ");
		
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
