package kr.or.ddit.main.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.vo.MainVO;

@Controller
public class MainController {
	
	@Inject
	private IMainService mainService;
	
	@RequestMapping(value= {"/", "main.do"}, method= RequestMethod.GET)
	public String main(Model model) {

		MainVO mv = mainService.getMain();
		
		model.addAttribute("mv", mv);
		
		return "main";
	}
}