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
		
		int perPage = 8;
		
		System.out.println("리스트오는지?");
		IMeetService meetService =  MeetServiceImpl.getInstance();
		
		
		System.out.println("컨트롤러타는구문");
		//List<MeetVO> meetList =  meetService.displayAllMeet();
		//System.out.println("리스트사이즈"+meetList.size());
		// Meet 리스트를 request에 저장
		
		int totalMeet = meetService.countAll();
				
		//현재페이지와 전체페이지 생성
		int currPage = ( (req.getParameter("page") != null) && (!req.getParameter("page").equals("")) ) ? 
				Integer.parseInt(req.getParameter("page")) : 1;
				
		int totalPage = (totalMeet % perPage) == 0 ? (totalMeet / perPage) : (totalMeet / perPage) + 1;
		
		//페이징해서 가져올 글 rownum지정해서 매개변수로 날림
		MeetVO mv = new MeetVO();
		mv.setStartPage( (currPage-1)*perPage + 1);
		int lastMeet = (perPage*currPage) > totalMeet ? totalMeet : perPage*currPage;
		mv.setEndPage(lastMeet);
		
		//현재 페이지를 매개면수로 전송
		List<MeetVO> meetList =  meetService.displayAllMeet(mv);
		
		req.setAttribute("meetList", meetList);
		req.setAttribute("currPage", currPage);
		req.setAttribute("totalPage", totalPage);
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
