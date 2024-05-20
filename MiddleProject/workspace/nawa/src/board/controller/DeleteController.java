package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.IPostService;
import board.service.PostServiceImpl;
import member.vo.MemberVO;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int postNo = Integer.parseInt(req.getParameter("postNo"));
		
		// 삭제권한 부여
//		HTTPSESSION SESSION = REQ.GETSESSION();
//		MEMBERVO MV = (MEMBERVO) SESSION.GETATTRIBUTE("LOGIN_USER");
//		STRING POSTWRITER = REQ.GETPARAMETER("POSTWRITER");
//		STRING MEMID = MV.GETMEM_ID();
//		SYSTEM.OUT.PRINTLN("삭제확인 - MEMID: " + MEMID + " | POSTWRITER: " + POSTWRITER);
//		
//		IF (!MEMID.EQUALS(POSTWRITER) || POSTWRITER == NULL || POSTWRITER.EQUALS("")) {
//			SYSTEM.OUT.PRINTLN("[DELETECONTROLLER] 삭제 권한이 없습니다.");
//			RESP.SENDREDIRECT(REQ.GETCONTEXTPATH() + "/BOARD/DETAIL.DO" + "?PAGENO=" + POSTNO);
//		}
		
		
		IPostService postService = PostServiceImpl.getInstance();
		
		int cnt = postService.removePost(postNo);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
	    System.out.println("삭제 결과: " + msg);
	    System.out.println("삭제 번호: " + postNo);
	    
		// 목록 화면으로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/board/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp); //(delete할때도 나눌 필요 없으므로...)
	}
}
