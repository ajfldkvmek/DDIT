package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet("/member/editProfile.do")
public class editProfileController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		System.out.println("edit profile왔어");

		IMemberService memService = MemberServiceImpl.getInstance();
		
		HttpSession session = req.getSession();
		String pw = ((MemberVO) session.getAttribute("LOGIN_USER")).getMem_pw();
		
		String old_pw = req.getParameter("old_pw");
		if( !(pw.equals(old_pw)) ) {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('잘못된 비밀번호 입니다'); ");
			out.print("location.href= '/nawa/member/edit_profile.jsp'");
			out.print("</script>");
		}
		
		MemberVO mv = new MemberVO();
		
		
		String mem_nick = ( (req.getParameter("mem_nick") != null) && (!req.getParameter("mem_nick").equals("")) ) ? 
				req.getParameter("mem_nick") : "john doe";
		String mem_email = req.getParameter("mem_email");
		String mem_telno = req.getParameter("mem_telno");
		String add = req.getParameter("add");
		String new_pw = req.getParameter("new_pw");
		
		String[] str = add.split(" ");
		String mem_add1 = str[0];
		String mem_add2 = str[1];
		
		mv.setMem_nick(mem_nick);
		mv.setMem_email(mem_email);
		mv.setMem_telno(mem_telno);
		mv.setMem_add1(mem_add1);
		mv.setMem_add1(mem_add2);
		mv.setMem_pw(new_pw);
		
		int res = memService.updateMember(mv);
		
	}
}
