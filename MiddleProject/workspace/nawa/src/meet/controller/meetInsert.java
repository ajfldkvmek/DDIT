package meet.controller;

import java.io.IOException;
import java.util.Random;

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
 * Servlet implementation class meetInsert
 */
@WebServlet("/meetInsert")
public class meetInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("mb인서트컨트롤러");
		req.getRequestDispatcher("meet/meetinsert.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mb인서트 컨트롤러 post");
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		
		/* String meetId = req.getParameter("meetId"); */
		/* String meetNo = req.getParameter("meetNo"); */
		String meetName = req.getParameter("meetName");
		String meetInfo = req.getParameter("meetInfo");
		String meetDay = req.getParameter("meetDay");
		String meetTime = req.getParameter("meetTime");
		String meetLevel = req.getParameter("meetLevel");
		int meetLimit = Integer.parseInt(req.getParameter("meetLimit"));
		String meetLoc = req.getParameter("meetLoc");
		String meetLocDetail = req.getParameter("meetLocDetail");
		
		System.out.println(">>>>>>>" +meetName +"  "+meetInfo+"  "+meetDay+"  "+meetTime+"  "
						+meetLevel+"  "+meetLimit+"  "+meetLoc+"  "+meetLocDetail);
		
		System.out.println("인서트post"+ meetLoc);
		
		////////////////////////////////////////////////////////////
		Random rand = new Random();
		int a = rand.nextInt(10000) + 1; //여기서 10000은 0~ 9999의 범위를 말함
		//if(a < 1000) a+=1000; //그냥 단순히 자릿수 맞춰주려고 필수는 아님,
		
		String meetNo = "spo"+a; //여기서는 spo로 했지만 이후 생성 할 때는 카테고리에 맞게 변수명 바꿔주려고...
		
		System.out.println("세션불러오기");
		HttpSession session = req.getSession();
		MemberVO mv2 =	(MemberVO) session.getAttribute("LOGIN_USER");
		String mem_id = mv2.getMem_id();
		
		
		System.out.println("memid>>>>>>>>" + mem_id);
		IMeetService meetService = MeetServiceImpl.getInstance();
		MeetVO mv = new MeetVO();
		mv.setMem_id(mem_id);
		mv.setMeet_no(meetNo);
		mv.setMeet_name(meetName);
		mv.setMeet_info(meetInfo);
		mv.setMeet_day(meetDay);
		mv.setMeet_time(meetTime);
		mv.setMeet_level(meetLevel);
		mv.setMeet_limit(meetLimit);
		/* mv.setMem_id(meetId); */
		mv.setMeet_loc(meetLoc);
		mv.setMeet_loc_detail(meetLocDetail);
		mv.setMcate_no("c001");
		
		System.out.println("d인서트"+meetNo);
		System.out.println(mv.toString());
		
		int cnt = meetService.insertMeet(mv);
		
		System.out.println(cnt);
		
		String msg = "";
		if(cnt>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+"/meetList");
		
		
	}

}
