package kr.or.ddit.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class CalendarController {

	@RequestMapping(value="/printCalendar.do", method=RequestMethod.GET)
	public String printCalendar() {
		log.info("잉ㅁㅇㅁㄴㅁ나ㅣ멈니ㅏㅇㅁ니ㅏㅓㅇ");
		return "calendar/test01";
	}
	
	@RequestMapping(value="/printCalendarMain.do", method=RequestMethod.GET)
	public String printCalendarMain() {
		log.info("잉ㅁㅇㅁㄴㅁ나ㅣ멈니ㅏㅇㅁ니ㅏㅓㅇ");
		return "calendar/calMain";
	}
	
	
	@RequestMapping(value="/printCalendarMy.do", method=RequestMethod.GET)
	public String printCalendarMy() {
		log.info("잉ㅁㅇㅁㄴㅁ나ㅣ멈니ㅏㅇㅁ니ㅏㅓㅇ");
		return "calendar/calMy";
	}
}
