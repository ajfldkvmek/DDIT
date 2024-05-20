package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;

@WebServlet("/board/search.do")
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	        
		PostVO pv = new PostVO();
		IPostService postService = PostServiceImpl.getInstance();

        String searchField = req.getParameter("searchField");
        String searchText = req.getParameter("searchText");
        System.out.println("[SearchController] searchField: " + searchField + " | " + "searchText: " + searchText);
        
        String searchPageStr = req.getParameter("searchPage");
        System.out.println("[SearchController] pageStr: " + searchPageStr);
        // 현재 페이지 번호 가져오기
//        int page = getPageNumber(req); // 현재 페이지 번호 가져오기
        int searchPage = (searchPageStr != null && !searchPageStr.isEmpty()) ? Integer.parseInt(searchPageStr) : 1;
        // 페이지당 포스트 수 조절
        int countPerPage = 10; 
        // 페이지 시작&끝 번호
        int start = (searchPage - 1) * countPerPage + 1;
        int end = searchPage*countPerPage;
        
        System.out.println("[SearchController] page: " + searchPage + " | start: " + start + " | end: " + end);
        
        pv.setSearchStartIdx(start);
        pv.setSearchCountPerPage(end);
        pv.setSearchField(searchField);
        pv.setSearchText(searchText);
        
        System.out.println("searchText: " + searchText);
        
        PostVO pv2 = pv;
        
        // 검색 결과의 총 개수를 가져와 전체 페이지 수 계산
        int totalSearchCount = postService.getTotalSearchCount(pv);
        int totalSearchPages = (int) Math.ceil((double) totalSearchCount / countPerPage);
        System.out.println("total-" + totalSearchCount + " | " + totalSearchPages);
        
        List<PostVO> searchList = new ArrayList<PostVO>();
        if (searchField != null && searchText != null) {
            // 검색 결과를 페이징하여 가져오기
            searchList = postService.searchPostWithPaging(pv);
            System.out.println("[SearchController] searchList: " + searchList);
            req.setAttribute("searchList", searchList);
            req.setAttribute("totalPages", totalSearchPages);
            
            // 현재 페이지 전달
            req.setAttribute("currentPage", searchPage);

            req.setAttribute("pv", pv);
            req.getRequestDispatcher("/board/board/search.jsp").forward(req, resp);
        } else {
        	//검색어가 없는 경우 전체 포스트를 가져오기
			
        	int totalPostCount = postService.getTotalPostCount(); 
        	int totalPages = (int) Math.ceil((double) totalPostCount / countPerPage);
			List<PostVO> postList = postService.getPostListWithPaging(pv2);
			System.out.println("[SearchController] postList: " + postList);
			
			
			req.setAttribute("postList", postList);
			String pageStr = req.getParameter("page");
	        int page = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
			req.setAttribute("currentPage", page);
			req.setAttribute("totalPages", totalPages);
			
			req.getRequestDispatcher("/board/board/list.do").forward(req, resp);
			
        }
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
