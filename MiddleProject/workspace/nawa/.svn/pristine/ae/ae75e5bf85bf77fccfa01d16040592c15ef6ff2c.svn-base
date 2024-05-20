package meet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MeetVO;
import member.vo.MemberVO;

/**
 * Servlet implementation class meetHeart
 */
@WebServlet("/meetHeart")
public class meetHeart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("하트하트맨!~~" );
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberVO mem = (MemberVO) session.getAttribute("LOGIN_USER");
		String memId = mem.getMem_id();
		String meetNo = req.getParameter("meetNo");
		System.out.println("하트하트맨!~~" + memId + meetNo);
		IMeetService meetService =  MeetServiceImpl.getInstance();
		
		MeetVO mv = new MeetVO();
		mv.setMem_id(memId);
		mv.setMeet_no(meetNo);
		
		int cnt = meetService.registerHeart(mv);
		System.out.println("하트컨트롤러 cnt:"+ cnt);
		String msg = "";
		if(cnt < 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><head><script>");
		out.println("alert('즐겨찾는 강의에 추가되었습니다.');");
		out.println("location.href='" + req.getContextPath() + "/meetList';");
		out.println("</script></head></html>");
		out.flush();
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/meet/meetList");
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
