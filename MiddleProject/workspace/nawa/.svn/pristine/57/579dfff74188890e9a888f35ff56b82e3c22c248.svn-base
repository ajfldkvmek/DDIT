package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.CommentServiceImpl;
import board.service.ICommentService;
import board.service.IPostService;
import board.service.PostServiceImpl;

@WebServlet("/board/commDelete.do")
public class CommDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int commNo = Integer.parseInt(req.getParameter("commNo"));
		int postNo = Integer.parseInt(req.getParameter("postNo"));
		
		ICommentService commService = CommentServiceImpl.getInstance();
		
		int cnt = commService.deleteComment(commNo);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
	    System.out.println("삭제 결과: " + msg);
	    System.out.println("삭제 번호: " + commNo);
	    
		// 목록 화면으로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/board/detail.do" + "?postNo=" + postNo);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp); //(delete할때도 나눌 필요 없으므로...)
	}
}
