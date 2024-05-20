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
		
		int perPage = 8;
		
		IMeetService meetService = MeetServiceImpl.getInstance();
		
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
		
		//검색결과 페이징시작
		//검색결과에 따른 전체 글 수 가져오기
		int searchCount = meetService.meetSearchCount(mv);
		
		//현재 페이지(default값은 1로 지정)
		int currPage = ( (req.getParameter("page") != null) && (!req.getParameter("page").equals("")) ) ? 
				Integer.parseInt(req.getParameter("page")) : 1;
		
		//총 페이지 수는 전체 검색결과(searchCount) / 8
		int totalPage = (searchCount % perPage) == 0 ? (searchCount / perPage) : (searchCount / perPage) + 1;
		
		mv.setStartPage( (currPage-1)*perPage + 1);
		int lastMeet = (perPage*currPage) > searchCount ? searchCount : perPage*currPage;
		mv.setEndPage(lastMeet);
		
		List<MeetVO> meetList =  meetService.meetSearch(mv);
		
		
		req.setAttribute("currPage", currPage);
		req.setAttribute("totalPage", totalPage);

		System.out.println("모임 검색페이지" + currPage + " " + totalPage);
		
//		mv.setEndPage(endPage);
//		mv.setEndPage(endPage);
		
		System.out.println("search컨트롤러 값 나오는부분"+meetList);
		
		req.setAttribute("meetList", meetList);
		req.getRequestDispatcher("meet/meetlist.jsp").forward(req, resp);
		
	    
	}

}
