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
import meet.vo.MeetVO;

/**
 * Servlet implementation class meetList
 */
@WebServlet("/meetList")
public class meetList extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("리스트오는지?");
		IMeetService meetService =  MeetServiceImpl.getInstance();
		System.out.println("컨트롤러타는구문");
		List<MeetVO> meetList =  meetService.displayAllMeet();
		System.out.println("리스트사이즈"+meetList.size());
		// Meet 리스트를 request에 저장
		req.setAttribute("meetList", meetList);
		System.out.println("리스트"+meetList);
		req.getRequestDispatcher("meet/meetlist.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
