package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.service.IheartService;
import lecture.service.heartServiceImple;
import lecture.vo.LectureVO;
import member.vo.MemberVO;

@WebServlet("/lecture/heart.do")
public class heartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("하트하트맨!~~" );
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
		String memId = mv.getMem_id();
		String lecNo = req.getParameter("lecNo");
		System.out.println("하트하트맨!~~" + memId + lecNo);
		IheartService heartService = heartServiceImple.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setMemId(memId);
		lv.setLecNo(lecNo);
		
		int cnt = heartService.registHeart(lv);
		
		String msg = "";
		if(cnt < 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html><head><script>");
		out.println("alert('즐겨찾는 강의에 추가되었습니다.');");
		out.println("location.href='" + req.getContextPath() + "/lecture/list.do';");
		out.println("</script></head></html>");
		out.flush();
		
        
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/lecture/list.do");
		
		
		
		
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
	
	}
}
