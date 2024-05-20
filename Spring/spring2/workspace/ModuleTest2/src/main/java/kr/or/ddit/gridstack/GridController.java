package kr.or.ddit.gridstack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GridController {

	@GetMapping(value="/test01.do")
	public String test1() {
		return "gridstack/test01";
	}
}
