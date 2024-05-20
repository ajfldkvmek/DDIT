package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atch.service.BoardAtchFileServiceImpl;
import atch.service.IBoardAtchFileService;
import atch.vo.BoardAtchFileVO;
import board.atch.service.AtchFileServiceImpl;
import board.atch.service.IAtchFileService;
import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;
import board.atch.vo.AtchFileVO;
import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet("/board/insert.do")
// 이제 doGet/doPost 구분해서 작업: get은 폼 등록 화면으로, post는 db에 insert?
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/board/board/insertForm.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    
		//세션
		HttpSession session = req.getSession();
		// 로그인 정보 가져오기
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		IMemberService memService = MemberServiceImpl.getInstance();
		
		MemberVO mv = new MemberVO(); 
		AtchFileVO atchFileVO = new AtchFileVO();
		
		mv = (MemberVO)session.getAttribute("LOGIN_USER");
		System.out.println("[InsertController] mv 정보 가져옴!: " + mv);
		//id값 생성
		String postWriter = mv.getMem_id();
		//로그인 확인
		if (postWriter == null || "".equals(postWriter)) {
			// 첫 화면으로 리다이렉트
			System.out.println("로그인 정보가 없습니다.");
			resp.sendRedirect("./member/signin.jsp");
		}
		System.out.println("[InsertController] memId: " + postWriter);
		
		//(사용자가 보낸 정보 꺼내옴)
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		int postCate = Integer.parseInt(req.getParameter("postCate"));
		System.out.println("[InsertController] postCate: " + postCate + " | postTitle: " + postTitle + " | postWriter: " + postWriter + " | postContent: " + postContent) ;
		
		
		//여기서 atchfileid 가져오기
		
		//첨부파일 목록저장하기(공통기능)
		atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		
		// 게시물 정보 저장
		IPostService postService = PostServiceImpl.getInstance();
	
		PostVO pv = new PostVO();
		pv.setPostCate(postCate);
		pv.setPostTitle(postTitle);
		pv.setPostWriter(postWriter);
		pv.setPostContent(postContent);
				
		if(atchFileVO != null) {
			pv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		int cnt = postService.registPost(pv);
		//(정보등록요청)
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);

		// 목록 화면으로 포워딩처리 (보내기)
//		req.getRequestDispatcher("/member/list.do").forward(req,resp);
			//(리스트 화면 뜨게 하고 싶음)(jsp로 바로 가게 하면 안 됨)
			//(insertCont에서 ListCont로 포워드한것)
		
		// 목록 화면으로 리다이렉팅 처리 (흐름을 바꾸기) => alert이 안 뜸!(list.jsp)
		resp.sendRedirect(req.getContextPath() + "/board/list.do");
//		(포워드와 리다이렉트 차이 알아둘 것: forward는 같은 값, redirect는 값사라짐
		//(request에 저장해도 같은 request가 아니라서 의미가 없음)(dispatcher: forwarding할때 씀)
		//=> req나 지역변수로 할 수 있으면 하는게 좋지만 redicrect에선 어쩔수없이 session
	    
//	    resp.sendRedirect(req.getContextPath() + "/post/list.jsp");
		
		System.out.println("[InsertController] 작성 결과: " + msg);
		System.out.println("[InsertController] 작성 내용: " + pv);
	}
}
