package lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.IPageService;
import lecture.service.LecServiceImpl;
import lecture.service.PageServiceImple;
import lecture.vo.LectureVO;

@WebServlet ("/lecture/list.do")
public class ListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ㅎㅇㅎㅇ 강의 리슽으 왔어");
		LectureVO lv = new LectureVO();
		ILecService lecService = LecServiceImpl.getInstance();
		IPageService pageService = PageServiceImple.getInstance();
		
		String pageStr = req.getParameter("page");
		int page = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
	    int countPerPage = 10; // 페이지당 포스트 수 조절
		
//	    	이건 전체페이지니까 검색어로 설정한 글수 나오게
	    int totalPostCount = pageService.getTotalPostCount();
	    int totalPages = (int) Math.ceil((double) totalPostCount / countPerPage);
	   
	    
//	    int searchPostCount = pageService.getSearchPostCount();
//	    int searchPages = (int) Math.ceil((double) searchPostCount / countPerPage);
	    //int remain = totalPostCount % countPerPage;
	    
	    System.out.println("page" + page);
	    int start = (page - 1) * countPerPage + 1;
        int end = page*countPerPage;
        System.out.println("start.end" + start + "." + "end" + end);
        
        lv.setStartIdx(start);
        lv.setCountPerPage(end);
        
        List<LectureVO> pageList = pageService.getPostListWithPaging(lv);
        req.setAttribute("pageList", pageList);
        System.out.println(">>>>>>" + pageList);
        
        // 현재 페이지와 전체 페이지 수 전달
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);
        
        System.out.println(totalPages);
        System.out.println(page);
		
		req.getRequestDispatcher("/lecture/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
