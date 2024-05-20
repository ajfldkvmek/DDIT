package meet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MeetVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

/**
 * Servlet implementation class meetDetail
 */
@WebServlet("/meetDetail")
public class meetDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meetNo = req.getParameter("meetNo");
		System.out.println(">>>>>>>>>>>>"+meetNo);
		IMeetService meetService =  MeetServiceImpl.getInstance();
		//IMemberService memService = MemberServiceImpl.getInstance();//membervo 가져올수있음 
		System.out.println("디테일시작");
		
//		HttpSession session = req.getSession();//로그인정보 세션 
//		MemberVO mem = new MemberVO();
//		mem = (MemberVO) session.getAttribute("LOGIN_USER");
		
		
		MeetVO mv = meetService.getDetail(meetNo);
		req.setAttribute("mv",mv);
//		req.setAttribute("mem",mem);
		req.getRequestDispatcher("meet/meetdetail.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
