package meet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MeetVO;


@WebServlet("/meetUpdate")
public class meetUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meetNo = req.getParameter("meetNo");
		System.out.println("updatedoget시작");
		IMeetService meetService = MeetServiceImpl.getInstance();
		MeetVO mv = meetService.getDetail(meetNo);
		req.setAttribute("mv", mv);
		req.getRequestDispatcher("meet/meetupdate.jsp").forward(req, resp);
		System.out.println("updatedoget끝");
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset:UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String meetNo = req.getParameter("meetNo");
		String meetName = req.getParameter("meetName");
		String meetInfo =req.getParameter("meetInfo");
		String meetLevel =req.getParameter("meetLevel");
		int meetLimit =Integer.parseInt(req.getParameter("meetLimit"));
		String meetLoc =req.getParameter("meetLoc");
		System.out.println("update 들어감");
		
		IMeetService meetService = MeetServiceImpl.getInstance();
		MeetVO mv = new MeetVO();
		mv.setMeet_no(meetNo);
		mv.setMeet_name(meetName);
		mv.setMeet_info(meetInfo);
		mv.setMeet_level(meetLevel);
		mv.setMeet_limit(meetLimit);
		mv.setMeet_loc(meetLoc);
		
		System.out.println("update dopost시작"+mv);
		int cnt =meetService.modifyMeet(mv);
		String msg = "";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		//목록화면으로 포워딩처리
		//req.getRequestDispatcher("/member/list.do").forward(req, resp);
		
		//목록화면으로 리다이렉팅처리
		resp.sendRedirect(req.getContextPath()+"/meetList");
	}

}
