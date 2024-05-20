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

import board.atch.service.AtchFileServiceImpl;
import board.atch.service.IAtchFileService;
import board.atch.vo.AtchFileVO;
import board.service.CommentServiceImpl;
import board.service.ICommentService;
import board.service.IPostService;
import board.service.PostServiceImpl;
import board.vo.PostVO;

@MultipartConfig
@WebServlet("/board/detail.do")
public class DetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(req.getParameter("postNo")); //key값=id
		System.out.println("[DetailController] postNo: " + postNo);
		IPostService postService = PostServiceImpl.getInstance();
		
		//atch파일 정보 가져오기위한 서비스 호출
		IAtchFileService fileSerivce = AtchFileServiceImpl.getInstance();
		
		// 먼저 조회수 업데이트
	    postService.updateViewCnt(postNo); //여기는 잘 오고

	    // 게시글 번호로 상세페이지 게시물 상세정보 조회
	    PostVO pv = postService.getPostNo(postNo);
		req.setAttribute("pv", pv); //이거도 잘 옴
		
		long atchFileId = pv.getAtchFileId();
		
		//###########################첨부파일 가져오기 시작
		if(atchFileId > 0) { // 첨부파일이 존재하는 경우 해당 파일들의 정보 가져오기
			
			List<AtchFileVO> atchList = new ArrayList<>(); 

			//해당 게시판의 첨부파일 목록 불러오기
			atchList = fileSerivce.getDeatilList(pv.getAtchFileId());
			System.out.println("atchlist왜 안되는데 시밞ㄴㅁ넝ㅁ니임나임넘ㄴ" + atchList);
			req.setAttribute("atchList", atchList);
		}
		
		
		//댓글 가져오기 시작########################################		
		ICommentService commService = CommentServiceImpl.getInstance();
		
		String commPageStr = req.getParameter("commPage");
        int commPage = (commPageStr != null && !commPageStr.isEmpty()) ? Integer.parseInt(commPageStr) : 1;
        int countCommPerPage = 10; // 페이지당 댓글 수 조절 ########################
        
        int commStart = (commPage - 1) * countCommPerPage + 1;
        int commEnd = commPage*countCommPerPage;
        
        pv.setCommStart(commStart);
        pv.setCommEnd(commEnd);
        
        List<PostVO> commList = commService.getCommentListWithPaging(pv);

        int totalCommCount = commService.getTotalCommentCount(postNo);
        int totalCommPages = (int) Math.ceil((double) totalCommCount / countCommPerPage);

        // 현재 페이지와 전체 페이지 수 전달
        req.setAttribute("totalCommPages", totalCommPages);
        req.setAttribute("currentCommPage", commPage);
        
        req.setAttribute("commList", commList);
        System.out.println("[DetailController] commList: " + commList);
        
        req.getRequestDispatcher("/board/board/detail.jsp").forward(req, resp);
        
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
		
		resp.setContentType("text/html;charset=UTF-8");
	    req.setCharacterEncoding("UTF-8");
		
	    int postNo = Integer.parseInt(req.getParameter("postNo"));
	    String commWriter = req.getParameter("commWriter");
	    String commContent = req.getParameter("commContent");

	    ICommentService commService = CommentServiceImpl.getInstance();
		
		PostVO pv = new PostVO();
        pv.setPostNo(postNo);
        pv.setCommWriter(commWriter);
        pv.setCommContent(commContent);
        
		int cnt = commService.insertComment(pv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		req.setAttribute("postNo", postNo);
		req.setAttribute("commWriter", commWriter);
		req.setAttribute("commContent", commContent);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail.do" + "?postNo=" + postNo );
		
	}
}
