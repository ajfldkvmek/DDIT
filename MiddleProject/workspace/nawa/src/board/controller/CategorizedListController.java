package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;

@MultipartConfig
@WebServlet("/board/catelist.do")
public class CategorizedListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	        
	    System.out.println("CateController 시작");
		PostVO pv = new PostVO();
		IPostService postService = PostServiceImpl.getInstance();

//		System.out.println(req.getParameter("postCate"));
//        int postCate = Integer.parseInt(req.getParameter("postCate"));
        int cateValue = Integer.parseInt(req.getParameter("postCate"));
        	System.out.println("cateValue: " + cateValue);
//        int cateNo = Integer.parseInt(req.getParameter("cateNo"));
        System.out.println("[CateController] cateValue: " + cateValue );
//        + " | " + "cateNo: " + cateNo);
        
        String catePageStr = req.getParameter("catePage");
        System.out.println("[CateController] catePageStr: " + catePageStr);
        // 현재 페이지 번호 가져오기
//        int page = getPageNumber(req); // 현재 페이지 번호 가져오기
        int catePage = (catePageStr != null && !catePageStr.isEmpty()) ? Integer.parseInt(catePageStr) : 1;
        // 페이지당 포스트 수 조절
        int cateCountPerPage = 10; 
        // 페이지 시작&끝 번호
        int start = (catePage - 1) * cateCountPerPage + 1;
        int end = catePage*cateCountPerPage;
        
        System.out.println("[CateController] catePage: " + catePage + " | start: " + start + " | end: " + end);
        
        pv.setCateStartIdx(start);
        pv.setCateCountPerPage(end);
        pv.setCateValue(cateValue);
        
        System.out.println("[CateController] cateValue: " + cateValue);
        
//        PostVO pv2 = pv;
        
        // 카테고리의 총 개수를 가져와 전체 페이지 수 계산
        int catePostsCount = postService.getPostsByCategoryCount(pv);
        System.out.println("[CateController] catePostsCount: " + catePostsCount);
        int totalCatePages = (int) Math.ceil((double) catePostsCount / cateCountPerPage);
        System.out.println("[CateController] total-" + catePostsCount + " | " + totalCatePages);
        
        List<PostVO> catePostsList = new ArrayList<PostVO>();

            // 카테고리별 게시물 목록을 페이징하여 가져오기
        	catePostsList = postService.getPostsByCategory(pv);
            System.out.println("[CateController] catePostsList: " + catePostsList);
            req.setAttribute("catePostsList", catePostsList);
            req.setAttribute("totalPages", totalCatePages);
            System.out.println("[CateController] totalPages: " + totalCatePages);
            
            // 현재 페이지 전달
            req.setAttribute("currentPage", catePage);

            req.setAttribute("pv", pv);
            req.getRequestDispatcher("/board/board/catelist.jsp").forward(req, resp);

	}
	
//	 private int getPageNumber(HttpServletRequest req) {
//	        String pageStr = req.getParameter("page");
//	        return (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
//	    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
