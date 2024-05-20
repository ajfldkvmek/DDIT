package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.CommentServiceImpl;
import board.service.ICommentService;
import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;

@MultipartConfig
@WebServlet("/board/commUpdate.do")
public class CommUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int commNo = Integer.parseInt(req.getParameter("commNo"));

		ICommentService commService = CommentServiceImpl.getInstance();

		PostVO pv = commService.getCommNo(commNo);

		req.setAttribute("pv", pv);		
		req.getRequestDispatcher("/board/board/commUpdateForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    
		int postNo = Integer.parseInt(req.getParameter("postNo"));
		int commNo = Integer.parseInt(req.getParameter("commNo"));
		String commWriter = req.getParameter("commWriter");
		String commContent = req.getParameter("commContent");
		String commDate = req.getParameter("commDate");
		System.out.println("(댓글수정컨트롤러 postNo: " + postNo + " | " + "commNo: " + commNo);
		
		ICommentService commService = CommentServiceImpl.getInstance();

		PostVO pv = new PostVO(commNo, commContent);
		
		int cnt = commService.updateComment(pv);

		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		

	    // 수정이 성공하면, 다시 목록을 로드하거나 다른 동작을 수행하는 등의 코드를 추가
//	    resp.sendRedirect(req.getContextPath() + "/post/list.jsp");
	    resp.sendRedirect(req.getContextPath() + "/board/detail.do" + "?postNo=" + postNo);
	    
//	 // 수정 작업 후에 handleUpdateRedirect 함수 호출
//	    String redirectScript = "<script>handleUpdateRedirect('" + req.getContextPath() + "/post/list.do');</script>";
//	    resp.getWriter().write(redirectScript);

	    // 아래 디버깅 코드를 추가
	    System.out.println("댓글 수정 결과: " + msg);
	    System.out.println("수정된 댓글 내용: " + pv);
	}
}
