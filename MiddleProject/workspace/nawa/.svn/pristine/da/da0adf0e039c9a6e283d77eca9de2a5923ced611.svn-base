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
 * Servlet implementation class meetSearch
 */
@WebServlet("/meetSearch")
public class meetSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMeetService memService = MeetServiceImpl.getInstance();
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		String search = req.getParameter("search"); //검색 빈칸 입력값
		String cate = req.getParameter("mcate_no");
		String level = req.getParameter("meet_level");
		String loc1 = req.getParameter("lcate_no");
		String loc2 = req.getParameter("local_com");
		
		System.out.println(">>>>>>>>>>>>>>>"+cate+ level);
		System.out.println(">>>>>local_com: "+loc2);
		
		System.out.println(search);
		
		MeetVO mv = new MeetVO();
		mv.setSearch(search);
		mv.setMcate_no(cate);
		mv.setMeet_level(level);
		mv.setLcate_no(loc1); 
		mv.setLocal_com(loc2);
		
		
		List<MeetVO> meetList =  memService.meetSearch(mv);
		
		System.out.println("search컨트롤러 값 나오는부분"+meetList);
		
		req.setAttribute("meetList", meetList);
		req.getRequestDispatcher("meet/meetlist.jsp").forward(req, resp);
		
	    
	}

}
