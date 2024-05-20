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

import atch.service.BoardAtchFileServiceImpl;
import atch.service.IBoardAtchFileService;
import atch.vo.BoardAtchFileVO;
import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet("/board/update.do")
public class UpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int postNo = Integer.parseInt(req.getParameter("postNo"));

		IPostService postService = PostServiceImpl.getInstance();

		PostVO pv = postService.getPostNo(postNo);

		req.setAttribute("pv", pv);

		//(detailcontroller와 동일)
//		if(pv.getAtchFileId() > 0) { // 화면만 요청하는거라 get에
//			IBoardAtchFileService fileService = BoardAtchFileServiceImpl.getInstance();
//			BoardAtchFileVO atchFileVO = new BoardAtchFileVO();
//			atchFileVO.setAtchFileId(pv.getAtchFileId());
//			List<BoardAtchFileVO> atchFileList = 
//					fileService.getAtchFileList(atchFileVO);
//			req.setAttribute("atchFileList", atchFileList);
//		}
		
		req.getRequestDispatcher("/board/board/updateForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    
		int postNo = Integer.parseInt(req.getParameter("postNo"));
		String postWriter = req.getParameter("postWriter");
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		String boardFIndex = req.getParameter("boardFIndex"); //기존 첨부파일 ID
		int postCate = Integer.parseInt(req.getParameter("postCate"));
		
		//첨부파일 저장하기
		IBoardAtchFileService fileService = BoardAtchFileServiceImpl.getInstance();
		BoardAtchFileVO bv = new BoardAtchFileVO();
		bv = fileService.saveBoardAtchFileList(req.getParts());
		
		IPostService postService = PostServiceImpl.getInstance();

//		PostVO pv = new PostVO(postNo, postTitle, postWriter, postContent);
//		PostVO pv = new PostVO(postNo, postTitle, postContent);
		
		PostVO pv = new PostVO();
		pv.setPostNo(postNo);
		pv.setPostCate(postCate);
		pv.setPostTitle(postTitle);
		pv.setPostWriter(postWriter);
		pv.setPostContent(postContent);
		System.out.println("postCate: " + postCate);
		
//		if(atchFileVO == null) { // 신규 첨부파일이 존재하지 않는 경우...
//			pv.setAtchFileId(Long.parseLong(atchFileId));
//		}else { // 신규 첨부파일이 존재하는 경우...
//			pv.setAtchFileId(atchFileVO.getAtchFileId());
//		}
		
		int cnt = postService.modifyPost(pv);

		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		

	    // 수정이 성공하면, 다시 목록을 로드하거나 다른 동작을 수행하는 등의 코드를 추가
//	    resp.sendRedirect(req.getContextPath() + "/post/list.jsp");
	    resp.sendRedirect(req.getContextPath() + "/board/list.do" + "?pageNo=" + postNo);
	    
//	 // 수정 작업 후에 handleUpdateRedirect 함수 호출
//	    String redirectScript = "<script>handleUpdateRedirect('" + req.getContextPath() + "/post/list.do');</script>";
//	    resp.getWriter().write(redirectScript);

	    // 아래 디버깅 코드를 추가
	    System.out.println("수정 결과: " + msg);
	    System.out.println("수정된 내용: " + pv);
	}
}
