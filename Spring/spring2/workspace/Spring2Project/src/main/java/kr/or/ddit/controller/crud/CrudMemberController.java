package kr.or.ddit.controller.crud;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.crud.CrudMember;

@Controller
@RequestMapping("/crud/member")
public class CrudMemberController {

	@Inject
	private IMemberService service;
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String crudMemberController() {
		return "crud/member/register";
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String crudMemberRegister(CrudMember member, Model model) throws IOException {
		service.register(member);
		model.addAttribute("msg", "등록완료ㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛㅛ");
		return "crud/member/success";
	}
	
	//crudMemberList:get
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String crudMemberList(Model model) {
		List<CrudMember> memberList = service.list();
		model.addAttribute("memberList", memberList);
		System.out.println(memberList);
		return "crud/member/list";
	}
	
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String crudMemberRead(int userNo, Model model) {
		
		CrudMember member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/read";
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String crudMemberModifyForm(int userNo, Model model) {
		System.out.println("asdasaasddasasd");
		CrudMember member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String crudMemberModify(CrudMember member, Model model) {
		service.modify(member);
		model.addAttribute("msg", "스정완료");
		return "crud/member/success";
	}
	
	
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String crudMemberRemove(int userNo, Model model) {
		service.remove(userNo);
		System.out.println("dasdsaadsadsasdasdadsasddsa");
		model.addAttribute("msg", "삭제 해ㅅ따");
		return "crud/member/success";
	}
	
		
	
	
	
}
