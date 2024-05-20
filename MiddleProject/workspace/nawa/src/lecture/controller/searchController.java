package lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.service.ILecService;
import lecture.service.LecServiceImpl;
import lecture.vo.LectureVO;

@WebServlet("/lecture/lecSearch")
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ILecService lecService = LecServiceImpl.getInstance();
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    String search = req.getParameter("search"); // 검색빈칸 입력값
	    String cate = req.getParameter("lcate_no");
	    
	    String pageStr = req.getParameter("page");
	    int page = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
	    int countPerPage = 10; // 페이지당 포스트 수 조절

	    LectureVO lv = new LectureVO();
	    lv.setSearch(search);
	    lv.setLecCate(cate);
	    System.out.println("controller>>>>>>>>" + search + " " + cate);
	   
	    // 총 페이지 수 계산
	    int totalLectureCount = lecService.getTotalLectureCount(lv); // 검색된 강의 수를 가져오는 메서드
	    int totalPages = (int) Math.ceil((double) totalLectureCount / countPerPage); //전체 페이지 수
	   
	    String cate2 = req.getParameter("lcate_no2");
	    if(cate2.equals("1")) {
	        lv.setSort("LECTURE_SCORE");
	    } else {
	        lv.setSort("PRICE");
	    }

	    // 페이징 처리
	    int start = (page - 1) * countPerPage + 1;
	    int end = page * countPerPage;
	    lv.setStart(start);
	    lv.setEnd(end);

	    List<LectureVO> lecList = lecService.lectureSearch(lv);

	    req.setAttribute("pageList", lecList);
	    req.setAttribute("currentPage", page);
	    req.setAttribute("totalPages", totalPages);
	    req.getRequestDispatcher("/lecture/searchlist.jsp").forward(req, resp);
		
	}
}
