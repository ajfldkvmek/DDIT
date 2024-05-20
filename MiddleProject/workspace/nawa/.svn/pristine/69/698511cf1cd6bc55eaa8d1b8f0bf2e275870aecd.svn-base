package board.controller;

import java.io.IOException;

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
@WebServlet("/board/commInsert.do")
// 이제 doGet/doPost 구분해서 작업: get은 폼 등록 화면으로, post는 db에 insert?
public class CommInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==CommInsertController doGet==");
		req.getRequestDispatcher("/board/board/detail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    
		//세션
		HttpSession session = req.getSession();
		// 로그인 정보 가져오기
		IMemberService memService = MemberServiceImpl.getInstance();
		MemberVO mv = new MemberVO(); 
		mv = (MemberVO)session.getAttribute("LOGIN_USER");
		System.out.println("[InsertController] mv 정보 가져옴!: " + mv);
		//id값 생성
		String commWriter = mv.getMem_id();
		//로그인 확인
		if (commWriter == null || "".equals(commWriter)) {
			// 첫 화면으로 리다이렉트
			System.out.println("로그인 정보가 없습니다.");
			resp.sendRedirect("./member/signin.jsp");
		}
		System.out.println("[CommInsertController] commWriter: " + commWriter);
		
		//(사용자가 보낸 정보 꺼내옴)
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		
		int postNo = Integer.parseInt(req.getParameter("postNo")); //켜면 null 오류남 (안 켜도 null 됨)
		System.out.println("[CommInsertController] postNo: " + postNo);
		
		IPostService postService = PostServiceImpl.getInstance();
		PostVO pv = postService.getPostNo(postNo);
		req.setAttribute("pv", pv);
		
		String commContent = req.getParameter("commContent");
		System.out.println("[CommInsertController] postNo: " + postNo + " | commWriter: " + commWriter + " | commContent: " + commContent) ;
		
		// 게시물 정보 저장
//		IPostService postService = PostServiceImpl.getInstance();
		ICommentService commService = CommentServiceImpl.getInstance();
	
//		PostVO pv = new PostVO(commContent, postNo, commWriter);
//		PostVO pv = new PostVO();
		pv.setCommContent(commContent);
		pv.setPostNo(postNo);
		pv.setCommWriter(commWriter);
		System.out.println("[CommInsertController] pv: " + pv);
		
		//dao 다녀옴
		int cnt = commService.insertComment(pv);
		//(정보등록요청)
		System.out.println("[CommInsertController] cnt: " + cnt);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		req.getSession().setAttribute("pv", pv);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail.do" + "?postNo=" + postNo);
		
		System.out.println("작성 결과: " + msg);
		System.out.println("작성 내용: " + pv);
	}
}
