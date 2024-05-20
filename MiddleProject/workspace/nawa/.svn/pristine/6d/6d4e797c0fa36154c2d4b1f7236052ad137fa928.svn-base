package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/signUp.do")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("post왔어양!!!!!!");
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		String mem_id = req.getParameter("mem_id");
		String mem_pass = req.getParameter("mem_pass");
		String mem_bir = req.getParameter("mem_bir");
		mem_bir = mem_bir.substring(2, mem_bir.length());
		String mem_name = req.getParameter("mem_name");
		String mem_nick = req.getParameter("nickName");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("mem_mail");
		String addr = req.getParameter("mem_add1");
		
		String[] str = addr.split(" ");
		String add1 = str[1];
		String add2 = str[2];
		
		add1 = add1+" "+add2;
		add2 = req.getParameter("mem_add2");
		
		
		MemberVO mv = new MemberVO();	
		
		System.out.println(phone);
		System.out.println(">>>>>" + add2);
		
		mv.setMem_id(mem_id);
		mv.setMem_pw(mem_pass);
		mv.setMem_birth(mem_bir);
		mv.setMem_name(mem_name);
		mv.setMem_nick(mem_nick);
		mv.setMem_telno(phone);
		mv.setMem_email(mail);
		mv.setMem_add1(add1);
		mv.setMem_add2(add2);
		
		IMemberService memService = MemberServiceImpl.getInstance();
		//int res = memService.insertMember(mv);
		
		if(memService.insertMember(mv) != 0) {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입성공 메인페이지로 갑니다!'); location.href = './index.jsp'</script>"); 
		}
	}
}
