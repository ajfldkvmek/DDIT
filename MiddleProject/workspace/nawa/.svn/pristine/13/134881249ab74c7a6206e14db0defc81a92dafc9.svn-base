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
 * Servlet implementation class meetJoin
 */
@WebServlet("/meetJoin")
public class meetJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		MemberVO mv2 = (MemberVO) session.getAttribute("LOGIN_USER");
		String memId = mv2.getMem_id(); // 로그인 할때 세션에담은것 가져옴

		IMeetService meetService = MeetServiceImpl.getInstance();

		String meetNo = req.getParameter("meetNo");
		System.out.println("meetNO확인>>>"+meetNo);
		System.out.println("memId확인>>>"+memId);

		////////////////////////////////////////////////////////////
		Random rand = new Random();
		int a = rand.nextInt(100000000) + 1; // 여기서 10000은 0~ 9999의 범위를 말함
		//if(a < 1000) a+=1000; //그냥 단순히 자릿수 맞춰주려고 필수는 아님,

		String applyNo =  "a"  + a; // 여기서는 spo로 했지만 이후 생성 할 때는 카테고리에 맞게 변수명 바꿔주려고...

		MeetVO mv = new MeetVO();
		mv.setApply_no(applyNo);
		mv.setMem_id(memId);
		mv.setMeet_no(meetNo);
		// mv.setOkyn("N");
		
		System.out.println(applyNo);

		int cnt = meetService.meetJoin(mv);
		String msg = "";
		if(cnt >0) {
			msg="성공";
		}else {
			msg="실패";
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect("./meet/meetjoin_success.jsp");

	}

}
