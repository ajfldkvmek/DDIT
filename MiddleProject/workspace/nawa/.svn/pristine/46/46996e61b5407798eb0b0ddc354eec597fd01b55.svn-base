package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		int a = rand.nextInt(10000000) + 1;
		String lmNo = Integer.toString(a);
		
		System.out.println("인벌브 저장했음>>" + lmNo);
		IinvolveService involveService = involveServiceImple.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setMemId(memId);
		lv.setLecNo(lecNo);
		lv.setLmNo(lmNo);
		System.out.println("인벌브 저장했음>>" + lv);
		
		PrintWriter out = resp.getWriter();
		
		// 강의인원 추가
		int cnt = involveService.checkLec(lecNo);
		if(cnt>0) {
			//강의추가임
			involveService.registHeart(lv);
			out.print("<script>alert('등록되었습니다!');" +
					"window.location.href='../lecture/list.do';" +
					"</script>");
			out.close();
		} else {
			out.print("<script>alert('신청인원이 꽉 찼습니다ㅠㅠ~');" +
					"window.location.href='../lecture/list.do';" +
					"</script>");
			out.close();
		}
		
		// "/lecture/count.do"
//		resp.sendRedirect(req.getContextPath() + "/lecture/list.do");
//		resp.sendRedirect(req.getContextPath() + "/lecture/count.do?lecNo=" + lv.getLecNo());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	
	}
	
}
