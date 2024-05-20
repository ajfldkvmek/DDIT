package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.CommentServiceImpl;
import board.service.ICommentService;
import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet("/board/tutorreq.do")
public class TutorReqListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	        
		//세션
		HttpSession session = req.getSession();
		// 로그인 정보 가져오기
//		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = new MemberVO(); 
		mv = (MemberVO)session.getAttribute("LOGIN_USER");
		//로그인 확인
		//id값 생성
		String memId = mv.getMem_id();
		if (memId == null || "".equals(memId)) {
			// 첫 화면으로 리다이렉트
			System.out.println("로그인 정보가 없습니다.");
			resp.sendRedirect("./member/signin.jsp");
		} else {
			req.setAttribute("memId", memId);
		}
		
		//(김현태씨 테스트)
//		MemberVO mv = new MemberVO();
//		mv = (MemberVO)session.getAttribute("LOGIN_USER");
		System.out.println("[TutorReqListController] (게시판 도착) 로그인한 사용자: " + mv.getMem_id());
		
		//(첨부파일 관련)
		PostVO pv = new PostVO();
//		BoardAtchFileVO bv = new BoardAtchFileVO();
		IPostService postService = PostServiceImpl.getInstance();
		
		
		// 현재 페이지 수 가져오기
		String pageStr = req.getParameter("page");
        int page = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
        System.out.println("[TutorReqListController] page: " + page);
        int countPerPage = 10; // 페이지당 포스트 수 조절
        // 페이징 시작 & 끝 페이지
        int start = (page - 1) * countPerPage + 1;
        int end = page*countPerPage;
        System.out.println("[TutorReqListController] start: " + start + " | end: " + end);
        
        pv.setStartIdx(start);
        pv.setCountPerPage(end);
        // pv 보내기
        List<PostVO> tutuorReqList = postService.getTutorReqList(pv);

        int totalPostCount = postService.getTutorReqCount(pv); // 총 게시물 수 계산
        int totalPages = (int) Math.ceil((double) totalPostCount / countPerPage); // 총 페이지 수 계산 
      
        // 현재 페이지와 전체 페이지 수 전달
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        
        // postWriter로 member 정보 가져오기
//        MemberVO tv = new MemberVO();
		/*
		 * PostVO ppv = new PostVO(); int postNo =
		 * Integer.parseInt(req.getParameter("postNo")); ppv.setPostNo(postNo);
		 * List<MemberVO> tutorDetail = postService.getTutorReqDetail(ppv);
		 * req.setAttribute("tutorDetail", tutorDetail);
		 */
        
        
        req.setAttribute("tutuorReqList", tutuorReqList);
        req.getRequestDispatcher("/board/board/tutorreq.jsp").forward(req, resp);
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
