package kr.or.ddit.codingtest.cotroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/codingtest")
@Slf4j
public class CodingTestController {
	
	public static void main(String[] args) {
		Date date = new Date();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = sdf.format(date);
		String year = dateFormat.substring(0, 4);
		
		log.info(year);
	}

	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String testList() {
		
		return "codingtest/list";		
	}
	
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String getDetailByQstnNo() {
		return "codingtest/detail";		
	}
	
	
}
