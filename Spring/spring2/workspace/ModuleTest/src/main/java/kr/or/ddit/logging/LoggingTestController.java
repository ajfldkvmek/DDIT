package kr.or.ddit.logging;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class LoggingTestController {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String logTest() {
        String name = "Spring";
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "logtest/logtest";
    }
}
