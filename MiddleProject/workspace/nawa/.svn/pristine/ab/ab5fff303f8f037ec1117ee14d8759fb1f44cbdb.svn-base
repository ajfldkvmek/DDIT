package lecture.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.service.IinvolveService;
import lecture.service.involveServiceImple;
import lecture.vo.LectureVO;
import member.vo.MemberVO;

@WebServlet("/lecture/involve.do")
public class involveController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
		String memId = mv.getMem_id();
		String lecNo = req.getParameter("lecNo");
		Random rand = new Random();
		int a = rand.nextInt(10000) + 1;
		String lmNo = Integer.toString(a);
		
		IinvolveService involveService = involveServiceImple.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setMemId(memId);
		lv.setLecNo(lecNo);
		lv.setLmNo(lmNo);
		
		
		resp.sendRedirect(req.getContextPath() + "/lecutre/detail.do");
		
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	
	}
	
}
