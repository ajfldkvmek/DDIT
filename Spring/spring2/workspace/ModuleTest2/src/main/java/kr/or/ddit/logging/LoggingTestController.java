package kr.or.ddit.logging;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.ILogService;

@Controller
//@Slf4j
@RequestMapping("/aop")
public class LoggingTestController {

	@Inject
	private ILogService logService;
	
	@RequestMapping(value="/test01", method=RequestMethod.GET)
    public String logTest(Model model) {
        String name = "Spring";
//        log.trace("trace log = {}", name);
//        log.debug("debug log = {}", name);
//        log.info("info log = {}", name);
//        log.warn("warn log = {}", name);
//        log.error("error log = {}", name);

        String[] strArr = new String[100];
        for(int i = 0 ; i < 100; i++) {
        	strArr[i] = 1+" ";
        }
        
        String str = logService.appendString(strArr);
        
        model.addAttribute("str", str);
        
        return "logtest/logtest01";
    }
	
	@RequestMapping(value="/test02", method=RequestMethod.GET)
    public String logTest2(Model model) {
		
		String s = logService.test();
		
		model.addAttribute("msg", s);
		
		return "logtest/logtest02";
	}
	
	@RequestMapping(value="/test03", method=RequestMethod.GET)
    public String logTest3() {
		
		return "logtest/logtest03";
	}
	
	
}
