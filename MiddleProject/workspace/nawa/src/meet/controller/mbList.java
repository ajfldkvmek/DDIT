package meet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meet.service.IMeetService;
import meet.service.MeetServiceImpl;
import meet.vo.MbVO;
import meet.vo.MeetVO;

/**
 * Servlet implementation class mbList
 */
@WebServlet("/mbList")
public class mbList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String meetNo = req.getParameter("meetNo");
		
		
		System.out.println("mbList의 meetNo 파라미터가져오는지:" + meetNo);

		System.out.println("mbList시작");

		IMeetService meetService = MeetServiceImpl.getInstance();
		List<MbVO> mbList = meetService.displayAllMeetBoard(meetNo);

		/*
		 * MeetVO meet = new MeetVO(); meet.setMeet_no(meetNo);
		 */

		req.setAttribute("mbList", mbList);
		////////세션
		req.getSession().setAttribute("pageNo",meetNo );
		
		// req.setAttribute("meetNo", meet);//mbdetail에서 필요해서.. hidden으로 가져갈것임
		req.getRequestDispatcher("meet/mblist.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
