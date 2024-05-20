package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.atch.service.AtchFileServiceImpl;
import lecture.atch.service.IAtchFileService;
import lecture.atch.vo.AtchFileVO;
import lecture.service.ILecService;
import lecture.service.LecServiceImpl;
import lecture.vo.LectureVO;
import member.vo.MemberVO;

@MultipartConfig
@WebServlet ("/lecture/insert.do")
public class insertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
		
		System.out.println("ㅁㅇㅁㄴㅁㅇㄴㅁㄴㅇㅁㄴㅇㄴㅇ");
		System.out.println(mv.getTutNo());
		System.out.println(mv.getDelyn());
		
		if( mv.getTutNo() == null) {
			
		}
		boolean chkTutNO = ( (mv.getTutNo() != null) && (!mv.getTutNo().equals("")));
		boolean chkDel = ( mv.getDelyn().equalsIgnoreCase("n") );
		
		if(chkTutNO && chkDel) {
			req.getRequestDispatcher("/lecture/insertForm.jsp").forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('권한이 없습니다');</script>");
			resp.sendRedirect("/nawa/lecture/list.do");
			out.flush();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
		
		String tutNo = mv.getTutNo();
		String memId = mv.getMem_id();
		String lecTitle = req.getParameter("lecTitle");
		String lecCont = req.getParameter("lecCont");
		String lecCata = req.getParameter("lecCata");
		String lecLoc = req.getParameter("lecLoc");
		Integer lecMax = Integer.parseInt(req.getParameter("lecMax"));
		Integer price = Integer.parseInt(req.getParameter("price"));
		String lecGrade = req.getParameter("lecGrade");
		Random rand = new Random();
		
		int a = rand.nextInt(10000) + 1;
		String lecNo = Integer.toString(a);
		
		// 첨부파일
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();

		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		System.out.println("끼릭끼릭입니다 >>" + atchFileVO.getAtchFileId());
		// 강의정보 저장
		ILecService lecService = LecServiceImpl.getInstance();
		
		LectureVO lv = new LectureVO();
		lv.setLecTitle(lecTitle);
		lv.setLecCont(lecCont);
		lv.setTutNo(tutNo);
		lv.setPrice(price);
		lv.setLecMax(lecMax);
		lv.setLecCata(lecCata);
		lv.setLecLoc(lecLoc);
		lv.setLecGrade(lecGrade);
		lv.setLecNo(lecNo);
		lv.setMemId(memId);
		lv.setAtchFileId(atchFileVO.getAtchFileId());
		/*
		 * //어태치파일 아이디 입력 맨~ 하기 lv.setAtchFileId(atchFileVO.getAtchFileId());
		 * lv.setStreFileNm(atchFileVO.get);
		 */
		
		int cnt = lecService.registLecture(lv);
		
		String msg = "";
		if(cnt < 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/lecture/list.do");
	}
}