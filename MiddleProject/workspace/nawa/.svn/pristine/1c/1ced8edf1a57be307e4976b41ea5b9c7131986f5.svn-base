package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;


@WebServlet("/signin.do")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		System.out.println("로그인왔다감");
		
		PrintWriter out = resp.getWriter();
		out.println("<script>location.href = './member/signin.jsp'</script>"); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		
		System.out.println("ㅎㅇㅎㅇ");
		
		HttpSession session = req.getSession();
				
		PrintWriter out = resp.getWriter();
			
		MemberVO mv = new MemberVO();
		
		IMemberService memService = MemberServiceImpl.getInstance();
		
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		
		mv.setMem_id(mem_id);
		mv.setMem_pw(mem_pw);
		
		System.out.println(mv.toString());
		
		if(memService.loginCheck(mv) == null) {
			
			  out.println("<script>alert('아이디나 비밀번호가 이상해용!'); location.href = './member/signin.jsp'</script>"); 
			  session.invalidate();
			 
		} else {
			session.setAttribute("LOGIN_USER", mv);
			req.getRequestDispatcher("./index.jsp").forward(req, resp);
		}
		
	}

}
